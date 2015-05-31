package com.spring.controller.auth;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.test.project.po.gen.UserDetail;

@Controller
@RequestMapping(value="main")
public class MainList {
	private final static Logger LOGGER = LoggerFactory.getLogger(MainList.class);

	@RequestMapping(value="productlist")
	public ModelAndView list(UserDetail user){
		ModelAndView mv = new ModelAndView("auth/index");
		LOGGER.info(SecurityUtils.getSubject().getPrincipal().toString());
		mv.addObject("userName", SecurityUtils.getSubject().getPrincipal().toString());
		return mv;
	}
}
