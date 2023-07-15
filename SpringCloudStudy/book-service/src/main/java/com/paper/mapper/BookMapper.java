package com.paper.mapper;

import com.paper.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface BookMapper {
    @Select("select * from book")
    List<Book> getAllBook();
    @Select("select * from book where bid = #{bid}")
    Book getBook(Long bid);
}
