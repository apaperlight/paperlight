package com.paper.mapper;

import com.paper.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from user where uid = #{uid}")
    User getUserById(Long uid);
}
