package cn.yunsenlin.web.base.dao;

import cn.yunsenlin.web.base.model.BillUserRecordKey;
import cn.yunsenlin.web.base.model.BolePinusLogCalculateUserRecord;

import java.util.List;

public interface BolePinusLogCalculateUserRecordMapper {
    int deleteByPrimaryKey(BillUserRecordKey key);

    int insert(BolePinusLogCalculateUserRecord record);

    int insertSelective(BolePinusLogCalculateUserRecord record);

    List<BolePinusLogCalculateUserRecord> selectByPrimaryKey(BillUserRecordKey key);
}