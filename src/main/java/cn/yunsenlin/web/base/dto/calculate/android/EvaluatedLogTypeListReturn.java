package cn.yunsenlin.web.base.dto.calculate.android;

import java.util.ArrayList;
import java.util.List;

public class EvaluatedLogTypeListReturn {
    private List<EvaluatedLogType> logList = new ArrayList<>();

    public List<EvaluatedLogType> getLogList() {
        return logList;
    }

    public void setLogList(List<EvaluatedLogType> logList) {
        this.logList = logList;
    }
}
