package cn.yunsenlin.web.base.factory;

public class RegxFactory {
    public final static String phoneRegx = "^1[34578]\\d{9}$";
    public final static String emailRegx = "^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$";
    public final static String tokenPassword = "123456";
    public final static String phoneCode = "123456";
    public final static String emailCode = "123456";
    public static String nowEmailCodeJustForTest ="";
    public static String nowPhoneCodeJustForTest ="";
    public final static Long rememberTokenLong = 6048000000L;
    public final static Long tokenLong = 1800000L;
    final static int bigDecimalCleanTime = 3600000;
    final static int bigDecimalMaxSize = 10000;
    public final static int emailAvailableTime = 1800000;
    public final static int phoneAvailableTime = 1800000;

}
