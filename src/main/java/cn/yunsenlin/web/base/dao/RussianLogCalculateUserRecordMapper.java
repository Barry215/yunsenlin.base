package cn.yunsenlin.web.base.dao;

import cn.yunsenlin.web.base.model.BillUserRecordKey;
import cn.yunsenlin.web.base.model.RussianLogCalculateUserRecord;

import java.util.List;

public interface RussianLogCalculateUserRecordMapper {
    int deleteByPrimaryKey(BillUserRecordKey key);

    int insert(RussianLogCalculateUserRecord record);

    int insertSelective(RussianLogCalculateUserRecord record);

    List<RussianLogCalculateUserRecord> selectByPrimaryKey(BillUserRecordKey key);
}