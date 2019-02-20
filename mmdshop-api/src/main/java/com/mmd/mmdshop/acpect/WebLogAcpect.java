package com.mmd.mmdshop.acpect;

import org.aspectj.lang.JoinPoint;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 
 * @author QJH
 *
 */

@Aspect
@Component
public class WebLogAcpect {
	private Logger logger = LoggerFactory.getLogger(WebLogAcpect.class);
	@Pointcut("execution(* com.mmd.mmdshop.controller.*.*(..))")
	public void pointcutName(){}
/**	
	@Before("pointcutName()")
	public void performance(){
		System.out.println("Spring AOP");
	}
*/	
	@AfterReturning(returning="rvt",pointcut="pointcutName()")
	public Object afterExec(JoinPoint jp,Object rvt) {
		Class<?> pcc = jp.getTarget().getClass();
		logger.info("AFTER===="+pcc.getName()+":"+pcc.getSimpleName()+",backValues:" + rvt);
	    return rvt;
	}
}
