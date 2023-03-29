package com.tenorio.estracker.model.table;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.tenorio.estracker.model.Employee;

public class EmployeeTableModel extends AbstractTableModel {
	private ArrayList<Employee> employees;
	/**
	 * 
	 */
	private static final long serialVersionUID = 2105862940060058643L;
	public EmployeeTableModel(ArrayList<Employee> employees)
	{
		super();
		this.employees = employees;
	}

	@Override
	public int getRowCount() {
		return employees.size();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		String value = "";
		
		Employee emp = employees.get(rowIndex);
		switch(columnIndex)
		{
		case 0:
			value += emp.getName();
			break;
		case 1:
			value += emp.getWage();
			break;
		case 2:
			value += ""  + emp.getWeeklyPay(LocalDate.now());
		}
		
		return value;
	}
	
	public void addEmployee(Employee employee)
	{
		employees.add(employee);
		fireTableRowsInserted(employees.size() - 1,employees.size()-1);
	}
	
	public void editEmployee(int rowIndex, int columnIndex, Employee emp)
	{
	    employees.set(rowIndex, emp);
	    fireTableRowsUpdated(rowIndex, rowIndex);
	}
	
	public void deleteEmployee(int rowIndex)
	{
	    employees.remove(rowIndex);
	    fireTableRowsDeleted(rowIndex, rowIndex);
	}
	
	public void paymentInfoChange(int rowindex)
	{  
	    fireTableRowsUpdated(rowindex, rowindex);;
	}
	
	public ArrayList<Employee> getEmployees()
	{
	    return employees;
	}
}
