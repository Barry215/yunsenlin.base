package cn.yunsenlin.web.base.base;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.servlet.http.HttpSession;

/**
 * Spring 基本内容
 * Created by RichardW on 9/16/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring-dao.xml","classpath:config/spring-service.xml","classpath:config/spring-mvc.xml"})
public class SpringTestBase {
    private MockHttpServletRequest request = new MockHttpServletRequest();
    private MockHttpServletResponse response =new MockHttpServletResponse();

    public HttpSession getSession() {
        return request.getSession();
    }

    public MockHttpServletRequest getRequest() {
        return request;
    }

    public MockHttpServletResponse getResponse() {
        return response;
    }

    protected ApplicationContext app = new ClassPathXmlApplicationContext("config/spring-dao.xml","classpath:config/spring-service.xml","classpath:config/spring-mvc.xml");

    @Test
    public void test(){

    }
}
