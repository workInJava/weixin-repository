package com.text.project.auth.sessiondao;

import java.io.Serializable;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;

public class SelfSessionDao extends CachingSessionDAO{

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Session doReadSession(Serializable sessionId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}