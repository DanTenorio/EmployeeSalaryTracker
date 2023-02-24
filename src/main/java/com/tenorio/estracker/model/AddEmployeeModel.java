package com.tenorio.estracker.model;

import com.tenorio.estracker.model.table.EmployeeTableModel;

public class AddEmployeeModel
{
    private EmployeeTableModel empTableM;
    public AddEmployeeModel(EmployeeTableModel empTableM) {
        this.setEmpTableM(empTableM);
    }
    public EmployeeTableModel getEmpTableM()
    {
        return empTableM;
    }
    public void setEmpTableM(EmployeeTableModel empTableM)
    {
        this.empTableM = empTableM;
    }

}
