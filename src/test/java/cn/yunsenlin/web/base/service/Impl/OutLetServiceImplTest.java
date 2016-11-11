package cn.yunsenlin.web.base.service.Impl;

import cn.yunsenlin.web.base.base.SpringTestBase;
import cn.yunsenlin.web.base.dao.EmailSendRecordMapper;
import cn.yunsenlin.web.base.dao.PhoneSendRecordMapper;
import cn.yunsenlin.web.base.factory.RegxFactory;
import cn.yunsenlin.web.base.service.OutLetService;
import org.junit.Assert;
import org.junit.Test;


public class OutLetServiceImplTest extends SpringTestBase {
    private OutLetService outLetService
            = (OutLetService) app.getBean("outLetService");
    private EmailSendRecordMapper emailSendRecordMapper
            = (EmailSendRecordMapper) app.getBean("emailSendRecordMapper");
    private PhoneSendRecordMapper phoneSendRecordMapper
            = (PhoneSendRecordMapper) app.getBean("phoneSendRecordMapper");
    @Test
    public void sendEmail() throws Exception {
        emailSendRecordMapper.deleteByPrimaryKey("1277287015@qq.com");
        Assert.assertEquals(
                outLetService.sendEmail("1277287015@qq.com"),true);
        Assert.assertEquals(
                outLetService.sendEmail("1277287015@qq.com"),true);
        Assert.assertEquals(
                outLetService.sendEmail("1277287015@qq.com"),true);
        Assert.assertEquals(
                outLetService.sendEmail("1277287015@qq.com"),true);
        Assert.assertEquals(
                outLetService.sendEmail("1277287015@qq.com"),true);
        Assert.assertEquals(
                outLetService.sendEmail("1277287015@qq.com"),true);
        Assert.assertEquals(
                outLetService.sendEmail("1277287015@qq.com"),true);
        Assert.assertEquals(
                outLetService.sendEmail("1277287015@qq.com"),true);
        Assert.assertEquals(
                outLetService.sendEmail("1277287015@qq.com"),true);
        Assert.assertEquals(
                outLetService.sendEmail("1277287015@qq.com"),true);
        Assert.assertEquals(
                outLetService.sendEmail("1277287015@qq.com"),false);
        emailSendRecordMapper.deleteByPrimaryKey("1277287015@qq.com");
    }

    @Test
    public void sendPhone() throws Exception {
        phoneSendRecordMapper.deleteByPrimaryKey("18100174605");
        Assert.assertEquals(
                outLetService.sendPhone("18100174605"),true
        );
        Assert.assertEquals(
                outLetService.sendPhone("18100174605"),true
        );
        Assert.assertEquals(
                outLetService.sendPhone("18100174605"),true
        );
        Assert.assertEquals(
                outLetService.sendPhone("18100174605"),true
        );
        Assert.assertEquals(
                outLetService.sendPhone("18100174605"),true
        );
        Assert.assertEquals(
                outLetService.sendPhone("18100174605"),true
        );
        Assert.assertEquals(
                outLetService.sendPhone("18100174605"),true
        );
        Assert.assertEquals(
                outLetService.sendPhone("18100174605"),true
        );
        Assert.assertEquals(
                outLetService.sendPhone("18100174605"),true
        );
        Assert.assertEquals(
                outLetService.sendPhone("18100174605"),true
        );
        Assert.assertEquals(
                outLetService.sendPhone("18100174605"),false
        );
        phoneSendRecordMapper.deleteByPrimaryKey("18100174605");
    }

    @Test
    public void checkPhoneCode() throws Exception {
        phoneSendRecordMapper.deleteByPrimaryKey("18100174605");
        Assert.assertEquals(
                outLetService.sendPhone("18100174605"),true
        );
        Assert.assertEquals(
                outLetService.sendPhone("18100174605"),true
        );
        String code = RegxFactory.nowPhoneCodeJustForTest;
        Assert.assertEquals(
                outLetService.checkPhoneCode(code,"18100174605")
                ,true
        );
        phoneSendRecordMapper.deleteByPrimaryKey("18100174605");
    }

    @Test
    public void checkEmailCode() throws Exception {
        emailSendRecordMapper.deleteByPrimaryKey("1277287015@qq.com");
        Assert.assertEquals(
                outLetService.sendEmail("1277287015@qq.com"),true
        );
        Assert.assertEquals(
                outLetService.sendEmail("1277287015@qq.com"),true
        );
        String code = RegxFactory.nowEmailCodeJustForTest;
        Assert.assertEquals(
                outLetService.checkEmailCode(
                        code,"1277287015@qq.com"
                ),true
        );
        emailSendRecordMapper.deleteByPrimaryKey("1277287015@qq.com");
    }

}