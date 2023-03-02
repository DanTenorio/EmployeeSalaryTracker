package com.tenorio.estracker.model.table;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.tenorio.estracker.model.Employee;

public class EmployeeWageTableModel extends AbstractTableModel
{
    private ArrayList<Employee> employees;
    private ArrayList<Double> employeeWages;
    /**
     * 
     */
    private static final long serialVersionUID = 4326797898800165445L;
    public EmployeeWageTableModel(ArrayList<Employee> employees)
    {
        this.employees = employees;
        this.employeeWages = new ArrayList<>();
        for(int i = 0; i < employees.size(); i++)
        {
            employeeWages.add(Double.valueOf(0.0));
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
        } else if(employeeWages.get(rowIndex) != null ){
            return employeeWages.get(rowIndex);
        }else {
            return employeeWages.get(rowIndex);
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
        employeeWages.set(rowIndex, Double.valueOf(val));
        fireTableCellUpdated(rowIndex, columnIndex);
    }
    
    public void setValueAt(Double value, int row, int col)
    {
        employeeWages.set(row, value);
        fireTableCellUpdated(row, col);
    }

}
