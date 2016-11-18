package cn.yunsenlin.web.base.dao;

import cn.yunsenlin.web.base.model.Log2013CalculateRecord;

public interface Log2013CalculateRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Log2013CalculateRecord record);

    int insertSelective(Log2013CalculateRecord record);

    Log2013CalculateRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Log2013CalculateRecord record);

    int updateByPrimaryKey(Log2013CalculateRecord record);
}