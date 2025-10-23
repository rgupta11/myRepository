package com.h2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.h2.entity.db.Book;
import com.h2.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    @GetMapping("/search")
    public List<Book> getBooksBySearchTerm(@RequestParam(value = "searchTerm", required = true) String searchTerm) {
        List<Book> books = bookService.getBooksBySearchTerm(searchTerm);
        logger.info("Books found: {}", books.size());
        return books;
    }


    @RequestMapping("/error")
    public String handleError() {
        // return custom error view
        return "errorPage";
    }

}
