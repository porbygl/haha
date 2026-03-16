package com.liuyu;

import com.liuyu.mapper.UserMapper;
import com.liuyu.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest  //表示当前测试类中的测试方法运行时，会启动SpringBoot项目
class SpringbootMybatisQuickstartApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testFindAll() {
        List<User> users = userMapper.findAll();
        users.forEach(System.out::println);
    }
    @Test
    public void testDeleteById() {
        Integer i = userMapper.deleteById(4);
        System.out.println("结束后影响的记录数："+i);
    }

    @Test
    public void testInsert() {
        User user = new User(null,18,"gaoyuanyuan","666888","高圆圆");
        userMapper.insert(user);
    }

    @Test
    public void testUpdate() {
        User user = new User(1,18,"gaoyuan","666888","高圆圆");
        Integer update = userMapper.update(user);
        System.out.println("受影响的行数："+update);
    }
    /**测试查询 */
    @Test
    public void testFindByUsernameAndPassword() {
        User user = userMapper.findByUsernameAndPassword("gaoyuan","666888");
        System.out.println(user);
    }
}
