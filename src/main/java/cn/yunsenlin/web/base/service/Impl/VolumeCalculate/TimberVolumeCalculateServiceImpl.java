package cn.yunsenlin.web.base.service.Impl.VolumeCalculate;

import cn.yunsenlin.web.base.factory.BigDecimalFactory;
import cn.yunsenlin.web.base.service.TimberVolumeCalculateService;

import java.math.BigDecimal;

public class TimberVolumeCalculateServiceImpl implements TimberVolumeCalculateService {
    @Override
    public BigDecimal getVolumeCalculateResult(String length, String width, String height) {
        BigDecimal lengthBig = BigDecimalFactory.get(length);
        BigDecimal widthBig = BigDecimalFactory.get(width);
        BigDecimal heightBig = BigDecimalFactory.get(height);
        if (lengthBig.compareTo(BigDecimalFactory.get("0.5"))>=0
                &&lengthBig.compareTo(BigDecimalFactory.get("8"))<=0
                &&widthBig.compareTo(BigDecimalFactory.get("12"))>=0
                &&widthBig.compareTo(BigDecimalFactory.get("300"))<=0
                &&heightBig.compareTo(BigDecimalFactory.get("12"))>=0
                &&heightBig.compareTo(BigDecimalFactory.get("100"))<=0){
            if (lengthBig.compareTo(BigDecimalFactory.get("2"))<0){
                return lengthBig.multiply(widthBig).multiply(heightBig)
                        .divide(BigDecimalFactory.get("1000000"),5,BigDecimal.ROUND_HALF_UP);
            }else {
                return lengthBig.multiply(widthBig).multiply(heightBig)
                        .divide(BigDecimalFactory.get("1000000"),4,BigDecimal.ROUND_HALF_UP);
            }
        }
        return BigDecimalFactory.get("-1");
    }
}
