package cn.yunsenlin.web.base.dao;

import cn.yunsenlin.web.base.model.BolePinusLogCalculateRecord;

public interface BolePinusLogCalculateRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BolePinusLogCalculateRecord record);

    int insertSelective(BolePinusLogCalculateRecord record);

    BolePinusLogCalculateRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BolePinusLogCalculateRecord record);

    int updateByPrimaryKey(BolePinusLogCalculateRecord record);
}