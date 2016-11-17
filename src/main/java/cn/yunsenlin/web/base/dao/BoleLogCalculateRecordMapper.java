package cn.yunsenlin.web.base.dao;

import cn.yunsenlin.web.base.model.BoleLogCalculateRecord;

public interface BoleLogCalculateRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BoleLogCalculateRecord record);

    int insertSelective(BoleLogCalculateRecord record);

    BoleLogCalculateRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BoleLogCalculateRecord record);

    int updateByPrimaryKey(BoleLogCalculateRecord record);
}