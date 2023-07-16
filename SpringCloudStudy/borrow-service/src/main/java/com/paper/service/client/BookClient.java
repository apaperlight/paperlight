package com.paper.service.client;

import com.paper.entity.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("bookservice")
public interface BookClient {
    @GetMapping("/book/all")
    public List<Book> bookList();
    @GetMapping("/book/{bid}")
    public Book getBookByBid(@PathVariable Long bid);

}
