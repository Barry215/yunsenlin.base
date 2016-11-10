package cn.yunsenlin.web.base.service.Impl;

import cn.yunsenlin.web.base.service.EncryptionService;
import cn.yunsenlin.web.base.service.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class TokenServiceImpl implements TokenService {
    private final EncryptionService aesEncryptionService;
    private Date lastTime = new Date();
    private List<String> oneSecond = new ArrayList<>();
    private Logger logger = LoggerFactory.getLogger(TokenService.class);

    public TokenServiceImpl(EncryptionService aesEncryptionService) {
        this.aesEncryptionService = aesEncryptionService;
    }

    @Override
    public String getUniqueTokenString() {
        Date now = new Date();
        if (now.getTime()-lastTime.getTime()<1000){
            logger.info("Token两次间隔响应时间小于1000毫秒!启动重复检验器");
            String result = generate();
            int repeatCount = 0;
            while (oneSecond.contains(result)){
                result = generate();
                logger.warn("重复次数"+repeatCount++);
            }
            oneSecond.add(result);
            logger.info("关闭重复检验器");
            return result;
        }
        lastTime = new Date();
        return generate();
    }

    @Override
    public Date getTokenDate(String token) {
        if (token==null){
            return null;
        }
        String dateString =
                aesEncryptionService.decrypt(
                        token.substring(token.length()-24,token.length()),
                        "123456"
                );
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");//小写的mm表示的是分钟
        try {
            return sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String generate(){
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        int length = random.nextInt(15)+10;
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
        Date date=new Date();
        String time = sdf.format(date);
        String aesTimeString =
                aesEncryptionService.encrypt(
                        time,"123456"
                );
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString()+"_"+aesTimeString;
    }
}
