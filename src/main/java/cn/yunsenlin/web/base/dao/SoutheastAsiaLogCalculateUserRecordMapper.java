package cn.yunsenlin.web.base.dao;

import cn.yunsenlin.web.base.model.SoutheastAsiaLogCalculateUserRecord;
import cn.yunsenlin.web.base.model.SoutheastAsiaLogCalculateUserRecordKey;

public interface SoutheastAsiaLogCalculateUserRecordMapper {
    int deleteByPrimaryKey(SoutheastAsiaLogCalculateUserRecordKey key);

    int insert(SoutheastAsiaLogCalculateUserRecord record);

    int insertSelective(SoutheastAsiaLogCalculateUserRecord record);

    SoutheastAsiaLogCalculateUserRecord selectByPrimaryKey(SoutheastAsiaLogCalculateUserRecordKey key);

    int updateByPrimaryKeySelective(SoutheastAsiaLogCalculateUserRecord record);

    int updateByPrimaryKey(SoutheastAsiaLogCalculateUserRecord record);
}