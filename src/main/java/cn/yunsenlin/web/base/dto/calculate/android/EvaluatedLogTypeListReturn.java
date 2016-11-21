package cn.yunsenlin.web.base.dto.calculate.android;

import cn.yunsenlin.web.base.model.LogType;

import java.util.ArrayList;
import java.util.List;

public class EvaluatedLogTypeListReturn {
    private List<LogType> logList = new ArrayList<>();

    public List<LogType> getLogList() {
        return logList;
    }

    public void setLogList(List<LogType> logList) {
        this.logList = logList;
    }

    public EvaluatedLogTypeListReturn(List<LogType> logList) {
        this.logList = logList;
    }

    public EvaluatedLogTypeListReturn() {

    }
}
