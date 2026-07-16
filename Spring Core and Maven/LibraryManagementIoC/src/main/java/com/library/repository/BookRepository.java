package com.library.repository;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    private List<String> books;

    // Constructor
    public BookRepository() {
        this.books = new ArrayList<>();
        // Add some initial books
        books.add("The Great Gatsby");
        books.add("To Kill a Mockingbird");
        books.add("1984");
        books.add("Pride and Prejudice");
    }

    public String findBookById(int id) {
        if (id >= 0 && id < books.size()) {
            return "Book: " + books.get(id) + " (ID: " + id + ")";
        }
        return "Book with ID: " + id + " not found";
    }

    public String saveBook(String bookName) {
        books.add(bookName);
        return "Book '" + bookName + "' saved successfully! (ID: " + (books.size() - 1) + ")";
    }

    public String deleteBook(int id) {
        if (id >= 0 && id < books.size()) {
            String removedBook = books.remove(id);
            return "Book '" + removedBook + "' deleted successfully!";
        }
        return "Book with ID: " + id + " not found";
    }

    public String getAllBooks() {
        if (books.isEmpty()) {
            return "No books available";
        }
        return String.join(", ", books);
    }

    public int getBookCount() {
        return books.size();
    }
}