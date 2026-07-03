package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApplication {

    public static void main(String[] args) {
        System.out.println("======================================");
        System.out.println("   📚 Library Management System      ");
        System.out.println("   - Using Setter Injection         ");
        System.out.println("======================================");
        System.out.println();

        // Load the Spring context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get the BookService bean
        BookService bookService = context.getBean(BookService.class);

        // Test the service methods
        System.out.println("📖 Testing BookService with Setter Injection:\n");

        System.out.println("1️⃣ Get Book (ID: 101)");
        System.out.println("   ➜ " + bookService.getBook(101));
        System.out.println();

        System.out.println("2️⃣ Add New Book");
        System.out.println("   ➜ " + bookService.addBook("The Great Gatsby"));
        System.out.println();

        System.out.println("3️⃣ List All Books");
        System.out.println("   ➜ " + bookService.listAllBooks());
        System.out.println();

        System.out.println("4️⃣ Remove Book (ID: 201)");
        System.out.println("   ➜ " + bookService.removeBook(201));
        System.out.println();

        System.out.println("✅ Dependency Injection using Setter Injection works!");
        System.out.println("======================================");

        // Display dependency info
        System.out.println("\n🔍 Dependency Information:");
        System.out.println("   BookService depends on BookRepository");
        System.out.println("   Spring injected BookRepository via setter method");
        System.out.println("   Configuration: applicationContext.xml");

        // Close the context
        ((ClassPathXmlApplicationContext) context).close();
    }
}