package cn.yunsenlin.web.base.dto.calculate.android;

import cn.yunsenlin.web.base.factory.BigDecimalFactory;
import cn.yunsenlin.web.base.model.*;

public class LogReturn extends Log {
    private String volume;
    private String sum;

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public Log2013CalculateUserRecord toLog2013CalculateUserRecord(BillUserRecordKey userRecordKey) {
        Log2013CalculateUserRecord record =
                new Log2013CalculateUserRecord();
        record.setUserid(userRecordKey.getUserid());
        record.setTime(userRecordKey.getTime());
        record.setLength(Double.parseDouble(getLength()));
        record.setWidth(Double.parseDouble(getDiameter()));
        record.setVolume(Double.parseDouble(getVolume()));
        record.setNum(Double.parseDouble(getNum()));
        String sum = getSum();
        String piece = getPiece();
        if (BigDecimalFactory.isNumber(sum)) {
            record.setSum(Double.parseDouble(sum));
        }
        if (BigDecimalFactory.isNumber(piece)) {
            record.setPiece(Double.parseDouble(piece));
        }
        return record;
    }

    public Log1984CalculateUserRecord toLog1984CalculateUserRecord(BillUserRecordKey userRecordKey) {
        Log1984CalculateUserRecord record =
                new Log1984CalculateUserRecord();
        record.setUserid(userRecordKey.getUserid());
        record.setTime(userRecordKey.getTime());
        record.setLength(Double.parseDouble(getLength()));
        record.setWidth(Double.parseDouble(getDiameter()));
        record.setVolume(Double.parseDouble(getVolume()));
        record.setNum(Double.parseDouble(getNum()));
        String sum = getSum();
        String piece = getPiece();
        if (BigDecimalFactory.isNumber(sum)) {
            record.setSum(Double.parseDouble(sum));
        }
        if (BigDecimalFactory.isNumber(piece)) {
            record.setPiece(Double.parseDouble(piece));
        }
        return record;
    }
    public MineLogCalculateUserRecord toMineLogCalculateUserRecord(BillUserRecordKey userRecordKey) {
        MineLogCalculateUserRecord record =
                new MineLogCalculateUserRecord();
        record.setUserid(userRecordKey.getUserid());
        record.setTime(userRecordKey.getTime());
        record.setLength(Double.parseDouble(getLength()));
        record.setWidth(Double.parseDouble(getDiameter()));
        record.setVolume(Double.parseDouble(getVolume()));
        record.setNum(Double.parseDouble(getNum()));
        String sum = getSum();
        String piece = getPiece();
        if (BigDecimalFactory.isNumber(sum)) {
            record.setSum(Double.parseDouble(sum));
        }
        if (BigDecimalFactory.isNumber(piece)) {
            record.setPiece(Double.parseDouble(piece));
        }
        return record;
    }
    public PurlinLogCalculateUserRecord toPurlinLogCalculateUserRecord(BillUserRecordKey userRecordKey) {
        PurlinLogCalculateUserRecord record =
                new PurlinLogCalculateUserRecord();
        record.setUserid(userRecordKey.getUserid());
        record.setTime(userRecordKey.getTime());
        record.setLength(Double.parseDouble(getLength()));
        record.setWidth(Double.parseDouble(getDiameter()));
        record.setVolume(Double.parseDouble(getVolume()));
        record.setNum(Double.parseDouble(getNum()));
        String sum = getSum();
        String piece = getPiece();
        if (BigDecimalFactory.isNumber(sum)) {
            record.setSum(Double.parseDouble(sum));
        }
        if (BigDecimalFactory.isNumber(piece)) {
            record.setPiece(Double.parseDouble(piece));
        }
        return record;
    }
    public RafterLogCalculateUserRecord toRafterLogCalculateUserRecord(BillUserRecordKey userRecordKey) {
        RafterLogCalculateUserRecord record =
                new RafterLogCalculateUserRecord();
        record.setUserid(userRecordKey.getUserid());
        record.setTime(userRecordKey.getTime());
        record.setLength(Double.parseDouble(getLength()));
        record.setWidth(Double.parseDouble(getDiameter()));
        record.setVolume(Double.parseDouble(getVolume()));
        record.setNum(Double.parseDouble(getNum()));
        String sum = getSum();
        String piece = getPiece();
        if (BigDecimalFactory.isNumber(sum)) {
            record.setSum(Double.parseDouble(sum));
        }
        if (BigDecimalFactory.isNumber(piece)) {
            record.setPiece(Double.parseDouble(piece));
        }
        return record;
    }
    public BoleLogCalculateUserRecord toBoleLogCalculateUserRecord(BillUserRecordKey userRecordKey) {
        BoleLogCalculateUserRecord record =
                new BoleLogCalculateUserRecord();
        record.setUserid(userRecordKey.getUserid());
        record.setTime(userRecordKey.getTime());
        record.setLength(Double.parseDouble(getLength()));
        record.setWidth(Double.parseDouble(getDiameter()));
        record.setVolume(Double.parseDouble(getVolume()));
        record.setNum(Double.parseDouble(getNum()));
        String sum = getSum();
        String piece = getPiece();
        if (BigDecimalFactory.isNumber(sum)) {
            record.setSum(Double.parseDouble(sum));
        }
        if (BigDecimalFactory.isNumber(piece)) {
            record.setPiece(Double.parseDouble(piece));
        }
        return record;
    }
    public SmallBoleLogCalculateUserRecord toSmallBoleLogCalculateUserRecord(BillUserRecordKey userRecordKey) {
        SmallBoleLogCalculateUserRecord record =
                new SmallBoleLogCalculateUserRecord();
        record.setUserid(userRecordKey.getUserid());
        record.setTime(userRecordKey.getTime());
        record.setLength(Double.parseDouble(getLength()));
        record.setWidth(Double.parseDouble(getDiameter()));
        record.setVolume(Double.parseDouble(getVolume()));
        record.setNum(Double.parseDouble(getNum()));
        String sum = getSum();
        String piece = getPiece();
        if (BigDecimalFactory.isNumber(sum)) {
            record.setSum(Double.parseDouble(sum));
        }
        if (BigDecimalFactory.isNumber(piece)) {
            record.setPiece(Double.parseDouble(piece));
        }
        return record;
    }
    public BoleShanLogCalculateUserRecord toBoleShanLogCalculateUserRecord(BillUserRecordKey userRecordKey) {
        BoleShanLogCalculateUserRecord record =
                new BoleShanLogCalculateUserRecord();
        record.setUserid(userRecordKey.getUserid());
        record.setTime(userRecordKey.getTime());
        record.setLength(Double.parseDouble(getLength()));
        record.setWidth(Double.parseDouble(getDiameter()));
        record.setVolume(Double.parseDouble(getVolume()));
        record.setNum(Double.parseDouble(getNum()));
        String sum = getSum();
        String piece = getPiece();
        if (BigDecimalFactory.isNumber(sum)) {
            record.setSum(Double.parseDouble(sum));
        }
        if (BigDecimalFactory.isNumber(piece)) {
            record.setPiece(Double.parseDouble(piece));
        }
        return record;
    }
    public BolePinusLogCalculateUserRecord toBolePinusLogCalculateUserRecord(BillUserRecordKey userRecordKey) {
        BolePinusLogCalculateUserRecord record =
                new BolePinusLogCalculateUserRecord();
        record.setUserid(userRecordKey.getUserid());
        record.setTime(userRecordKey.getTime());
        record.setLength(Double.parseDouble(getLength()));
        record.setWidth(Double.parseDouble(getDiameter()));
        record.setVolume(Double.parseDouble(getVolume()));
        record.setNum(Double.parseDouble(getNum()));
        String sum = getSum();
        String piece = getPiece();
        if (BigDecimalFactory.isNumber(sum)) {
            record.setSum(Double.parseDouble(sum));
        }
        if (BigDecimalFactory.isNumber(piece)) {
            record.setPiece(Double.parseDouble(piece));
        }
        return record;
    }
    public AmericanLogCalculateUserRecord toAmericanLogCalculateUserRecord(BillUserRecordKey userRecordKey) {
        AmericanLogCalculateUserRecord record =
                new AmericanLogCalculateUserRecord();
        record.setUserid(userRecordKey.getUserid());
        record.setTime(userRecordKey.getTime());
        record.setLength(Double.parseDouble(getLength()));
        record.setWidth(Double.parseDouble(getDiameter()));
        record.setVolume(Double.parseDouble(getVolume()));
        record.setNum(Double.parseDouble(getNum()));
        String sum = getSum();
        String piece = getPiece();
        if (BigDecimalFactory.isNumber(sum)) {
            record.setSum(Double.parseDouble(sum));
        }
        if (BigDecimalFactory.isNumber(piece)) {
            record.setPiece(Double.parseDouble(piece));
        }
        return record;
    }
    public RussianLogCalculateUserRecord toRussianLogCalculateUserRecord(BillUserRecordKey userRecordKey) {
        RussianLogCalculateUserRecord record =
                new RussianLogCalculateUserRecord();
        record.setUserid(userRecordKey.getUserid());
        record.setTime(userRecordKey.getTime());
        record.setLength(Double.parseDouble(getLength()));
        record.setWidth(Double.parseDouble(getDiameter()));
        record.setVolume(Double.parseDouble(getVolume()));
        record.setNum(Double.parseDouble(getNum()));
        String sum = getSum();
        String piece = getPiece();
        if (BigDecimalFactory.isNumber(sum)) {
            record.setSum(Double.parseDouble(sum));
        }
        if (BigDecimalFactory.isNumber(piece)) {
            record.setPiece(Double.parseDouble(piece));
        }
        return record;
    }
    public SoutheastAsiaLogCalculateUserRecord toSoutheastAsiaLogCalculateUserRecord(BillUserRecordKey userRecordKey) {
        SoutheastAsiaLogCalculateUserRecord record =
                new SoutheastAsiaLogCalculateUserRecord();
        record.setUserid(userRecordKey.getUserid());
        record.setTime(userRecordKey.getTime());
        record.setLength(Double.parseDouble(getLength()));
        record.setWidth(Double.parseDouble(getDiameter()));
        record.setVolume(Double.parseDouble(getVolume()));
        record.setNum(Double.parseDouble(getNum()));
        String sum = getSum();
        String piece = getPiece();
        if (BigDecimalFactory.isNumber(sum)) {
            record.setSum(Double.parseDouble(sum));
        }
        if (BigDecimalFactory.isNumber(piece)) {
            record.setPiece(Double.parseDouble(piece));
        }
        return record;
    }

}
