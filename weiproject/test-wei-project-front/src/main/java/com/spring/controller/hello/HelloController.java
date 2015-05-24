package com.spring.controller.hello;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.text.project.test.TestService;

  
@Controller
@RequestMapping("/hello")
public class HelloController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(HelloController.class);
	
	@Resource
	private TestService testService;
 // 
  //  @RequestMapping(method = RequestMethod.GET)
 //   @ResponseBody
   /* public String  printHello() {
    	UserDetail record = new UserDetail();
		record.setUserId("123456");
		testService.test(record);
        return "HELLO";
    }*/
}