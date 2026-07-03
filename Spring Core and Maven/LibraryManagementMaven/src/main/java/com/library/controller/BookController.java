package com.library.controller;

import com.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    @ResponseBody
    public String getAllBooks() {
        return bookService.listAllBooks();
    }

    @GetMapping("/status")
    @ResponseBody
    public String getStatus() {
        return "Library Management System is running! Total books: " + bookService.getTotalBooks();
    }
}