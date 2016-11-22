package cn.yunsenlin.web.base.dao;

import cn.yunsenlin.web.base.model.TimberCalculateRecord;

public interface TimberCalculateRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TimberCalculateRecord record);

    int insertSelective(TimberCalculateRecord record);

    TimberCalculateRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TimberCalculateRecord record);

    int updateByPrimaryKey(TimberCalculateRecord record);
}