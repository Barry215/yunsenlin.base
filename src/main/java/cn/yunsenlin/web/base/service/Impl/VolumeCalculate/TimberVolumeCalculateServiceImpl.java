package cn.yunsenlin.web.base.service.Impl.VolumeCalculate;

import cn.yunsenlin.web.base.dao.TimberCalculateRecordMapper;
import cn.yunsenlin.web.base.factory.BigDecimalFactory;
import cn.yunsenlin.web.base.model.TimberCalculateRecord;
import cn.yunsenlin.web.base.service.TimberVolumeCalculateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class TimberVolumeCalculateServiceImpl implements TimberVolumeCalculateService {
    private final TimberCalculateRecordMapper timberCalculateRecordMapper;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public TimberVolumeCalculateServiceImpl(TimberCalculateRecordMapper timberCalculateRecordMapper) {
        this.timberCalculateRecordMapper = timberCalculateRecordMapper;
    }

    @Override
    public BigDecimal getVolumeCalculateResult(String length, String width, String height) {
        BigDecimal lengthBig = BigDecimalFactory.get(length);
        BigDecimal widthBig = BigDecimalFactory.get(width);
        BigDecimal heightBig = BigDecimalFactory.get(height);
        BigDecimal volume = BigDecimalFactory.get("-1");
        if (lengthBig.compareTo(BigDecimalFactory.get("0.5"))>=0
                &&lengthBig.compareTo(BigDecimalFactory.get("8"))<=0
                &&widthBig.compareTo(BigDecimalFactory.get("30"))>=0
                &&widthBig.compareTo(BigDecimalFactory.get("300"))<=0
                &&heightBig.compareTo(BigDecimalFactory.get("12"))>=0
                &&heightBig.compareTo(BigDecimalFactory.get("100"))<=0){
            if (lengthBig.compareTo(BigDecimalFactory.get("2"))<0){
                volume = lengthBig.multiply(widthBig).multiply(heightBig)
                        .divide(BigDecimalFactory.get("1000000"),5,BigDecimal.ROUND_HALF_UP);
            }else {
                volume = lengthBig.multiply(widthBig).multiply(heightBig)
                        .divide(BigDecimalFactory.get("1000000"),4,BigDecimal.ROUND_HALF_UP);
            }
        }
        try {
            if (volume.compareTo(BigDecimalFactory.get("-1"))==0){
                logger.warn("传入了不合法的计算值!");
            }else{
                timberCalculateRecordMapper.insert(
                        new TimberCalculateRecord(
                                lengthBig,
                                widthBig,
                                heightBig,
                                volume
                        )
                );
            }
        }catch (Exception e){
            logger.error("插入数据出现错误!length:"+length+",width:"+width
                    +",volume:"+volume.toString());
            logger.error(e.getMessage());
        }
        return volume;
    }
}
