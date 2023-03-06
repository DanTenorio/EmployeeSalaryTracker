package com.tenorio.estracker.model;

import com.tenorio.estracker.model.table.EmployeeTableModel;

public class ReportBtnModel
{
    private EmployeeTableModel empTableM;
    public ReportBtnModel(EmployeeTableModel etl)
    {
        setEmpTableM(etl);
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
