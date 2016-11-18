package cn.yunsenlin.web.base.dao;

import cn.yunsenlin.web.base.model.Log1984CalculateRecord;

public interface Log1984CalculateRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Log1984CalculateRecord record);

    int insertSelective(Log1984CalculateRecord record);

    Log1984CalculateRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Log1984CalculateRecord record);

    int updateByPrimaryKey(Log1984CalculateRecord record);
}