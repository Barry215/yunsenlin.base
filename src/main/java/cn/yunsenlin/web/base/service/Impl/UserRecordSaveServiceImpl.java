package cn.yunsenlin.web.base.service.Impl;

import cn.yunsenlin.web.base.dao.*;
import cn.yunsenlin.web.base.dto.calculate.android.*;
import cn.yunsenlin.web.base.factory.BigDecimalFactory;
import cn.yunsenlin.web.base.model.*;
import cn.yunsenlin.web.base.model.inter.UserRecordKey;
import cn.yunsenlin.web.base.service.UserRecordSaveService;

import java.util.Date;
import java.util.List;
public class UserRecordSaveServiceImpl implements UserRecordSaveService {
    private final AmericanLogCalculateUserRecordMapper americanLogCalculateUserRecordMapper;
    private final BillUserRecordMapper billUserRecordMapper;
    private final WoodTypeMapper woodTypeMapper;
    private final BoleLogCalculateUserRecordMapper boleLogCalculateUserRecordMapper;
    private final BolePinusLogCalculateUserRecordMapper bolePinusLogCalculateUserRecordMapper;
    private final BoleShanLogCalculateUserRecordMapper boleShanLogCalculateUserRecordMapper;
    private final Log1984CalculateUserRecordMapper log1984CalculateUserRecordMapper;
    private final Log2013CalculateUserRecordMapper log2013CalculateUserRecordMapper;
    private final MineLogCalculateUserRecordMapper mineLogCalculateUserRecordMapper;
    private final PurlinLogCalculateUserRecordMapper purlinLogCalculateUserRecordMapper;
    private final RafterLogCalculateUserRecordMapper rafterLogCalculateUserRecordMapper;
    private final SmallBoleLogCalculateUserRecordMapper smallBoleLogCalculateUserRecordMapper;
    private final SoutheastAsiaLogCalculateUserRecordMapper southeastAsiaLogCalculateUserRecordMapper;
    private final WeightUserRecordMapper weightUserRecordMapper;

    public UserRecordSaveServiceImpl(AmericanLogCalculateUserRecordMapper americanLogCalculateUserRecordMapper,
                                     BillUserRecordMapper billUserRecordMapper,
                                     WoodTypeMapper woodTypeMapper, BoleLogCalculateUserRecordMapper boleLogCalculateUserRecordMapper,
                                     BolePinusLogCalculateUserRecordMapper bolePinusLogCalculateUserRecordMapper,
                                     BoleShanLogCalculateUserRecordMapper boleShanLogCalculateUserRecordMapper,
                                     Log1984CalculateUserRecordMapper log1984CalculateUserRecordMapper,
                                     Log2013CalculateUserRecordMapper log2013CalculateUserRecordMapper,
                                     MineLogCalculateUserRecordMapper mineLogCalculateUserRecordMapper,
                                     PurlinLogCalculateUserRecordMapper purlinLogCalculateUserRecordMapper,
                                     SmallBoleLogCalculateUserRecordMapper smallBoleLogCalculateUserRecordMapper,
                                     SoutheastAsiaLogCalculateUserRecordMapper southeastAsiaLogCalculateUserRecordMapper,
                                     WeightUserRecordMapper weightUserRecordMapper,
                                     RafterLogCalculateUserRecordMapper rafterLogCalculateUserRecordMapper) {
        this.americanLogCalculateUserRecordMapper = americanLogCalculateUserRecordMapper;
        this.billUserRecordMapper = billUserRecordMapper;
        this.woodTypeMapper = woodTypeMapper;
        this.boleLogCalculateUserRecordMapper = boleLogCalculateUserRecordMapper;
        this.bolePinusLogCalculateUserRecordMapper = bolePinusLogCalculateUserRecordMapper;
        this.boleShanLogCalculateUserRecordMapper = boleShanLogCalculateUserRecordMapper;
        this.log1984CalculateUserRecordMapper = log1984CalculateUserRecordMapper;
        this.log2013CalculateUserRecordMapper = log2013CalculateUserRecordMapper;
        this.mineLogCalculateUserRecordMapper = mineLogCalculateUserRecordMapper;
        this.purlinLogCalculateUserRecordMapper = purlinLogCalculateUserRecordMapper;
        this.smallBoleLogCalculateUserRecordMapper = smallBoleLogCalculateUserRecordMapper;
        this.southeastAsiaLogCalculateUserRecordMapper = southeastAsiaLogCalculateUserRecordMapper;
        this.weightUserRecordMapper = weightUserRecordMapper;
        this.rafterLogCalculateUserRecordMapper =rafterLogCalculateUserRecordMapper;
    }

