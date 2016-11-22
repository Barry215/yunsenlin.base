package cn.yunsenlin.web.base.service;

import cn.yunsenlin.web.base.model.User;

public interface UserService {
    boolean login(String loginName,String password);
    User loginToGetUser(String loginName,String password);
    void signIn(User user);
    void modifyPasswordByPhone(String phone, String password);
    boolean hasEmail(String email);
    boolean hasPhone(String phone);
    String sendEmailToSignIn(String email);
    String sendEmailToGetBackPassword(String email);
    String sendPhoneToSignIn(String email);
    String sendPhoneToGetBackPassword(String email);
}
