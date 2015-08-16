package com.text.project.auth.cache;

import java.util.Collection;
import java.util.Set;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;

import com.test.common.redis.wrapper.JedisManager;
import com.test.common.utils.SerializeUtil;

public class RedisCache<K, V> implements Cache<K, V> {

	private static Logger LOGGER = LoggerFactory.getLogger(RedisCache.class);
	
	private static final String REDIS_SHIRO_CACHE = "shiro-cache:";
	private static final int DB_INDEX = 0;
	private JedisManager jedisManager;
	private String name;

	public RedisCache() {
	}

	public RedisCache(String name, JedisManager jedisManager) {
		this.name = name;
		this.jedisManager = jedisManager;
	}

	/**
	 * 自定义relm中的授权/认证的类名加上授权/认证英文名字
	 */
	public String getName() {
		if (name == null)
			return "";
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@SuppressWarnings("unchecked")
	@Override
	public V get(K key) throws CacheException {
		byte[] byteKey = SerializeUtil.serialize(buildCacheKey(key));
		byte[] byteValue = null;
		try {
			byteValue = jedisManager.getValueByKey(DB_INDEX, byteKey);
		} catch (Exception e) {
			LOGGER.error("get cache error", e);
		}
		return (V) SerializeUtil.deserialize(byteValue);
	}

	@Override
	public V put(K key, V value) throws CacheException {
		V previos = get(key);
		try {
			jedisManager.saveValueByKey(DB_INDEX,
					SerializeUtil.serialize(buildCacheKey(key)),
					SerializeUtil.serialize(value), -1);
		} catch (Exception e) {
			LOGGER.error("get cache error", e);
		}
		return previos;
	}

	@Override
	public V remove(K key) throws CacheException {
		V previos = get(key);
		try {
			jedisManager.deleteByKey(DB_INDEX,
					SerializeUtil.serialize(buildCacheKey(key)));
		} catch (Exception e) {
			LOGGER.error("get cache error", e);
		}
		return previos;
	}

	@Override
	public void clear() throws CacheException {
		Jedis jedis = jedisManager.getJedis();
		jedis.flushDB();
		jedis.close();
	}

	@Override
	public int size() {
		if (keys() == null)
			return 0;
		return keys().size();
	}

	@Override
	public Set<K> keys() {
		// TODO
		return null;
	}

	@Override
	public Collection<V> values() {
		// TODO
		return null;
	}

	private String buildCacheKey(Object key) {
		return REDIS_SHIRO_CACHE +getName() + key;
	}
}
