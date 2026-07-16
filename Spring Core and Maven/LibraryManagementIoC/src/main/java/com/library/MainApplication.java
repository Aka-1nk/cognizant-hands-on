package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApplication {

    public static void main(String[] args) {
        System.out.println("============================================");
        System.out.println("   📚 Library Management System            ");
        System.out.println("   - XML Configuration with Setter DI     ");
        System.out.println("============================================");
        System.out.println();

        // =========================================
        // 1. Load the Spring IoC Container
        // =========================================
        System.out.println("⏳ Loading Spring IoC Container...");
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("✅ Spring IoC Container loaded successfully!");
        System.out.println();

        // =========================================
        // 2. Get the BookService Bean
        // =========================================
        System.out.println("⏳ Retrieving bookService bean...");
        BookService bookService = context.getBean(BookService.class);
        System.out.println("✅ Retrieved bookService bean!");
        System.out.println();

        // =========================================
        // 3. Display All Books
        // =========================================
        System.out.println("📖 Current Books in Library:\n");
        System.out.println("   ➜ " + bookService.listAllBooks());
        System.out.println("   📊 Total books: " + bookService.getTotalBooks());
        System.out.println();

        // =========================================
        // 4. Add a New Book
        // =========================================
        System.out.println("📝 Adding a new book...");
        System.out.println("   ➜ " + bookService.addBook("The Catcher in the Rye"));
        System.out.println();

        // =========================================
        // 5. Display Updated List
        // =========================================
        System.out.println("📖 Updated Books in Library:\n");
        System.out.println("   ➜ " + bookService.listAllBooks());
        System.out.println("   📊 Total books: " + bookService.getTotalBooks());
        System.out.println();

        // =========================================
        // 6. Search for a Book
        // =========================================
        System.out.println("🔍 Searching for book with ID 2:");
        System.out.println("   ➜ " + bookService.getBook(2));
        System.out.println();

        // =========================================
        // 7. Remove a Book
        // =========================================
        System.out.println("🗑️ Removing book with ID 0:");
        System.out.println("   ➜ " + bookService.removeBook(0));
        System.out.println();

        // =========================================
        // 8. Final Book List
        // =========================================
        System.out.println("📖 Final Books in Library:\n");
        System.out.println("   ➜ " + bookService.listAllBooks());
        System.out.println("   📊 Total books: " + bookService.getTotalBooks());
        System.out.println();

        System.out.println("============================================");
        System.out.println("✅ Application ran successfully!");
        System.out.println("   Dependency Injection via Setter works!");
        System.out.println("============================================");

        // Close the context
        ((ClassPathXmlApplicationContext) context).close();
    }
}