package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApplication {

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("   📚 Library Management System         ");
        System.out.println("   - Spring Framework with AOP & WebMVC ");
        System.out.println("==========================================");
        System.out.println();

        // Load Spring context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get BookService bean
        BookService bookService = context.getBean(BookService.class);

        // Display all books
        System.out.println("📖 Current Books in Library:\n");
        System.out.println("   " + bookService.listAllBooks());
        System.out.println();

        // Add a new book
        System.out.println("📝 Adding a new book...");
        System.out.println("   " + bookService.addBook("The Catcher in the Rye"));
        System.out.println();

        // Display updated list
        System.out.println("📖 Updated Books in Library:\n");
        System.out.println("   " + bookService.listAllBooks());
        System.out.println();

        // Get a specific book
        System.out.println("🔍 Searching for book with ID 2:");
        System.out.println("   " + bookService.getBook(2));
        System.out.println();

        // Remove a book
        System.out.println("🗑️ Removing book with ID 0:");
        System.out.println("   " + bookService.removeBook(0));
        System.out.println();

        // Final book list
        System.out.println("📖 Final Books in Library:\n");
        System.out.println("   " + bookService.listAllBooks());
        System.out.println();

        System.out.println("✅ Application ran successfully!");
        System.out.println("   Total books: " + bookService.getTotalBooks());
        System.out.println("==========================================");

        // Close context
        ((ClassPathXmlApplicationContext) context).close();
    }
}