package cn.yunsenlin.web.base.dto;


import java.util.HashMap;
import java.util.Map;

public class SessionObject {
    private Map<String,Object> map
            = new HashMap<>();
    public void put(Object object,String description){
        map.put(description,object);
    }
    public Object get(String description){
        return map.get(description);
    }
}
