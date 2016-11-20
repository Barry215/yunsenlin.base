package cn.yunsenlin.web.base.service.Impl;

import cn.yunsenlin.web.base.base.SpringTestBase;
import cn.yunsenlin.web.base.service.GsonService;
import cn.yunsenlin.web.base.service.SigarService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SigarServiceImplTest extends SpringTestBase {
    private Logger logger = LoggerFactory.getLogger(SigarServiceImpl.class);
    private SigarService sigarService
            = (SigarService) app.getBean("sigarService");
    private GsonService gsonService
            = (GsonService) app.getBean("gsonService");
    @Test
    public void getCpu() throws Exception {
        logger.info(
                gsonService.toJson(sigarService.getCpu())
        );
    }

    @Test
    public void getNet() throws Exception {
        logger.info(
                gsonService.toJson(sigarService.getNet())
        );
    }

    @Test
    public void getEthernet() throws Exception {
        logger.info(
                gsonService.toJson(sigarService.getEthernet())
        );
    }

    @Test
    public void getOs() throws Exception {
        logger.info(
                gsonService.toJson(sigarService.getOs())
        );
    }

    @Test
    public void getWho() throws Exception {
        logger.info(
                gsonService.toJson(sigarService.getWho())
        );
    }

    @Test
    public void getDisk() throws Exception {
        logger.info(
                gsonService.toJson(sigarService.getDisk())
        );
    }
    @Test
    public void getJava() throws Exception {
        logger.info(
                gsonService.toJson(sigarService.getJavaProperty())
        );
    }
    @Test
    public void getMemory() throws Exception{
        logger.info(
                gsonService.toJson(sigarService.getMemory())
        );
    }
}