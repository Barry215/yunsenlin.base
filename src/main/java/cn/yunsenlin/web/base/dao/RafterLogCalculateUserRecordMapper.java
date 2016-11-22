package cn.yunsenlin.web.base.dao;

import cn.yunsenlin.web.base.model.BillUserRecordKey;
import cn.yunsenlin.web.base.model.RafterLogCalculateUserRecord;

import java.util.List;

public interface RafterLogCalculateUserRecordMapper {
    int deleteByPrimaryKey(BillUserRecordKey key);

    int insert(RafterLogCalculateUserRecord record);

    int insertSelective(RafterLogCalculateUserRecord record);

    List<RafterLogCalculateUserRecord> selectByPrimaryKey(BillUserRecordKey key);
}