package com.test.product.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisTest {
	private static JedisPool pool = null;

	/**
	 * ����redis���ӳ�
	 * 
	 * @param ip
	 * @param port
	 * @return JedisPool
	 */
	public static JedisPool getPool() {
		if (pool == null) {
			JedisPoolConfig config = new JedisPoolConfig();
			// ����һ��pool�ɷ�����ٸ�jedisʵ����ͨ��pool.getResource()����ȡ��
			// �����ֵΪ-1�����ʾ�����ƣ����pool�Ѿ�������maxActive��jedisʵ�������ʱpool��״̬Ϊexhausted(�ľ�)��
			// config.setMaxActive(500);
			// ����һ��pool����ж��ٸ�״̬Ϊidle(���е�)��jedisʵ����
			config.setMaxIdle(5);
			// ��ʾ��borrow(����)һ��jedisʵ��ʱ�����ĵȴ�ʱ�䣬��������ȴ�ʱ�䣬��ֱ���׳�JedisConnectionException��
			// config.setMaxWait(1000 * 100);
			// ��borrowһ��jedisʵ��ʱ���Ƿ���ǰ����validate���������Ϊtrue����õ���jedisʵ�����ǿ��õģ�
			config.setTestOnBorrow(true);
			pool = new JedisPool(config, "192.168.2.121", 6379);
		}
		return pool;
	}

	/**
	 * ���������ӳ�
	 * 
	 * @param pool
	 * @param redis
	 */
	public static void returnResource(JedisPool pool, Jedis redis) {
		if (redis != null) {
			pool.returnResource(redis);
		}
	}

	/**
	 * ��ȡ����
	 * 
	 * @param key
	 * @return
	 */
	public static String get(String key) {
		String value = null;

		JedisPool pool = null;
		Jedis jedis = null;
		try {
			pool = getPool();
			jedis = pool.getResource();
			value = jedis.get(key);
		} catch (Exception e) {
			// �ͷ�redis����
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			// ���������ӳ�
			returnResource(pool, jedis);
		}
		return value;
	}

	public static boolean save(String key, Object obj) {
		JedisPool pool = null;
		Jedis jedis = null;
		try {
			pool = getPool();
			jedis = pool.getResource();
			jedis.append(key, (String) obj);
		} finally {
			returnResource(pool, jedis);
		}
		return true;
	}

	public static void main(String args[]) {
		RedisTest.save("name", "hello world redis");
		System.out.println(RedisTest.get("name"));
		
	}
}