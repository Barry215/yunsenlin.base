package cn.yunsenlin.web.base.service.Impl;

import cn.yunsenlin.web.base.service.GsonService;
import com.google.gson.Gson;

import java.lang.reflect.Type;

public class GsonServiceImpl implements GsonService {
    private Gson gson = new Gson();


    @Override
    public String toJson(Object object) {
        return gson.toJson(object);
    }

    @Override
    public Object toObject(String jsonString, Type type) {
        return gson.fromJson(jsonString,type);
    }

    @Override
    public Object toObject(String jsonString, Class type) {
        return gson.fromJson(jsonString,type);
    }
}
