package com.library.repository;

public class BookRepository {

    public String findBookById(int id) {
        return "Book with ID: " + id + " found in repository";
    }

    public String saveBook(String bookName) {
        return "Book '" + bookName + "' saved successfully!";
    }

    public String deleteBook(int id) {
        return "Book with ID: " + id + " deleted successfully!";
    }

    public String getAllBooks() {
        return "List of all books from repository";
    }
}