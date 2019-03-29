package com.javainuse.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeServiceAspect {

	@Before(value = "execution(* com.javainuse.service.EmployeeService.*(..)) && args(name,empId)")
	public void beforeAdvice(JoinPoint joinPoint, String name, String empId) {
		System.out.println("Before method:" + joinPoint.getSignature());
		System.out.println("Creating Employee with name - " + name + " and id - " + empId);
	}

	@After(value = "execution(* com.javainuse.service.EmployeeService.*(..)) && args(name,empId)")
	public void afterAdvice(JoinPoint joinPoint, String name, String empId) {
		System.out.println("After method:" + joinPoint.getSignature());
		System.out.println("Successfully created Employee with name - " + name + " and id - " + empId);
	}

	@Around("within(com.javainuse.service.*)")
	public Object ExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		final long start = System.currentTimeMillis();
		final Object proceed = joinPoint.proceed();
		final long executionTime = System.currentTimeMillis() - start;
		String logs= String.format("\n---- Performance aspect ----\n" +
						"method: %s \n" +
						"execution time:  %s [ms]\n" +
						"------------------------\n",
				joinPoint.getSignature().getName(), executionTime);
		System.out.println(logs);
		return proceed;
	}

}
