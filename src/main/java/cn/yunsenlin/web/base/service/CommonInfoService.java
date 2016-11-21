package cn.yunsenlin.web.base.service;


import cn.yunsenlin.web.base.model.City;
import cn.yunsenlin.web.base.model.LogType;

import java.util.List;

public interface CommonInfoService {
    List<City> getCityList();
    List<LogType> getX();
    List<LogType> getG();
}
