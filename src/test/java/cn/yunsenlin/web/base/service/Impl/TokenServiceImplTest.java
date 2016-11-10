package cn.yunsenlin.web.base.service.Impl;

import cn.yunsenlin.web.base.base.SpringTestBase;
import cn.yunsenlin.web.base.service.TokenService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TokenServiceImplTest extends SpringTestBase{
    private TokenService tokenService
            = (TokenService) app.getBean("tokenService");
    private final Logger logger =
            LoggerFactory.getLogger(TokenService.class);
    @Test
    public void getUniqueTokenString() throws Exception {
        for (int i=0;i<1000;i++){
            logger.debug("测试TOKEN生成字符串"
            +tokenService.getUniqueTokenString());
            logger.debug(tokenService.getTokenDate(
                    tokenService.getUniqueTokenString()
            ).toString());
        }
    }

}