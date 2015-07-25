package com.text.project.auth.sessiondao;

import java.io.Serializable;

import javax.annotation.Resource;

import org.apache.shiro.authc.Account;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.SerializationUtils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisException;

import com.test.common.redis.wrapper.JedisPoolManager;

public class RedisSessionDAO extends CachingSessionDAO{
	
	private static Logger logger = LoggerFactory.getLogger(RedisSessionDAO.class);
	@Resource
	private JedisPoolManager redisManager;
	
	@Override
	protected void doUpdate(Session session) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void doDelete(Session session) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Serializable doCreate(Session session) {
		Serializable sessionId = this.generateSessionId(session);
		this.assignSessionId(session, sessionId);
	//	redisManager.
		//this.saveSession(session);
		return sessionId;
	}

	@Override
	protected Session doReadSession(Serializable sessionId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}