package cn.yunsenlin.web.base.dao;

import cn.yunsenlin.web.base.model.MineLogCalculateUserRecord;
import cn.yunsenlin.web.base.model.MineLogCalculateUserRecordKey;

public interface MineLogCalculateUserRecordMapper {
    int deleteByPrimaryKey(MineLogCalculateUserRecordKey key);

    int insert(MineLogCalculateUserRecord record);

    int insertSelective(MineLogCalculateUserRecord record);

    MineLogCalculateUserRecord selectByPrimaryKey(MineLogCalculateUserRecordKey key);

    int updateByPrimaryKeySelective(MineLogCalculateUserRecord record);

    int updateByPrimaryKey(MineLogCalculateUserRecord record);
}