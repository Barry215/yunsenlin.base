package cn.yunsenlin.web.base.dao;

import cn.yunsenlin.web.base.model.BillUserRecordKey;
import cn.yunsenlin.web.base.model.WeightUserRecord;

import java.util.List;

public interface WeightUserRecordMapper {
    int deleteByPrimaryKey(BillUserRecordKey key);

    int insert(WeightUserRecord record);

    int insertSelective(WeightUserRecord record);

    List<WeightUserRecord> selectByPrimaryKey(BillUserRecordKey key);
}