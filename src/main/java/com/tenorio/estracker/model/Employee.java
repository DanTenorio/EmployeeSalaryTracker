package com.tenorio.estracker.model;


import java.util.Hashtable;
import java.time.*;

public class Employee 
{
	
	private String name;
	private double wage;
//	private 
//	private double[] yrlyPay;
	/*
	 * How should the Employee Exist?
	 * They should have a name and a wage
	 * A history of payments
	 * reports of each week, biweek, month, quarter and year
	 * How to implement? 
	 * Ok so an arraylist of payments
	 * A Payment:
	 *     Date of payment: MM/dd/yyyy
	 *     Hours Worked
	 *     Payment recieved
	 *     Wage maybe at the time???
	 *     
	 *     
	 *     Ok so I'm thinking a hashtable with the key being a year and value being an array of PaymentInfos where
	 *     each payment info has 366 days 
	 *     Payment info also has a field for weekly,monthly,qrtr and total for the year. 
	 *     within each day is payment made
	 */
	
	private Hashtable<Integer, PaymentInfo[]> paymentInfos;
	
	public Employee(String name, double wage) 
	{
		this.name = name;
		this.wage = wage;
		paymentInfos = new Hashtable<>();
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public double getWage() 
	{
		return wage;
	}

	public void setWage(double wage) 
	{
		this.wage = wage;
	}
	
	public double getWeeklyPay()
	{
	    return 0;
	}
	public void getMonthlyPay()
	{
	    
	}
	public void getQuarterPay()
	{
	    
	}
	public void getYearlyPay()
	{
	    
	}
	public PaymentInfo[] getPaymentInfos(int year)
	{
	    return paymentInfos.get(Integer.valueOf(year));
	}

}
