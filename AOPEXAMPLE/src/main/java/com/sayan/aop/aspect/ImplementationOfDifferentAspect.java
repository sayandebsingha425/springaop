package com.sayan.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// Enables the spring AOP functionality in an application
@Aspect
@Component
public class ImplementationOfDifferentAspect {
	// Displays all the available methods i.e. the advice
	// will be called for all the methods The method
	// declaration is called the pointcut signature. It
	// provides a name that can be used by advice annotations
	// to refer to that pointcut.
	@Pointcut(value = "execution(* com.sayan.aop.service.ServiceExample.*(..))")
	private void printLogs() {
	}

	// If there is no @Around advice, @Before will be called
	// first, otherwise @Around Before Invocation is called
	@Before("execution(* com.sayan.aop.service.ServiceExample.*(..))")
	public void printLogStatementsBefore() {

		System.out.println(
				".............Looking for @Around advice, if none is there, @Before will be called first. My role is to execute before each and every method.............");
	}

	// If there is no @Around advice, @After will be called
	// after @Before(if available) first, otherwise @Around
	// After Invocation is called
	@After("execution(* com.sayan.aop.service.ServiceExample.*(..))")
	public void printLogStatementsAfter() {
		System.out.println(
				".............Looking for @Around advice, if none is there, @After will be called after @Before(if available). My role is to execute after each and every method.............");
	}

	// implementing after returning advice
	// This is generally used to indicate the output after
	// successful return of the method, will be called at
	// last i.e. after @Around
	// AOP aspect plug in place is JointPoint
	@AfterReturning(value = "execution(* com.sayan.aop.service.ServiceExample.*(..))", returning = "accoun")
	public void logsAfterReturningDisplay(JoinPoint joinPoint,String accoun) {
		System.out.println("After Returning method:" + joinPoint.getSignature()+ "Status: "+accoun);
		System.out.println(accoun);
	}

	// implementing after throwing advice
	// This is generally used to indicate the exception in
	// case of exception , will be called whenever exception
	// occurs
	@AfterThrowing(value = "execution(* com.sayan.aop.service.ServiceExample.*(..))", throwing = "ex")
	public void logsAfterThrowingDisplay(JoinPoint jPoint, Exception ex) {
		System.out.println("After Throwing exception in method:" + jPoint.getSignature());
		System.out.println("Exception is:" + ex.getMessage());
	}

	// Declares the around advice that is applied before and
	// after the method matching with a pointcut expression
	// Even there are @Before annotations, @Around will be
	// invoked first with the before invocation and then only
	// @Before will be called
	@Around(value = "printLogs()")
	public void logsAroundAdvice(ProceedingJoinPoint proJoinPoint) throws Throwable {
		System.out.println("The method aroundAdvice() before invocation of the method "
				+ proJoinPoint.getSignature().getName() + " method");
		try {
			proJoinPoint.proceed();
		} finally {
		}
		System.out.println("The method aroundAdvice() after invocation of the method "
				+ proJoinPoint.getSignature().getName() + " method");
	} 
}

//@around,@before, @afterreturn,@after,@around
