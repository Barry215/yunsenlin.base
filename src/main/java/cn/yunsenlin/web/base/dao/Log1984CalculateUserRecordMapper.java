package cn.yunsenlin.web.base.dao;

import cn.yunsenlin.web.base.model.Log1984CalculateUserRecord;
import cn.yunsenlin.web.base.model.Log1984CalculateUserRecordKey;

public interface Log1984CalculateUserRecordMapper {
    int deleteByPrimaryKey(Log1984CalculateUserRecordKey key);

    int insert(Log1984CalculateUserRecord record);

    int insertSelective(Log1984CalculateUserRecord record);

    Log1984CalculateUserRecord selectByPrimaryKey(Log1984CalculateUserRecordKey key);

    int updateByPrimaryKeySelective(Log1984CalculateUserRecord record);

    int updateByPrimaryKey(Log1984CalculateUserRecord record);
}