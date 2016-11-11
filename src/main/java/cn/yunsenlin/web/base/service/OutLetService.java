package cn.yunsenlin.web.base.service;

public interface OutLetService {
    boolean sendPhone(String phone);
    boolean sendEmail(String email);
    boolean checkPhoneCode(String code,String phone);
    boolean checkEmailCode(String code,String email);
}
