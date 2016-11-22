package cn.yunsenlin.web.base.model;

import cn.yunsenlin.web.base.dto.calculate.android.TimberReturn;

public class TimberCalculateUserRecord extends BillUserRecordKey {
    private Double length;

    private Double width;

    private Double height;

    private Double volume;

    private Double piece;

    private Double sum;

    private Integer num;

    private Integer stack;

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Double getPiece() {
        return piece;
    }

    public void setPiece(Double piece) {
        this.piece = piece;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getStack() {
        return stack;
    }

    public void setStack(Integer stack) {
        this.stack = stack;
    }

    public TimberReturn toTimberReturn(){
        TimberReturn t = new TimberReturn();
        t.setSum(sum.toString());
        t.setVolume(volume.toString());
        t.setHeight(height.toString());
        t.setPiece(piece.toString());
        t.setWidth(width.toString());
        t.setNum(num.toString());
        t.setStack(stack.toString());
        t.setPiece(piece.toString());
        return t;
    }
}