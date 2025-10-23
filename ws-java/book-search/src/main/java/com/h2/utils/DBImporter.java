package com.h2.utils;

import java.sql.*;
import java.sql.Date;
import java.util.*;
import java.io.*;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DBImporter {

    private static final Logger logger = LoggerFactory.getLogger(DBImporter.class);

        //private static final String CSV_URL = "https://gist.github.com/hhimanshu/d55d17b51e0a46a37b739d0f3d3e3c74/raw/5b9027cf7b1641546c1948caffeaa44129b7db63/books.csv";
    private static final String CSV_URL = System.getenv().getOrDefault("CSV_PATH", "/Users/ravi.gupta/work/codebase/repo/ws-java/book-search/src/main/resources/books.csv");
    private static final String DB_URL = System.getenv().getOrDefault("DB_URL", "jdbc:postgresql://localhost:5432/library");
    private static final String DB_USER = System.getenv().getOrDefault("DB_USER", "admin");
    private static final String DB_PASSWORD = System.getenv().getOrDefault("DB_PASSWORD", "admin");

    public static void main(String[] args) {
        try {
            logger.info("Starting data ingestion...");

            // Step 1: Download CSV Data
            logger.info("Downloading CSV data...");
            InputStream csvStream = downloadCSV(CSV_URL);

            // Step 2: Parse CSV Data
            logger.info("Parsing CSV data...");
            List<String[]> records = parseCSV(csvStream);

            // Step 3: Insert Data into Database
            logger.info("Inserting data into database...");
            insertData(records);

            // Step 4: Update search vectors for all books
            logger.info("Updating search vectors...");
            updateSearchVectors();

            logger.info("Data ingestion completed successfully.");

        } catch (Exception e) {
            logger.error("An error occurred during data ingestion:", e);
            e.printStackTrace();
        }
    }

    // Download the CSV file from the URL
    // private static InputStream downloadCSV(String urlStr) throws IOException {
    //     URI uri = URI.create(urlStr);
    //     URL url = uri.toURL();
    //     HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    //     return conn.getInputStream();
    // }
    // Read the CSV file from local file system
    private static InputStream downloadCSV(String filePath) throws IOException {
        return new FileInputStream(filePath);
    }

    // Preprocess and parse the CSV file using OpenCSV
    private static List<String[]> parseCSV(InputStream csvStream) throws IOException, CsvValidationException {
        List<String[]> records = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(csvStream));

        CSVParser parser = new CSVParserBuilder()
                .withSeparator(',')
                .build();

        CSVReader csvReader = new CSVReaderBuilder(reader)
                .withCSVParser(parser)
                .build(); // Don't skip the header

        String[] nextLine;
        while ((nextLine = csvReader.readNext()) != null) {
            records.add(nextLine);
        }

        csvReader.close();
        return records;
    }

    // Insert data into the database, including authors and book_authors tables
    private static void insertData(List<String[]> records) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

        String insertAuthorSQL = "INSERT INTO authors (name) VALUES (?)";
        String selectAuthorSQL = "SELECT author_id FROM authors WHERE name = ?";
        String insertBookSQL = "INSERT INTO books (title, rating, description, language, isbn, book_format, edition, pages, publisher, publish_date, first_publish_date, liked_percent, price) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String insertBookAuthorSQL = "INSERT INTO books_authors (book_id, author_id) VALUES (?, ?)";

        conn.setAutoCommit(false);

        try (PreparedStatement authorStmt = conn.prepareStatement(insertAuthorSQL, Statement.RETURN_GENERATED_KEYS);
             PreparedStatement selectAuthorStmt = conn.prepareStatement(selectAuthorSQL);
             PreparedStatement bookStmt = conn.prepareStatement(insertBookSQL, Statement.RETURN_GENERATED_KEYS);
             PreparedStatement bookAuthorStmt = conn.prepareStatement(insertBookAuthorSQL)) {

            String[] header = records.get(0);
            Map<String, Integer> headerMap = new HashMap<>();
            for (int i = 0; i < header.length; i++) {
                headerMap.put(header[i], i);
            }

            for (int i = 1; i < records.size(); i++) {
                String[] record = records.get(i);

                String title = record[headerMap.get("title")];
                String authorName = record[headerMap.get("author")];
                double rating = Double.parseDouble(record[headerMap.get("rating")]);
                String description = record[headerMap.get("description")];
                String language = record[headerMap.get("language")];
                String isbn = record[headerMap.get("isbn")];
                String bookFormat = record[headerMap.get("bookFormat")];
                String edition = record[headerMap.get("edition")];
                int pages = Integer.parseInt(record[headerMap.get("pages")]);
                String publisher = record[headerMap.get("publisher")];
                String publishDateStr = record[headerMap.get("publishDate")];
                String firstPublishDateStr = record[headerMap.get("firstPublishDate")];
                double likedPercent = Double.parseDouble(record[headerMap.get("likedPercent")]);
                double price = Double.parseDouble(record[headerMap.get("price")]);

                // Handle author insertion/retrieval
                int authorId;
                
                // First check if author already exists
                selectAuthorStmt.setString(1, authorName);
                ResultSet selectAuthorRS = selectAuthorStmt.executeQuery();
                if (selectAuthorRS.next()) {
                    // Author exists, get the ID
                    authorId = selectAuthorRS.getInt("author_id");
                    selectAuthorRS.close();
                } else {
                    // Author doesn't exist, insert new one
                    selectAuthorRS.close();
                    authorStmt.setString(1, authorName);
                    int rowsAffected = authorStmt.executeUpdate();
                    
                    if (rowsAffected > 0) {
                        ResultSet authorRS = authorStmt.getGeneratedKeys();
                        if (authorRS.next()) {
                            authorId = authorRS.getInt(1);
                        } else {
                            throw new SQLException("Failed to get generated author ID for " + authorName);
                        }
                        authorRS.close();
                    } else {
                        throw new SQLException("Failed to insert author " + authorName);
                    }
                }

                // Insert into books
                int bookId;
                bookStmt.setString(1, title);
                bookStmt.setDouble(2, rating);
                bookStmt.setString(3, description);
                bookStmt.setString(4, language);
                bookStmt.setString(5, isbn);
                bookStmt.setString(6, bookFormat);
                bookStmt.setString(7, edition);
                bookStmt.setInt(8, pages);
                bookStmt.setString(9, publisher);

                // Handle possible null dates
                Date publishDate = null;
                Date firstPublishDate = null;
                try {
                    publishDate = Date.valueOf(publishDateStr);
                } catch (Exception e) {
                    // Date parsing failed, set to null
                }
                try {
                    firstPublishDate = Date.valueOf(firstPublishDateStr);
                } catch (Exception e) {
                    // Date parsing failed, set to null
                }
                bookStmt.setDate(10, publishDate);
                bookStmt.setDate(11, firstPublishDate);

                bookStmt.setDouble(12, likedPercent);
                bookStmt.setDouble(13, price);
                
                int bookRowsAffected = bookStmt.executeUpdate();
                if (bookRowsAffected > 0) {
                    ResultSet bookRS = bookStmt.getGeneratedKeys();
                    if (bookRS.next()) {
                        bookId = bookRS.getInt(1);
                    } else {
                        throw new SQLException("Failed to get generated book ID for " + title);
                    }
                    bookRS.close();
                } else {
                    throw new SQLException("Failed to insert book " + title);
                }

                // Insert into book_authors
                bookAuthorStmt.setInt(1, bookId);
                bookAuthorStmt.setInt(2, authorId);
                bookAuthorStmt.executeUpdate();
            }
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            throw e;
        } finally {
            conn.setAutoCommit(true);
            conn.close();
        }
    }

    // Update search vectors for all books in a single operation
    private static void updateSearchVectors() throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        
        String updateSearchVectorSQL = 
            "UPDATE books SET search_vector = " +
            "setweight(to_tsvector('english', COALESCE(title, '')), 'A') || " +
            "setweight(to_tsvector('english', COALESCE(description, '')), 'B') || " +
            "setweight(to_tsvector('english', COALESCE(isbn, '')), 'C')";
        
        try (PreparedStatement stmt = conn.prepareStatement(updateSearchVectorSQL)) {
            int rowsUpdated = stmt.executeUpdate();
            logger.info("Updated search vectors for {} books.", rowsUpdated);
        } finally {
            conn.close();
        }
    }
}
