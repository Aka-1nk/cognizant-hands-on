package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    // Dependency
    private BookRepository bookRepository;

    // ===== SETTER METHOD FOR DEPENDENCY INJECTION =====
    public void setBookRepository(BookRepository bookRepository) {
        System.out.println("🔧 Spring is injecting BookRepository via setter!");
        this.bookRepository = bookRepository;
    }

    // ===== BUSINESS METHODS =====
    public String getBook(int id) {
        System.out.println("📖 Getting book with ID: " + id);
        return bookRepository.findBookById(id);
    }

    public String addBook(String bookName) {
        System.out.println("📝 Adding new book: " + bookName);
        return bookRepository.saveBook(bookName);
    }

    public String removeBook(int id) {
        System.out.println("🗑️ Removing book with ID: " + id);
        return bookRepository.deleteBook(id);
    }

    public String listAllBooks() {
        System.out.println("📋 Listing all books");
        return bookRepository.getAllBooks();
    }

    public int getTotalBooks() {
        return bookRepository.getBookCount();
    }
}