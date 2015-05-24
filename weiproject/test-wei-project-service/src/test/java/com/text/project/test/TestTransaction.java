package com.text.project.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.text.project.test.TestService;
import com.text.project.test.TestTransactionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
	"classpath*:spring/test-dataSource.xml",
	"classpath*:spring/project-service.xml"
	})
public class TestTransaction {
	
	/*@Resource
	private TestService testService;
	@Resource
	private TestTransactionService testTransactionService;

	@Test
	public void test() {
		UserDetail record = new UserDetail();
		record.setUserId("123456");
		//testService.test(record);
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				testService.test(record);
			}
		});
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				record.setUserName("ddddddddd");
				testTransactionService.update(record);
			}
		});
		
		t1.start();
		t2.start();
		while(true){}
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}*/

}
