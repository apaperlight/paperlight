package com.paper.service.client;

import com.paper.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookClientFallback implements BookClient{
    @Override
    public Book getBookByBid(Long bid) {
        return new Book();
    }
}
