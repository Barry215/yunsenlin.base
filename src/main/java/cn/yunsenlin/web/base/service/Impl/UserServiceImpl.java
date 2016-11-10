package cn.yunsenlin.web.base.service.Impl;

import cn.yunsenlin.web.base.dao.UserMapper;
import cn.yunsenlin.web.base.factory.RegxFactory;
import cn.yunsenlin.web.base.model.User;
import cn.yunsenlin.web.base.service.EncryptionService;
import cn.yunsenlin.web.base.service.UserService;

public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final EncryptionService aesEncryptionService;

    public UserServiceImpl(UserMapper userMapper, EncryptionService aesEncryptionService) {
        this.userMapper = userMapper;
        this.aesEncryptionService = aesEncryptionService;
    }

    @Override
    public boolean login(String loginName, String password) {
        if (loginName.matches(RegxFactory.mobileRegx)){
            User user = userMapper.selectByEmail(loginName);
            if (user!=null&&
                    user.getPassword().equals(
                            aesEncryptionService.encrypt(
                                    password,user.getPhone().substring(2,8)
                            )
                    )
                    ){
                return true;
            }
        }else if (loginName.matches(RegxFactory.phoneRegx)){
            User user = userMapper.selectByPhone(loginName);
            if (user!=null&&
                    user.getPassword().equals(
                            aesEncryptionService.encrypt(
                                    password,user.getPhone().substring(2,8)
                            )
                    )
                    ){
                return true;
            }
        }
        return false;
    }

    @Override
    public User loginToGetUser(String loginName, String password) {
        if (login(loginName,password)
                &&loginName.matches(RegxFactory.mobileRegx)){
            return userMapper.selectByPhone(loginName);
        }else if (login(loginName,password)
                &&loginName.matches(RegxFactory.mobileRegx)) {
            return userMapper.selectByEmail(loginName);
        }
            return null;

    }

    @Override
    public void signIn(User user) {
        user.setPassword(
                aesEncryptionService.encrypt(
                        user.getPassword(),
                        user.getPhone().substring(2,8)
                )
        );
        userMapper.insertSelective(user);
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
