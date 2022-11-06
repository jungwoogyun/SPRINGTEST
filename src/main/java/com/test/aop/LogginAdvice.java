package com.test.aop;



import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;
 
@Component
@Aspect
public class LogginAdvice {

	//@Around("execution(* com.test.aop.MyMath.*(..))")
	@Around("execution(* com.test.aop.MyMath.add(..))")
	public Object log1(ProceedingJoinPoint pjp) throws Throwable{
		
		long start = System.currentTimeMillis();
		
		System.out.println("[START] "+pjp.getSignature().getName()+Arrays.toString(pjp.getArgs()));
		
		Object result = pjp.proceed();//target의 메서드를 호출
	
		System.out.println("[RESULT] : " + result);
		System.out.println("[Time] :" +(System.currentTimeMillis()-start)+"ms");
		System.out.println("[END]\n");
		return result;
		
	}
	
}
