package com.tenorio.estracker.model;


public class ESTModel
{
	CompanyModel company;
	
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
		company = new CompanyModel(companyName);
	}

	public CompanyModel getCompany()
	{
		return company;
	}
}
