package org.excel;

import java.text.SimpleDateFormat;
import java.util.Date;

public class A {
	
	public static void main(String[] args) {
		
		Date date=new Date();
		
		System.out.println(date);
		
		SimpleDateFormat a=new SimpleDateFormat("dd/MMMM/yyyy");

		String format = a.format(date);
		
		System.out.println(format);
		
		
	}
	

}
