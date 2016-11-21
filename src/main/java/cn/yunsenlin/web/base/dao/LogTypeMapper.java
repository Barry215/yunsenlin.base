package cn.yunsenlin.web.base.dao;

import cn.yunsenlin.web.base.model.LogType;

import java.util.List;

public interface LogTypeMapper {
    int deleteByPrimaryKey(String logCode);

    int insert(LogType record);

    int insertSelective(LogType record);

    LogType selectByPrimaryKey(String logCode);

    int updateByPrimaryKeySelective(LogType record);

    int updateByPrimaryKey(LogType record);

    List<LogType> getX();

    List<LogType> getG();
}