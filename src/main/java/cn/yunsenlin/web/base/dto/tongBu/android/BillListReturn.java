package cn.yunsenlin.web.base.dto.tongBu.android;

import cn.yunsenlin.web.base.dto.calculate.android.CalculateMore;

import java.util.ArrayList;
import java.util.List;

public class BillListReturn {
    private List<CalculateMore> billList
            = new ArrayList<>();

    public List<CalculateMore> getBillList() {
        return billList;
    }

    public void setBillList(List<CalculateMore> billList) {
        this.billList = billList;
    }
}
