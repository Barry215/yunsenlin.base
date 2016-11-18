package cn.yunsenlin.web.base.service.Impl.VolumeCalculate;

import cn.yunsenlin.web.base.dao.BoleShanLogCalculateRecordMapper;
import cn.yunsenlin.web.base.factory.BigDecimalFactory;
import cn.yunsenlin.web.base.model.BoleShanLogCalculateRecord;
import cn.yunsenlin.web.base.service.LogVolumeCalculateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class BoleShanLogVolumeCalculateServiceImpl implements LogVolumeCalculateService{
    private final BoleShanLogCalculateRecordMapper boleShanLogCalculateRecordMapper;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static BigDecimal num5 = getByFactory("5");
    private static BigDecimal num19 = getByFactory("19");
    private static BigDecimal num10 = getByFactory("10");
    private static BigDecimal num100 = getByFactory("100");
    private static BigDecimal num10000 = getByFactory("10000");
    private static BigDecimal num8 = getByFactory("8");
    private static BigDecimal num30 = getByFactory("30");
    private static BigDecimal num60 = getByFactory("60");
    private static BigDecimal num04902 = getByFactory("0.4902");
    private static BigDecimal num0394 = getByFactory("0.394");
    private static BigDecimal num3D279 = getByFactory("3.279");
    private static BigDecimal num3D5 = getByFactory("3.5");
    private static BigDecimal num0707 = getByFactory("0.707");
    private static BigDecimal num20 = getByFactory("20");
    private static BigDecimal num048 = getByFactory("0.48");
    private static BigDecimal num039 = getByFactory("0.39");
    private static BigDecimal getByFactory(String num) {
        return BigDecimalFactory.get(num);
    }

    public BoleShanLogVolumeCalculateServiceImpl(BoleShanLogCalculateRecordMapper boleShanLogCalculateRecordMapper) {
        this.boleShanLogCalculateRecordMapper = boleShanLogCalculateRecordMapper;
    }

    @Override
    public BigDecimal getVolumeCalculateResult(BigDecimal length, BigDecimal diameter) {
        BigDecimal volume = BigDecimalFactory.get("-1");
        if (length.compareTo(num5) >= 0
                && length.compareTo(num30) <= 0
                && diameter.compareTo(num8) >= 0
                && diameter.compareTo(num60) <= 0){
            if (diameter.compareTo(num8)<=0){
                volume = num04902.multiply(length)
                        .divide(num100,3,BigDecimal.ROUND_HALF_UP);
            }
            if (diameter.compareTo(num10)>=0
                    &&length.compareTo(num19)<=0){
                volume = num0394.multiply((num3D279.add(diameter)).pow(2))
                        .multiply(num0707.add(length))
                        .divide(num10000,3,BigDecimal.ROUND_HALF_UP);
            }
            if (diameter.compareTo(num10)>=0
                    &&length.compareTo(num20)>=0){
                volume = num039.multiply((num3D5.add(diameter)).pow(2))
                        .multiply(num048.add(length))
                        .divide(num10000,3,BigDecimal.ROUND_HALF_UP);
            }
        }
        try {
            if (volume.compareTo(BigDecimalFactory.get("-1"))==0){
                logger.warn("传入了不合法的计算值!");
            }else{
                boleShanLogCalculateRecordMapper.insert(
                        new BoleShanLogCalculateRecord(
                                length,diameter,volume
                        )
                );
            }
        }catch (Exception e){
            logger.error("插入数据出现错误!length:"+length.toString()+",diameter:"+diameter
                    +",volume:"+volume.toString());
            logger.error(e.getMessage());
        }
        return volume;
    }
}
