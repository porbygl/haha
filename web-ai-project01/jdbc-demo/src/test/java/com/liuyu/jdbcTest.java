package com.liuyu;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbcTest {
    @SneakyThrows
    @Test
    public void testUpdate() {
//        注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
//        获取数据库连接
        String url="jdbc:mysql://localhost:3306/web01";
        String username="root";
        String password="1234";
        Connection connection = DriverManager.getConnection(url, username, password);
//        获取sql语句执行对象
        Statement statement = connection.createStatement();
//        执行sql

        int i = statement.executeUpdate("update user set age=25 where id=1");
        System.out.println("sql执行完后影响的记录数："+i);
//        释放资源
        statement.close();
        connection.close();
    }
}
