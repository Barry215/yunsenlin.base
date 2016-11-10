package cn.yunsenlin.web.base.service.Impl;

import cn.yunsenlin.web.base.service.EncryptionService;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

public class EncryptionServiceImpl implements EncryptionService {
    @Override
    public String encrypt(String content, String password) {
        try {
            return base64Encode(
                    aesEncryptToBytes(content, password)
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public String decrypt(String content, String password){
        try {
            return content==null ?
                    null :
                    aesDecryptByBytes(
                            base64Decode(content), password
                    );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
    private String base64Encode(byte[] bytes){
        return new BASE64Encoder().encode(bytes);
    }
    private byte[] base64Decode(String base64Code) throws Exception{
        return base64Code==null ? null : new BASE64Decoder().decodeBuffer(base64Code);
    }
    private byte[] aesEncryptToBytes(String content, String encryptKey) throws Exception {
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        random.setSeed(encryptKey.getBytes());
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128,random);

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(kgen.generateKey().getEncoded(), "AES"));

        return cipher.doFinal(content.getBytes("utf-8"));
    }
    private String aesDecryptByBytes(byte[] encryptBytes, String decryptKey) throws Exception {
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        random.setSeed(decryptKey.getBytes());
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128, random);

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(kgen.generateKey().getEncoded(), "AES"));
        byte[] decryptBytes = cipher.doFinal(encryptBytes);

        return new String(decryptBytes);
    }

}
