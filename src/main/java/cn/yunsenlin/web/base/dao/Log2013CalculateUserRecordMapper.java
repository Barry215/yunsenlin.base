package cn.yunsenlin.web.base.dao;

import cn.yunsenlin.web.base.model.BillUserRecordKey;
import cn.yunsenlin.web.base.model.Log2013CalculateUserRecord;

import java.util.List;

public interface Log2013CalculateUserRecordMapper {
    int deleteByPrimaryKey(BillUserRecordKey key);

    int insert(Log2013CalculateUserRecord record);

    int insertSelective(Log2013CalculateUserRecord record);

    List<Log2013CalculateUserRecord> selectByPrimaryKey(BillUserRecordKey key);
}