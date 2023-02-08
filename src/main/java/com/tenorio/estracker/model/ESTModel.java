package com.tenorio.estracker.model;


public class ESTModel
{
	Company company;
	
	public ESTModel()
	{
		this("Company Name");
	}
	
	public ESTModel(String companyName)
	{
		setCompany(companyName);
	}
	
	public String toString()
	{
		return company.getCompanyName();
	}
	
	public void setCompany(String companyName)
	{
		company = new Company(companyName);
	}

	public Company getCompany()
	{
		return company;
	}
}
