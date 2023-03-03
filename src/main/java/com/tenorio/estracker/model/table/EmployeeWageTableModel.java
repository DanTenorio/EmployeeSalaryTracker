package com.tenorio.estracker.model.table;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.tenorio.estracker.model.Employee;

public class EmployeeWageTableModel extends AbstractTableModel
{
    private ArrayList<Employee> employees;
    private ArrayList<Double> employeeHrsWorked;
    /**
     * 
     */
    private static final long serialVersionUID = 4326797898800165445L;
    public EmployeeWageTableModel(ArrayList<Employee> employees)
    {
        this.employees = employees;
        this.employeeHrsWorked = new ArrayList<>();
        for(int i = 0; i < employees.size(); i++)
        {
            employeeHrsWorked.add(Double.valueOf(0.0));
        }
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
        }else {
            return employeeHrsWorked.get(rowIndex);
        }
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return columnIndex == 1;
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        String val = aValue.toString();
        employeeHrsWorked.set(rowIndex, Double.valueOf(val));
        fireTableCellUpdated(rowIndex, columnIndex);
    }
    
    
    public ArrayList<Double> getEmpHrsWorked()
    {
        return employeeHrsWorked;
    }
    

}
