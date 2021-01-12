package com.example.dao;

import com.example.pojo.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TestMapper
{
    @Select("select * from user where id=#{id}")
    public Users getUserBysql(int id);

}
