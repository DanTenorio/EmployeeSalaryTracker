package com.tenorio.estracker.view.table;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.tenorio.estracker.model.Employee;

public class EmployeeTableModel extends AbstractTableModel {
	private ArrayList<Employee> employees;

	/**
	 * 
	 */
	private static final long serialVersionUID = 2105862940060058643L;
	EmployeeTableModel(Object[][] data, String[] columnNames)
	{
		super();
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
			
		
		return null;
	}

}
