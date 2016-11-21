package cn.yunsenlin.web.base.dto.calculate.android;

import java.util.ArrayList;
import java.util.List;

public class CityListReturn {
    private List<City> cityList = new ArrayList<>();
    public void add(City city){
        cityList.add(city);
    }

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }
}
