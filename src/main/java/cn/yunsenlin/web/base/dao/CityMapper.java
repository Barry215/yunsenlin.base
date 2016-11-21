package cn.yunsenlin.web.base.dao;

import cn.yunsenlin.web.base.model.City;

import java.util.List;

public interface CityMapper {
    int insert(City record);

    int insertSelective(City record);

    List<City> selectAll();
}