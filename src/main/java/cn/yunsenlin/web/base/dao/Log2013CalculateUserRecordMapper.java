package cn.yunsenlin.web.base.dao;

import cn.yunsenlin.web.base.model.Log2013CalculateUserRecord;
import cn.yunsenlin.web.base.model.Log2013CalculateUserRecordKey;

public interface Log2013CalculateUserRecordMapper {
    int deleteByPrimaryKey(Log2013CalculateUserRecordKey key);

    int insert(Log2013CalculateUserRecord record);

    int insertSelective(Log2013CalculateUserRecord record);

    Log2013CalculateUserRecord selectByPrimaryKey(Log2013CalculateUserRecordKey key);

    int updateByPrimaryKeySelective(Log2013CalculateUserRecord record);

    int updateByPrimaryKey(Log2013CalculateUserRecord record);
}