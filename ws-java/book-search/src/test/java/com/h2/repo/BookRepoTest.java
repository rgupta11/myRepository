package com.h2.repo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.h2.entity.db.Book;


//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest
public class BookRepoTest {

    private static final Logger logger = LoggerFactory.getLogger(BookRepoTest.class);

    @Autowired
    private BookRepo bookRepo;

    @Test
    void testSearchBooks() {
        String searchTerm = "artificial intelligence";
        List<Book> results = bookRepo.searchBooks(searchTerm);
        assertTrue(results.size() > 0);
        logger.info("Found Books: {}", results.size());
    }
}