package cn.yunsenlin.web.base.service;

import java.util.Date;

public interface TokenService {
    String getUniqueTokenString();
    Date getTokenDate(String token);
}
