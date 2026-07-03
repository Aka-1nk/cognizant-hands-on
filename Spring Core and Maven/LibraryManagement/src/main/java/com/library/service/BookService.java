package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    // Setter method for dependency injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

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
}