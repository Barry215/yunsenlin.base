package cn.yunsenlin.web.base.service.Impl.VolumeCalculate;

import cn.yunsenlin.web.base.dao.AmericanLogCalculateRecordMapper;
import cn.yunsenlin.web.base.factory.BigDecimalFactory;
import cn.yunsenlin.web.base.model.AmericanLogCalculateRecord;
import cn.yunsenlin.web.base.service.LogVolumeCalculateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class AmericanLogVolumeCalculateServiceImpl implements LogVolumeCalculateService {
    private final AmericanLogCalculateRecordMapper americanLogCalculateRecordMapper;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public AmericanLogVolumeCalculateServiceImpl(AmericanLogCalculateRecordMapper americanLogCalculateRecordMapper) {
        this.americanLogCalculateRecordMapper = americanLogCalculateRecordMapper;
    }

    @Override
    public BigDecimal getVolumeCalculateResult(BigDecimal length, BigDecimal diameter) {
        BigDecimal volume = BigDecimalFactory.get("-1");
        if (diameter.compareTo(BigDecimalFactory.get("4"))>=0
                &&diameter.compareTo(BigDecimalFactory.get("60"))<=0
                &&length.compareTo(BigDecimalFactory.get("8"))>=0
                &&length.compareTo(BigDecimalFactory.get("48"))<=0){
            volume = length.multiply(
                    diameter.pow(2).subtract(
                            BigDecimalFactory.get("3").multiply(diameter)
                    )
            ).divide(BigDecimalFactory.get("20"),0,BigDecimal.ROUND_HALF_UP)
            .divide(BigDecimalFactory.get("10"),0,BigDecimal.ROUND_DOWN)
            .multiply(BigDecimalFactory.get("10"));
        }
        try {
            if (volume.compareTo(BigDecimalFactory.get("-1"))==0){
                logger.warn("传入了不合法的计算值!");
            }else{
                americanLogCalculateRecordMapper.insert(
                        new AmericanLogCalculateRecord(
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
