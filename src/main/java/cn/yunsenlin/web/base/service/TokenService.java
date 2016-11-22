package cn.yunsenlin.web.base.service;

import java.util.Date;

public interface TokenService {
    String getUniqueString();
    Date getTokenDate(String token);
    String getEmailAndPhoneCode();
}
