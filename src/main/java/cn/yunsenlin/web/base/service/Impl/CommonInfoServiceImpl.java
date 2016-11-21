package cn.yunsenlin.web.base.service.Impl;

import cn.yunsenlin.web.base.dao.CityMapper;
import cn.yunsenlin.web.base.dao.LogTypeMapper;
import cn.yunsenlin.web.base.model.City;
import cn.yunsenlin.web.base.model.LogType;
import cn.yunsenlin.web.base.service.CommonInfoService;

import java.util.List;

public class CommonInfoServiceImpl implements CommonInfoService {
    private final CityMapper cityMapper;
    private final LogTypeMapper logTypeMapper;

    public CommonInfoServiceImpl(CityMapper cityMapper, LogTypeMapper logTypeMapper) {
        this.cityMapper = cityMapper;
        this.logTypeMapper = logTypeMapper;
    }

    @Override
    public List<City> getCityList() {
        return cityMapper.selectAll();
    }

    @Override
    public List<LogType> getX() {
        return logTypeMapper.getX();
    }

    @Override
    public List<LogType> getG() {
        return logTypeMapper.getG();
    }
}
