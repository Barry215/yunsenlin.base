package cn.yunsenlin.web.base.factory;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class BigDecimalFactory {
    private static Map<String, BigDecimal> numberMap = new HashMap<>();
    private static Date lastCleanTime = new Date();

    public static BigDecimal get(String number) {
        Date now = new Date();
        Long cleanTimes = now.getTime() - lastCleanTime.getTime();
        if (cleanTimes > RegxFactory.bigDecimalCleanTime || numberMap.size() > RegxFactory.bigDecimalMaxSize) {
            numberMap = new HashMap<>();
            lastCleanTime = new Date();
        }
        if (!numberMap.containsKey(number)) {
            numberMap.put(number, new BigDecimal(number));
        }
        return numberMap.get(number);
    }
    public static boolean isNumber(String str) {
        return str != null && str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
    }
    public static boolean isNumber(String... str) {
        for (String string:str){
            if (string==null||string.length()==0){
                return false;
            }
            if (!string.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$")){
                return false;
            }
        }
        return true;
    }
}