    @Override
    public void save(CalculateMoreReturn calculateMoreReturn,CalculateMore calculateMore) {
        BillUserRecord userRecordKey = new BillUserRecord();
        userRecordKey.setTime(calculateMoreReturn.getTime());
        userRecordKey.setUserid(calculateMore.getUserId());
        List<LogReturn> logReturnList
                = calculateMoreReturn.getLogList();
        List<WeightReturn> weightReturnList
                = calculateMoreReturn.getWeightList();
        List<TimberReturn> timberReturnList
                = calculateMoreReturn.getTimberList();
        List<ValidationReturn> validationReturnList
                = calculateMoreReturn.getValidationList();
        saveLogList(logReturnList,userRecordKey);
        saveWeightReturnList(weightReturnList,userRecordKey);
        saveTimberReturnList(timberReturnList,userRecordKey);
        saveValidationReturnList(validationReturnList,userRecordKey);
        BillUserRecord billUserRecord = new BillUserRecord();
        billUserRecord.setUserid(userRecordKey.getUserid());
        billUserRecord.setTime(userRecordKey.getTime());
        String logSum = calculateMoreReturn.getLogSum();
        if (BigDecimalFactory.isNumber(logSum)) {
            billUserRecord.setLogSum(Double.parseDouble(logSum));
        }
        billUserRecord.setLogVolume(Double.parseDouble(
                calculateMoreReturn.getLogVolume()
        ));
        billUserRecord.setWeight(Double.parseDouble(
                calculateMoreReturn.getWeightVolume()
                )
        );
        String weightSum = calculateMoreReturn.getWeightSum();
        if (BigDecimalFactory.isNumber(weightSum)) {
            billUserRecord.setWeightSum(
                Double.parseDouble(weightSum)
            );
        }
        String validationSum = calculateMoreReturn.getValuationSum();
        if (BigDecimalFactory.isNumber(validationSum)) {
            billUserRecord.setValidationSum(Double.parseDouble(
                    validationSum
            ));
        }
        billUserRecord.setValidationVolume(
                Double.parseDouble(
                        calculateMoreReturn.getValuationVolume()
                )
        );
        String timberSum = calculateMoreReturn.getTimberSum();
        if (BigDecimalFactory.isNumber(timberSum)) {
            billUserRecord.setTimberSum(Double.parseDouble(
                    timberSum
            ));
        }
        billUserRecord.setTimberVolume(
                Double.parseDouble(
                        calculateMoreReturn.getTimberVolume()
                )
        );
        billUserRecordMapper.insert(billUserRecord);
    }

    @Override
    public CalculateMoreReturn get(UserRecordKey userRecordKey) {
        return null;
    }

