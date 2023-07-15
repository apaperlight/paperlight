package com.paper.service;

import com.paper.entity.Borrow;
import com.paper.mapper.BorrowMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BorrowService {
    @Resource
    BorrowMapper borrowMapper;
    public List<Borrow> getUserBorrow(Long uid){
        return borrowMapper.getUserBorrow(uid);
    }
}
