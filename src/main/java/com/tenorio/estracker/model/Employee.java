package com.tenorio.estracker.model;

public class Employee 
{
	
	private String name;
	private double salary;
	private double weeklyPay;
	
	public Employee(String name, double salary) 
	{
		this.name = name;
		this.salary = salary;
		setWeeklyPay(0);
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public double getSalary() 
	{
		return salary;
	}

	public void setSalary(double salary) 
	{
		this.salary = salary;
	}

	public double getWeeklyPay() {
		return weeklyPay;
	}

	public void setWeeklyPay(double weeklyPay) {
		this.weeklyPay = weeklyPay;
	}
}
