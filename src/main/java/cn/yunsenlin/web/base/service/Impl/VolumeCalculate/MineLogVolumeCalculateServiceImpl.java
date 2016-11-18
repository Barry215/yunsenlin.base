package cn.yunsenlin.web.base.service.Impl.VolumeCalculate;

import cn.yunsenlin.web.base.dao.MineLogCalculateRecordMapper;
import cn.yunsenlin.web.base.factory.BigDecimalFactory;
import cn.yunsenlin.web.base.model.MineLogCalculateRecord;
import cn.yunsenlin.web.base.service.LogVolumeCalculateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class MineLogVolumeCalculateServiceImpl implements LogVolumeCalculateService {
    private final MineLogCalculateRecordMapper mineLogCalculateRecordMapper;
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
    private static BigDecimal num08 = getByFactory("0.8");
    private static BigDecimal num12 = getByFactory("12");
    private static BigDecimal num24 = getByFactory("24");
    private static BigDecimal num2D2 = getByFactory("2.2");
    private static BigDecimal num3D2 = getByFactory("3.2");
    private static BigDecimal num1D4 = getByFactory("1.4");
    private static BigDecimal num1D8 = getByFactory("1.8");
    private static BigDecimal getByFactory(String num) {
        return BigDecimalFactory.get(num);
    }
    public MineLogVolumeCalculateServiceImpl(MineLogCalculateRecordMapper mineLogCalculateRecordMapper) {
        this.mineLogCalculateRecordMapper = mineLogCalculateRecordMapper;
    }

    public BigDecimal getVolumeCalculateResult(BigDecimal length, BigDecimal diameter) {
        BigDecimal volume = BigDecimalFactory.get("-1");
        //检尺长1.4-1.8米,检尺径8-10厘米
        if (length.compareTo(num1D4) >= 0
                && length.compareTo(num1D8) <= 0
                && diameter.compareTo(num8) >= 0
                && diameter.compareTo(num10)<=0){
            //0.8L(D+0.5L)^2/10000
            volume = num08.multiply(length).multiply(
                    (
                            diameter.add(
                                    num05.multiply(length)
                            ).pow(2)
                    )
            ).divide(num10000,3,BigDecimal.ROUND_HALF_UP);
        }
        //检尺径为12,检尺径为2.2m-3.2m
        if (length.compareTo(num2D2) >= 0
                && length.compareTo(num3D2) <= 0
                && diameter.compareTo(num12) >= 0
                && diameter.compareTo(num12)<=0){
            volume = num07854.multiply(length).multiply((
                    (diameter.add(num045.multiply(length)).add(num02))
            ).pow(2)).divide(num10000, 3, BigDecimal.ROUND_HALF_UP);

        }
        //检尺径为14-24厘米，检尺长为2.2m-3.2m
        if (length.compareTo(num2D2) >= 0
                && length.compareTo(num3D2) <= 0
                && diameter.compareTo(num14) >= 0
                && diameter.compareTo(num24)<=0){
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
                mineLogCalculateRecordMapper.insert(
                        new MineLogCalculateRecord(
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
