package cn.yunsenlin.web.base.dao;

import cn.yunsenlin.web.base.model.SmallBoleLogCalculateRecord;

public interface SmallBoleLogCalculateRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SmallBoleLogCalculateRecord record);

    int insertSelective(SmallBoleLogCalculateRecord record);

    SmallBoleLogCalculateRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SmallBoleLogCalculateRecord record);

    int updateByPrimaryKey(SmallBoleLogCalculateRecord record);
}