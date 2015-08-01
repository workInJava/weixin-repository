package com.test.common.redis.wrapper;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisException;

/**
 * JedisPool 管理类 用于单个redis 集群， 每个redis集群由master-salve组成
 */
public class JedisPoolManager {

	private static final Logger logger = LoggerFactory.getLogger(JedisPoolManager.class);

	private JedisPool jedisPool;

	/**
	 * redis的List集合 ，向key这个list添加元素
	 */
	public long rpush(String key, String string) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			long ret = jedis.rpush(key, string);
			jedis.close();
			return ret;
		} catch (Exception e) {
			logger.error("", e);
			if (jedis != null) {
				jedis.close();
			}
			throw new JedisException(e);
		}
	}

	/**
	 * 获取key这个List，从第几个元素到第几个元素 LRANGE key start
	 * stop返回列表key中指定区间内的元素，区间以偏移量start和stop指定。
	 * 下标(index)参数start和stop都以0为底，也就是说，以0表示列表的第一个元素，以1表示列表的第二个元素，以此类推。
	 * 也可以使用负数下标，以-1表示列表的最后一个元素，-2表示列表的倒数第二个元素，以此类推。
	 */
	public List<String> lrange(String key, long start, long end) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			List<String> ret = jedis.lrange(key, start, end);
			jedis.close();
			return ret;
		} catch (Exception e) {
			logger.error("", e);
			if (jedis != null) {
				jedis.close();
			}
			throw new JedisException(e);
		}
	}

	/**
	 * 将哈希表key中的域field的值设为value。
	 */
	public void hset(String key, String field, String value) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.hset(key, field, value);
			jedis.close();
		} catch (Exception e) {
			logger.error("", e);
			if (jedis != null) {
				jedis.close();
			}
			throw new JedisException(e);
		}
	}

	/**
	 * 向key赋值
	 */
	public void set(String key, String value) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.set(key, value);
			jedis.close();
		} catch (Exception e) {
			logger.error("", e);
			if (jedis != null) {
				jedis.close();
			}
			throw new JedisException(e);
		}
	}

	/**
	 * 向key赋值
	 */
	public void set(byte[] key, byte[] value) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.set(key, value);
			jedis.close();
		} catch (Exception e) {
			logger.error("", e);
			if (jedis != null) {
				jedis.close();
			}
			throw new JedisException(e);
		}
	}

	/**
	 * 获取key的值
	 */
	public String get(String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			String value = jedis.get(key);
			jedis.close();
			return value;
		} catch (Exception e) {
			logger.error("", e);
			if (jedis != null) {
				jedis.close();
			}
			throw new JedisException(e);
		}
	}

	/**
	 * 获取key的值
	 */
	public byte[] get(byte[] key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			byte[] value = jedis.get(key);
			jedis.close();
			//jedis.close();
			return value;
		} catch (Exception e) {
			logger.error("", e);
			if (jedis != null) {
				jedis.close();
				//jedis.close();
			}
			throw new JedisException(e);
		}

	}

	/**
	 * 将多个field - value(域-值)对设置到哈希表key中。
	 */
	public void hmset(String key, Map<String, String> map) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.hmset(key, map);
			jedis.close();
		} catch (Exception e) {
			logger.error("hmset出错", e);
			if (jedis != null) {
				jedis.close();
			}
			throw new JedisException(e);
		}
	}

	/**
	 * 给key赋值，并生命周期设置为seconds
	 */
	public void setex(String key, int seconds, String value) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.setex(key, seconds, value);
			jedis.close();
		} catch (Exception e) {
			logger.error("", e);
			if (jedis != null) {
				jedis.close();
			}
			throw new JedisException(e);
		}
	}

	/**
	 * 给key赋值，并生命周期设置为seconds
	 */
	public byte[] setex(byte[] key, byte[] value, int seconds) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.setex(key, seconds, value);
			jedis.close();
			return value;
		} catch (Exception e) {
			logger.error("", e);
			if (jedis != null) {
				jedis.close();
			}
			throw new JedisException(e);
		}

	}

	/**
	 * 为给定key设置生命周期
	 */
	public void expire(String key, int seconds) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.expire(key, seconds);
			jedis.close();
		} catch (Exception e) {
			logger.error("", e);
			if (jedis != null) {
				jedis.close();
			}
			throw new JedisException(e);
		}
	}

	/**
	 * 检查key是否存在
	 */
	public boolean exists(String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			boolean bool = jedis.exists(key);
			jedis.close();
			return bool;
		} catch (Exception e) {
			logger.error("", e);
			if (jedis != null) {
				jedis.close();
			}
			throw new JedisException(e);
		}
	}

	/**
	 * 检查key是否存在
	 */
	public boolean exists(byte[] key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			Set<byte[]> hashSet = jedis.keys(key);
			jedis.close();
			if (null != hashSet && hashSet.size() > 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			logger.error("", e);
			if (jedis != null) {
				jedis.close();
			}
			throw new JedisException(e);
		}
	}

	/**
	 * 返回key值的类型 none(key不存在),string(字符串),list(列表),set(集合),zset(有序集),hash(哈希表)
	 */
	public String type(String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			String type = jedis.type(key);
			jedis.close();
			return type;
		} catch (Exception e) {
			logger.error("", e);
			if (jedis != null) {
				jedis.close();
			}
			throw new JedisException(e);
		}
	}

	/**
	 * 从哈希表key中获取field的value
	 */
	public String hget(String key, String field) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			String value = jedis.hget(key, field);
			jedis.close();
			return value;
		} catch (Exception e) {
			logger.error("", e);
			if (jedis != null) {
				jedis.close();
			}
			throw new JedisException(e);
		}
	}

	/**
	 * 返回哈希表key中，所有的域和值
	 */
	public Map<String, String> hgetAll(String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			Map<String, String> map = jedis.hgetAll(key);
			jedis.close();
			return map;
		} catch (Exception e) {
			logger.error("", e);
			if (jedis != null) {
				jedis.close();
			}
			throw new JedisException(e);
		}

	}

	/**
	 * 返回哈希表key中，所有的域和值
	 */
	public Set<?> smembers(String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			Set<?> set = jedis.smembers(key);
			jedis.close();
			return set;
		} catch (Exception e) {
			logger.error("", e);
			if (jedis != null) {
				jedis.close();
			}
			throw new JedisException(e);
		}
	}

	/**
	 * 返回匹配的 keys 列表
	 */
	public Set<byte[]> keys(String pattern) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			Set<byte[]> keys = jedis.keys(pattern.getBytes());
			jedis.close();
			return keys;
		} catch (Exception e) {
			logger.error("", e);
			if (jedis != null) {
				jedis.close();
			}
			throw new JedisException(e);
		}

	}

	/**
	 * 移除set集合中的member元素
	 */
	public void delSetObj(String key, String field) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.srem(key, field);
			jedis.close();
		} catch (Exception e) {
			logger.error("", e);
			if (jedis != null) {
				jedis.close();
			}
			throw new JedisException(e);
		}
	}

	/**
	 * 删除元素
	 */
	public void del(byte[] key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.del(key);
			jedis.close();
		} catch (Exception e) {
			logger.error("", e);
			if (jedis != null) {
				jedis.close();
			}
			throw new JedisException(e);
		}
	}

	/**
	 * 判断member元素是否是集合key的成员。是（true），否则（false）
	 */
	public boolean isNotField(String key, String field) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			boolean bool = jedis.sismember(key, field);
			jedis.close();
			return bool;
		} catch (Exception e) {
			logger.error("", e);
			if (jedis != null) {
				jedis.close();
			}
			throw new JedisException(e);
		}
	}

	/**
	 * 如果key已经存在并且是一个字符串，将value追加到key原来的值之后
	 */
	public void append(String key, String value) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.append(key, value);
			jedis.close();
		} catch (Exception e) {
			logger.error("", e);
			if (jedis != null) {
				jedis.close();
			}
			throw new JedisException(e);
		}
	}
	
	
	/**
	 * 清空当前的redis 库
	 */
	public void flushDB() {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.flushDB();
			jedis.close();
		} catch (Exception e) {
			logger.error("", e);
			if (jedis != null) {
				jedis.close();
			}
			throw new JedisException(e);
		}

	}

	/**
	 * 返回当前redis库所存储数据的大小
	 */
	public Long dbSize() {

		Long dbSize = 0L;

		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.dbSize();
			jedis.close();
			return dbSize;
		} catch (Exception e) {
			logger.error("", e);
			if (jedis != null) {
				jedis.close();
			}
			throw new JedisException(e);
		}

	}

	/**
	 * 关闭 Redis
	 */
	public void destory() {
		jedisPool.destroy();
	}

	public JedisPool getJedisPool() {
		return jedisPool;
	}

	public void setJedisPool(JedisPool jedisPool) {
		this.jedisPool = jedisPool;
	}
}