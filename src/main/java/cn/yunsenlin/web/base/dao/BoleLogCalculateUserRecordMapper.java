package cn.yunsenlin.web.base.dao;

import cn.yunsenlin.web.base.model.BillUserRecordKey;
import cn.yunsenlin.web.base.model.BoleLogCalculateUserRecord;

import java.util.List;

public interface BoleLogCalculateUserRecordMapper {
    int deleteByPrimaryKey(BillUserRecordKey key);

    int insert(BoleLogCalculateUserRecord record);

    int insertSelective(BoleLogCalculateUserRecord record);

    List<BoleLogCalculateUserRecord> selectByPrimaryKey(BillUserRecordKey key);
}