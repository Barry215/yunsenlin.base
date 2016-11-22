package cn.yunsenlin.web.base.dao;

import cn.yunsenlin.web.base.model.BillUserRecordKey;
import cn.yunsenlin.web.base.model.TimberCalculateUserRecord;

import java.util.List;

public interface TimberCalculateUserRecordMapper {
    int deleteByPrimaryKey(BillUserRecordKey key);

    int insert(TimberCalculateUserRecord record);

    int insertSelective(TimberCalculateUserRecord record);

    List<TimberCalculateUserRecord> selectByPrimaryKey(BillUserRecordKey key);
}