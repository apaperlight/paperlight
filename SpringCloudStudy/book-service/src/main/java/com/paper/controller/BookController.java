package com.paper.controller;

import com.paper.entity.Book;
import com.paper.service.BookService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/book")
@RefreshScope
public class BookController {
    @Resource
    BookService bookService;
    @Value("${test}")
    String test;
    @GetMapping("/all")
    public List<Book> bookList(){
        return bookService.getBookList();
    }
    @GetMapping("/{bid}")
    public Book getBookByBid(@PathVariable Long bid){
        System.out.println(test);
        return bookService.getBook(bid);
    }
}
