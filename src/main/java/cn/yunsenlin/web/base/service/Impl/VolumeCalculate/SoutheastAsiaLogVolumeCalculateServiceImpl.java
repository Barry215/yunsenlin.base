package cn.yunsenlin.web.base.service.Impl.VolumeCalculate;

import cn.yunsenlin.web.base.dao.SoutheastAsiaLogCalculateRecordMapper;
import cn.yunsenlin.web.base.factory.BigDecimalFactory;
import cn.yunsenlin.web.base.model.SoutheastAsiaLogCalculateRecord;
import cn.yunsenlin.web.base.service.LogVolumeCalculateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class SoutheastAsiaLogVolumeCalculateServiceImpl implements LogVolumeCalculateService {
    private final SoutheastAsiaLogCalculateRecordMapper southeastAsiaLogCalculateRecordMapper;

    public SoutheastAsiaLogVolumeCalculateServiceImpl(SoutheastAsiaLogCalculateRecordMapper southeastAsiaLogCalculateRecordMapper) {
        this.southeastAsiaLogCalculateRecordMapper = southeastAsiaLogCalculateRecordMapper;
    }
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public BigDecimal getVolumeCalculateResult(BigDecimal length, BigDecimal diameter) {
        BigDecimal volume = BigDecimalFactory.get("-1");
        if (diameter.compareTo(BigDecimalFactory.get("10"))>=0
                &&diameter.compareTo(BigDecimalFactory.get("199"))<=0
                &&length.compareTo(BigDecimalFactory.get("1"))>=0
                &&length.compareTo(BigDecimalFactory.get("19.9"))<=0){
            volume = BigDecimalFactory.get("0.7854").multiply(
                    diameter.pow(2)
            ).multiply(length)
                    .divide(BigDecimalFactory.get("10000"),4,BigDecimal.ROUND_HALF_UP);
        }
        try {
            if (volume.compareTo(BigDecimalFactory.get("-1"))==0){
                logger.warn("传入了不合法的计算值!");
            }else{
                southeastAsiaLogCalculateRecordMapper.insert(
                        new SoutheastAsiaLogCalculateRecord(
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
