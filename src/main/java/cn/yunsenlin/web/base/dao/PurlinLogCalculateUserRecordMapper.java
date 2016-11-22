package cn.yunsenlin.web.base.dao;

import cn.yunsenlin.web.base.model.PurlinLogCalculateUserRecord;
import cn.yunsenlin.web.base.model.PurlinLogCalculateUserRecordKey;

public interface PurlinLogCalculateUserRecordMapper {
    int deleteByPrimaryKey(PurlinLogCalculateUserRecordKey key);

    int insert(PurlinLogCalculateUserRecord record);

    int insertSelective(PurlinLogCalculateUserRecord record);

    PurlinLogCalculateUserRecord selectByPrimaryKey(PurlinLogCalculateUserRecordKey key);

    int updateByPrimaryKeySelective(PurlinLogCalculateUserRecord record);

    int updateByPrimaryKey(PurlinLogCalculateUserRecord record);
}