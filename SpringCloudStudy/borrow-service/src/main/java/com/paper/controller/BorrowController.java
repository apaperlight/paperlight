package com.paper.controller;

import com.paper.entity.Book;
import com.paper.entity.Borrow;
import com.paper.entity.BorrowDetail;
import com.paper.entity.User;
import com.paper.service.BorrowService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/borrow")
public class BorrowController {
    @Resource
    BorrowService borrowService;
    @GetMapping("/{uid}")
    public BorrowDetail getBorrowByUid(@PathVariable Long uid){
        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject("http://localhost:8101/user/" + uid, User.class);
        List<Borrow> list = borrowService.getUserBorrow(uid);
        List<Book> bookList = list.stream().map(b -> restTemplate.getForObject("http://localhost:8301/book/" + b.getBid(), Book.class)).collect(Collectors.toList());
        return new BorrowDetail(user,bookList);
    }
}
