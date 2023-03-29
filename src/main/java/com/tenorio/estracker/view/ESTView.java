package com.tenorio.estracker.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.*;
import com.tenorio.estracker.controller.*;
import com.tenorio.estracker.model.*;

public class ESTView extends JFrame
{
    /**
     * 
     */
    private static final long serialVersionUID = -1899009042922694604L;
    CompanyModel company;
    ArrayList<Employee> employees;

    public ESTView(ESTModel estModel) {
        company = estModel.getCompany();
        employees = company.getEmployees();
        setLayout(new GridBagLayout());
        setName("Employee Salary Tracker");
        setTitle("Employee Salary Tracker ");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    

        MenuBarView menuBarView = new MenuBarView();
        GridBagConstraints menuBargbc = new GridBagConstraints();
        menuBargbc.gridx = 0;
        menuBargbc.gridy = 0;
        menuBargbc.gridwidth = 3;
        menuBargbc.fill = GridBagConstraints.HORIZONTAL;
        menuBargbc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(menuBarView, menuBargbc);
        new MenuBarController(menuBarView);

        GridBagConstraints mainPanelgbc = new GridBagConstraints();
        mainPanelgbc.gridy = 1;
        mainPanelgbc.gridwidth = 3;
        mainPanelgbc.gridheight=2;
        mainPanelgbc.fill = GridBagConstraints.HORIZONTAL;
//        add(mainPanel, mainPanelgbc);
        CompanyModel companyM = new CompanyModel();
        CompanyView companyV = new CompanyView(companyM, employees, this);
        add(companyV, mainPanelgbc);

        
        pack();
    }

}
