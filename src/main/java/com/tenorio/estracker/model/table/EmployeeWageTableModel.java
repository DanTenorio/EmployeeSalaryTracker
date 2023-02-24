package com.tenorio.estracker.model.table;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.tenorio.estracker.model.Employee;

public class EmployeeWageTableModel extends AbstractTableModel
{
    private ArrayList<Employee> employees;
    /**
     * 
     */
    private static final long serialVersionUID = 4326797898800165445L;
    public EmployeeWageTableModel(ArrayList<Employee> employees)
    {
        this.employees = employees;
    }
    
    @Override
    public int getRowCount()
    {
        return employees.size();
    }

    @Override
    public int getColumnCount()
    {
        
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        if(columnIndex == 0)
        {
            return employees.get(rowIndex).getName();
        } else {
            return null;
        }
    }

}
