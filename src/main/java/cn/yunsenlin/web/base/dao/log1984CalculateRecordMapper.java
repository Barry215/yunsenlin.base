package cn.yunsenlin.web.base.dao;

import cn.yunsenlin.web.base.model.log1984CalculateRecord;

public interface log1984CalculateRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(log1984CalculateRecord record);

    int insertSelective(log1984CalculateRecord record);

    log1984CalculateRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(log1984CalculateRecord record);

    int updateByPrimaryKey(log1984CalculateRecord record);
}