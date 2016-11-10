package cn.yunsenlin.web.base.dao;

import cn.yunsenlin.web.base.model.WoodType;

public interface WoodTypeMapper {
    int deleteByPrimaryKey(String typeCode);

    int insert(WoodType record);

    int insertSelective(WoodType record);

    WoodType selectByPrimaryKey(String typeCode);

    int updateByPrimaryKeySelective(WoodType record);

    int updateByPrimaryKey(WoodType record);
}