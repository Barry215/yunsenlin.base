package cn.yunsenlin.web.base.dao;

import cn.yunsenlin.web.base.model.WeightUserRecord;
import cn.yunsenlin.web.base.model.WeightUserRecordKey;

public interface WeightUserRecordMapper {
    int deleteByPrimaryKey(WeightUserRecordKey key);

    int insert(WeightUserRecord record);

    int insertSelective(WeightUserRecord record);

    WeightUserRecord selectByPrimaryKey(WeightUserRecordKey key);

    int updateByPrimaryKeySelective(WeightUserRecord record);

    int updateByPrimaryKey(WeightUserRecord record);
}