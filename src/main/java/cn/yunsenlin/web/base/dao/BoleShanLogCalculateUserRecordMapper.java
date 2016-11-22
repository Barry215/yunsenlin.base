package cn.yunsenlin.web.base.dao;

import cn.yunsenlin.web.base.model.BoleShanLogCalculateUserRecord;
import cn.yunsenlin.web.base.model.BoleShanLogCalculateUserRecordKey;

public interface BoleShanLogCalculateUserRecordMapper {
    int deleteByPrimaryKey(BoleShanLogCalculateUserRecordKey key);

    int insert(BoleShanLogCalculateUserRecord record);

    int insertSelective(BoleShanLogCalculateUserRecord record);

    BoleShanLogCalculateUserRecord selectByPrimaryKey(BoleShanLogCalculateUserRecordKey key);

    int updateByPrimaryKeySelective(BoleShanLogCalculateUserRecord record);

    int updateByPrimaryKey(BoleShanLogCalculateUserRecord record);
}