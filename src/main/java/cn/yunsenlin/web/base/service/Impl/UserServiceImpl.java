package cn.yunsenlin.web.base.service.Impl;

import cn.yunsenlin.web.base.model.User;
import cn.yunsenlin.web.base.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public boolean login(String loginName, String password) {
        return false;
    }

    @Override
    public void signIn(User user) {

    }

    @Override
    public String sendActivatedEmail(String email) {
        return null;
    }

    @Override
    public String sendActivatedMessage(String phone) {
        return null;
    }

    @Override
    public String sendForgetPasswordEmail(String email) {
        return null;
    }

    @Override
    public String sendForgetPasswordMessage(String phone) {
        return null;
    }

    @Override
    public String sendModifyEmailOrPhoneActivatedEmail(String email) {
        return null;
    }

    @Override
    public String sendModifyEmailOrPhoneActivatedPhoen(String phone) {
        return null;
    }
}
