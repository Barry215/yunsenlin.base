package cn.yunsenlin.web.base.service.Impl;

import cn.yunsenlin.web.base.dao.EmailSendRecordMapper;
import cn.yunsenlin.web.base.dao.PhoneSendRecordMapper;
import cn.yunsenlin.web.base.factory.RegxFactory;
import cn.yunsenlin.web.base.model.EmailSendRecord;
import cn.yunsenlin.web.base.model.PhoneSendRecord;
import cn.yunsenlin.web.base.service.EncryptionService;
import cn.yunsenlin.web.base.service.OutLetService;
import cn.yunsenlin.web.base.service.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

public class OutLetServiceImpl implements OutLetService {
    private final EmailSendRecordMapper emailSendRecordMapper;
    private final PhoneSendRecordMapper phoneSendRecordMapper;
    private final EncryptionService encryptionService;
    private final TokenService tokenService;
    private final Logger logger =
            LoggerFactory.getLogger(this.getClass());
    public OutLetServiceImpl(EmailSendRecordMapper emailSendRecordMapper, PhoneSendRecordMapper phoneSendRecordMapper, EncryptionService encryptionService, TokenService tokenService) {
        this.emailSendRecordMapper = emailSendRecordMapper;
        this.phoneSendRecordMapper = phoneSendRecordMapper;
        this.encryptionService = encryptionService;
        this.tokenService = tokenService;
    }

    @Override
    public boolean sendPhone(String phone) {
        List<PhoneSendRecord> phoneSendRecordList
                = phoneSendRecordMapper.selectByPrimaryKey(phone);
        Date now = new Date();
        int repeatCount=0;
        for (PhoneSendRecord p: phoneSendRecordList) {
            if (now.getTime()-p.getTime().getTime()<RegxFactory.phoneAvailableTime){
                repeatCount++;
            }
        }
        if (repeatCount>=10){
            return false;
        }
        String code = tokenService.getEmailAndPhoneCode();
        RegxFactory.nowPhoneCodeJustForTest =code;
        logger.info("发送到手机"+phone+"短信验证码"+code);
        String codeEncryption = encryptionService.encrypt(code, RegxFactory.phoneCode);
        PhoneSendRecord phoneSendRecord
                = new PhoneSendRecord(phone,codeEncryption);
        phoneSendRecordMapper.insertSelective(phoneSendRecord);
        return true;
    }

    @Override
    public boolean sendEmail(String email) {
        List<EmailSendRecord> emailSendRecordList
                = emailSendRecordMapper.selectByPrimaryKey(email);
        Date now = new Date();
        int repeatCount=0;
        for (EmailSendRecord e: emailSendRecordList) {
            if (now.getTime()-e.getTime().getTime()<RegxFactory.emailAvailableTime){
                repeatCount++;
            }
        }
        if (repeatCount>=10){
            return false;
        }
        String code = tokenService.getEmailAndPhoneCode();
        RegxFactory.nowEmailCodeJustForTest = code;
        logger.info("发送到邮箱"+email+"邮箱验证码"+code);
        String codeEncryption = encryptionService.encrypt(code, RegxFactory.emailCode);
        EmailSendRecord emailSendRecord
                = new EmailSendRecord(email,codeEncryption);
        emailSendRecordMapper.insertSelective(emailSendRecord);
        return true;
    }

    @Override
    public boolean checkPhoneCode(String code, String phone) {
        List<PhoneSendRecord> phoneSendRecordList
                = phoneSendRecordMapper.selectByPrimaryKey(phone);
        if (phoneSendRecordList!=null&&phoneSendRecordList.size()>0){
            String rightCode = encryptionService.decrypt(
                    phoneSendRecordList.get(0).getCode(),RegxFactory.phoneCode
            );
            Date now = new Date();
            Date sendTime = phoneSendRecordList.get(0).getTime();
            if (rightCode.equals(code)&&now.getTime()-sendTime.getTime()<RegxFactory.phoneAvailableTime){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkEmailCode(String code, String email) {
        List<EmailSendRecord> emailSendRecordList
                = emailSendRecordMapper.selectByPrimaryKey(email);
        if (emailSendRecordList!=null&&emailSendRecordList.size()>0){
            String rightCode = encryptionService.decrypt(
                    emailSendRecordList.get(0).getCode(),
                    RegxFactory.emailCode
            );
            Date now = new Date();
            Date sendTime = emailSendRecordList.get(0).getTime();
            if (rightCode.equals(code)&&now.getTime()-sendTime.getTime()<RegxFactory.emailAvailableTime){
                return true;
            }
        }
        return false;
    }
}
