package cn.yunsenlin.web.base.dao;

import cn.yunsenlin.web.base.model.AmericanLogCalculateRecord;

public interface AmericanLogCalculateRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericanLogCalculateRecord record);

    int insertSelective(AmericanLogCalculateRecord record);

    AmericanLogCalculateRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericanLogCalculateRecord record);

    int updateByPrimaryKey(AmericanLogCalculateRecord record);
}