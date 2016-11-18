package cn.yunsenlin.web.base.service.Impl.VolumeCalculate;

import cn.yunsenlin.web.base.dao.Log2013CalculateRecordMapper;
import cn.yunsenlin.web.base.factory.BigDecimalFactory;
import cn.yunsenlin.web.base.model.Log2013CalculateRecord;
import cn.yunsenlin.web.base.service.LogVolumeCalculateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class Log2013LogVolumeCalculateServiceImpl implements LogVolumeCalculateService {
    private final Log2013CalculateRecordMapper log2013CalculateRecordMapper;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static BigDecimal num4 = getByFactory("4");
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
    private static BigDecimal num2 = getByFactory("2");
    private static BigDecimal num13 = getByFactory("13");
    private static BigDecimal num18 = getByFactory("18");
    private static BigDecimal num7 = getByFactory("7");
    private static BigDecimal num200 = getByFactory("200");
    private static BigDecimal num100 = getByFactory("100");
    private static BigDecimal num1D9 = getByFactory("1.9");
    private static BigDecimal num10D2 = getByFactory("10.2");

    public Log2013LogVolumeCalculateServiceImpl(Log2013CalculateRecordMapper log2013CalculateRecordMapper) {
        this.log2013CalculateRecordMapper = log2013CalculateRecordMapper;
    }

    @org.jetbrains.annotations.Contract("_ -> !null")
    private static BigDecimal getByFactory(String num) {
        return BigDecimalFactory.get(num);
    }
    public BigDecimal getVolumeCalculateResult(BigDecimal length, BigDecimal diameter) {
        BigDecimal volume = BigDecimalFactory.get("-1");
        //检尺长2m-10m，0.2进位，检尺径4-13cm 1进位
        if (length.compareTo(num2) >= 0
                && length.compareTo(num10) <= 0
                && diameter.compareTo(num4) >= 0
                && diameter.compareTo(num13) <= 0) {
            //0.7854L(D+0.45L+0.2)^2/10000
            //检尺径在4-7cm，保留4位小数
            if (diameter.compareTo(num7) <= 0) {
                volume = num07854.multiply(length).multiply((
                        diameter.add(num045.multiply(length)).add(num02)
                ).pow(2)).divide(num10000, 4, BigDecimal.ROUND_HALF_UP);
            }
            //检尺径8cm+ 保留三位小数
            else {
                volume = num07854.multiply(length).multiply((
                        (diameter.add(num045.multiply(length)).add(num02))
                ).pow(2)).divide(num10000, 3, BigDecimal.ROUND_HALF_UP);
            }
        }
        //检尺长2m-10m，0.2进位，检尺径14cm + 1进位
        if (length.compareTo(num2) >= 0
                && length.compareTo(num10) <= 0
                && diameter.compareTo(num14) >= 0
                && diameter.compareTo(num200) <= 0) {
            //0.7854L(D+0.5L+0.005L^2+0.000125L(14-L)^2(D-10))^2/10000
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
        if ((length.compareTo(num05) >= 0
                && length.compareTo(num1D9) <= 0
                && diameter.compareTo(num8) >= 0
                && diameter.compareTo(num100) <= 0) ||
                (
                        length.compareTo(num10D2) >= 0
                                && length.compareTo(num18) <= 0
                                && diameter.compareTo(num4) >= 0
                                && diameter.compareTo(num100) <= 0
                )) {
            //0.8L(D+0.5L)^2/10000
            volume = num08.multiply(length).multiply(
                    (
                            diameter.add(
                            num05.multiply(length)
                    ).pow(2)
                    )
            ).divide(num10000,3,BigDecimal.ROUND_HALF_UP);
        }
        try {
            if (volume.compareTo(BigDecimalFactory.get("-1"))==0){
                logger.warn("传入了不合法的计算值!");
            }else{
                log2013CalculateRecordMapper.insert(
                        new Log2013CalculateRecord(
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
