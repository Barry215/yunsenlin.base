package cn.yunsenlin.web.base.service.Impl.VolumeCalculate;

import cn.yunsenlin.web.base.dao.PurlinLogCalculateRecordMapper;
import cn.yunsenlin.web.base.factory.BigDecimalFactory;
import cn.yunsenlin.web.base.model.PurlinLogCalculateRecord;
import cn.yunsenlin.web.base.service.LogVolumeCalculateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class PurlinLogVolumeCalculateServiceImpl implements LogVolumeCalculateService {
    private final PurlinLogCalculateRecordMapper purlinLogCalculateRecordMapper;

    public PurlinLogVolumeCalculateServiceImpl(PurlinLogCalculateRecordMapper purlinLogCalculateRecordMapper) {
        this.purlinLogCalculateRecordMapper = purlinLogCalculateRecordMapper;
    }
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static BigDecimal num14 = getByFactory("14");
    private static BigDecimal num10 = getByFactory("10");
    private static BigDecimal num07854 = getByFactory("0.7854");
    private static BigDecimal num045 = getByFactory("0.45");
    private static BigDecimal num02 = getByFactory("0.2");
    private static BigDecimal num05 = getByFactory("0.5");
    private static BigDecimal num0005 = getByFactory("0.005");
    private static BigDecimal num0000125 = getByFactory("0.000125");
    private static BigDecimal num10000 = getByFactory("10000");
    private static BigDecimal num8 = getByFactory("8");
    private static BigDecimal num3 = getByFactory("3");
    private static BigDecimal num6 = getByFactory("6");
    private static BigDecimal num13 = getByFactory("13");
    private static BigDecimal num16 = getByFactory("16");
    private static BigDecimal getByFactory(String num) {
        return BigDecimalFactory.get(num);
    }
    public BigDecimal getVolumeCalculateResult(BigDecimal length, BigDecimal diameter) {
        BigDecimal volume = BigDecimalFactory.get("-1");
        //检尺长3-6m 检尺径8-13cm
        if (length.compareTo(num3) >= 0
                && length.compareTo(num6) <= 0
                && diameter.compareTo(num8) >= 0
                && diameter.compareTo(num13)<=0){
            volume = num07854.multiply(length).multiply((
                    (diameter.add(num045.multiply(length)).add(num02))
            ).pow(2)).divide(num10000, 3, BigDecimal.ROUND_HALF_UP);
        }
        //检尺径3-6m 检尺径14-16cm
        if (length.compareTo(num3) >= 0
                && length.compareTo(num6) <= 0
                && diameter.compareTo(num14) >= 0
                && diameter.compareTo(num16)<=0){
            volume = num07854.multiply(length).multiply(
                    (
                            diameter.add(num05.multiply(length))
                                    .add(num0005.multiply((length).pow(2)))
                                    .add(num0000125.multiply(length).multiply(
                                            (
                                                    (num14.subtract(length)).pow(2)
                                            ).multiply(
                                                    diameter.subtract(num10)
                                            )
                                    ))
                    ).pow(2)
            ).divide(num10000, 3, BigDecimal.ROUND_HALF_UP);
        }
        try {
            if (volume.compareTo(BigDecimalFactory.get("-1"))==0){
                logger.warn("传入了不合法的计算值!");
            }else{
                purlinLogCalculateRecordMapper.insert(
                        new PurlinLogCalculateRecord(
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
