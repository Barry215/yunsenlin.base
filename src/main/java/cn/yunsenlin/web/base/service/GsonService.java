package cn.yunsenlin.web.base.service;

import java.lang.reflect.Type;

public interface GsonService {
    String toJson(Object object);
    Object toObject(String jsonString,Type type);
    Object toObject(String jsonString,Class type);
}
