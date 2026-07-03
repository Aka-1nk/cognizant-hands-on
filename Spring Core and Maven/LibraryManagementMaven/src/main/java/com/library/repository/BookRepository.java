package com.library.repository;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {

    private List<String> books = new ArrayList<>();

    public BookRepository() {
        // Adding some initial data
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
        return "Available books: " + String.join(", ", books);
    }

    public int getBookCount() {
        return books.size();
    }
}