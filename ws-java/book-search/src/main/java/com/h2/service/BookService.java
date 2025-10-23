package com.h2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2.entity.db.Book;
import com.h2.repo.BookRepo;

@Service
public class BookService {
    
    @Autowired
    private BookRepo bookRepo;

    public List<Book> getBooksBySearchTerm(String searchTerm) {

        if(searchTerm == null || searchTerm.trim().isEmpty()) {
            throw new IllegalArgumentException("Search term must not be null or empty");
        }
        return bookRepo.searchBooks(searchTerm);
    }
}
