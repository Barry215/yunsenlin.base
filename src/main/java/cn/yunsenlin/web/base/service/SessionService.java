package cn.yunsenlin.web.base.service;

import cn.yunsenlin.web.base.model.User;

public interface SessionService {
    void insert(String token,
                User user,
                Object object,
                String description);
    Object get(String token,User user,String description);

    boolean checkToken(String token,int userId);
    String createToken(int userId,Long tokenPeriod);
}
