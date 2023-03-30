package org.base;

import java.util.List;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class A {

	@Test
	public void test() {

		Result result = JUnitCore.runClasses(HotelBooking.class);
		
		int runCount = result.getRunCount();
		
		System.out.println(runCount);
		
		int failureCount = result.getFailureCount();
		
		System.out.println(failureCount);
		
		int ignoreCount = result.getIgnoreCount();
		
		System.out.println(ignoreCount);
		
		long runTime = result.getRunTime();
		
		System.out.println(runTime);
		
		List<Failure> failures = result.getFailures();
		
		for (Failure failure : failures) {
			
			String message = failure.getMessage();
			
			System.out.println(message);
			
		}
	}
	
}
