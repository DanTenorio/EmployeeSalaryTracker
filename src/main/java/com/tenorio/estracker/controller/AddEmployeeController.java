package com.tenorio.estracker.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;

import com.tenorio.estracker.model.AddEmployeeModel;
import com.tenorio.estracker.model.Employee;
import com.tenorio.estracker.model.table.EmployeeTableModel;
import com.tenorio.estracker.view.AddEmployeeView;

public class AddEmployeeController
{
	AddEmployeeView view;
	AddEmployeeModel model;
	EmployeeTableModel etl;

	
	public AddEmployeeController(AddEmployeeModel model, AddEmployeeView view)
	{
	    this.view = view;
	    this.model = model;
	    view.addAddEmployeeListener(new addEmployeeListener());
	}

    class addEmployeeListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
		    if(validEmployee(view.getEmployeeName(), view.getEmployeeWage())) 
		    {
		        
		        model.getEmpTableM().addEmployee(new Employee(view.getEmployeeName(), Double.valueOf(view.getEmployeeWage())));
		    } else {
		        JDialog employeeErrDlg = new JDialog();
		        employeeErrDlg.setTitle("Employee Error");
		        employeeErrDlg.setSize(200, 200);
		        JLabel errLabel = new JLabel("Incorrect Employee Format");
		        employeeErrDlg.add(errLabel);
		        employeeErrDlg.setVisible(true);
		    }
		}

	}
	
	private boolean validEmployee(String empName, String empWage)
	{
	    empName = view.getEmployeeName();
	    empWage = view.getEmployeeWage();
	    
	    if(empName.isBlank())
	    {
	        return false;
	    }
	    
	    if(empWage.isBlank())
	    {
	        return false;
	    }
	    try
	    {
	        Double.parseDouble(empWage);
	    }catch(NumberFormatException nfe)
	    {
	        return false;
	    }
	    return true;
	}
}
