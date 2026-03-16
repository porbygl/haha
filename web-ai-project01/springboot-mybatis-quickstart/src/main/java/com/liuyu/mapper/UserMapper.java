package com.liuyu.mapper;


import com.liuyu.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper //应用程序运行时，会自动创建一个实现类对象（代理对象），并且自动将其存入ioc容器当中--bean
public interface UserMapper {
//    查询所有用户
//    @Select("select id,username,password,name,age from user")
    public List<User> findAll();

    @Delete("delete from user where id = #{id}")
    public Integer deleteById(Integer i);

    @Insert("insert into user(username,password,name,age) values (#{username},#{password},#{name},#{age})")
    public Integer insert(User user);

    @Update("update user set username=#{username} , password = #{password},name=#{name},age=#{age} where id = #{id}")
    public Integer update(User user);

    /**
     * 根据用户名和密码查询用户信息

     */
    @Select("SELECT * from user where username = #{username} and password = #{password}")
    public User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}

// ceshi





















































