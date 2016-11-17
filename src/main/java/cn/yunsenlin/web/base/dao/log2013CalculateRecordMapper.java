package cn.yunsenlin.web.base.dao;

import cn.yunsenlin.web.base.model.log2013CalculateRecord;

public interface log2013CalculateRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(log2013CalculateRecord record);

    int insertSelective(log2013CalculateRecord record);

    log2013CalculateRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(log2013CalculateRecord record);

    int updateByPrimaryKey(log2013CalculateRecord record);
}