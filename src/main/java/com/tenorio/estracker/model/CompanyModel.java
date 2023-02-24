package com.tenorio.estracker.model;

import java.util.ArrayList;

public class CompanyModel
{
	private String companyName;
	private ArrayList<Employee> employees;
	
	public CompanyModel()
	{
	    companyName = "CompanyName";
	    employees = new ArrayList<Employee>();
	}
	
	public CompanyModel(String companyName)
	{
		this.companyName = companyName;
		employees = new ArrayList<>();
	}

	public String getCompanyName()
	{
		return companyName;
	}

	public void setCompanyName(String companyName)
	{
		this.companyName = companyName;
	}

	public ArrayList<Employee> getEmployees()
	{
		return employees;
	}
	
	public void addEmployee(Employee newEmployee)
	{
		employees.add(newEmployee);
	}
	
}
