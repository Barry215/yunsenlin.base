package cn.yunsenlin.web.base.service.Impl;

import cn.yunsenlin.web.base.dao.WoodTypeMapper;
import cn.yunsenlin.web.base.dto.calculate.android.*;
import cn.yunsenlin.web.base.factory.BigDecimalFactory;
import cn.yunsenlin.web.base.model.WoodType;
import cn.yunsenlin.web.base.service.EvaluateVolumeCalculateService;
import cn.yunsenlin.web.base.service.LogVolumeCalculateService;
import cn.yunsenlin.web.base.service.TimberVolumeCalculateService;
import cn.yunsenlin.web.base.service.VolumeAutoCalculateService;

import java.math.BigDecimal;
import java.util.ArrayList;
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
    public String getTimberVolumeAutoCalculate(String length, String width, String height,String num) {
        return timberVolumeCalculateService.getVolumeCalculateResult(length, width, height)
                .multiply(BigDecimalFactory.get(num)).toString();
    }

    @Override
    public String getEvaluateXiongJingVolumeAutoCalculate(String length, String xiongjing, String num, String typeCode, String cityCode) {
        return evaluateVolumeCalculateService.evaluateXiongJing(
                length, xiongjing, num, typeCode, cityCode
        );
    }

    @Override
    public String getEvaluateGenJingVolumeAutoCalculate(String length, String xiongjing, String num, String typeCode, String cityCode) {
        return evaluateVolumeCalculateService.evaluateGenJing(
                length, xiongjing, num, typeCode, cityCode
        );
    }

    @Override
    public String getWeightCalculate(String total, String lorry) {
        return BigDecimalFactory.get(total).subtract(
                BigDecimalFactory.get(lorry)
        ).toString();
    }

    @Override
    public List<LogReturn> getLogReturn(List<Log> logList) {
        List<LogReturn> logReturnList = new ArrayList<>();
        for (Log l : logList) {
            LogReturn logReturn = new LogReturn();
            logReturn.setTypeCode(l.getTypeCode());
            logReturn.setLength(l.getLength());
            logReturn.setDiameter(l.getDiameter());
            logReturn.setNum(l.getNum());
            logReturn.setPiece(l.getPiece());
            String volume = getLogVolumeAutoCalculate(
                    l.getLength(),l.getDiameter(),
                    l.getTypeCode(),l.getNum()
            );
            logReturn.setVolume(
                    BigDecimalFactory.get(volume).multiply(
                            BigDecimalFactory.get(l.getNum())
                    ).toString()
            );
            if (BigDecimalFactory.isNumber(l.getPiece())) {
                String sum = BigDecimalFactory.get(volume).multiply(
                        BigDecimalFactory.get(l.getNum())
                ).multiply(
                        BigDecimalFactory.get(l.getPiece())
                ).toString();
                logReturn.setSum(sum);
            }
            logReturnList.add(logReturn);
        }
        return logReturnList;
    }

    @Override
    public List<WeightReturn> getWeightReturn(List<Weight> weightList) {
        List<WeightReturn> weightReturnList = new ArrayList<>();
        for (Weight w : weightList) {
            WeightReturn wr = new WeightReturn();
            wr.setTotal(w.getTotal());
            wr.setLorry(w.getLorry());
            wr.setPiece(w.getPiece());
            String weight = getWeightCalculate(
                    w.getTotal(),w.getLorry()
            );
            wr.setWeight(weight);
            if (BigDecimalFactory.isNumber(w.getPiece())) {
                String sum = BigDecimalFactory.get(weight).multiply(
                        BigDecimalFactory.get(w.getPiece())
                ).divide(BigDecimalFactory.get("1000"), 3, BigDecimal.ROUND_HALF_UP).toString();
                wr.setSum(sum);
            }
            weightReturnList.add(wr);
        }
        return weightReturnList;
    }

    @Override
    public List<TimberReturn> getTimberReturn(List<Timber> timberList) {
        List<TimberReturn> timberReturnList = new ArrayList<>();
        for (Timber t : timberList) {
            TimberReturn tb = new TimberReturn();
            tb.setHeight(t.getHeight());
            tb.setWidth(t.getWidth());
            tb.setLength(t.getLength());
            tb.setStack(t.getStack());
            tb.setPiece(t.getPiece());
            tb.setNum(t.getNum());
            String volume = getTimberVolumeAutoCalculate(
                    t.getLength(),t.getWidth(),t.getHeight(),t.getNum()
            );
            tb.setVolume(
                    BigDecimalFactory.get(volume).multiply(
                            BigDecimalFactory.get(t.getStack())
                    ).toString()
            );
            if (BigDecimalFactory.isNumber(t.getPiece())) {
                String sum = BigDecimalFactory.get(volume).multiply(
                        BigDecimalFactory.get(tb.getPiece())
                ).multiply(
                        BigDecimalFactory.get(t.getStack())
                ).toString();
                tb.setSum(sum);
            }
            timberReturnList.add(tb);
        }
        return timberReturnList;
    }

    @Override
    public List<ValidationReturn> getValidationReturn(List<Validation> validationList) {
        List<ValidationReturn> validationReturn = new ArrayList<>();
        for (Validation v : validationList) {
            ValidationReturn vd = new ValidationReturn();
            vd.setPiece(v.getPiece());
            vd.setLength(v.getLength());
            vd.setDiameter(v.getDiameter());
            vd.setCityCode(v.getCityCode());
            vd.setType(v.getType());
            vd.setLogCode(v.getLogCode());
            String volume;
            if (v.getType().equals("genjing")){
                volume = getEvaluateGenJingVolumeAutoCalculate(
                        v.getLength(),v.getDiameter(),v.getNum(),
                        v.getLogCode(),v.getCityCode()
                );
            }else{
                volume = getEvaluateXiongJingVolumeAutoCalculate(
                        v.getLength(),v.getDiameter(),v.getNum(),
                        v.getLogCode(),v.getCityCode()
                );
            }
            vd.setVolume(volume);
            if (BigDecimalFactory.isNumber(vd.getPiece())) {
                String sum = BigDecimalFactory.get(volume).multiply(
                        BigDecimalFactory.get(vd.getPiece())
                ).multiply(
                        BigDecimalFactory.get(vd.getNum())
                ).toString();
                vd.setSum(sum);
            }
            validationReturn.add(vd);
        }
        return validationReturn;
    }

    @Override
    public String getLogSum(List<Log> logList) {
        BigDecimal sum = BigDecimalFactory.get("0");
        for (LogReturn l :
                getLogReturn(logList)) {
            if (!BigDecimalFactory.isNumber(l.getSum())){
                return "";
            }
            sum = sum.add(BigDecimalFactory.get(l.getSum()));
        }
        return sum.toString();
    }

    @Override
    public String getLogVolume(List<Log> logList) {
        BigDecimal volume = BigDecimalFactory.get("0");
        for (LogReturn l :
                getLogReturn(logList)) {
            volume = volume.add(BigDecimalFactory.get(l.getVolume()));
        }
        return volume.toString();
    }

    @Override
    public String getWeightSum(List<Weight> weightList) {
        BigDecimal sum = BigDecimalFactory.get("0");
        for (WeightReturn w :
                getWeightReturn(weightList)) {
            if (!BigDecimalFactory.isNumber(w.getSum())){
                return "";
            }
            sum = sum.add(BigDecimalFactory.get(w.getSum()));
        }
        return sum.toString();
    }

    @Override
    public String getWeight(List<Weight> weightList) {
        BigDecimal sum = BigDecimalFactory.get("0");
        for (WeightReturn w :
                getWeightReturn(weightList)) {
            sum = sum.add(BigDecimalFactory.get(w.getWeight()));
        }
        return sum.toString();
    }

    @Override
    public String getTimberSum(List<Timber> timberList) {
        BigDecimal sum = BigDecimalFactory.get("0");
        for (TimberReturn t :
                getTimberReturn(timberList)) {
            if (!BigDecimalFactory.isNumber(t.getSum())){
                return "";
            }
            sum = sum.add(BigDecimalFactory.get(t.getSum()));
        }
        return sum.toString();
    }

    @Override
    public String getTimberVolume(List<Timber> timberList) {
        BigDecimal volume = BigDecimalFactory.get("0");
        for (TimberReturn t :
                getTimberReturn(timberList)) {
            volume = volume.add(BigDecimalFactory.get(t.getVolume()));
        }
        return volume.toString();
    }

    @Override
    public String getValidationSum(List<Validation> validationList) {
        BigDecimal sum = BigDecimalFactory.get("0");
        for (ValidationReturn l :
                getValidationReturn(validationList)) {
            if (!BigDecimalFactory.isNumber(l.getSum())){
                return "";
            }
            sum = sum.add(BigDecimalFactory.get(l.getSum()));
        }
        return sum.toString();
    }

    @Override
    public String getValidationVolume(List<Validation> validationList) {
        BigDecimal volume = BigDecimalFactory.get("0");
        for (ValidationReturn l :
                getValidationReturn(validationList)) {
            volume = volume.add(BigDecimalFactory.get(l.getVolume()));
        }
        return volume.toString();
    }
}
