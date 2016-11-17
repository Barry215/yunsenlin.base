package cn.yunsenlin.web.base.service.Impl;

import cn.yunsenlin.web.base.base.SpringTestBase;
import cn.yunsenlin.web.base.factory.BigDecimalFactory;
import org.junit.Assert;
import org.junit.Test;


public class VolumeAutoCalculateServiceImplTest extends SpringTestBase{
    private VolumeAutoCalculateServiceImpl service
            = (VolumeAutoCalculateServiceImpl) app.getBean("volumeAutoCalculateService");
    @Test
    public void getVolumeAutoCalculate() throws Exception {
        Assert.assertEquals(service.getLogVolumeAutoCalculate(
                "1.3","18","1","100001"),"0.036");
    }
    @Test
    public void isNumber(){
        Assert.assertEquals(BigDecimalFactory.isNumber("11"),true);
    }

}