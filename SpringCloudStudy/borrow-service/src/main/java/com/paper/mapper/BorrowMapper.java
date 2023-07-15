package com.paper.mapper;

import com.paper.entity.Borrow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BorrowMapper {
    @Select("select * from borrow where uid = #{uid}")
    List<Borrow> getUserBorrow(Long uid);
}
