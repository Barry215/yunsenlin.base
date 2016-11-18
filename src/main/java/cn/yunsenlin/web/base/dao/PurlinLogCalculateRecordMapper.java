package cn.yunsenlin.web.base.dao;

import cn.yunsenlin.web.base.model.PurlinLogCalculateRecord;

public interface PurlinLogCalculateRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PurlinLogCalculateRecord record);

    int insertSelective(PurlinLogCalculateRecord record);

    PurlinLogCalculateRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PurlinLogCalculateRecord record);

    int updateByPrimaryKey(PurlinLogCalculateRecord record);
}