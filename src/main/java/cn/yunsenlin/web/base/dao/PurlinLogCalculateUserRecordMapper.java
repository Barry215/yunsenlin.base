package cn.yunsenlin.web.base.dao;

import cn.yunsenlin.web.base.model.BillUserRecordKey;
import cn.yunsenlin.web.base.model.PurlinLogCalculateUserRecord;

import java.util.List;

public interface PurlinLogCalculateUserRecordMapper {
    int deleteByPrimaryKey(BillUserRecordKey key);

    int insert(PurlinLogCalculateUserRecord record);

    int insertSelective(PurlinLogCalculateUserRecord record);

    List<PurlinLogCalculateUserRecord> selectByPrimaryKey(BillUserRecordKey key);
}