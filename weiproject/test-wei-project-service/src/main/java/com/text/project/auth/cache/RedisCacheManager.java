package com.text.project.auth.cache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.test.common.redis.wrapper.JedisManager;

public class RedisCacheManager implements CacheManager {

	private static final Logger logger = LoggerFactory.getLogger(RedisCacheManager.class);

	// fast lookup by name map
	private final ConcurrentMap<String, Cache> caches = new ConcurrentHashMap<String, Cache>();

	private JedisManager redisManager;

	public <K, V> Cache<K, V> getCache(String name) throws CacheException {
		logger.debug("��ȡ����Ϊ: " + name + " ��RedisCacheʵ��");
		Cache c = caches.get(name);
		if (c == null) {
			c = new RedisCache<K, V>(name,redisManager);
			caches.put(name, c);
		}
		return c;
	}
	// setter��getter����ʡ��
	
}