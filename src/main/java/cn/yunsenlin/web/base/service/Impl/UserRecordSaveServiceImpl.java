package cn.yunsenlin.web.base.service.Impl;

import cn.yunsenlin.web.base.dao.*;
import cn.yunsenlin.web.base.dto.calculate.android.*;
import cn.yunsenlin.web.base.dto.tongBu.android.IndexReturn;
import cn.yunsenlin.web.base.factory.BigDecimalFactory;
import cn.yunsenlin.web.base.model.*;
import cn.yunsenlin.web.base.service.UserRecordSaveService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
    private final RussianLogCalculateUserRecordMapper russianLogCalculateUserRecordMapper;
    private final TimberCalculateUserRecordMapper timberCalculateUserRecordMapper;

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
                                     RafterLogCalculateUserRecordMapper rafterLogCalculateUserRecordMapper, RussianLogCalculateUserRecordMapper russianLogCalculateUserRecordMapper, TimberCalculateUserRecordMapper timberCalculateUserRecordMapper) {
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
        this.rafterLogCalculateUserRecordMapper = rafterLogCalculateUserRecordMapper;
        this.russianLogCalculateUserRecordMapper = russianLogCalculateUserRecordMapper;
        this.timberCalculateUserRecordMapper = timberCalculateUserRecordMapper;
    }

    @Override
    public void save(CalculateMoreReturn calculateMoreReturn, CalculateMore calculateMore) {
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
        saveLogList(logReturnList, userRecordKey);
        saveWeightReturnList(weightReturnList, userRecordKey);
        saveTimberReturnList(timberReturnList, userRecordKey);
        saveValidationReturnList(validationReturnList, userRecordKey);
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
        billUserRecordMapper.deleteByPrimaryKey(userRecordKey);
        billUserRecordMapper.insert(billUserRecord);
    }

    @Override
    public CalculateMoreReturn get(BillUserRecordKey userRecordKey) {
        List<LogReturn> logList = new ArrayList<>();
        List<Log2013CalculateUserRecord> list1
                = log2013CalculateUserRecordMapper.selectByPrimaryKey(userRecordKey);
        List<Log1984CalculateUserRecord> list2
                = log1984CalculateUserRecordMapper.selectByPrimaryKey(userRecordKey);
        List<AmericanLogCalculateUserRecord> list3
                = americanLogCalculateUserRecordMapper.selectByPrimaryKey(userRecordKey);
        List<BoleLogCalculateUserRecord> list4
                = boleLogCalculateUserRecordMapper.selectByPrimaryKey(userRecordKey);
        List<BolePinusLogCalculateUserRecord> list5
                = bolePinusLogCalculateUserRecordMapper.selectByPrimaryKey(userRecordKey);
        List<BoleShanLogCalculateUserRecord> list6
                = boleShanLogCalculateUserRecordMapper.selectByPrimaryKey(userRecordKey);
        List<MineLogCalculateUserRecord> list7
                = mineLogCalculateUserRecordMapper.selectByPrimaryKey(userRecordKey);
        List<PurlinLogCalculateUserRecord> list8
                = purlinLogCalculateUserRecordMapper.selectByPrimaryKey(userRecordKey);
        List<RafterLogCalculateUserRecord> list9
                = rafterLogCalculateUserRecordMapper.selectByPrimaryKey(userRecordKey);
        List<RussianLogCalculateUserRecord> list10
                = russianLogCalculateUserRecordMapper.selectByPrimaryKey(userRecordKey);
        List<SmallBoleLogCalculateUserRecord> list11
                = smallBoleLogCalculateUserRecordMapper.selectByPrimaryKey(userRecordKey);
        List<SoutheastAsiaLogCalculateUserRecord> list12
                = southeastAsiaLogCalculateUserRecordMapper.selectByPrimaryKey(userRecordKey);
        logList.addAll(toLogReturn1(list1));
        logList.addAll(toLogReturn2(list2));
        logList.addAll(toLogReturn3(list3));
        logList.addAll(toLogReturn4(list4));
        logList.addAll(toLogReturn5(list5));
        logList.addAll(toLogReturn6(list6));
        logList.addAll(toLogReturn7(list11));
        logList.addAll(toLogReturn8(list7));
        logList.addAll(toLogReturn9(list8));
        logList.addAll(toLogReturn10(list9));
        logList.addAll(toLogReturn11(list10));
        logList.addAll(toLogReturn12(list12));
        List<WeightUserRecord> weightList = weightUserRecordMapper.selectByPrimaryKey(userRecordKey);
        CalculateMoreReturn c = new CalculateMoreReturn();
        c.setLogList(logList);
        c.setWeightList(toWeightReturn(weightList));
        List<TimberCalculateUserRecord> timberList = timberCalculateUserRecordMapper.selectByPrimaryKey(userRecordKey);
        c.setTimberList(toTimberReturn(timberList));
        // TODO: 11/22/2016 暂时不计算估算木材
        return null;
    }

    @Override
    public void saveLogList(List<LogReturn> logReturnList, BillUserRecord userRecordKey) {
        log2013CalculateUserRecordMapper.deleteByPrimaryKey(userRecordKey);
        log1984CalculateUserRecordMapper.deleteByPrimaryKey(userRecordKey);
        mineLogCalculateUserRecordMapper.deleteByPrimaryKey(userRecordKey);
        boleLogCalculateUserRecordMapper.deleteByPrimaryKey(userRecordKey);
        rafterLogCalculateUserRecordMapper.deleteByPrimaryKey(userRecordKey);
        purlinLogCalculateUserRecordMapper.deleteByPrimaryKey(userRecordKey);
        boleShanLogCalculateUserRecordMapper.deleteByPrimaryKey(userRecordKey);
        smallBoleLogCalculateUserRecordMapper.deleteByPrimaryKey(userRecordKey);
        bolePinusLogCalculateUserRecordMapper.deleteByPrimaryKey(userRecordKey);
        americanLogCalculateUserRecordMapper.deleteByPrimaryKey(userRecordKey);
        russianLogCalculateUserRecordMapper.deleteByPrimaryKey(userRecordKey);
        southeastAsiaLogCalculateUserRecordMapper.deleteByPrimaryKey(userRecordKey);
        for (LogReturn l : logReturnList) {
            saveLoginReturn(l,userRecordKey);
        }
    }
    private void saveLoginReturn(LogReturn l, BillUserRecord userRecordKey){
        WoodType woodType = woodTypeMapper.selectByPrimaryKey(l.getTypeCode());
        if (judgeWoodType(woodType,"原木2013")) {
            log2013CalculateUserRecordMapper.insert(
                    l.toLog2013CalculateUserRecord(userRecordKey)
            );
        }
        if (judgeWoodType(woodType,"原木1984")) {
            log1984CalculateUserRecordMapper.insert(l.toLog1984CalculateUserRecord(userRecordKey));
        }
        if (judgeWoodType(woodType,"矿木")) {
            mineLogCalculateUserRecordMapper.insert(l.toMineLogCalculateUserRecord(userRecordKey));
        }

        if (judgeWoodType(woodType,"檩材")) {
            purlinLogCalculateUserRecordMapper.insert(l.toPurlinLogCalculateUserRecord(userRecordKey));
        }
        if (judgeWoodType(woodType,"椽材")) {
            rafterLogCalculateUserRecordMapper.insert(l.toRafterLogCalculateUserRecord(userRecordKey));
        }
        if (judgeWoodType(woodType,"原条1999")) {
            boleLogCalculateUserRecordMapper.insert(l.toBoleLogCalculateUserRecord(userRecordKey));
        }
        if (judgeWoodType(woodType,"小原条")) {
            smallBoleLogCalculateUserRecordMapper.insert(l.toSmallBoleLogCalculateUserRecord(userRecordKey));
        }
        if (judgeWoodType(woodType,"杉原条")) {
            boleShanLogCalculateUserRecordMapper.insert(l.toBoleShanLogCalculateUserRecord(userRecordKey));
        }
        if (judgeWoodType(woodType,"马尾松原条")) {
            bolePinusLogCalculateUserRecordMapper.insert(l.toBolePinusLogCalculateUserRecord(userRecordKey));
        }
        if (judgeWoodType(woodType,"美国原木")) {
            americanLogCalculateUserRecordMapper.insert(l.toAmericanLogCalculateUserRecord(userRecordKey));
        }
        if (judgeWoodType(woodType,"俄罗斯原木")) {
            russianLogCalculateUserRecordMapper.insert(l.toRussianLogCalculateUserRecord(userRecordKey));
        }
        if (judgeWoodType(woodType,"东南亚原木")) {
            southeastAsiaLogCalculateUserRecordMapper.insert(l.toSoutheastAsiaLogCalculateUserRecord(userRecordKey));
        }
    }

    @Override
    public void saveWeightReturnList(List<WeightReturn> weightReturnList, BillUserRecord userRecordKey) {
        weightUserRecordMapper.deleteByPrimaryKey(userRecordKey);
        int userId = userRecordKey.getUserid();
        Date time = userRecordKey.getTime();
        for (WeightReturn w : weightReturnList) {
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
            if (BigDecimalFactory.isNumber(sum)) {
                wr.setSum(Double.parseDouble(sum));
            }
            weightUserRecordMapper.insert(wr);
        }
    }

    @Override
    public void saveTimberReturnList(List<TimberReturn> timberReturnList, BillUserRecord userRecordKey) {
        timberCalculateUserRecordMapper.deleteByPrimaryKey(userRecordKey);
        int userId = userRecordKey.getUserid();
        Date time = userRecordKey.getTime();
        for (TimberReturn t :
                timberReturnList) {
            TimberCalculateUserRecord tu =
                    new TimberCalculateUserRecord();
            tu.setUserid(userId);
            tu.setTime(time);
            tu.setLength(Double.parseDouble(t.getLength()));
            tu.setWidth(Double.parseDouble(t.getWidth()));
            tu.setHeight(Double.parseDouble(t.getHeight()));
            tu.setVolume(Double.parseDouble(t.getVolume()));
            String num = t.getNum();
            if (BigDecimalFactory.isNumber(num)){
                tu.setNum(Integer.parseInt(num));
            }
            String stack = t.getStack();
            if (BigDecimalFactory.isNumber(stack)){
                tu.setStack(Integer.parseInt(stack));
            }
            String piece = t.getPiece();
            if (BigDecimalFactory.isNumber(piece)) {
                tu.setPiece(Double.parseDouble(piece));
            }
            String sum = t.getSum();
            if (BigDecimalFactory.isNumber(sum)) {
                tu.setSum(Double.parseDouble(sum));
            }
            timberCalculateUserRecordMapper.insert(tu);
        }
    }

    @Override
    public void saveValidationReturnList(List<ValidationReturn> validationReturnList, BillUserRecord userRecordKey) {
        // TODO: 11/22/2016 暂时不计算估算木材
    }

    @Override
    public void delete(BillUserRecordKey userRecordKey) {
        americanLogCalculateUserRecordMapper.deleteByPrimaryKey(userRecordKey);
        billUserRecordMapper.deleteByPrimaryKey(userRecordKey);
        boleLogCalculateUserRecordMapper.deleteByPrimaryKey(userRecordKey);
        bolePinusLogCalculateUserRecordMapper.deleteByPrimaryKey(userRecordKey);
        boleShanLogCalculateUserRecordMapper.deleteByPrimaryKey(userRecordKey);
        log1984CalculateUserRecordMapper.deleteByPrimaryKey(userRecordKey);
        log2013CalculateUserRecordMapper.deleteByPrimaryKey(userRecordKey);
        mineLogCalculateUserRecordMapper.deleteByPrimaryKey(userRecordKey);
        purlinLogCalculateUserRecordMapper.deleteByPrimaryKey(userRecordKey);
        rafterLogCalculateUserRecordMapper.deleteByPrimaryKey(userRecordKey);
        smallBoleLogCalculateUserRecordMapper.deleteByPrimaryKey(userRecordKey);
        southeastAsiaLogCalculateUserRecordMapper.deleteByPrimaryKey(userRecordKey);
        weightUserRecordMapper.deleteByPrimaryKey(userRecordKey);
        russianLogCalculateUserRecordMapper.deleteByPrimaryKey(userRecordKey);
        timberCalculateUserRecordMapper.deleteByPrimaryKey(userRecordKey);
        // TODO: 11/22/2016 暂时不计算估算木材
    }

    @Override
    public IndexReturn getIndexReturn(int userId) {
        IndexReturn indexReturn = new IndexReturn();
        indexReturn.setIndexList(billUserRecordMapper.getTimeIndex(userId));
        return indexReturn;
    }

    private List<LogReturn> toLogReturn1(List<Log2013CalculateUserRecord> list) {
        List<LogReturn> logList = new ArrayList<>();
        for (Log2013CalculateUserRecord r : list) {
            LogReturn l = new LogReturn();
            l.setVolume(r.getVolume().toString());
            l.setDiameter(r.getWidth().toString());
            l.setTypeCode("100001");
            l.setNum(r.getNum().toString());
            l.setSum(r.getSum().toString());
            l.setPiece(r.getPiece().toString());
            l.setLength(r.getLength().toString());
            logList.add(l);
        }
        return logList;
    }
    private List<LogReturn> toLogReturn2(List<Log1984CalculateUserRecord> list) {
        List<LogReturn> logList = new ArrayList<>();
        for (Log1984CalculateUserRecord r : list) {
            LogReturn l = new LogReturn();
            l.setVolume(r.getVolume().toString());
            l.setDiameter(r.getWidth().toString());
            l.setTypeCode("100002");
            l.setNum(r.getNum().toString());
            l.setSum(r.getSum().toString());
            l.setPiece(r.getPiece().toString());
            l.setLength(r.getLength().toString());
            logList.add(l);
        }
        return logList;
    }
    private List<LogReturn> toLogReturn3(List<AmericanLogCalculateUserRecord> list) {
        List<LogReturn> logList = new ArrayList<>();
        for (AmericanLogCalculateUserRecord r : list) {
            LogReturn l = new LogReturn();
            l.setVolume(r.getVolume().toString());
            l.setDiameter(r.getWidth().toString());
            l.setTypeCode("100005");
            l.setNum(r.getNum().toString());
            l.setSum(r.getSum().toString());
            l.setPiece(r.getPiece().toString());
            l.setLength(r.getLength().toString());
            logList.add(l);
        }
        return logList;
    }
    private List<LogReturn> toLogReturn4(List<BoleLogCalculateUserRecord> list) {
        List<LogReturn> logList = new ArrayList<>();
        for (BoleLogCalculateUserRecord r : list) {
            LogReturn l = new LogReturn();
            l.setVolume(r.getVolume().toString());
            l.setDiameter(r.getWidth().toString());
            l.setTypeCode("100009");
            l.setNum(r.getNum().toString());
            l.setSum(r.getSum().toString());
            l.setPiece(r.getPiece().toString());
            l.setLength(r.getLength().toString());
            logList.add(l);
        }
        return logList;
    }
    private List<LogReturn> toLogReturn5(List<BolePinusLogCalculateUserRecord> list) {
        List<LogReturn> logList = new ArrayList<>();
        for (BolePinusLogCalculateUserRecord r : list) {
            LogReturn l = new LogReturn();
            l.setVolume(r.getVolume().toString());
            l.setDiameter(r.getWidth().toString());
            l.setTypeCode("100014");
            l.setNum(r.getNum().toString());
            l.setSum(r.getSum().toString());
            l.setPiece(r.getPiece().toString());
            l.setLength(r.getLength().toString());
            logList.add(l);
        }
        return logList;
    }
    private List<LogReturn> toLogReturn6(List<BoleShanLogCalculateUserRecord> list) {
        List<LogReturn> logList = new ArrayList<>();
        for (BoleShanLogCalculateUserRecord r : list) {
            LogReturn l = new LogReturn();
            l.setVolume(r.getVolume().toString());
            l.setDiameter(r.getWidth().toString());
            l.setTypeCode("100013");
            l.setNum(r.getNum().toString());
            l.setSum(r.getSum().toString());
            l.setPiece(r.getPiece().toString());
            l.setLength(r.getLength().toString());
            logList.add(l);
        }
        return logList;
    }
    private List<LogReturn> toLogReturn7(List<SmallBoleLogCalculateUserRecord> list) {
        List<LogReturn> logList = new ArrayList<>();
        for (SmallBoleLogCalculateUserRecord r : list) {
            LogReturn l = new LogReturn();
            l.setVolume(r.getVolume().toString());
            l.setDiameter(r.getWidth().toString());
            l.setTypeCode("100008");
            l.setNum(r.getNum().toString());
            l.setSum(r.getSum().toString());
            l.setPiece(r.getPiece().toString());
            l.setLength(r.getLength().toString());
            logList.add(l);
        }
        return logList;
    }
    private List<LogReturn> toLogReturn8(List<MineLogCalculateUserRecord> list) {
        List<LogReturn> logList = new ArrayList<>();
        for (MineLogCalculateUserRecord r : list) {
            LogReturn l = new LogReturn();
            l.setVolume(r.getVolume().toString());
            l.setDiameter(r.getWidth().toString());
            l.setTypeCode("100007");
            l.setNum(r.getNum().toString());
            l.setSum(r.getSum().toString());
            l.setPiece(r.getPiece().toString());
            l.setLength(r.getLength().toString());
            logList.add(l);
        }
        return logList;
    }
    private List<LogReturn> toLogReturn9(List<PurlinLogCalculateUserRecord> list) {
        List<LogReturn> logList = new ArrayList<>();
        for (PurlinLogCalculateUserRecord r : list) {
            LogReturn l = new LogReturn();
            l.setVolume(r.getVolume().toString());
            l.setDiameter(r.getWidth().toString());
            l.setTypeCode("100012");
            l.setNum(r.getNum().toString());
            l.setSum(r.getSum().toString());
            l.setPiece(r.getPiece().toString());
            l.setLength(r.getLength().toString());
            logList.add(l);
        }
        return logList;
    }
    private List<LogReturn> toLogReturn10(List<RafterLogCalculateUserRecord> list) {
        List<LogReturn> logList = new ArrayList<>();
        for (RafterLogCalculateUserRecord r : list) {
            LogReturn l = new LogReturn();
            l.setVolume(r.getVolume().toString());
            l.setDiameter(r.getWidth().toString());
            l.setTypeCode("100003");
            l.setNum(r.getNum().toString());
            l.setSum(r.getSum().toString());
            l.setPiece(r.getPiece().toString());
            l.setLength(r.getLength().toString());
            logList.add(l);
        }
        return logList;
    }
    private List<LogReturn> toLogReturn11(List<RussianLogCalculateUserRecord> list) {
        List<LogReturn> logList = new ArrayList<>();
        for (RussianLogCalculateUserRecord r : list) {
            LogReturn l = new LogReturn();
            l.setVolume(r.getVolume().toString());
            l.setDiameter(r.getWidth().toString());
            l.setTypeCode("100004");
            l.setNum(r.getNum().toString());
            l.setSum(r.getSum().toString());
            l.setPiece(r.getPiece().toString());
            l.setLength(r.getLength().toString());
            logList.add(l);
        }
        return logList;
    }
    private List<LogReturn> toLogReturn12(List<SoutheastAsiaLogCalculateUserRecord> list) {
        List<LogReturn> logList = new ArrayList<>();
        for (SoutheastAsiaLogCalculateUserRecord r : list) {
            LogReturn l = new LogReturn();
            l.setVolume(r.getVolume().toString());
            l.setDiameter(r.getWidth().toString());
            l.setTypeCode("100006");
            l.setNum(r.getNum().toString());
            l.setSum(r.getSum().toString());
            l.setPiece(r.getPiece().toString());
            l.setLength(r.getLength().toString());
            logList.add(l);
        }
        return logList;
    }
    private List<WeightReturn> toWeightReturn(List<WeightUserRecord> list){
        return list.stream().map(WeightUserRecord::toWeightReturn).collect(Collectors.toList());
    }
    private List<TimberReturn> toTimberReturn(List<TimberCalculateUserRecord> list){
        return list.stream().map(TimberCalculateUserRecord::toTimberReturn).collect(Collectors.toList());
    }
    private boolean judgeWoodType(WoodType woodType,String name){
        return woodType != null && woodType.getBelongs().equals("原木")
                && woodType.getName().equals(name);
    }
}