    @Override
    public void saveLogList(List<LogReturn> logReturnList,BillUserRecord userRecordKey) {
        int userId = userRecordKey.getUserid();
        Date time =userRecordKey.getTime();
        for (LogReturn l: logReturnList) {
            WoodType woodType = woodTypeMapper.selectByPrimaryKey(l.getTypeCode());
            if (woodType != null && woodType.getBelongs().equals("原木")
                    && woodType.getName().equals("原木2013")) {
                Log2013CalculateUserRecord record =
                        new Log2013CalculateUserRecord();
                record.setUserid(userId);
                record.setTime(time);
                record.setLength(Double.parseDouble(l.getLength()));
                record.setWidth(Double.parseDouble(l.getDiameter()));
                record.setVolume(Double.parseDouble(l.getVolume()));
                String sum = l.getSum();
                String piece = l.getPiece();
                if (BigDecimalFactory.isNumber(sum)){
                    record.setSum(Double.parseDouble(sum));
                }
                if (BigDecimalFactory.isNumber(piece)){
                    record.setPiece(Double.parseDouble(piece));
                }
                log2013CalculateUserRecordMapper.insert(record);
            }
            if (woodType != null && woodType.getBelongs().equals("原木")
                    && woodType.getName().equals("原木1984")) {
                Log1984CalculateUserRecord record =
                        new Log1984CalculateUserRecord();
                record.setUserid(userId);
                record.setTime(time);
                record.setLength(Double.parseDouble(l.getLength()));
                record.setWidth(Double.parseDouble(l.getDiameter()));
                record.setVolume(Double.parseDouble(l.getVolume()));
                String sum = l.getSum();
                String piece = l.getPiece();
                if (BigDecimalFactory.isNumber(sum)){
                    record.setSum(Double.parseDouble(sum));
                }
                if (BigDecimalFactory.isNumber(piece)){
                    record.setPiece(Double.parseDouble(piece));
                }
                log1984CalculateUserRecordMapper.insert(record);
            }
            if (woodType != null && woodType.getBelongs().equals("原木")
                    && woodType.getName().equals("矿木")){
                MineLogCalculateUserRecord record =
                        new MineLogCalculateUserRecord();
                record.setUserid(userId);
                record.setTime(time);
                record.setLength(Double.parseDouble(l.getLength()));
                record.setWidth(Double.parseDouble(l.getDiameter()));
                record.setVolume(Double.parseDouble(l.getVolume()));
                String sum = l.getSum();
                String piece = l.getPiece();
                if (BigDecimalFactory.isNumber(sum)){
                    record.setSum(Double.parseDouble(sum));
                }
                if (BigDecimalFactory.isNumber(piece)){
                    record.setPiece(Double.parseDouble(piece));
                }
                mineLogCalculateUserRecordMapper.insert(record);
            }
            if (woodType != null && woodType.getBelongs().equals("原木")
                    && woodType.getName().equals("檩材")){
                PurlinLogCalculateUserRecord record =
                        new PurlinLogCalculateUserRecord();
                record.setUserid(userId);
                record.setTime(time);
                record.setLength(Double.parseDouble(l.getLength()));
                record.setWidth(Double.parseDouble(l.getDiameter()));
                record.setVolume(Double.parseDouble(l.getVolume()));
                String sum = l.getSum();
                String piece = l.getPiece();
                if (BigDecimalFactory.isNumber(sum)){
                    record.setSum(Double.parseDouble(sum));
                }
                if (BigDecimalFactory.isNumber(piece)){
                    record.setPiece(Double.parseDouble(piece));
                }
                purlinLogCalculateUserRecordMapper.insert(record);
            }
            if (woodType != null && woodType.getBelongs().equals("原木")
                    && woodType.getName().equals("椽材")){
                RafterLogCalculateUserRecord record =
                        new RafterLogCalculateUserRecord();
                record.setUserid(userId);
                record.setTime(time);
                record.setLength(Double.parseDouble(l.getLength()));
                record.setWidth(Double.parseDouble(l.getDiameter()));
                record.setVolume(Double.parseDouble(l.getVolume()));
                String sum = l.getSum();
                String piece = l.getPiece();
                if (BigDecimalFactory.isNumber(sum)){
                    record.setSum(Double.parseDouble(sum));
                }
                if (BigDecimalFactory.isNumber(piece)){
                    record.setPiece(Double.parseDouble(piece));
                }
                rafterLogCalculateUserRecordMapper.insert(record);
            }
            if (woodType != null && woodType.getBelongs().equals("原条")
                    && woodType.getName().equals("原条1999")){
                BoleLogCalculateUserRecord record =
                        new BoleLogCalculateUserRecord();
                record.setUserid(userId);
                record.setTime(time);
                record.setLength(Double.parseDouble(l.getLength()));
                record.setWidth(Double.parseDouble(l.getDiameter()));
                record.setVolume(Double.parseDouble(l.getVolume()));
                String sum = l.getSum();
                String piece = l.getPiece();
                if (BigDecimalFactory.isNumber(sum)){
                    record.setSum(Double.parseDouble(sum));
                }
                if (BigDecimalFactory.isNumber(piece)){
                    record.setPiece(Double.parseDouble(piece));
                }
                boleLogCalculateUserRecordMapper.insert(record);
            }
            if (woodType != null && woodType.getBelongs().equals("原条")
                    && woodType.getName().equals("小原条")){
                SmallBoleLogCalculateUserRecord record =
                        new SmallBoleLogCalculateUserRecord();
                record.setUserid(userId);
                record.setTime(time);
                record.setLength(Double.parseDouble(l.getLength()));
                record.setWidth(Double.parseDouble(l.getDiameter()));
                record.setVolume(Double.parseDouble(l.getVolume()));
                String sum = l.getSum();
                String piece = l.getPiece();
                if (BigDecimalFactory.isNumber(sum)){
                    record.setSum(Double.parseDouble(sum));
                }
                if (BigDecimalFactory.isNumber(piece)){
                    record.setPiece(Double.parseDouble(piece));
                }
                smallBoleLogCalculateUserRecordMapper.insert(record);
            }
            if (woodType != null && woodType.getBelongs().equals("原条")
                    && woodType.getName().equals("杉原条")){
                BoleShanLogCalculateUserRecord record =
                        new BoleShanLogCalculateUserRecord();
                record.setUserid(userId);
                record.setTime(time);
                record.setLength(Double.parseDouble(l.getLength()));
                record.setWidth(Double.parseDouble(l.getDiameter()));
                record.setVolume(Double.parseDouble(l.getVolume()));
                String sum = l.getSum();
                String piece = l.getPiece();
                if (BigDecimalFactory.isNumber(sum)){
                    record.setSum(Double.parseDouble(sum));
                }
                if (BigDecimalFactory.isNumber(piece)){
                    record.setPiece(Double.parseDouble(piece));
                }
                boleShanLogCalculateUserRecordMapper.insert(record);
            }
            if (woodType != null && woodType.getBelongs().equals("原条")
                    && woodType.getName().equals("马尾松原条")){
                BolePinusLogCalculateUserRecord record =
                        new BolePinusLogCalculateUserRecord();
                record.setUserid(userId);
                record.setTime(time);
                record.setLength(Double.parseDouble(l.getLength()));
                record.setWidth(Double.parseDouble(l.getDiameter()));
                record.setVolume(Double.parseDouble(l.getVolume()));
                String sum = l.getSum();
                String piece = l.getPiece();
                if (BigDecimalFactory.isNumber(sum)){
                    record.setSum(Double.parseDouble(sum));
                }
                if (BigDecimalFactory.isNumber(piece)){
                    record.setPiece(Double.parseDouble(piece));
                }
                bolePinusLogCalculateUserRecordMapper.insert(record);
            }
            if (woodType != null && woodType.getBelongs().equals("原木")
                    && woodType.getName().equals("美国原木")){
                AmericanLogCalculateUserRecord record =
                        new AmericanLogCalculateUserRecord();
                record.setUserid(userId);
                record.setTime(time);
                record.setLength(Double.parseDouble(l.getLength()));
                record.setWidth(Double.parseDouble(l.getDiameter()));
                record.setVolume(Double.parseDouble(l.getVolume()));
                String sum = l.getSum();
                String piece = l.getPiece();
                if (BigDecimalFactory.isNumber(sum)){
                    record.setSum(Double.parseDouble(sum));
                }
                if (BigDecimalFactory.isNumber(piece)){
                    record.setPiece(Double.parseDouble(piece));
                }
                americanLogCalculateUserRecordMapper.insert(record);
            }
            if (woodType != null && woodType.getBelongs().equals("原木")
                    && woodType.getName().equals("俄罗斯原木")){
                // TODO: 11/22/2016 俄罗斯木材没有保存
            }
            if (woodType != null && woodType.getBelongs().equals("原木")
                    && woodType.getName().equals("东南亚原木")){
                SoutheastAsiaLogCalculateUserRecord record =
                        new SoutheastAsiaLogCalculateUserRecord();
                record.setUserid(userId);
                record.setTime(time);
                record.setLength(Double.parseDouble(l.getLength()));
                record.setWidth(Double.parseDouble(l.getDiameter()));
                record.setVolume(Double.parseDouble(l.getVolume()));
                String sum = l.getSum();
                String piece = l.getPiece();
                if (BigDecimalFactory.isNumber(sum)){
                    record.setSum(Double.parseDouble(sum));
                }
                if (BigDecimalFactory.isNumber(piece)){
                    record.setPiece(Double.parseDouble(piece));
                }
                southeastAsiaLogCalculateUserRecordMapper.insert(record);
            }
        }
    }

