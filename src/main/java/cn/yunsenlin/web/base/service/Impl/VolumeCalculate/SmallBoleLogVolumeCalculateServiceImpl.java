package cn.yunsenlin.web.base.service.Impl.VolumeCalculate;

import cn.yunsenlin.web.base.dao.SmallBoleLogCalculateRecordMapper;
import cn.yunsenlin.web.base.factory.BigDecimalFactory;
import cn.yunsenlin.web.base.model.SmallBoleLogCalculateRecord;
import cn.yunsenlin.web.base.service.LogVolumeCalculateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class SmallBoleLogVolumeCalculateServiceImpl implements LogVolumeCalculateService{
    private final SmallBoleLogCalculateRecordMapper smallBoleLogCalculateRecordMapper;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static BigDecimal num4 = getByFactory("4");
    private static BigDecimal num038 = getByFactory("0.38");
    private static BigDecimal num16 = getByFactory("16");
    private static BigDecimal num30 = getByFactory("30");
    private static BigDecimal num10000 = getByFactory("10000");
    private static BigDecimal num5D5 = getByFactory("5.5");
    private static BigDecimal num3 = getByFactory("3");
    private static BigDecimal num10 = getByFactory("10");
    private static BigDecimal num7D5 = getByFactory("7.5");

    public SmallBoleLogVolumeCalculateServiceImpl(SmallBoleLogCalculateRecordMapper smallBoleLogCalculateRecordMapper) {
        this.smallBoleLogCalculateRecordMapper = smallBoleLogCalculateRecordMapper;
    }

    private static BigDecimal getByFactory(String num) {
        return BigDecimalFactory.get(num);
    }

    @Override
    public BigDecimal getVolumeCalculateResult(BigDecimal length, BigDecimal diameter) {
        BigDecimal volume = BigDecimalFactory.get("-1");
        //检尺长3m-7.5m，0.2进位，检尺径4-10cm 1进位
        if (length.compareTo(num3) >= 0
                && length.compareTo(num7D5) <= 0
                && diameter.compareTo(num4) >= 0
                && diameter.compareTo(num10) <= 0){
            volume = num5D5.multiply(length).add(
                    num038.multiply(diameter.pow(2)).multiply(length)
            ).add(num16.multiply(diameter)).subtract(num30).
                    divide(num10000,4,BigDecimal.ROUND_HALF_UP);
        }
        try {
            if (volume.compareTo(BigDecimalFactory.get("-1"))==0){
                logger.warn("传入了不合法的计算值!");
            }else{
                smallBoleLogCalculateRecordMapper.insert(
                        new SmallBoleLogCalculateRecord(
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
