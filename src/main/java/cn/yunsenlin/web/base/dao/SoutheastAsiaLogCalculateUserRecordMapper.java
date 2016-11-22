package cn.yunsenlin.web.base.dao;

import cn.yunsenlin.web.base.model.BillUserRecordKey;
import cn.yunsenlin.web.base.model.SoutheastAsiaLogCalculateUserRecord;

import java.util.List;

public interface SoutheastAsiaLogCalculateUserRecordMapper {
    int deleteByPrimaryKey(BillUserRecordKey key);

    int insert(SoutheastAsiaLogCalculateUserRecord record);

    int insertSelective(SoutheastAsiaLogCalculateUserRecord record);

    List<SoutheastAsiaLogCalculateUserRecord> selectByPrimaryKey(BillUserRecordKey key);
}