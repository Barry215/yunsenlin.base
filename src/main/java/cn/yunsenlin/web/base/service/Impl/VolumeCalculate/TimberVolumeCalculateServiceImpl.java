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
        // TODO: 11/18/2016
        if (BigDecimalFactory.get(length).compareTo(BigDecimalFactory.get("2"))==-1){
            return BigDecimalFactory.get(length).multiply(
                    BigDecimalFactory.get(width)
            ).multiply(
                    BigDecimalFactory.get(width)
            ).divide(BigDecimalFactory.get("1000000"),5, BigDecimal.ROUND_HALF_UP);
        }else{
            return BigDecimalFactory.get(length).multiply(
                    BigDecimalFactory.get(width)
            ).multiply(
                    BigDecimalFactory.get(width)
            ).divide(BigDecimalFactory.get("1000000"),4, BigDecimal.ROUND_HALF_UP);
        }

    }
}
