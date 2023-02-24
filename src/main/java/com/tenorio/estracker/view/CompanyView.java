package com.tenorio.estracker.view;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import com.tenorio.estracker.model.AddEmployeeModel;
import com.tenorio.estracker.model.CompanyModel;
import com.tenorio.estracker.model.EditEmpBtnModel;
import com.tenorio.estracker.model.Employee;
import com.tenorio.estracker.model.EnterHoursBtnModel;
import com.tenorio.estracker.model.ReportBtnModel;
import com.tenorio.estracker.model.table.EmployeeTableModel;
import com.tenorio.estracker.controller.AddEmployeeController;
import com.tenorio.estracker.controller.EditEmpBtnContoller;
import com.tenorio.estracker.controller.EnterHoursBtnController;
import com.tenorio.estracker.controller.ReportBtnController;
import com.tenorio.estracker.gbc.GridBagHelper;

public class CompanyView extends JPanel
{

    /**
     * Automatically Generated
     */
    private static final long serialVersionUID = -4008971674125794586L;
    CompanyModel company;
    ArrayList<Employee> employees;
    EmployeeTableModel  empTableM;
    EmployeesTableView empTableV;
    private JFrame parentFrame;
    
    public CompanyView(CompanyModel cModel, ArrayList<Employee> employees, JFrame parent)
    {
        parentFrame = parent;
        company = cModel;
        this.employees = employees;
        
        Border blackline = BorderFactory.createLineBorder(Color.black);
        TitledBorder companyBorder = BorderFactory.createTitledBorder(blackline, company.getCompanyName());
        setBorder(companyBorder);
        
        setLayout(new GridBagLayout());
        
        GridBagConstraints  empTableGBC =  GridBagHelper.getTableConstraints();
        empTableM = new EmployeeTableModel(employees);
        empTableV = new EmployeesTableView(empTableM);
        //TODO: Add Controller maybe?
        add(empTableV, empTableGBC);
        
        addReportBtn();
        addEditEmpBtn();
        addEnterHrsBtn();
        
        addEmployeePnl();
        //Create Border DONE
        //GUI Layout DONE
        //Add Table View gridy = 0 DONE
        //Add Button Views gridy = 1, gridx 0, 1, 2 DONE
        //Add addEmployee View gridy = 2
        
    }

    
    

    private void addReportBtn()
    {
        GridBagConstraints  getReportGBC = GridBagHelper.getGetReportConstraints();
        ReportBtnModel      reportBtnM = new ReportBtnModel(empTableM);
        ReportBtnView       reportBtnV = new ReportBtnView(reportBtnM);
        new ReportBtnController(reportBtnM, reportBtnV);
        add(reportBtnV, getReportGBC);
    }
    private void addEditEmpBtn()
    {
        GridBagConstraints   editEmpGBC  = GridBagHelper.getEditEmpConstraints();
        EditEmpBtnModel      editEmpBtnM = new EditEmpBtnModel(empTableM, empTableV);
        EditEmpBtnView       editEmpBtnV = new EditEmpBtnView(editEmpBtnM, parentFrame);
        new EditEmpBtnContoller(editEmpBtnM, editEmpBtnV);
        add(editEmpBtnV, editEmpGBC);
    }
    private void addEnterHrsBtn()
    {
        GridBagConstraints      enterHoursGBC  = GridBagHelper.getEnterHoursConstraints();
        EnterHoursBtnModel      enterHrsBtnM = new EnterHoursBtnModel(empTableM);
        EnterHoursBtnView       enterHrsBtnV = new EnterHoursBtnView(enterHrsBtnM);
        new EnterHoursBtnController(enterHrsBtnM, enterHrsBtnV);
        add(enterHrsBtnV, enterHoursGBC);
        
    }

    private void addEmployeePnl()
    {
        GridBagConstraints addEmpGBC = GridBagHelper.getAddEmpConstraints();
        AddEmployeeModel    addEmpM  = new AddEmployeeModel(empTableM);
        AddEmployeeView     addEmpV  = new AddEmployeeView(addEmpM, parentFrame);
        new AddEmployeeController(addEmpM, addEmpV);
        add(addEmpV, addEmpGBC);
    }

}
