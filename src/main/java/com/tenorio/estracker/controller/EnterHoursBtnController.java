package com.tenorio.estracker.controller;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.tenorio.estracker.model.Employee;
import com.tenorio.estracker.model.EnterHoursBtnModel;
import com.tenorio.estracker.model.table.EmployeeWageTableModel;
import com.tenorio.estracker.view.EnterHoursBtnView;

public class EnterHoursBtnController
{
    private EnterHoursBtnModel enterHrsBtnM;
    private EnterHoursBtnView enterHrsBtnV;
    private ArrayList<Employee> employees;
    public EnterHoursBtnController(EnterHoursBtnModel enterHrsBtnM, EnterHoursBtnView enterHrsBtnV) {
        this.setEnterHrsBtnM(enterHrsBtnM);
        this.setEnterHrsBtnV(enterHrsBtnV);
        setEmployees(enterHrsBtnM.getEmpTableM().getEmployees());
        enterHrsBtnV.addEnterHoursListener(new EnterHoursListener());
    }
    public EnterHoursBtnModel getEnterHrsBtnM()
    {
        return enterHrsBtnM;
    }
    public void setEnterHrsBtnM(EnterHoursBtnModel enterHrsBtnM)
    {
        this.enterHrsBtnM = enterHrsBtnM;
    }
    public EnterHoursBtnView getEnterHrsBtnV()
    {
        return enterHrsBtnV;
    }
    public void setEnterHrsBtnV(EnterHoursBtnView enterHrsBtnV)
    {
        this.enterHrsBtnV = enterHrsBtnV;
    }
    public ArrayList<Employee> getEmployees()
    {
        return employees;
    }
    public void setEmployees(ArrayList<Employee> employees)
    {
        this.employees = employees;
    }
    class EnterHoursListener implements ActionListener{

        JTable empWagesTable;
        @Override
        public void actionPerformed(ActionEvent e)
        {
            // TODO Create a Dialog with a table of employee names and a blank field for employee
            JDialog enterEmpWagesDlg = new JDialog();
            enterEmpWagesDlg.setLayout(new GridBagLayout());
            GridBagConstraints tableGBC = new GridBagConstraints();
            GridBagConstraints submitBtnGBC = new GridBagConstraints();
            submitBtnGBC.gridy = 1;
            submitBtnGBC.gridx = 0;
            GridBagConstraints enterHrsBtnGBC = new GridBagConstraints();
            enterHrsBtnGBC.gridx = 1;
            enterHrsBtnGBC.gridy = 1;
            enterEmpWagesDlg.setSize(500,500);
            EmployeeWageTableModel empWageTM = new EmployeeWageTableModel(enterHrsBtnM.getEmpTableM().getEmployees());
            empWagesTable  = new JTable(empWageTM);
            JScrollPane empWagesTableSP = new JScrollPane(empWagesTable);
            //Submit Wages button should change arrayList and potentially weekly Wage field in table
            JButton submitWagesBtn = new JButton("Submit");
            //Enter Wages Button opens dialog
            JButton enterWageBtn = new JButton("Enter Wage");
            enterWageBtn.addActionListener(new EnterWagesListener());
            //Enter Button should change EmpWagesTable and employeeArraList by changing payment Info
           
            submitWagesBtn.addActionListener(new SubmitWagesListener());
            enterEmpWagesDlg.add(empWagesTableSP, tableGBC);
            enterEmpWagesDlg.add(enterWageBtn, enterHrsBtnGBC);
            enterEmpWagesDlg.add(submitWagesBtn, submitBtnGBC);
            enterEmpWagesDlg.setVisible(true);
            
        }
        
        class SubmitWagesListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e)
            {
                //Should submit info to employees arraylist then
                LocalDate date = LocalDate.now();
            }
            
        }
        
        class EnterWagesListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e)
            {
                // TODO Should Create JDialog w Name and Field for Employee
                JDialog enterWageDlg = new JDialog();
                enterWageDlg.setSize(500, 500);
                enterWageDlg.setLayout(new GridBagLayout());
                GridBagConstraints nameLGBC = new GridBagConstraints();
                GridBagConstraints wageTFGBC = new GridBagConstraints();
                wageTFGBC.gridx = 1;
                GridBagConstraints submitBtnGBC = new GridBagConstraints();
                submitBtnGBC.gridy = 1;
                JLabel nameLabel = new JLabel((String)empWagesTable.getValueAt(empWagesTable.getSelectedRow(), 0));
                JTextField wageTextField = new JTextField((String)empWagesTable.getValueAt(empWagesTable.getSelectedRow(), 1), 15);
                //submit Button should change EmpWagesTable and employeeArraList by changing payment Info
                JButton submitButton = new JButton("Submit");
                
                enterWageDlg.add(nameLabel, nameLGBC);
                enterWageDlg.add(wageTextField, wageTFGBC);
                enterWageDlg.add(submitButton, submitBtnGBC);
                enterWageDlg.setVisible(true);
                
            }
            
        }
    }

}
