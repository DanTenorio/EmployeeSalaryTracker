package com.tenorio.estracker.view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.tenorio.estracker.model.AddEmployeeModel;

public class AddEmployeeView extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1589817958580005093L;
	private JLabel 		newEmployeeNameLabel;
	private JTextField 	newEmployeeField;
	private JTextField	newEmployeeWageField;
	private JLabel 		newEmployeeWageLabel;
	private JButton		addEmployeeBtn;
	private JFrame      parentFrame;
	
	public AddEmployeeView(AddEmployeeModel addEmpM, JFrame parent)
	{
	    setParentFrame(parent);
		newEmployeeNameLabel= new JLabel("Name:");
		newEmployeeField	= new JTextField(10);
		newEmployeeWageLabel= new JLabel("Wage");
		newEmployeeWageField= new JTextField(10);
		addEmployeeBtn		= new JButton("Add Employee");
		
		add(newEmployeeNameLabel);
		add(newEmployeeField);
		add(newEmployeeWageLabel);
		add(newEmployeeWageField);
		add(addEmployeeBtn);
	}
	
	public void addAddEmployeeListener(ActionListener ael)
	{
		addEmployeeBtn.addActionListener(ael);
	}
	
	public String getEmployeeName()
	{
		return newEmployeeField.getText();
	}
	
	public String getEmployeeWage()
	{
		return newEmployeeWageField.getText();
	}

    public JFrame getParentFrame()
    {
        return parentFrame;
    }

    public void setParentFrame(JFrame parentFrame)
    {
        this.parentFrame = parentFrame;
    }
	
	
}
