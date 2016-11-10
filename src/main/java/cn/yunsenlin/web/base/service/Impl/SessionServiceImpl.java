package cn.yunsenlin.web.base.service.Impl;

import cn.yunsenlin.web.base.dao.SessionMapper;
import cn.yunsenlin.web.base.dto.SessionObject;
import cn.yunsenlin.web.base.model.Session;
import cn.yunsenlin.web.base.model.User;
import cn.yunsenlin.web.base.service.GsonService;
import cn.yunsenlin.web.base.service.SessionService;
import cn.yunsenlin.web.base.service.TokenService;

public class SessionServiceImpl implements SessionService {
    private final SessionMapper sessionMapper;
    private final GsonService gsonService;
    private final TokenService tokenService;

    public SessionServiceImpl(SessionMapper sessionMapper, GsonService gsonService, TokenService tokenService) {
        this.sessionMapper = sessionMapper;
        this.gsonService = gsonService;
        this.tokenService = tokenService;
    }

    @Override
    public void insert(String token, User user, Object object, String description) {
        Session session =
                sessionMapper.selectByPrimaryKey(user.getUserId());
        if (session != null && session.getToken().equals(token)) {
            SessionObject sessionObject =
                    (SessionObject) gsonService.toObject(session.getSession(), SessionObject.class);
            sessionObject.put(object, description);
            session.setSession(gsonService.toJson(sessionObject));
            sessionMapper.updateByPrimaryKey(session);
        }
    }

    @Override
    public Object get(String token, User user, String description) {
        Session session =
                sessionMapper.selectByPrimaryKey(user.getUserId());
        if (session != null && session.getToken().equals(token)) {
            SessionObject sessionObject
                    = (SessionObject) gsonService.toObject(session.getSession(),SessionObject.class);
            return sessionObject.get(description);
        }
        return null;
    }

    @Override
    public boolean checkToken(String token, int userId) {
        Session session =
                sessionMapper.selectByPrimaryKey(userId);
        return session != null && session.getToken().equals(token);
    }

    @Override
    public String createToken(int userId) {
        sessionMapper.deleteByPrimaryKey(userId);
        Session session = new Session();
        session.setUserId(userId);
        String token =tokenService.getUniqueTokenString();
        session.setToken(token);
        sessionMapper.insert(session);
        return null;
    }
}
