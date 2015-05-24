package com.text.project.test;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestTransactionService  {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(TestService.class);

//	@Resource
//	private UserDetailMapper mapper;
	
	/*@Transactional(propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public void update(UserDetail record){
		//Thread.currentThread().yield();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			LOGGER.info("update Thread sleep",e);
			
		}
		synchronized(record){
			System.out.println("-------------------------update start..------------------");
			int updateByPrimaryKey = mapper.updateByPrimaryKeySelective(record);
			System.out.println(updateByPrimaryKey);
			record.notify();
		}
		LOGGER.info("--------------------------------update end-------------------");
	}*/
}
