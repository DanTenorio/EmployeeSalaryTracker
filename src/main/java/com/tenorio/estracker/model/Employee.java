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
		paymentInfos.put(Integer.valueOf(LocalDate.now().getYear()), new PaymentInfo[366]);
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
	public double getWeeklyPay(LocalDate date)
	{
	    double pay = 0;
	    PaymentInfo[] pi = paymentInfos.get(Integer.valueOf(date.getYear()));
	    if(pi[date.getDayOfYear()] != null) {
	        pay += pi[date.getDayOfYear()].getPayment();
	    }
	    switch(date.getDayOfWeek())
	    {
	    case MONDAY:
	        pay += getOtherDayPayments(date, 0, 6);
	        break;
	    case TUESDAY:
	        pay += getOtherDayPayments(date, 1, 5);
	        break;
        case WEDNESDAY:
            pay += getOtherDayPayments(date, 2, 4);
            break;
        case THURSDAY:
            pay += getOtherDayPayments(date, 3, 3);
            break;
        case FRIDAY:
            pay += getOtherDayPayments(date, 4, 2);
            break;
        case SATURDAY:
            pay += getOtherDayPayments(date, 5, 1);
            break;
        case SUNDAY:
            pay += getOtherDayPayments(date, 6, 0);
            break;
        default:
            break;
	    }
	    
	    return pay;
	}
	public double getOtherDayPayments(LocalDate date, int daysBefore, int daysAfter)
	{
	    double total = 0;
	    PaymentInfo[] pi = getPaymentInfos(date.getYear());

	    for(int i = 0; i < daysBefore; i++)
	    {
	        LocalDate checkDate = date.minusDays(i + 1);
	        if(pi[checkDate.getDayOfYear()] != null)
	        {
	            total += pi[checkDate.getDayOfYear()].getWage();
	        } 
	    }
	    for(int i = 0; i< daysAfter; i++)
	    {
	        LocalDate checkDate = date.plusDays(i + 1);
	        if(pi[checkDate.getDayOfYear()] != null) 
	        {
	            total += pi[checkDate.getDayOfYear()].getWage();
	        }
	        
	    }
	    return total;
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
	
	public void insertPaymentInfo(int year, PaymentInfo pi, int dayOfYear)
	{
	    PaymentInfo[] paymentInfoArray = paymentInfos.get(year);
	    paymentInfoArray[dayOfYear] = pi;
	}
	
	public PaymentInfo[] getPaymentInfo(int year)
	{
	    return paymentInfos.get(year);
	}
}
