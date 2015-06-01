package com.text.project.auth.realm;

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
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.StringUtils;

import com.test.common.enums.UserStateEnum;
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
				throw new UnknownAccountException();//û�ҵ��ʺ�
			}
			if(UserStateEnum.LOCK.toString().equals(userDetail.getType())){
				throw new LockedAccountException(); //�ʺ�����
			}
			SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
					userDetail.getLoginName(), //�û���
					userDetail.getPassword(), //����
					getName() //realm name
					);
			authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(userDetail.getLoginName()+userDetail.getSalt()));
			return authenticationInfo;
		}
		return null;
	}

}