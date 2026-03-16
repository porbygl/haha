package com.liuyu;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
@DisplayName("用户信息的测试类")
public class UserServiceTest {
    private UserService userService;
    @BeforeEach
    public void beforeEach() {userService = new UserService(); }
    @BeforeAll
    public static void beforeAll(){
        System.out.println("开始测试,only appear one");
    }
    @AfterAll
    public static void afterAll(){
        System.out.println("结束测试,only appear one");
    }
    @AfterEach
    public void afterEach(){
        System.out.println("结束测试");
    }
    @Test
   public void testGetAge(){
            Integer age = userService.getAge("430123199001011234");
            System.out.println(age);
        }
    @Test
    public void testGetGender(){
        String gender = userService.getGender("430123199001011234");
        System.out.println(gender);
    }

    /*
     *断言
     */
    @Test
    public void testGetGenderWithAssert(){
        String gender = userService.getGender("430123199001011234");
        Assertions.assertEquals("男",gender,"性别获取逻辑有问题");
    }

    @DisplayName("异常是否正常")
    @Test
    public void testGetGenderWithAssert2(){
        Assertions.assertThrows(IllegalArgumentException.class,()->{
            userService.getGender(null);
        });
    }

    /*
    参*数化测试
     */
    @DisplayName("测试用户性别")
    @ParameterizedTest
    @ValueSource(strings = {"110101199001011234", "110101199001011235"})
    public void testGetGender2(String idCard){
        String gender = userService.getGender(idCard);
        Assertions.assertEquals("男",gender,"性别获取逻辑有问题");
    }
}
