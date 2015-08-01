package com.text.project.auth.sessiondao;

import java.io.Serializable;
import java.util.Collection;

import org.apache.shiro.session.Session;

public interface IShiroSessionRepository {
	void saveSession(Session session);

	void deleteSession(Serializable sessionId);

	Session getSession(Serializable sessionId);

	Collection<Session> getAllSessions();
}
