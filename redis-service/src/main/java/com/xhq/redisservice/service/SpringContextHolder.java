package com.xhq.redisservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class SpringContextHolder implements ApplicationContextAware,DisposableBean{
	private static final Logger logger = LoggerFactory.getLogger(SpringContextHolder.class);
	
	private static ApplicationContext applicationContext; 
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringContextHolder.applicationContext = applicationContext;
	}

	@Override
	public void destroy() throws Exception {
		//进行销毁
		applicationContext = null;
		
	}
    
	 /**
     * 从静态变量applicationContext中取得Bean, 自动转型为所赋值对象的类型.
     */
    @SuppressWarnings("unchecked")
	public static <T> T getBean(String name) {
    	if(applicationContext==null) {
        	logger.error("applicationContext is null,pleas cheak spring is ok");
        	return null;
        }
        return (T) applicationContext.getBean(name);
    }

    /**
     * 从静态变量applicationContext中取得Bean, 自动转型为所赋值对象的类型.
     */
    public static <T> T getBean(Class<T> clazz) {
        if(applicationContext==null) {
        	logger.error("applicationContext is null,pleas cheak spring is ok");
        	return null;
        }
        return applicationContext.getBean(clazz);
    }
}
