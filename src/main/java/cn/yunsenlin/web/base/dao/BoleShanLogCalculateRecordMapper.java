package cn.yunsenlin.web.base.dao;

import cn.yunsenlin.web.base.model.BoleShanLogCalculateRecord;

public interface BoleShanLogCalculateRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BoleShanLogCalculateRecord record);

    int insertSelective(BoleShanLogCalculateRecord record);

    BoleShanLogCalculateRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BoleShanLogCalculateRecord record);

    int updateByPrimaryKey(BoleShanLogCalculateRecord record);
}