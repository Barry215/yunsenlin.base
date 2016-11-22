package cn.yunsenlin.web.base.dao;

import cn.yunsenlin.web.base.model.BillUserRecordKey;
import cn.yunsenlin.web.base.model.BoleShanLogCalculateUserRecord;

import java.util.List;

public interface BoleShanLogCalculateUserRecordMapper {
    int deleteByPrimaryKey(BillUserRecordKey key);

    int insert(BoleShanLogCalculateUserRecord record);

    int insertSelective(BoleShanLogCalculateUserRecord record);

    List<BoleShanLogCalculateUserRecord> selectByPrimaryKey(BillUserRecordKey key);
}