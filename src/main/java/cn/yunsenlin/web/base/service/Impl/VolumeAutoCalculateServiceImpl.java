package cn.yunsenlin.web.base.service.Impl;

import cn.yunsenlin.web.base.dao.WoodTypeMapper;
import cn.yunsenlin.web.base.dto.calculate.android.Timber;
import cn.yunsenlin.web.base.dto.calculate.android.WoodBase;
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
    private final LogVolumeCalculateService log1984LogVolumeCalculateService;
    private final LogVolumeCalculateService bole1999LogVolumeCalculateService;
    private final LogVolumeCalculateService bolePinusLogVolumeCalculateService;
    private final LogVolumeCalculateService boleShanLogCalculateRecordMapper;
    private final LogVolumeCalculateService smallBoleLogVolumeCalculateService;
    private final LogVolumeCalculateService mineLogVolumeCalculateService;
    private final LogVolumeCalculateService purlinLogVolumeCalculateService;
    private final LogVolumeCalculateService americanLogVolumeCalculateService;
    private final LogVolumeCalculateService southeastAsiaLogVolumeCalculateService;
    private final LogVolumeCalculateService russianLogVolumeCalculateService;
    private final LogVolumeCalculateService rafterLogVolumeCalculateService;
    private final WoodTypeMapper woodTypeMapper;
    private final TimberVolumeCalculateService timberVolumeCalculateService;
    private final EvaluateVolumeCalculateService evaluateVolumeCalculateService;

    public VolumeAutoCalculateServiceImpl(
            LogVolumeCalculateService log2013LogVolumeCalculateService,
            LogVolumeCalculateService log1984LogVolumeCalculateService,
            LogVolumeCalculateService bole1999LogVolumeCalculateService,
            LogVolumeCalculateService bolePinusLogVolumeCalculateService,
            LogVolumeCalculateService boleShanLogCalculateRecordMapper,
            LogVolumeCalculateService smallBoleLogVolumeCalculateService,
            LogVolumeCalculateService mineLogVolumeCalculateService,
            LogVolumeCalculateService purlinLogVolumeCalculateService,
            LogVolumeCalculateService americanLogVolumeCalculateService,
            LogVolumeCalculateService southeastAsiaLogVolumeCalculateService,
            LogVolumeCalculateService russianLogVolumeCalculateService,
            LogVolumeCalculateService rafterLogVolumeCalculateService,
            WoodTypeMapper woodTypeMapper,
            TimberVolumeCalculateService timberVolumeCalculateService,
            EvaluateVolumeCalculateService evaluateVolumeCalculateService) {
        this.log2013LogVolumeCalculateService = log2013LogVolumeCalculateService;
        this.log1984LogVolumeCalculateService = log1984LogVolumeCalculateService;
        this.bole1999LogVolumeCalculateService = bole1999LogVolumeCalculateService;
        this.bolePinusLogVolumeCalculateService = bolePinusLogVolumeCalculateService;
        this.boleShanLogCalculateRecordMapper = boleShanLogCalculateRecordMapper;
        this.smallBoleLogVolumeCalculateService = smallBoleLogVolumeCalculateService;
        this.mineLogVolumeCalculateService = mineLogVolumeCalculateService;
        this.purlinLogVolumeCalculateService = purlinLogVolumeCalculateService;
        this.americanLogVolumeCalculateService = americanLogVolumeCalculateService;
        this.southeastAsiaLogVolumeCalculateService = southeastAsiaLogVolumeCalculateService;
        this.russianLogVolumeCalculateService = russianLogVolumeCalculateService;
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
                && woodType.getName().equals("原木1984")) {
            return log1984LogVolumeCalculateService.getVolumeCalculateResult(
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
        if (woodType != null && woodType.getBelongs().equals("原条")
                && woodType.getName().equals("原条1999")){
            return bole1999LogVolumeCalculateService.getVolumeCalculateResult(
                    BigDecimalFactory.get(length),
                    BigDecimalFactory.get(diameter)
            ).multiply(BigDecimalFactory.get(num)).toString();
        }
        if (woodType != null && woodType.getBelongs().equals("原条")
                && woodType.getName().equals("小原条")){
            return smallBoleLogVolumeCalculateService.getVolumeCalculateResult(
                    BigDecimalFactory.get(length),
                    BigDecimalFactory.get(diameter)
            ).multiply(BigDecimalFactory.get(num)).toString();
        }
        if (woodType != null && woodType.getBelongs().equals("原条")
                && woodType.getName().equals("杉原条")){
            return boleShanLogCalculateRecordMapper.getVolumeCalculateResult(
                    BigDecimalFactory.get(length),
                    BigDecimalFactory.get(diameter)
            ).multiply(BigDecimalFactory.get(num)).toString();
        }
        if (woodType != null && woodType.getBelongs().equals("原条")
                && woodType.getName().equals("马尾松原条")){
            return bolePinusLogVolumeCalculateService.getVolumeCalculateResult(
                    BigDecimalFactory.get(length),
                    BigDecimalFactory.get(diameter)
            ).multiply(BigDecimalFactory.get(num)).toString();
        }
        if (woodType != null && woodType.getBelongs().equals("原木")
                && woodType.getName().equals("美国原木")){
            return americanLogVolumeCalculateService.getVolumeCalculateResult(
                    BigDecimalFactory.get(length),
                    BigDecimalFactory.get(diameter)
            ).multiply(BigDecimalFactory.get(num)).toString();
        }
        if (woodType != null && woodType.getBelongs().equals("原木")
                && woodType.getName().equals("俄罗斯原木")){
            return russianLogVolumeCalculateService.getVolumeCalculateResult(
                    BigDecimalFactory.get(length),
                    BigDecimalFactory.get(diameter)
            ).multiply(BigDecimalFactory.get(num)).toString();
        }
        if (woodType != null && woodType.getBelongs().equals("原木")
                && woodType.getName().equals("东南亚原木")){
            return southeastAsiaLogVolumeCalculateService.getVolumeCalculateResult(
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
            if (woodType != null
                    && (woodType.getBelongs().equals("原木")
                    ||woodType.getBelongs().equals("原条"))) {
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
    public String getTimberVolumeAutoCalculate(String length, String width, String height,String num) {
        return timberVolumeCalculateService.getVolumeCalculateResult(length, width, height)
                .multiply(BigDecimalFactory.get(num)).toString();
    }

    @Override
    public String getTimberVolumeAutoCalculate(List<Timber> timbers) {
        BigDecimal sum = BigDecimalFactory.get("0");
        for (Timber timber :timbers){
            sum = sum.add(
                    BigDecimalFactory.get(
                            getTimberVolumeAutoCalculate(
                                    timber.getLength(),
                                    timber.getWidth(),
                                    timber.getHeight(),
                                    timber.getNum()
                            )
                    )
            );
        }
        return sum.toString();
    }

    @Override
    public String getEvaluateVolumeAutoCalculate(String length, String xiongjing, String num, String typeCode, String cityCode) {
        return evaluateVolumeCalculateService.evaluate(
                length, xiongjing, num, typeCode, cityCode
        );
    }
}
