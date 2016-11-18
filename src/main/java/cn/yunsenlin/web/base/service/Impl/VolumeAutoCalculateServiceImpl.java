package cn.yunsenlin.web.base.service.Impl;

import cn.yunsenlin.web.base.dao.WoodTypeMapper;
import cn.yunsenlin.web.base.dto.calculate.WoodBase;
import cn.yunsenlin.web.base.factory.BigDecimalFactory;
import cn.yunsenlin.web.base.model.WoodType;
import cn.yunsenlin.web.base.service.EvaluateVolumeCalculateService;
import cn.yunsenlin.web.base.service.LogVolumeCalculateService;
import cn.yunsenlin.web.base.service.TimberVolumeCalculateService;
import cn.yunsenlin.web.base.service.VolumeAutoCalculateService;

import java.math.BigDecimal;
import java.util.List;

public class VolumeAutoCalculateServiceImpl implements VolumeAutoCalculateService {
    private final LogVolumeCalculateService log2013LogVolumeCalculateService;
    private final LogVolumeCalculateService mineLogVolumeCalculateService;
    private final LogVolumeCalculateService purlinLogVolumeCalculateService;
    private final LogVolumeCalculateService rafterLogVolumeCalculateService;
    private final WoodTypeMapper woodTypeMapper;
    private final TimberVolumeCalculateService timberVolumeCalculateService;
    private final EvaluateVolumeCalculateService evaluateVolumeCalculateService;

    public VolumeAutoCalculateServiceImpl(LogVolumeCalculateService log2013LogVolumeCalculateService, LogVolumeCalculateService mineLogVolumeCalculateService, LogVolumeCalculateService purlinLogVolumeCalculateService, LogVolumeCalculateService rafterLogVolumeCalculateService, WoodTypeMapper woodTypeMapper, TimberVolumeCalculateService timberVolumeCalculateService, EvaluateVolumeCalculateService evaluateVolumeCalculateService) {
        this.log2013LogVolumeCalculateService = log2013LogVolumeCalculateService;
        this.mineLogVolumeCalculateService = mineLogVolumeCalculateService;
        this.purlinLogVolumeCalculateService = purlinLogVolumeCalculateService;
        this.rafterLogVolumeCalculateService = rafterLogVolumeCalculateService;
        this.woodTypeMapper = woodTypeMapper;
        this.timberVolumeCalculateService = timberVolumeCalculateService;
        this.evaluateVolumeCalculateService = evaluateVolumeCalculateService;
    }


    @Override
    public String getLogVolumeAutoCalculate(String length, String diameter, String typeCode, String num) {
        WoodType woodType = woodTypeMapper.selectByPrimaryKey(typeCode);
        if (woodType != null && woodType.getBelongs().equals("原木")
                && woodType.getName().equals("原木2013")) {
            return log2013LogVolumeCalculateService.getVolumeCalculateResult(
                    BigDecimalFactory.get(length),
                    BigDecimalFactory.get(diameter)
            ).multiply(BigDecimalFactory.get(num)).toString();
        }
        if (woodType != null && woodType.getBelongs().equals("原木")
                && woodType.getName().equals("矿木")){
            return mineLogVolumeCalculateService.getVolumeCalculateResult(
                    BigDecimalFactory.get(length),
                    BigDecimalFactory.get(diameter)
            ).multiply(BigDecimalFactory.get(num)).toString();
        }
        if (woodType != null && woodType.getBelongs().equals("原木")
                && woodType.getName().equals("檩材")){
            return purlinLogVolumeCalculateService.getVolumeCalculateResult(
                    BigDecimalFactory.get(length),
                    BigDecimalFactory.get(diameter)
            ).multiply(BigDecimalFactory.get(num)).toString();
        }
        if (woodType != null && woodType.getBelongs().equals("原木")
                && woodType.getName().equals("椽材")){
            return rafterLogVolumeCalculateService.getVolumeCalculateResult(
                    BigDecimalFactory.get(length),
                    BigDecimalFactory.get(diameter)
            ).multiply(BigDecimalFactory.get(num)).toString();
        }
        return "-1";

    }

    @Override
    public String getLogVolumeAutoCalculate(List<WoodBase> woodBaseList) {
        BigDecimal sum = BigDecimalFactory.get("0");
        for (WoodBase woodBase : woodBaseList) {
            String typeCode = woodBase.getTypeCode();
            WoodType woodType = woodTypeMapper.selectByPrimaryKey(typeCode);
            if (woodType != null&& woodType.getBelongs().equals("原木")) {
                sum = sum.add(
                        BigDecimalFactory.get(
                                getLogVolumeAutoCalculate(
                                        woodBase.getLength(),
                                        woodBase.getDiameter(),
                                        woodType.getTypeCode(),
                                        woodBase.getNum() + ""
                                )
                        ));
            } else {
                return "-1";
            }
        }
        return sum.toString();
    }

    @Override
    public String getTimberVolumeAutoCalculate(String length, String width, String height) {
        return timberVolumeCalculateService.getVolumeCalculateResult(length, width, height);
    }

    @Override
    public String getEvaluateVolumeAutoCalculate(String length, String xiongjing, String num, String typeCode, String cityCode) {
        return evaluateVolumeCalculateService.evaluate(
                length, xiongjing, num, typeCode, cityCode
        );
    }
}
