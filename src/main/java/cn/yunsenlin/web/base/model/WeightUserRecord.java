package cn.yunsenlin.web.base.model;

import cn.yunsenlin.web.base.dto.calculate.android.WeightReturn;

public class WeightUserRecord extends BillUserRecordKey {
    private Double lorry;

    private Double total;

    private Double weight;

    private Double piece;

    private Double sum;

    public Double getLorry() {
        return lorry;
    }

    public void setLorry(Double lorry) {
        this.lorry = lorry;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
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

    public WeightReturn toWeightReturn(){
        WeightReturn weightReturn = new WeightReturn();
        weightReturn.setSum(sum.toString());
        weightReturn.setPiece(piece.toString());
        weightReturn.setWeight(weight.toString());
        weightReturn.setLorry(lorry.toString());
        weightReturn.setTotal(total.toString());
        return weightReturn;
    }
}