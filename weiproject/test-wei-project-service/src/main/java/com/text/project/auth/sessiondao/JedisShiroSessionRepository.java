package com.text.project.auth.sessiondao;

import java.io.Serializable;
import java.util.Collection;

import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.test.common.redis.wrapper.JedisManager;
import com.test.common.utils.SerializeUtil;

public class JedisShiroSessionRepository implements IShiroSessionRepository {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(JedisShiroSessionRepository.class);

	private static final String REDIS_SHIRO_SESSION = "shiro-session:";
	private static final int SESSION_VAL_TIME_SPAN = 18000;
	private static final int DB_INDEX = 0;
	private JedisManager jedisManager;

	@Override
	public void saveSession(Session session) {
		if (session == null || session.getId() == null)
			throw new NullPointerException("session is empty");
		try {
			byte[] key = SerializeUtil.serialize(buildRedisSessionKey(session
					.getId()));
			byte[] value = SerializeUtil.serialize(session);
			long sessionTimeOut = session.getTimeout() / 1000;
			Long expireTime = sessionTimeOut + SESSION_VAL_TIME_SPAN + (5 * 60);
			getJedisManager().saveValueByKey(DB_INDEX, key, value,
					expireTime.intValue());
		} catch (Exception e) {
			LOGGER.debug("save session error", e);
		}
	}

	@Override
	public void deleteSession(Serializable id) {
		if (id == null) {
			throw new NullPointerException("session id is empty");
		}
		try {
			getJedisManager().deleteByKey(DB_INDEX,
					SerializeUtil.serialize(buildRedisSessionKey(id)));
		} catch (Exception e) {
			LOGGER.debug("delete session error", e);
		}
	}

	@Override
	public Session getSession(Serializable id) {
		if (id == null)
			throw new NullPointerException("session id is empty");
		Session session = null;
		try {
			byte[] value = getJedisManager().getValueByKey(DB_INDEX,
					SerializeUtil.serialize(buildRedisSessionKey(id)));
			session = SerializeUtil.deserialize(value, Session.class);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("get session error");
		}
		return session;
	}

	@Override
	public Collection<Session> getAllSessions() {
		// TODO
		getJedisManager().getAllValue(DB_INDEX);
		System.out.println("get all sessions");
		return null;
	}

	//
	private String buildRedisSessionKey(Serializable sessionId) {
		return REDIS_SHIRO_SESSION + sessionId;
	}

	public JedisManager getJedisManager() {
		return jedisManager;
	}

	public void setJedisManager(JedisManager jedisManager) {
		this.jedisManager = jedisManager;
	}
}