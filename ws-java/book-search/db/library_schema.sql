-- postgres version 15.14
-- CSV headers are below
-- bookId,title,author,rating,description,language,isbn,bookFormat,edition,pages,publisher,publishDate,firstPublishDate,likedPercent,price

-- Drop existing tables if they exist
DROP TABLE IF EXISTS books_authors;
DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS authors;

-- create table books
CREATE TABLE books (
    book_id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    rating FLOAT,
    description TEXT,
    language VARCHAR(100),
    isbn VARCHAR(20) UNIQUE NOT NULL,
    book_format VARCHAR(50),
    edition VARCHAR(100),
    pages INT,
    publisher VARCHAR(255),
    publish_date DATE,
    first_publish_date DATE,
    liked_percent FLOAT,
    price FLOAT,
    search_vector tsvector
);

--  create table authors
CREATE TABLE authors (
    author_id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

-- create table book_authors junction table
CREATE TABLE books_authors (
    book_id INT REFERENCES books(book_id),
    author_id INT REFERENCES authors(author_id),
    PRIMARY KEY (book_id, author_id)
);

-- Create GIN index on search_vector for full-text search performance
CREATE INDEX idx_books_search_vector ON books USING GIN (search_vector);


--UPDATE books SET search_vector =
    --setweight(to_tsvector('english', coalesce(title,'')), 'A') ||
    --setweight(to_tsvector('english', coalesce(description,'')), 'B') ||
    --setweight(to_tsvector('english', coalesce(isbn,'')), 'C');