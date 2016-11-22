package cn.yunsenlin.web.base.dao;

import cn.yunsenlin.web.base.model.BillUserRecordKey;
import cn.yunsenlin.web.base.model.MineLogCalculateUserRecord;

import java.util.List;

public interface MineLogCalculateUserRecordMapper {
    int deleteByPrimaryKey(BillUserRecordKey key);

    int insert(MineLogCalculateUserRecord record);

    int insertSelective(MineLogCalculateUserRecord record);

    List<MineLogCalculateUserRecord> selectByPrimaryKey(BillUserRecordKey key);
}