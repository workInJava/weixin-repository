package com.text.project.auth.sessiondao;

import java.io.Serializable;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RedisSessionDAO extends CachingSessionDAO{
	
	private static Logger LOGGER = LoggerFactory.getLogger(RedisSessionDAO.class);

	private IShiroSessionRepository shiroSessionRepository;
	@Override
	protected void doUpdate(Session session) {
		LOGGER.info("update session");
        getShiroSessionRepository().saveSession(session);
	}

	@Override
	protected void doDelete(Session session) {
		if (session == null) {
            return;
        }
        Serializable id = session.getId();
        if (id != null) {
            LOGGER.info("delete session");
            getShiroSessionRepository().deleteSession(id);
        }
	}

	@Override
	protected Serializable doCreate(Session session) {
		LOGGER.info("do create session");
        Serializable sessionId = this.generateSessionId(session);
        this.assignSessionId(session, sessionId);
        getShiroSessionRepository().saveSession(session);
        return sessionId;
	}

	@Override
	protected Session doReadSession(Serializable sessionId) {
		 LOGGER.info("do read session");
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