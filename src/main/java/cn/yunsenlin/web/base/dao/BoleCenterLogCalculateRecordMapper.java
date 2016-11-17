package cn.yunsenlin.web.base.dao;

import cn.yunsenlin.web.base.model.BoleCenterLogCalculateRecord;

public interface BoleCenterLogCalculateRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BoleCenterLogCalculateRecord record);

    int insertSelective(BoleCenterLogCalculateRecord record);

    BoleCenterLogCalculateRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BoleCenterLogCalculateRecord record);

    int updateByPrimaryKey(BoleCenterLogCalculateRecord record);
}