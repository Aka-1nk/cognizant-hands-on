package com.library.service;

import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public String getBook(int id) {
        return bookRepository.findBookById(id);
    }

    public String addBook(String bookName) {
        return bookRepository.saveBook(bookName);
    }

    public String removeBook(int id) {
        return bookRepository.deleteBook(id);
    }

    public String listAllBooks() {
        return bookRepository.getAllBooks();
    }

    public int getTotalBooks() {
        return bookRepository.getBookCount();
    }
}