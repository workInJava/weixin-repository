package com.text.project.test;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.test.project.dao.gen.UserDetailMapper;
import com.test.project.po.gen.UserDetail;

@Service
public class TestTransactionService  {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(TestService.class);

	@Resource
	private UserDetailMapper mapper;
	
	@Transactional(isolation=Isolation.SERIALIZABLE,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public void update(UserDetail record){
			try {
				System.out.println("==========start sleep =====");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"-------------------------update start..------------------");
			int updateByPrimaryKey = mapper.updateByPrimaryKeySelective(record);
			System.out.println(Thread.currentThread().getName()+"-------------"+updateByPrimaryKey);
			//record.notify();
		LOGGER.info(Thread.currentThread().getName()+"--------------------------------update end-------------------");
	}
}
