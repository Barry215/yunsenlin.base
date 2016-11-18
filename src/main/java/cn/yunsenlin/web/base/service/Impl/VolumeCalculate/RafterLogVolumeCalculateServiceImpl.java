package cn.yunsenlin.web.base.service.Impl.VolumeCalculate;

import cn.yunsenlin.web.base.dao.RafterLogCalculateRecordMapper;
import cn.yunsenlin.web.base.factory.BigDecimalFactory;
import cn.yunsenlin.web.base.model.RafterLogCalculateRecord;
import cn.yunsenlin.web.base.service.LogVolumeCalculateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class RafterLogVolumeCalculateServiceImpl implements LogVolumeCalculateService {
    private final RafterLogCalculateRecordMapper rafterLogCalculateRecordMapper;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static BigDecimal num3 = getByFactory("3");
    private static BigDecimal num12 = getByFactory("12");
    private static BigDecimal num1 = getByFactory("1");
    private static BigDecimal num6 = getByFactory("6");
    private static BigDecimal num7 = getByFactory("7");
    private static BigDecimal num07854 = getByFactory("0.7854");
    private static BigDecimal num045 = getByFactory("0.45");
    private static BigDecimal num02 = getByFactory("0.2");
    private static BigDecimal num10000 = getByFactory("10000");
    private static BigDecimal getByFactory(String num) {
        return BigDecimalFactory.get(num);
    }
    public RafterLogVolumeCalculateServiceImpl(RafterLogCalculateRecordMapper rafterLogCalculateRecordMapper) {
        this.rafterLogCalculateRecordMapper = rafterLogCalculateRecordMapper;
    }

    @Override
    public BigDecimal getVolumeCalculateResult(BigDecimal length, BigDecimal diameter) {
        BigDecimal volume = BigDecimalFactory.get("-1");
        if (length.compareTo(num1) >= 0
                && length.compareTo(num6) <= 0
                && diameter.compareTo(num3) >= 0
                && diameter.compareTo(num12)<=0){
            if (diameter.compareTo(num7)<=0){
                volume = num07854.multiply(length).multiply((
                        (diameter.add(num045.multiply(length)).add(num02))
                ).pow(2)).divide(num10000, 4, BigDecimal.ROUND_HALF_UP);
            }else{
                volume = num07854.multiply(length).multiply((
                        (diameter.add(num045.multiply(length)).add(num02))
                ).pow(2)).divide(num10000, 3, BigDecimal.ROUND_HALF_UP);
            }

        }
        try {
            if (volume.compareTo(BigDecimalFactory.get("-1"))==0){
                logger.warn("传入了不合法的计算值!");
            }else{
                rafterLogCalculateRecordMapper.insert(
                        new RafterLogCalculateRecord(
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
