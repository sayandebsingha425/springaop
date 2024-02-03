package com.sayan.aop.service;
import org.springframework.stereotype.Service;

@Service
public class ServiceExample {
	public void
	getAccountBalance(String employeeAccountNumber)
	{
		System.out.println("Inside getBalance() method");
		// To mention about for a certain
		// employeeAccountNumber value
		if (employeeAccountNumber.equals("Emp1212")) {
			System.out.println("Total balance: ......");
		}
		else {
			System.out.println(
				"Sorry! wrong account number. Please give correct account number to verify");
		}
	}

	public String employeeStatus(String employeeNumber)
	{
		System.out.println(
			"Inside checkEmployeeExistence() method");
		String status = null;
		if (employeeNumber.equals("emp12345")) {
			System.out.println(employeeNumber
							+ " is currently active");
			status = "active";
		}
		else {
			System.out.println(employeeNumber
							+ " is currently inactive");
			status = "Inactive";
		}
		return status;
	}

	public String
	eligibilityForPromotion(int promotionExamMarks)
	{
		System.out.println(
			"Inside eligibilityForPromotion() method");
		String status = null;
		if (promotionExamMarks >= 650) {
			System.out.println("Eligible for promotion..");
			status = "eligible";
		}
		else {
			System.out.println(
				"Not eligible for promotion..");
			status = "not eligible";
		}
		return status;
	}
}
