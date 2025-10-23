package com.h2.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookSearcher {
    
    private static final Logger logger = LoggerFactory.getLogger(BookSearcher.class);
    
    private static final String DB_URL = System.getenv().getOrDefault("DB_URL", "jdbc:postgresql://localhost:5432/library");
    private static final String DB_USER = System.getenv().getOrDefault("DB_USER", "admin");
    private static final String DB_PASSWORD = System.getenv().getOrDefault("DB_PASSWORD", "admin");

    public static class SearchResult {
        public int bookId;
        public String title;
        public String description;
        public String isbn;
        public double rank;
        
        public SearchResult(int bookId, String title, String description, String isbn, double rank) {
            this.bookId = bookId;
            this.title = title;
            this.description = description;
            this.isbn = isbn;
            this.rank = rank;
        }
        
        @Override
        public String toString() {
            return String.format("Book ID: %d, Title: %s, ISBN: %s, Rank: %.3f", 
                               bookId, title, isbn, rank);
        }
    }

    public static List<SearchResult> searchBooks(String query) throws SQLException {
        List<SearchResult> results = new ArrayList<>();
        
        String searchSQL = """
            SELECT book_id, title, description, isbn, 
                   ts_rank(search_vector, to_tsquery('english', ?)) as rank
            FROM books 
            WHERE search_vector @@ to_tsquery('english', ?)
            ORDER BY rank DESC
            LIMIT 20
            """;
        
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(searchSQL)) {
            
            // Format query for PostgreSQL full-text search
            String formattedQuery = query.trim().replaceAll("\\s+", " & ");
            
            stmt.setString(1, formattedQuery);
            stmt.setString(2, formattedQuery);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                results.add(new SearchResult(
                    rs.getInt("book_id"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getString("isbn"),
                    rs.getDouble("rank")
                ));
            }
        }
        
        return results;
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            logger.info("Usage: java BookSearcher <search_query>");
            logger.info("Example: java BookSearcher \"Java programming\"");
            return;
        }
        
        String query = String.join(" ", args);
        
        try {
            logger.info("Searching for: {}", query);
            List<SearchResult> results = searchBooks(query);
            
            if (results.isEmpty()) {
                logger.info("No books found matching your search.");
            } else {
                logger.info("Found {} books:", results.size());
                logger.info(""); // Empty line for formatting
                for (SearchResult result : results) {
                    logger.info("{}", result);
                }
            }
            
        } catch (SQLException e) {
            logger.error("Error searching books: {}", e.getMessage(), e);
        }
    }
}
