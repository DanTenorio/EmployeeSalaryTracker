package com.tenorio.estracker.controller;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import com.tenorio.estracker.model.Employee;
import com.tenorio.estracker.model.EnterHoursBtnModel;
import com.tenorio.estracker.model.PaymentInfo;
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
        EmployeeWageTableModel empWageTM;
        JDialog enterEmpWagesDlg;
        @Override
        public void actionPerformed(ActionEvent e)
        {
            // TODO Create a Dialog with a table of employee names and a blank field for employee
            enterEmpWagesDlg = new JDialog();
            enterEmpWagesDlg.setLayout(new GridBagLayout());
            GridBagConstraints tableGBC = new GridBagConstraints();
            GridBagConstraints submitBtnGBC = new GridBagConstraints();
            submitBtnGBC.gridy = 1;
            submitBtnGBC.gridx = 0;

            enterEmpWagesDlg.setSize(500,500);
            empWageTM = new EmployeeWageTableModel(enterHrsBtnM.getEmpTableM().getEmployees());
            empWagesTable  = new JTable(empWageTM);
            
//            empWagesTable = new JTable(2, 5);

            JScrollPane empWagesTableSP = new JScrollPane(empWagesTable);
            //Submit Wages button should change arrayList and potentially weekly Wage field in table
            JButton submitWagesBtn = new JButton("Submit");
            //Enter Wages Button opens dialog

            //Enter Button should change EmpWagesTable and employeeArraList by changing payment Info
           
            submitWagesBtn.addActionListener(new SubmitWagesListener());
            enterEmpWagesDlg.add(empWagesTableSP, tableGBC);

            enterEmpWagesDlg.add(submitWagesBtn, submitBtnGBC);
            enterEmpWagesDlg.setVisible(true);
            
        }
        
        /**
         * @author Daniel Tenorio
         * This Listener should implement changes to the company view table by inserting payment Info then calculating the weekly wage
         *
         */
        class SubmitWagesListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e)
            {
                //Create and insert payment info and calculate weekly pay for each Employee
                LocalDate date = LocalDate.now();
                
                for(int i = 0; i < employees.size(); i++)
                {
                   PaymentInfo pi = new PaymentInfo(date, empWageTM.getEmpHrsWorked().get(i), employees.get(i).getWage());
                   Employee emp = employees.get(i);
                   emp.insertPaymentInfo(date.getYear(), pi, date.getDayOfYear());
                   enterHrsBtnM.getEmpTableM().paymentInfoChange(i);
                   
                }
                enterEmpWagesDlg.dispose();
            }
            

        }
        
    }

}
