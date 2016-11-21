package cn.yunsenlin.web.base.dao;

import cn.yunsenlin.web.base.model.RussianLogCalculateRecord;

public interface RussianLogCalculateRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RussianLogCalculateRecord record);

    int insertSelective(RussianLogCalculateRecord record);

    RussianLogCalculateRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RussianLogCalculateRecord record);

    int updateByPrimaryKey(RussianLogCalculateRecord record);
}