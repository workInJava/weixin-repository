package com.text.project.auth.realm;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.StringUtils;

import com.test.project.po.gen.UserDetail;
import com.text.project.service.IUserService;

public class ShiroDbRealm extends AuthorizingRealm {

	@Resource
	private IUserService userService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		String userName = token.getUsername();
		if(StringUtils.hasText(userName)){
			UserDetail userDetail = userService.findByUsername(userName);
			if(userDetail == null){
				throw new UnknownAccountException();//没找到帐号
			}
			SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
					userDetail.getLoginName(), //用户名
					userDetail.getPassword(), //密码
					//ByteSource.Util.bytes(userDetail.getSalt()),//salt=username+salt
					getName() //realm name
					);
			return authenticationInfo;
		}
		return null;
	}

}