package cn.yunsenlin.web.base.dao;

import cn.yunsenlin.web.base.model.BolePinusLogCalculateUserRecord;
import cn.yunsenlin.web.base.model.BolePinusLogCalculateUserRecordKey;

public interface BolePinusLogCalculateUserRecordMapper {
    int deleteByPrimaryKey(BolePinusLogCalculateUserRecordKey key);

    int insert(BolePinusLogCalculateUserRecord record);

    int insertSelective(BolePinusLogCalculateUserRecord record);

    BolePinusLogCalculateUserRecord selectByPrimaryKey(BolePinusLogCalculateUserRecordKey key);

    int updateByPrimaryKeySelective(BolePinusLogCalculateUserRecord record);

    int updateByPrimaryKey(BolePinusLogCalculateUserRecord record);
}