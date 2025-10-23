package com.h2.repo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.h2.entity.db.Book;


//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest
public class BookRepoTest {

    @Autowired
    private BookRepo bookRepo;

    @Test
    void testSearchBooks() {
        String searchTerm = "artificial intelligence";
        List<Book> results = bookRepo.searchBooks(searchTerm);
        assertTrue(results.size() > 0);
        System.out.println("Found Books: " + results.size());
    }
}