    @Override
    public void saveWeightReturnList(List<WeightReturn> weightReturnList,BillUserRecord userRecordKey) {
        int userId = userRecordKey.getUserid();
        Date time =userRecordKey.getTime();
        for (WeightReturn w:weightReturnList) {
            WeightUserRecord wr = new WeightUserRecord();
            wr.setUserid(userId);
            wr.setTime(time);
            wr.setTotal(Double.parseDouble(w.getTotal()));
            wr.setLorry(Double.parseDouble(w.getLorry()));
            wr.setWeight(Double.parseDouble(w.getWeight()));
            String piece = w.getPiece();
            if (BigDecimalFactory.isNumber(piece)) {
                wr.setPiece(Double.parseDouble(piece));
            }
            String sum = w.getSum();
            if (BigDecimalFactory.isNumber(sum)){
                wr.setSum(Double.parseDouble(sum));
            }
            weightUserRecordMapper.insert(wr);
        }
    }

    @Override
    public void saveTimberReturnList(List<TimberReturn> timberReturnList,BillUserRecord userRecordKey) {
// TODO: 11/22/2016
    }

    @Override
    public void saveValidationReturnList(List<ValidationReturn> validationReturnList,BillUserRecord userRecordKey) {
// TODO: 11/22/2016
    }

}
