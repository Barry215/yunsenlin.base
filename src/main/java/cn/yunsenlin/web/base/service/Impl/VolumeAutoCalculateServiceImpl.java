package cn.yunsenlin.web.base.service.Impl;

import cn.yunsenlin.web.base.dao.WoodTypeMapper;
import cn.yunsenlin.web.base.dto.calculate.WoodBase;
import cn.yunsenlin.web.base.factory.BigDecimalFactory;
import cn.yunsenlin.web.base.model.WoodType;
import cn.yunsenlin.web.base.service.VolumeAutoCalculateService;
import cn.yunsenlin.web.base.service.VolumeCalculateService;

import java.math.BigDecimal;
import java.util.List;

public class VolumeAutoCalculateServiceImpl implements VolumeAutoCalculateService{
    private final VolumeCalculateService logVolumeCalculateService;
    private final WoodTypeMapper woodTypeMapper;

    public VolumeAutoCalculateServiceImpl(VolumeCalculateService logVolumeCalculateService, WoodTypeMapper woodTypeMapper) {
        this.logVolumeCalculateService = logVolumeCalculateService;
        this.woodTypeMapper = woodTypeMapper;
    }

    @Override
    public String getVolumeAutoCalculate(String length, String diameter, String typeCode) {
        WoodType woodType = woodTypeMapper.selectByPrimaryKey(typeCode);
        if (woodType!=null&&woodType.getBelongs().equals("原木")){
            return logVolumeCalculateService.getVolumeCalculateResult(
                    BigDecimalFactory.get(length),
                    BigDecimalFactory.get(diameter)
            ).toString();
        }else{
            return "-1";
        }
    }

    @Override
    public String getVolumeAutoCalculate(List<WoodBase> woodBaseList) {
        BigDecimal sum = BigDecimalFactory.get("0");
        for (WoodBase woodBase : woodBaseList) {
            String typeCode =woodBase.getTypeCode();
            WoodType woodType = woodTypeMapper.selectByPrimaryKey(typeCode);
            if (woodType!=null&&woodType.getBelongs().equals("原木")){
                BigDecimal num = BigDecimalFactory.get(woodBase.getNum()+"");
                sum =sum.add(
                        (logVolumeCalculateService.getVolumeCalculateResult(
                                BigDecimalFactory.get(woodBase.getLength()),
                                BigDecimalFactory.get(woodBase.getDiameter())
                                ).multiply(num)
                ));
            }else{
                return "-1";
            }
        }
        return sum.toString();
    }
}
