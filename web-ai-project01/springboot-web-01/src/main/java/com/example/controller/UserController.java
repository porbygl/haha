package com.example.controller;

import cn.hutool.core.io.IoUtil;
import com.example.pojo.User;
import com.example.service.UserService;
import com.example.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class UserController {

//    方式一：属性注入
//    @Autowired
//    private UserService userService;

////    方式二：构造器注入  加上final表示初始化后不能在改变
//    private final UserService userService;
//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

//    方式三：setter注入
        private  UserService userService;
        @Autowired
        public void setUserService(UserService userService) {
            this.userService = userService;
        }


//    @RequestMapping("/list")
//    public List<User> list() throws FileNotFoundException {
//        //加载并读取user.txt文件
//        //这种因为路径写死了，所以不推荐
//        //InputStream in = new FileInputStream("D:\\weba\\web-ai-project01\\springboot-web-01\\src\\main\\resources\\user.txt");
//        InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.txt");
//        ArrayList<String> lines = IoUtil.readLines(in, StandardCharsets.UTF_8, new ArrayList<>());
//
//
//
//        //解析用户对象，封装为User对象->list 集合
//        List<User> userList = lines.stream().map(line -> {
//            String[] parts = line.split(",");
//            return new User(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3], Integer.parseInt(parts[4]), LocalDateTime.parse(parts[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
//        }).toList();
//        //返回数据  服务器自动把集合转化为字符串
//        return userList;
//    }
    @RequestMapping("/list")
    public List<User> list() throws FileNotFoundException {
        //加载并读取user.txt文件
        //这种因为路径写死了，所以不推荐
        //InputStream in = new FileInputStream("D:\\weba\\web-ai-project01\\springboot-web-01\\src\\main\\resources\\user.txt");



        //解析用户对象，封装为User对象->list 集合
        List<User> userList = userService.findAll();
        //返回数据  服务器自动把集合转化为字符串
        return userList;
    }
}
