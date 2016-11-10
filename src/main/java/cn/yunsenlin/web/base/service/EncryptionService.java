package cn.yunsenlin.web.base.service;

public interface EncryptionService {
    String encrypt(String content,String password);
    String decrypt(String content,String password);
}
