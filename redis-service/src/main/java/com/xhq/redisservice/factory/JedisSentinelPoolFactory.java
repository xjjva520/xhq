package com.xhq.redisservice.factory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

import com.xhq.redisservice.common.RedisConfig;
import com.xhq.redisservice.service.SpringContextHolder;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

@Configuration
public class JedisSentinelPoolFactory {
	
	private final static Logger logger = LogManager.getLogger(JedisSentinelPoolFactory.class);
	@Autowired
	private RedisConfig redisConfig;	
	@Autowired
    private ApplicationContext applicationContext;
	
	@PostConstruct
    public void dynamicCreateRedisPool() throws Exception {
		 try {
	        ConfigurableApplicationContext context = (ConfigurableApplicationContext)applicationContext;
	        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory)context.getBeanFactory();
	        //获取配置文件
	        JedisPoolConfig jedisPootConfig = redisConfig.getJedisPootConfig();
	        
	        final Integer connectionTimeout = redisConfig.getConnectionTimeout();
	        final Integer soTimeout = redisConfig.getSoTimeout();
	        final String password = redisConfig.getPassword();
	        //sentinels 池
	        Set<String> sentinels = new HashSet<>();
	        redisConfig.getSentinelHost().forEach(host -> {
	        	sentinels.add(host);
	        });
	        List<String> masterNames = redisConfig.getSentinelMasterName();
	        
	        int poolNum = redisConfig.getPoolNum();
	        for(int i=0;i<poolNum;i++) {
	        	BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(JedisSentinelPool.class);
	            /**
	                                  * 设置构造函数参数
	             */
	            beanDefinitionBuilder.addConstructorArgValue(masterNames.get(i));
	            beanDefinitionBuilder.addConstructorArgValue(sentinels);
	            beanDefinitionBuilder.addConstructorArgValue(jedisPootConfig);
	            beanDefinitionBuilder.addConstructorArgValue(connectionTimeout);
	            beanDefinitionBuilder.addConstructorArgValue(soTimeout);
	            beanDefinitionBuilder.addConstructorArgValue(password);
	            beanDefinitionBuilder.addConstructorArgValue(0);       
	            /**
	             * 注册到spring容器中
	             */
	            beanFactory.registerBeanDefinition("jedisSentinelPool" + i,  beanDefinitionBuilder.getBeanDefinition());
	        }
	        logger.info("jedisSentinelPools init occur is ok:");
		 }catch (Exception e) {
			 logger.error("jedisSentinelPools init occur error:",e);
		} 
		 
    }
	
	/**
	 * 通过key进行hash算法，取模进行redis分片
	 * @param key
	 * @return
	 */
	public JedisSentinelPool getSentinelPool(String key) {
		int partition = key.hashCode()%redisConfig.getPoolNum();
		JedisSentinelPool pool = SpringContextHolder.getBean("jedisSentinelPool"+partition);
		logger.info("get JedisSentinelPool by key = {},partition ={},pool = {}",key,partition,pool.getCurrentHostMaster());
		return pool;
	}
}
