package cn.yunsenlin.web.base.dto.calculate.android;

import cn.yunsenlin.web.base.model.City;

import java.util.ArrayList;
import java.util.List;

public class CityListReturn {
    private List<City> cityList = new ArrayList<>();

    public CityListReturn() {
    }

    public CityListReturn(List<City> cityList) {

        this.cityList = cityList;
    }

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }
}
