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
                "2","4","100001","1"),"0.0041");
        Assert.assertEquals(service.getLogVolumeAutoCalculate(
                "2","5","100001","1"),"0.0058");
        Assert.assertEquals(service.getLogVolumeAutoCalculate(
                "2","6","100001","1"),"0.0079");
        Assert.assertEquals(service.getLogVolumeAutoCalculate(
                "2","7","100001","1"),"0.0103");
        Assert.assertEquals(service.getLogVolumeAutoCalculate(
                "2","8","100001","1"),"0.013");
        Assert.assertEquals(service.getLogVolumeAutoCalculate(
                "2","9","100001","1"),"0.016");
        Assert.assertEquals(service.getLogVolumeAutoCalculate(
                "2","10","100001","1"),"0.019");
        Assert.assertEquals(service.getLogVolumeAutoCalculate(
                "2","11","100001","1"),"0.023");
        Assert.assertEquals(service.getLogVolumeAutoCalculate(
                "2","12","100001","1"),"0.027");
        Assert.assertEquals(service.getLogVolumeAutoCalculate(
                "2","13","100001","1"),"0.031");
        Assert.assertEquals(service.getLogVolumeAutoCalculate(
                "2","14","100001","1"),"0.036");
        Assert.assertEquals(service.getLogVolumeAutoCalculate(
                "2","16","100001","1"),"0.047");
        Assert.assertEquals(service.getLogVolumeAutoCalculate(
                "2","18","100001","1"),"0.059");
        Assert.assertEquals(service.getLogVolumeAutoCalculate(
                "10.8","4","100001","1"),"0.076");
        Assert.assertEquals(service.getLogVolumeAutoCalculate(
                "18","100","100001","1"),"17.109");
        Assert.assertEquals(service.getLogVolumeAutoCalculate(
                "0.5","20","100001","1"),"0.016");
        Assert.assertEquals(service.getLogVolumeAutoCalculate(
                "1.3","76","100001","1"),"0.611");
        Assert.assertEquals(service.getLogVolumeAutoCalculate(
                "1.4","8","100007","1"),"0.008");
        Assert.assertEquals(service.getLogVolumeAutoCalculate(
                "1.8","10","100007","1"),"0.017");
        Assert.assertEquals(service.getLogVolumeAutoCalculate(
                "3.8","16","100012","1"),"0.100");
        Assert.assertEquals(service.getLogVolumeAutoCalculate(
                "3.8","11","100012","1"),"0.050");
        Assert.assertEquals(service.getLogVolumeAutoCalculate(
                "3.8","11","100003","1"),"0.050");
        Assert.assertEquals(service.getLogVolumeAutoCalculate(
                "1","3","100003","1"),"0.0010");
    }
    @Test
    public void isNumber(){
        Assert.assertEquals(BigDecimalFactory.isNumber("11"),true);
    }

}