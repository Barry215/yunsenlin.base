package cn.yunsenlin.web.base.dao;

import cn.yunsenlin.web.base.model.SoutheastAsiaLogCalculateRecord;

public interface SoutheastAsiaLogCalculateRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SoutheastAsiaLogCalculateRecord record);

    int insertSelective(SoutheastAsiaLogCalculateRecord record);

    SoutheastAsiaLogCalculateRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SoutheastAsiaLogCalculateRecord record);

    int updateByPrimaryKey(SoutheastAsiaLogCalculateRecord record);
}