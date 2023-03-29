package com.tenorio.estracker.view;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;

import com.tenorio.estracker.model.table.EmployeeTableModel;

public class EmployeesTableView extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4578226204277124712L;
	
	private JTable employeeTable;
	public EmployeesTableView(EmployeeTableModel etl)
	{
	    Border blackline = BorderFactory.createLineBorder(Color.black);
	    setBorder(blackline);
		employeeTable 	= new JTable(etl);
		JScrollPane tablePane 		= new JScrollPane(employeeTable);

		add(tablePane);
	}
    public JTable getEmployeeTable()
    {
        return employeeTable;
    }
    public void setEmployeeTable(JTable employeeTable)
    {
        this.employeeTable = employeeTable;
    }
	
}
