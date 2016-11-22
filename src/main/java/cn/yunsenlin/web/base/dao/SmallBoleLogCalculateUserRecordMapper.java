package cn.yunsenlin.web.base.dao;

import cn.yunsenlin.web.base.model.BillUserRecordKey;
import cn.yunsenlin.web.base.model.SmallBoleLogCalculateUserRecord;

import java.util.List;

public interface SmallBoleLogCalculateUserRecordMapper {
    int deleteByPrimaryKey(BillUserRecordKey key);

    int insert(SmallBoleLogCalculateUserRecord record);

    int insertSelective(SmallBoleLogCalculateUserRecord record);

    List<SmallBoleLogCalculateUserRecord> selectByPrimaryKey(BillUserRecordKey key);
}