package com.paper.service.client;

import com.paper.entity.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "bookservice",fallback = BookClientFallback.class)
public interface BookClient {
    @GetMapping("/book/{bid}")
    Book getBookByBid(@PathVariable Long bid);
}
