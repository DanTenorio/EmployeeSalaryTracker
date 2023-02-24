package com.tenorio.estracker.model;

import com.tenorio.estracker.model.table.EmployeeTableModel;
import com.tenorio.estracker.view.EmployeesTableView;

public class EditEmpBtnModel
{
    private EmployeeTableModel empTableM;
    private EmployeesTableView empTableV;
    public EditEmpBtnModel(EmployeeTableModel empTableM, EmployeesTableView empTableV) {
        this.setEmpTableM(empTableM);
        this.setEmpTableV(empTableV);
    }
    public EmployeeTableModel getEmpTableM()
    {
        return empTableM;
    }
    public void setEmpTableM(EmployeeTableModel empTableM)
    {
        this.empTableM = empTableM;
    }
    public EmployeesTableView getEmpTableV()
    {
        return empTableV;
    }
    public void setEmpTableV(EmployeesTableView empTableV)
    {
        this.empTableV = empTableV;
    }

}
