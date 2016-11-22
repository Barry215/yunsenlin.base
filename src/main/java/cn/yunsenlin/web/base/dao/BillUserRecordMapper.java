package cn.yunsenlin.web.base.dao;

import cn.yunsenlin.web.base.dto.tongBu.android.TimeIndex;
import cn.yunsenlin.web.base.model.BillUserRecord;
import cn.yunsenlin.web.base.model.BillUserRecordKey;

import java.util.List;

public interface BillUserRecordMapper {
    int deleteByPrimaryKey(BillUserRecordKey key);

    int insert(BillUserRecord record);

    int insertSelective(BillUserRecord record);

    BillUserRecord selectByPrimaryKey(BillUserRecordKey key);

    int updateByPrimaryKeySelective(BillUserRecord record);

    int updateByPrimaryKey(BillUserRecord record);

    List<TimeIndex> getTimeIndex(Integer userId);
}