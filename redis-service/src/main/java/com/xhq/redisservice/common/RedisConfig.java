package com.xhq.redisservice.common;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {
   /**
    * 最大连接数	
    */
   @Value(value="${redis.maxTotal}")	
   private String redisMaxTotal;
   /**
    * 最大空闲连接数
    */
   @Value(value="${redis.maxIdle}")
   private String redisMaxIdle;
   /**
    * 最小空闲连接数
    */
   @Value(value="${redis.minIdle}")
   private String redisMinIdle;
   /**
    * 获取连接最大的等待时间（单位：毫秒）
    */
   @Value(value="${redis.maxWaitMillis}")
   private String redisMaxWaitMillis;
   
   /**
    * 逐出连接的最小空闲时间 默认1800000毫秒(30分钟)
    */
   @Value(value="${redis.minEvictableIdleTimeMillis}")
   private String minEvictableIdleTimeMillis;
   
   /**
    * 每次逐出检查时 逐出的最大数目 如果为负数就是 : 1/abs(n), 默认3
    */
   private String numTestsPerEvictionRun;  
   /**
    * 出扫描的时间间隔(毫秒) 如果为负数,则不运行逐出线程, 默认-1
    */
   private String timeBetweenEvictionRunsMillis;
   
   //------------------------sentinel 配置-------------------
   /**
    * 创建几个pools 池
    */
   @Value(value="${redis.sentinel.pools}")
   private int poolNum;
   /**
    * redsi 主名称
    */
   @Value(value="${redis.sentinel.masterName}")
   private String sentinelMasterName;
   /**
    * sentinel集群 ip1:port1,ip2:port2
    */
   @Value(value="${redis.sentinel.host}") 
   private String sentinelHost;
   
   @Value(value="${redis.sentinel.password}") 
   private String password;
   /**
    * 连接超时时间
    */
   @Value(value="${redis.sentinel.connectionTimeout}") 
   private String connectionTimeout;
   
   @Value(value="${redis.sentinel.soTimeout}") 
   private String soTimeout;

	public int getRedisMaxTotal() {
		if(StringUtils.isEmpty(redisMaxTotal)) {
			return 20;
		}
		return Integer.parseInt(redisMaxTotal);
	}
	
	public void setRedisMaxTotal(String redisMaxTotal) {
		this.redisMaxTotal = redisMaxTotal;
	}
	
	public int getRedisMaxIdle() {
		if(StringUtils.isEmpty(redisMaxIdle)) {
			return 20;
		}
		return Integer.parseInt(redisMaxTotal);
	}
	
	public void setRedisMaxIdle(String redisMaxIdle) {
		this.redisMaxIdle = redisMaxIdle;
	}
	
	public int getRedisMinIdle() {
		if(StringUtils.isEmpty(redisMinIdle)) {
			return 8;
		}
		return Integer.parseInt(redisMinIdle);
	}
	
	public void setRedisMinIdle(String redisMinIdle) {
		this.redisMinIdle = redisMinIdle;
	}
	
	public int getRedisMaxWaitMillis() {
		if(StringUtils.isEmpty(redisMaxWaitMillis)) {
			return 5000;
		}
		return Integer.parseInt(redisMaxWaitMillis);
	}
	
	public void setRedisMaxWaitMillis(String redisMaxWaitMillis) {
		this.redisMaxWaitMillis = redisMaxWaitMillis;
	}
	
	public String getMinEvictableIdleTimeMillis() {
		return minEvictableIdleTimeMillis;
	}
	
	public void setMinEvictableIdleTimeMillis(String minEvictableIdleTimeMillis) {
		this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
	}
	
	public String getNumTestsPerEvictionRun() {
		return numTestsPerEvictionRun;
	}
	
	public void setNumTestsPerEvictionRun(String numTestsPerEvictionRun) {
		this.numTestsPerEvictionRun = numTestsPerEvictionRun;
	}
	
	public String getTimeBetweenEvictionRunsMillis() {
		return timeBetweenEvictionRunsMillis;
	}
	
	public void setTimeBetweenEvictionRunsMillis(String timeBetweenEvictionRunsMillis) {
		this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
	}
	
	public int getPoolNum() {
		return poolNum;
	}

	public void setPoolNum(int poolNum) {
		this.poolNum = poolNum;
	}

	public List<String> getSentinelMasterName() {
		if(StringUtils.isEmpty(sentinelMasterName)) {
			return null;
		}
		return Arrays.asList(sentinelMasterName.split(","));
	}
	
	public void setSentinelMasterName(String sentinelMasterName) {
		this.sentinelMasterName = sentinelMasterName;
	}
	
	public List<String> getSentinelHost() {
		if(StringUtils.isEmpty(sentinelHost)) {
			return null;
		}
		return Arrays.asList(sentinelHost.split(","));
	}
	
	public void setSentinelHost(String sentinelHost) {
		this.sentinelHost = sentinelHost;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getConnectionTimeout() {
		if(StringUtils.isEmpty(connectionTimeout)) {
			return 1000;
		}
		return Integer.parseInt(connectionTimeout);
	}
	
	public void setConnectionTimeout(String connectionTimeout) {
		this.connectionTimeout = connectionTimeout;
	}
	
	public int getSoTimeout() {
		if(StringUtils.isEmpty(soTimeout)) {
			return 2000;
		}
		return Integer.parseInt(soTimeout);
	}
	
	public void setSoTimeout(String soTimeout) {
		this.soTimeout = soTimeout;
	}
   
   
   public JedisPoolConfig getJedisPootConfig() {
       JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
       jedisPoolConfig.setMaxTotal(getRedisMaxTotal());
       jedisPoolConfig.setMaxIdle(getRedisMaxIdle());
       jedisPoolConfig.setMaxWaitMillis(getRedisMaxWaitMillis());
       jedisPoolConfig.setMinIdle(getRedisMinIdle());
       return jedisPoolConfig;
   }
}
