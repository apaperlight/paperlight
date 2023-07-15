package com.paper.service;

import com.paper.entity.Book;
import com.paper.mapper.BookMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookService {
    @Resource
    BookMapper bookMapper;
    public List<Book> getBookList(){
        return bookMapper.getAllBook();
    }
    public Book getBook(Long bid){
        return bookMapper.getBook(bid);
    }
}
