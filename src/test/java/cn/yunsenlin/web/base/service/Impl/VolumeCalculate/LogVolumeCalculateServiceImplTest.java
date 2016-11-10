package cn.yunsenlin.web.base.service.Impl.VolumeCalculate;


import cn.yunsenlin.web.base.base.SpringTestBase;
import cn.yunsenlin.web.base.service.VolumeCalculateService;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class LogVolumeCalculateServiceImplTest extends SpringTestBase{
    private VolumeCalculateService logVolumeCalculateService
            = (VolumeCalculateService) app.getBean("logVolumeCalculateService");
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void getVolumeCalculateResult(){
        logger.info("正在测试每个木材积计算器");
        logger.info("正在测试原木木材积计算器");
        Assert.assertEquals(
                logVolumeCalculateService.getVolumeCalculateResult(
                        new BigDecimal("1.3"),new BigDecimal("12")
                ),new BigDecimal("0.017")
        );
        Assert.assertEquals(
                logVolumeCalculateService.getVolumeCalculateResult(
                        new BigDecimal("1"),new BigDecimal("1")
                ),new BigDecimal("-1")
        );
        logger.info("原木木材积计算器测试结束");
    }
}