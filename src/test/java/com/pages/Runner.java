package com.pages;

import java.util.List;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Runner {
	
	@Test
	public void test() {

		Result result = JUnitCore.runClasses(PomHotelLogin.class);
		
		int failureCount = result.getFailureCount();
		
		System.out.println(failureCount);
		
		List<Failure> failures = result.getFailures();
		
		for (Failure failure : failures) {

			System.out.println(failure.getMessage());
		}
		
	}
	

}
