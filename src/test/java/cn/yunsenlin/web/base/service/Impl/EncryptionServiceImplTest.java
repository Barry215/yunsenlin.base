package cn.yunsenlin.web.base.service.Impl;

import cn.yunsenlin.web.base.base.SpringTestBase;
import cn.yunsenlin.web.base.service.EncryptionService;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EncryptionServiceImplTest extends SpringTestBase {
    private EncryptionService aesEncryptionService
            = (EncryptionService) app.getBean("aesEncryptionService");
    @Test
    public void encrypt() throws Exception {
        Assert.assertEquals(
                aesEncryptionService.encrypt(
                        "Nihao","123456"
                ),"jJNv9HvKQS1xkhukosNBLw=="
        );
    }

    @Test
    public void decrypt() throws Exception {
        Assert.assertEquals(
                aesEncryptionService.decrypt(
                        "jJNv9HvKQS1xkhukosNBLw==",
                        "123456"
                ),"Nihao"
        );
    }

}