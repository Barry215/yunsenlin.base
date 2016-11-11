package cn.yunsenlin.web.base.service.Impl;

import cn.yunsenlin.web.base.base.SpringTestBase;
import cn.yunsenlin.web.base.dao.UserMapper;
import cn.yunsenlin.web.base.model.User;
import cn.yunsenlin.web.base.service.UserService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserServiceImplTest extends SpringTestBase {
    private UserService userService
            = (UserService) app.getBean("userService");
    private UserMapper userMapper
            = (UserMapper)app.getBean("userMapper");
    private int userId;
    @Before
    public void before(){
        User user = userMapper.selectByEmail("1277287015@qq.com");
        if (user!=null){
            userMapper.deleteByPrimaryKey(user.getUserId());
        }
        userId =signOne();
    }
    @After
    public void after(){
        deleteOne(userId);
    }
    @Test
    public void login() throws Exception {
        Assert.assertEquals(
                userService.login(
                        "1277287015@qq.com",
                        "123456"
                ),true
        );
        Assert.assertEquals(
                userService.login(
                        "18100174605",
                        "123456"
                ),true
        );
    }

    private int signOne(){
        User user = new User();
        user.setEmail("1277287015@qq.com");
        user.setPassword("123456");
        user.setPhone("18100174605");
        userService.signIn(user);
        return user.getUserId();
    }
    private void deleteOne(int userId){
        userMapper.deleteByPrimaryKey(userId);
    }

}