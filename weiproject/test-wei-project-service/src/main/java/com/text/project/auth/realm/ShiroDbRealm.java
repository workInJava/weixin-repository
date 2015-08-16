package com.text.project.auth.realm;

import java.io.Serializable;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.test.common.enums.UserStateEnum;
import com.test.project.po.gen.UserDetail;
import com.text.project.service.IUserService;
import com.text.project.utils.MyByteSource;

public class ShiroDbRealm extends AuthorizingRealm implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Logger LOGGER = LoggerFactory.getLogger(ShiroDbRealm.class);

	@Resource
	private IUserService userService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		LOGGER.info("========================doGetAuthenticationInfo==========================");
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		String userName = token.getUsername();
		if (StringUtils.hasText(userName)) {
			UserDetail userDetail = userService.findByUsername(userName);
			if (userDetail == null) {
				throw new UnknownAccountException();// 没找到帐号
			}
			if (UserStateEnum.LOCK.toString().equals(userDetail.getType())) {
				throw new LockedAccountException(); // 帐号锁定
			}
			SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
					userDetail.getLoginName(), // 用户名
					userDetail.getPassword(), // 密码 getName() // realm name
					//ByteSource.Util.bytes(userDetail.getLoginName() + userDetail.getSalt()),
					new MyByteSource(userDetail.getLoginName() + userDetail.getSalt()),
					getName());
			return authenticationInfo;
		}
		return null;
	}
	
	
	
}