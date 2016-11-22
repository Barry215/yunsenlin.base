package cn.yunsenlin.web.base.dao;

import cn.yunsenlin.web.base.model.BillUserRecordKey;
import cn.yunsenlin.web.base.model.Log1984CalculateUserRecord;

import java.util.List;

public interface Log1984CalculateUserRecordMapper {
    int deleteByPrimaryKey(BillUserRecordKey key);

    int insert(Log1984CalculateUserRecord record);

    int insertSelective(Log1984CalculateUserRecord record);

    List<Log1984CalculateUserRecord> selectByPrimaryKey(BillUserRecordKey key);
}