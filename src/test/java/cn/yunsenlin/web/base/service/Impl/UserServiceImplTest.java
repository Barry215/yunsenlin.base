package cn.yunsenlin.web.base.service.Impl;

import cn.yunsenlin.web.base.base.SpringTestBase;
import cn.yunsenlin.web.base.dao.UserMapper;
import cn.yunsenlin.web.base.model.User;
import cn.yunsenlin.web.base.service.UserService;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceImplTest extends SpringTestBase {
    private UserService userService
            = (UserService) app.getBean("userService");
    private UserMapper userMapper
            = (UserMapper)app.getBean("userMapper");
    @Test
    public void login() throws Exception {
        int userId =signOne();
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
        deleteOne(userId);
    }

    @Test
    public void signIn() throws Exception {
        int UserId = signOne();
        deleteOne(UserId);
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