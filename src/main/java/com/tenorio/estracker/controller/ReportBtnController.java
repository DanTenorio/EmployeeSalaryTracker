package com.tenorio.estracker.controller;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JLabel;

import com.tenorio.estracker.model.Employee;
import com.tenorio.estracker.model.ReportBtnModel;
import com.tenorio.estracker.model.table.EmployeeTableModel;
import com.tenorio.estracker.model.util.EmployeeUtil;
import com.tenorio.estracker.view.ReportBtnView;

public class ReportBtnController
{
    private ReportBtnModel  reportBtnM;
    private ReportBtnView   reportBtnV;
    public ReportBtnController(ReportBtnModel reportBtnM, ReportBtnView reportBtnV)
    {
        this.setReportBtnM(reportBtnM);
        this.setReportBtnV(reportBtnV);
        
        reportBtnV.addGetReportListener(new getReportListener());
    }
    public ReportBtnModel getReportBtnM()
    {
        return reportBtnM;
    }
    public void setReportBtnM(ReportBtnModel reportBtnM)
    {
        this.reportBtnM = reportBtnM;
    }
    public ReportBtnView getReportBtnV()
    {
        return reportBtnV;
    }
    public void setReportBtnV(ReportBtnView reportBtnV)
    {
        this.reportBtnV = reportBtnV;
    }
    
    public class getReportListener implements ActionListener
    {
        JDialog reportDlg;
        @Override
        public void actionPerformed(ActionEvent e)
        {
            // TODO: Create A dialog to show report
            EmployeeTableModel ETM = reportBtnM.getEmpTableM();
            ArrayList<Employee> emps = ETM.getEmployees();
            double mnthExpense = 0;
            double qrtrExpense = 0;
            double yrExpense = 0;
            for(int i = 0; i < emps.size(); i++)
            {
                Employee emp = emps.get(i);
                
                mnthExpense += EmployeeUtil.getMonthlyExpense(emp, LocalDate.now());
                qrtrExpense += EmployeeUtil.getQuarterlyExpense(emp, LocalDate.now());
                yrExpense += EmployeeUtil.getYearlyExpense(emp, LocalDate.now());
            }
            reportDlg = new JDialog();
            JLabel monthlyExpense = new JLabel("Monthly Expense "  + mnthExpense);
            JLabel quarterlyExpense = new JLabel("Quarterly Expense" + qrtrExpense);
            JLabel yearlyExpense = new JLabel("Yearly Expense" + yrExpense);
            reportDlg.setLayout(new GridBagLayout());
            reportDlg.add(monthlyExpense, getMonthlyExpenseGBC());
            reportDlg.add(quarterlyExpense, getQuarterlyExpenseGBC());
            reportDlg.add(yearlyExpense, getYearlyExpenseGBC());
            
            reportDlg.pack();
            reportDlg.setVisible(true);
            
        }
        
        private GridBagConstraints getMonthlyExpenseGBC() 
        {
            GridBagConstraints GBC = new GridBagConstraints();
            GBC.fill = GridBagConstraints.HORIZONTAL;
            return GBC;
        }
        
        private GridBagConstraints getQuarterlyExpenseGBC()
        {
            GridBagConstraints GBC = new GridBagConstraints();
            GBC.fill = GridBagConstraints.HORIZONTAL;
            GBC.gridy = 1;
            return GBC;
        }
        private GridBagConstraints getYearlyExpenseGBC()
        {
            GridBagConstraints GBC = new GridBagConstraints();
            GBC.fill = GridBagConstraints.HORIZONTAL;
            GBC.gridy = 2;
            return GBC;
        }
        
    }

}
