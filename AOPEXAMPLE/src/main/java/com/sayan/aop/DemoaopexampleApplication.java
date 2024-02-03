package com.sayan.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.sayan.aop.service.ServiceExample;

@SpringBootApplication
// @EnableAspectJAutoProxy annotation enables support for
// handling the components marked with @Aspect annotation.
@EnableAspectJAutoProxy
public class DemoaopexampleApplication {
	public static void main(String[] args)
	{
		ConfigurableApplicationContext context
			= SpringApplication.run(
					DemoaopexampleApplication.class,
				args);
		// Fetching the object from the application
		// context.
		ServiceExample service
			= context.getBean(ServiceExample.class);
		// checking for an employee available in the
		// organization
		String employeeNumber = "emp12345";
		try {
			service.employeeStatus(employeeNumber);
		}
		catch (Exception ex) {
			System.out.println("Exception occurred.."
							+ ex.getMessage());
		}
		
		System.out.println("/////////////////////");
		System.out.println();
		// Displaying balance in the account.
		String employeeAccountNumber = "Emp1212";
		try {
			service.getAccountBalance(
				employeeAccountNumber);
		}
		catch (Exception ex) {
			System.out.println("Exception occurred.."
							+ ex.getMessage());
		}

		
		System.out.println("/////////////////////");
		System.out.println();
		// Employee has undergone some exams for promotion.
		// Let us check that
		int promotionExamMarks = 650;
		try {
			service.eligibilityForPromotion(
				promotionExamMarks);
		}
		catch (Exception ex) {
			System.out.println("Exception occurred.."
							+ ex.getMessage());
		}
		// Closing the context object.
		context.close();
	}
}


