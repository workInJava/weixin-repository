package com.spring.controller.auth;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.text.project.test.TestService;

  
@Controller
public class HelloController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(HelloController.class);
	
	@Resource
	private TestService testService;
   
	@RequestMapping(value="/login" ,method = RequestMethod.GET)
    public String  login(ModelAndView mv) {
		LOGGER.info("go to signin page ");
        return "/auth/signin";
    }
	
	@RequestMapping(value="/login" ,method = RequestMethod.POST)
    public String login(ModelAndView mv) {
		LOGGER.info("go to signin page ");
        return "/auth/signin";
    }
	
}