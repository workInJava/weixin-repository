package com.text.project.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.project.po.gen.UserDetail;
import com.text.project.test.TestService;
import com.text.project.test.TestTransactionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"classpath*:spring/wei-dataSource.xml",
		"classpath*:spring/wei-project-service.xml"
	})
public class TestTransaction {
	
	@Resource
	private TestService testService;
	@Resource
	private TestTransactionService testTransactionService;

	private static ThreadPoolExecutor executor ;
	
	@BeforeClass
	public static void init(){
		executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
	            new ArrayBlockingQueue<Runnable>(5));
	}

	@AfterClass
	public static void distory(){
		System.out.println("-------------"+executor.getActiveCount());
		executor.shutdown();
	}
	@Test
	public void test() {
		UserDetail record = new UserDetail();
		record.setUserId("1435239108853000");
		
		
			executor.submit(new Runnable(){
				@Override
				public void run() {
					testService.test(record);
				}
				
			});
		
			executor.submit(new Runnable(){
				@Override
				public void run() {
					record.setLoginName("aaaaaa");
					testTransactionService.update(record);
				}
			});
			
			while(executor.getTaskCount()!=executor.getCompletedTaskCount()){
			}
			System.out.println("------------------------test ,end-----");
			

		/*UserDetail record = new UserDetail();
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
		}*/
		
	}

}
