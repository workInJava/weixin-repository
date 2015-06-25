package com.text.project.test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TestService {

	private final static Logger LOGGER = LoggerFactory.getLogger(TestService.class);

	// @Resource
	// private UserDetailMapper mapper;

	// @Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	/*
	 * public void test(UserDetail record){
	 * 
	 * synchronized(record){ System.out.println(
	 * "---------------------------��һ�β�ѯ----------------------------");
	 * UserDetailExample example = new UserDetailExample();
	 * example.createCriteria().andUserIdEqualTo(record.getUserId()); UserDetail
	 * u1 = mapper.selectByExample(example).get(0);
	 * System.out.println(u1.getUserName()); try { record.wait(); } catch
	 * (InterruptedException e) { LOGGER.info("wait update..", e); }
	 * System.out.println
	 * ("---------------------------�ڶ��β�ѯ----------------------------");
	 * UserDetail u2 = mapper.selectByExample(example).get(0);
	 * System.out.println(u2.getUserName()); } }
	 */

	public static void main(String args[]) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://route.showapi.com/9-2");
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("showapi_timestamp", "2015-06-10 22:12:13"));
		nvps.add(new BasicNameValuePair("showapi_appid", "3"));
		nvps.add(new BasicNameValuePair("areaid", "101020300"));
		nvps.add(new BasicNameValuePair("area", "�Ϻ�"));
		nvps.add(new BasicNameValuePair("showapi_sign", "simple_006513e01bd344fca03610d1fd0145f0"));
		httpPost.setEntity(new UrlEncodedFormEntity(nvps));
		CloseableHttpResponse response = httpclient.execute(httpPost);
		// HttpResponse response=httpclient.execute(httpPost);
		try {
			System.out.println(response.getStatusLine());
			HttpEntity entity = response.getEntity();
			InputStream in = entity.getContent();
			byte[] tt = new byte[100];
			int b;
			while ((b = in.read(tt)) != -1) {
				String tzt = new String(tt, "utf-8");
				System.out.println(tzt);
			}
			in.close();
			// do something useful with the response body
			// and ensure it is fully consumed
			EntityUtils.consume(entity);
		} finally {
			response.close();
		}
	}
}
