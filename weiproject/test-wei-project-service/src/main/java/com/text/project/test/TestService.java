package com.text.project.test;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class TestService {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(TestService.class);

//	@Resource
	//private UserDetailMapper mapper;
	
	//@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	/*public void test(UserDetail record){
		
		synchronized(record){
			System.out.println("---------------------------第一次查询----------------------------");
			UserDetailExample example = new UserDetailExample();
			example.createCriteria().andUserIdEqualTo(record.getUserId());
			UserDetail u1 = mapper.selectByExample(example).get(0);
			System.out.println(u1.getUserName());
			try {
				record.wait();
			} catch (InterruptedException e) {
				LOGGER.info("wait update..", e);
			}
			System.out.println("---------------------------第二次查询----------------------------");
			UserDetail u2 = mapper.selectByExample(example).get(0);
			System.out.println(u2.getUserName());
		}
	}*/
}
