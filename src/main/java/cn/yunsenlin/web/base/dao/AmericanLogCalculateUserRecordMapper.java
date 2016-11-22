package cn.yunsenlin.web.base.dao;

import cn.yunsenlin.web.base.model.AmericanLogCalculateUserRecord;
import cn.yunsenlin.web.base.model.BillUserRecordKey;

import java.util.List;

public interface AmericanLogCalculateUserRecordMapper {
    int deleteByPrimaryKey(BillUserRecordKey key);

    int insert(AmericanLogCalculateUserRecord record);

    int insertSelective(AmericanLogCalculateUserRecord record);

    List<AmericanLogCalculateUserRecord> selectByPrimaryKey(BillUserRecordKey key);
}