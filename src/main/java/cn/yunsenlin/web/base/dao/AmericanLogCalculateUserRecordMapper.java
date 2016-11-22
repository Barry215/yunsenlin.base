package cn.yunsenlin.web.base.dao;

import cn.yunsenlin.web.base.model.AmericanLogCalculateUserRecord;
import cn.yunsenlin.web.base.model.AmericanLogCalculateUserRecordKey;

public interface AmericanLogCalculateUserRecordMapper {
    int deleteByPrimaryKey(AmericanLogCalculateUserRecordKey key);

    int insert(AmericanLogCalculateUserRecord record);

    int insertSelective(AmericanLogCalculateUserRecord record);

    AmericanLogCalculateUserRecord selectByPrimaryKey(AmericanLogCalculateUserRecordKey key);

    int updateByPrimaryKeySelective(AmericanLogCalculateUserRecord record);

    int updateByPrimaryKey(AmericanLogCalculateUserRecord record);
}