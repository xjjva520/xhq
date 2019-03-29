package com.xhq.xhqservice.aspect;

import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
/**
 *  日志切面处理。对日志中切入traceId
 * @author 检检
 *
 */
@Aspect
@Configuration
public class LoggerAspect {
	private final static Logger logger = LogManager.getLogger(LoggerAspect.class);
	
	// 定义切点Pointcut，Controller包下面的所有controller
    @Pointcut("execution(* com.xhq.xhqservice.controller.*Controller.*(..))")
    public void excudeService() {
    }
    
    
    @Around("excudeService()")
    public Object doAround(ProceedingJoinPoint pj) throws Throwable {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
 
        String method = request.getMethod();
        String uri = request.getRequestURI();
        //看请求跟踪号
        String traceId = request.getParameter("traceId");
        if(StringUtils.isEmpty(traceId)) {
        	//为空就自动生存一个traceID
        	traceId=UUID.randomUUID().toString();
        }
        ThreadContext.put("traceId", traceId);
        //拿到请求参数列表
        Map<String, String[]> parameterMap = request.getParameterMap();
        logger.info("redis-service receive request, url: {}, method: {}, params: {}", uri, method, JSON.toJSONString(parameterMap));
        long start = System.currentTimeMillis();
        // result的值就是被拦截方法的返回值
        Object result = pj.proceed();
        
        long end = System.currentTimeMillis();
        logger.info("redis-service response,reulst: {},cost: {} ",JSON.toJSONString(result),end-start);
        return result;
    }
}
