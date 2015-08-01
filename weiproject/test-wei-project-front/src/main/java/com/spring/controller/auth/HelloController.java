package com.spring.controller.auth;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.text.project.test.TestService;

@Controller
public class HelloController {

	private final static Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

	@Resource
	private TestService testService;

	@RequestMapping(value = "/login")
	public String showLoginForm(HttpServletRequest req, Model model) {
		String exceptionClassName = (String) req.getAttribute("shiroLoginFailure");
		String error = null;
		if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
			error = "用户名/密码错误";
		} else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
			error = "用户名/密码错误";
		} else if (exceptionClassName != null) {
			error = "其他错误：" + exceptionClassName;
		}
		LOGGER.info(error);
		model.addAttribute("error", error);
		return "/auth/signin";
	}
	
	@RequestMapping(value = "/loginOut")
	public String loginOut(Model model) {
		SecurityUtils.getSubject().logout();
		return "redirect:/login";
	}

}