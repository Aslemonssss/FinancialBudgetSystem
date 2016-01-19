package com.dongcun.core.impl;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

public class BaseAdvise implements MethodBeforeAdvice, AfterReturningAdvice,
		ThrowsAdvice {
	private static Logger	logger = Logger.getLogger("aop");

	public void afterReturning(Object returnValue, Method method,
			Object[] args, Object target) throws Throwable {
		// TODO Auto-generated method stub
		
	}

	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		// TODO Auto-generated method stub
		logger.info("切入点: " + target.getClass().getName() + "类中" + method.getName() + "方法");
	}

    public void afterThrowing(Method method, Object[] args, Object target, Exception ex) throws Throwable {  
        logger.error("切入点: " + target.getClass().getName() + "类中" + method.getName() + "方法出现异常: " + ex.getMessage()); 
    }  	
}
