package cn.yunsenlin.web.base.service.Impl.VolumeCalculate;

import cn.yunsenlin.web.base.dao.BoleLogCalculateRecordMapper;
import cn.yunsenlin.web.base.factory.BigDecimalFactory;
import cn.yunsenlin.web.base.model.BoleLogCalculateRecord;
import cn.yunsenlin.web.base.service.LogVolumeCalculateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class Bole1999LogVolumeCalculateServiceImpl implements LogVolumeCalculateService{
    private final BoleLogCalculateRecordMapper boleLogCalculateRecordMapper;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static BigDecimal num4 = getByFactory("4");
    private static BigDecimal num07854 = getByFactory("0.7854");
    private static BigDecimal num10000 = getByFactory("10000");
    private static BigDecimal num2 = getByFactory("2");
    private static BigDecimal num40 = getByFactory("40");
    private static BigDecimal num100 = getByFactory("100");
    private static BigDecimal num6 = getByFactory("6");

    public Bole1999LogVolumeCalculateServiceImpl(BoleLogCalculateRecordMapper boleLogCalculateRecordMapper) {
        this.boleLogCalculateRecordMapper = boleLogCalculateRecordMapper;
    }

    private static BigDecimal getByFactory(String num) {
        return BigDecimalFactory.get(num);
    }

    @Override
    public BigDecimal getVolumeCalculateResult(BigDecimal length, BigDecimal diameter) {
        BigDecimal volume = BigDecimalFactory.get("-1");
        //检尺长2m-40m，0.5进位，检尺径4-100cm 1进位
        if (length.compareTo(num2) >= 0
                && length.compareTo(num40) <= 0
                && diameter.compareTo(num4) >= 0
                && diameter.compareTo(num100) <= 0){
            if (diameter.compareTo(num6)<=0){
                volume = num07854.multiply(diameter.pow(2)).multiply(length)
                        .divide(num10000,4,BigDecimal.ROUND_HALF_UP);
            }else{
                volume = num07854.multiply(diameter.pow(2)).multiply(length)
                        .divide(num10000,3,BigDecimal.ROUND_HALF_UP);
            }
        }
        try {
            if (volume.compareTo(BigDecimalFactory.get("-1"))==0){
                logger.warn("传入了不合法的计算值!");
            }else{
                boleLogCalculateRecordMapper.insert(
                        new BoleLogCalculateRecord(
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
