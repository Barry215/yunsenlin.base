package cn.yunsenlin.web.base.service.Impl.VolumeCalculate;

import cn.yunsenlin.web.base.dao.RussianLogCalculateRecordMapper;
import cn.yunsenlin.web.base.dao.RussianVolumeMapper;
import cn.yunsenlin.web.base.factory.BigDecimalFactory;
import cn.yunsenlin.web.base.model.RussianLogCalculateRecord;
import cn.yunsenlin.web.base.model.RussianVolume;
import cn.yunsenlin.web.base.model.RussianVolumeKey;
import cn.yunsenlin.web.base.service.LogVolumeCalculateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class RussianLogVolumeCalculateServiceImpl implements LogVolumeCalculateService {
    private final RussianLogCalculateRecordMapper russianLogCalculateRecordMapper;
    private final RussianVolumeMapper russianVolumeMapper;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public RussianLogVolumeCalculateServiceImpl(RussianLogCalculateRecordMapper russianLogCalculateRecordMapper, RussianVolumeMapper russianVolumeMapper) {
        this.russianLogCalculateRecordMapper = russianLogCalculateRecordMapper;
        this.russianVolumeMapper = russianVolumeMapper;
    }


    @Override
    public BigDecimal getVolumeCalculateResult(BigDecimal length, BigDecimal diameter) {
        BigDecimal volume = BigDecimalFactory.get("-1");
        if (diameter.compareTo(BigDecimalFactory.get("3"))>=0
                &&diameter.compareTo(BigDecimalFactory.get("120"))<=0
                &&length.compareTo(BigDecimalFactory.get("2"))>=0
                &&length.compareTo(BigDecimalFactory.get("9"))<=0){
            RussianVolumeKey russianVolumeKey = new RussianVolumeKey(
                    length,diameter
            );
            RussianVolume russianVolume = russianVolumeMapper.selectByPrimaryKey(russianVolumeKey);
            if (russianVolume!=null){
                volume = BigDecimalFactory.get(russianVolume.getVolume().toString());
            }
        }
        try {
            if (volume.compareTo(BigDecimalFactory.get("-1"))==0){
                logger.warn("传入了不合法的计算值!");
            }else{
                russianLogCalculateRecordMapper.insert(
                        new RussianLogCalculateRecord(
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
