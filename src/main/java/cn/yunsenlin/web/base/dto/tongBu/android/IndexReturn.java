package cn.yunsenlin.web.base.dto.tongBu.android;

import java.util.ArrayList;
import java.util.List;

public class IndexReturn {
    private List<TimeIndex> indexList = new ArrayList<>();

    public List<TimeIndex> getIndexList() {
        return indexList;
    }

    public void setIndexList(List<TimeIndex> indexList) {
        this.indexList = indexList;
    }
}
