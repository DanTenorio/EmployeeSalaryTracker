package com.tenorio.estracker.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import com.tenorio.estracker.model.Company;
import com.tenorio.estracker.model.ESTModel;
import com.tenorio.estracker.model.Employee;

public class ESTView extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1899009042922694604L;

	public ESTView(ESTModel estModel)
	{
		
		Company company = estModel.getCompany();
		ArrayList<Employee> employees = company.getEmployees();
		
		setName("Employee Salary Tracker");
		setTitle("Employee Salary Tracker ");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800,600);
		
		add(new MenuBarView(), BorderLayout.NORTH);
		add(new EmployeesView(employees), BorderLayout.CENTER);
		
		
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridBagLayout());
		Border blackline = BorderFactory.createLineBorder(Color.black);
		TitledBorder companyBorder = BorderFactory.createTitledBorder(blackline, company.getCompanyName());
		mainPanel.setBorder(companyBorder);
		
		
		
		
		add(mainPanel);
	}
}
