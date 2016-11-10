package cn.yunsenlin.web.base.dao;

import cn.yunsenlin.web.base.model.Session;

public interface SessionMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(Session session);

    int insertSelective(Session session);

    Session selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(Session session);

    int updateByPrimaryKey(Session session);
}