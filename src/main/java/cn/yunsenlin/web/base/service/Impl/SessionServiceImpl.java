package cn.yunsenlin.web.base.service.Impl;

import cn.yunsenlin.web.base.dao.SessionMapper;
import cn.yunsenlin.web.base.dto.SessionObject;
import cn.yunsenlin.web.base.model.Session;
import cn.yunsenlin.web.base.model.User;
import cn.yunsenlin.web.base.service.GsonService;
import cn.yunsenlin.web.base.service.SessionService;
import cn.yunsenlin.web.base.service.TokenService;

import java.util.Date;

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
            if (sessionObject==null){
                sessionObject= new SessionObject();
            }
            sessionObject.put(object, description);
            session.setSession(gsonService.toJson(sessionObject));
            Long tokenPeriod = session.getTokenPeriod();
            if (tokenPeriod<1800000){
                session.setTokenPeriod(1800000L);
                session.setTokenCreateTime(new Date());
            }
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
            Long tokenPeriod = session.getTokenPeriod();
            if (tokenPeriod<1800000){
                session.setTokenPeriod(1800000L);
                session.setTokenCreateTime(new Date());
                sessionMapper.updateByPrimaryKey(session);
            }
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
    public String createToken(int userId,Long tokenPeriod) {
        sessionMapper.deleteByPrimaryKey(userId);
        Session session = new Session();
        session.setUserId(userId);
        String token =tokenService.getUniqueTokenString();
        session.setToken(token);
        session.setTokenPeriod(tokenPeriod);
        sessionMapper.insert(session);
        return token;
    }
}
