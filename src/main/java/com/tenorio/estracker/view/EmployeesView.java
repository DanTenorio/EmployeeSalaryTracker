package com.tenorio.estracker.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.tenorio.estracker.model.Employee;
import com.tenorio.estracker.view.table.EmployeeTableModel;

public class EmployeesView extends JPanel{
	public EmployeesView(ArrayList<Employee> employees)
	{
		Object[][] data = getData(employees);
		String[] columnNames = {"Name","Wage","Weekly Pay"};
		
		JScrollPane tablePane 		= new JScrollPane();
		JTable employeeTable 		= new JTable(data, columnNames);
		
	}
	
	private Object[][] getData(ArrayList<Employee> emps)
	{
		Object[][] data = new Object[emps.size()][3];
		for(int i = 0; i < emps.size(); i++)
		{
			data[i][0] = emps.get(0);
			data[i][1] = emps.get(1);
			data[i][2] = emps.get(3);
		}
		return data;
	}
}
