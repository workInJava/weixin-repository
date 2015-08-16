package com.text.project.auth.sessiondao;

import java.io.Serializable;
import java.util.Collection;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomShiroSessionDAO extends AbstractSessionDAO {
	private static Logger LOGGER = LoggerFactory.getLogger(CustomShiroSessionDAO.class);
	
    private IShiroSessionRepository shiroSessionRepository;
    @Override
    public void update(Session session) throws UnknownSessionException {
        LOGGER.info("update session");
        getShiroSessionRepository().saveSession(session);
    }
    @Override
    public void delete(Session session) {
    	LOGGER.info("===========================delete session1=======================");
        if (session == null) {
            return;
        }
        Serializable id = session.getId();
        if (id != null) {
        	LOGGER.info("===========================delete session2=======================");
            getShiroSessionRepository().deleteSession(id);
        }
        //TODO if session is too large,when session destory clear shiro cache
    }
    @Override
    public Collection<Session> getActiveSessions() {
        LOGGER.info("get active sessions");
        return getShiroSessionRepository().getAllSessions();
    }
    @Override
    protected Serializable doCreate(Session session) {
    	LOGGER.info("===========================do create session=======================");
        Serializable sessionId = this.generateSessionId(session);
        this.assignSessionId(session, sessionId);
        getShiroSessionRepository().saveSession(session);
        return sessionId;
    }
    @Override
    protected Session doReadSession(Serializable sessionId) {
        LOGGER.info("==============================do read session======================");
        return getShiroSessionRepository().getSession(sessionId);
    }
    public IShiroSessionRepository getShiroSessionRepository() {
        return shiroSessionRepository;
    }
    public void setShiroSessionRepository(
            IShiroSessionRepository shiroSessionRepository) {
        this.shiroSessionRepository = shiroSessionRepository;
    }
}