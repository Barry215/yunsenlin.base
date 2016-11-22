package cn.yunsenlin.web.base.dao;

import cn.yunsenlin.web.base.model.BillUserRecord;
import cn.yunsenlin.web.base.model.BillUserRecordKey;

public interface BillUserRecordMapper {
    int deleteByPrimaryKey(BillUserRecordKey key);

    int insert(BillUserRecord record);

    int insertSelective(BillUserRecord record);

    BillUserRecord selectByPrimaryKey(BillUserRecordKey key);

    int updateByPrimaryKeySelective(BillUserRecord record);

    int updateByPrimaryKey(BillUserRecord record);
}