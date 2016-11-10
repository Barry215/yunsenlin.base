package cn.yunsenlin.web.base.service.Impl.VolumeCalculate;

import cn.yunsenlin.web.base.factory.BigDecimalFactory;
import cn.yunsenlin.web.base.service.VolumeCalculateService;

import java.math.BigDecimal;

public class LogVolumeCalculateServiceImpl implements VolumeCalculateService{
    private static BigDecimal num0 = getByFactory("0");
    private static BigDecimal num_1 = getByFactory("-1");
    private static BigDecimal num4 = getByFactory("4");
    private static BigDecimal num14 = getByFactory("14");
    private static BigDecimal num10 = getByFactory("10");
    private static BigDecimal num6 = getByFactory("6");
    private static BigDecimal num07854 = getByFactory("0.7854");
    private static BigDecimal num045 = getByFactory("0.45");
    private static BigDecimal num02 = getByFactory("0.2");
    private static BigDecimal num05 = getByFactory("0.5");
    private static BigDecimal num0005 = getByFactory("0.005");
    private static BigDecimal num12 = getByFactory("12");
    private static BigDecimal num120 = getByFactory("120");
    private static BigDecimal num0000125 = getByFactory("0.000125");
    private static BigDecimal num10000 = getByFactory("10000");
    private static BigDecimal num08 = getByFactory("0.8");
    @org.jetbrains.annotations.Contract("_ -> !null")
    private static BigDecimal getByFactory(String num){
        return BigDecimalFactory.get(num);
    }
    public BigDecimal getVolumeCalculateResult(BigDecimal length, BigDecimal diameter) {
        if (diameter.subtract(num4).compareTo(num0)<0){
            return num_1;
        }else if (diameter.subtract(num4).compareTo(num0)>=0
                &&diameter.subtract(num6).compareTo(num0)<=0){
            return num07854.multiply(length).
                    multiply(
                            (diameter.add(num045.multiply(length)).add(num02)).pow(2)
                    ).divide(num10000,4,BigDecimal.ROUND_HALF_UP);
        }else if (diameter.subtract(num6).compareTo(num0)>0
                &&diameter.subtract(num12).compareTo(num0)<=0){
            return num07854.multiply(length).
                    multiply(
                            (diameter.add(num045.multiply(length)).add(num02)).pow(2)
                    ).divide(num10000,3,BigDecimal.ROUND_HALF_UP);
        }else if (diameter.subtract(num12).compareTo(num0)>0
                &&diameter.subtract(num120).compareTo(num0)<=0){
            return num07854.multiply(length)
                    .multiply(
                            diameter.add(num05.multiply(length)).add(
                                   num0005.multiply(length).pow(2)
                            ).add(
                                    num0000125.multiply(length).multiply(
                                            num14.subtract(length).pow(2).multiply(
                                                    diameter.subtract(num10)
                                            )
                                    )
                            ).pow(2)
                    ).divide(num10000,3,BigDecimal.ROUND_HALF_UP);
        }else{
            return num08.multiply(length).multiply(
                    diameter.add(
                            num05.multiply(length).pow(2)
                    )
            ).divide(num10000,4,BigDecimal.ROUND_HALF_UP);
        }
    }
}
