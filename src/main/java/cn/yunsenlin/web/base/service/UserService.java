package cn.yunsenlin.web.base.service;

import cn.yunsenlin.web.base.model.User;

public interface UserService {
    boolean login(String loginName,String password);
    void signIn(User user);
    String sendActivatedEmail(String email);
    String sendActivatedMessage(String phone);
    String sendForgetPasswordEmail(String email);
    String sendForgetPasswordMessage(String phone);
    String sendModifyEmailOrPhoneActivatedEmail(String email);
    String sendModifyEmailOrPhoneActivatedPhoen(String phone);
}