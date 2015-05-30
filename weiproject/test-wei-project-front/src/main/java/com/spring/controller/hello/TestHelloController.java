package com.spring.controller.hello;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.text.project.test.TestService;

  
@Controller
@RequestMapping("/hello")
public class TestHelloController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(TestHelloController.class);
	
	@Resource
	private TestService testService;
 // 
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String  printHello() {
        return "HELLO";
    }
}