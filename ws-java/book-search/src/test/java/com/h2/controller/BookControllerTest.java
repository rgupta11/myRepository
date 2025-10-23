package com.h2.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.h2.entity.db.Book;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookControllerTest {

    // @Autowired
    // private BookController bookController;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testGetBooksBySearchTerm() {
        String searchTerm = "Data Science";
        String url = "/books/search?searchTerm=" + searchTerm;
        ResponseEntity<Book[]> response = restTemplate.getForEntity(url, Book[].class);
        assertTrue(HttpStatus.OK.equals(response.getStatusCode()));
        assertTrue(response.getBody() != null && response.getBody().length > 0);
    }

    // @Test
    // void testGetBooksBySearchTerm() {
    //     String searchTerm = "Data Science";
    //     List<Book> books = bookController.getBooksBySearchTerm(searchTerm);
    //     assertTrue(books.size() > 0);
    // }
}
