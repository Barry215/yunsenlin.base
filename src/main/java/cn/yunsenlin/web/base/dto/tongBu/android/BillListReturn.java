package cn.yunsenlin.web.base.dto.tongBu.android;

import cn.yunsenlin.web.base.dto.calculate.android.CalculateMoreReturn;

import java.util.ArrayList;
import java.util.List;

public class BillListReturn {
    private List<CalculateMoreReturn> billList
            = new ArrayList<>();

    public List<CalculateMoreReturn> getBillList() {
        return billList;
    }

    public BillListReturn() {
    }

    public BillListReturn(List<CalculateMoreReturn> billList) {

        this.billList = billList;
    }

    public void setBillList(List<CalculateMoreReturn> billList) {
        this.billList = billList;
    }
}
