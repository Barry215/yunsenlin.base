package cn.yunsenlin.web.base.dao;

import cn.yunsenlin.web.base.model.SmallBoleLogCalculateUserRecord;
import cn.yunsenlin.web.base.model.SmallBoleLogCalculateUserRecordKey;

public interface SmallBoleLogCalculateUserRecordMapper {
    int deleteByPrimaryKey(SmallBoleLogCalculateUserRecordKey key);

    int insert(SmallBoleLogCalculateUserRecord record);

    int insertSelective(SmallBoleLogCalculateUserRecord record);

    SmallBoleLogCalculateUserRecord selectByPrimaryKey(SmallBoleLogCalculateUserRecordKey key);

    int updateByPrimaryKeySelective(SmallBoleLogCalculateUserRecord record);

    int updateByPrimaryKey(SmallBoleLogCalculateUserRecord record);
}