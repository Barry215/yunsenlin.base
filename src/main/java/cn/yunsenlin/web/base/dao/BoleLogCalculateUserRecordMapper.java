package cn.yunsenlin.web.base.dao;

import cn.yunsenlin.web.base.model.BoleLogCalculateUserRecord;
import cn.yunsenlin.web.base.model.BoleLogCalculateUserRecordKey;

public interface BoleLogCalculateUserRecordMapper {
    int deleteByPrimaryKey(BoleLogCalculateUserRecordKey key);

    int insert(BoleLogCalculateUserRecord record);

    int insertSelective(BoleLogCalculateUserRecord record);

    BoleLogCalculateUserRecord selectByPrimaryKey(BoleLogCalculateUserRecordKey key);

    int updateByPrimaryKeySelective(BoleLogCalculateUserRecord record);

    int updateByPrimaryKey(BoleLogCalculateUserRecord record);
}