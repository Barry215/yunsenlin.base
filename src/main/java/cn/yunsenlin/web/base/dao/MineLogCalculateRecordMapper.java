package cn.yunsenlin.web.base.dao;

import cn.yunsenlin.web.base.model.MineLogCalculateRecord;

public interface MineLogCalculateRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MineLogCalculateRecord record);

    int insertSelective(MineLogCalculateRecord record);

    MineLogCalculateRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MineLogCalculateRecord record);

    int updateByPrimaryKey(MineLogCalculateRecord record);
}