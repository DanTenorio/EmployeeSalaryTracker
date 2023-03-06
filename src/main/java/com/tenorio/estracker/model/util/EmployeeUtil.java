package com.tenorio.estracker.model.util;

import java.time.LocalDate;
import java.time.Month;

import com.tenorio.estracker.model.Employee;
import com.tenorio.estracker.model.PaymentInfo;

public class EmployeeUtil
{
    private EmployeeUtil() {}
    
    public static double getMonthlyExpense(Employee emp, LocalDate date)
    {
        double expense = 0.0;
        
        PaymentInfo[] pis = emp.getPaymentInfos(date.getYear());
        int curDay = date.getDayOfMonth();
        
        //Checks days before the current Day
        for(int i = 1; i < curDay; i++)
        {
            LocalDate checkDate = date.minusDays(i);
            PaymentInfo pi = pis[checkDate.getDayOfYear()];
            if(pi != null)
            {
                expense += pi.getPayment();
            }
        }
        
        //Checks days after current Day
        LocalDate checkDate = date.plusDays(1);
        Month month = date.getMonth();
        boolean sameMonth = checkDate.getMonth() == month;
        
        while(sameMonth)
        {
            PaymentInfo pi = pis[checkDate.getDayOfYear()];
            if(pi!=null)
            {
                expense += pi.getPayment();
            }
            checkDate = checkDate.plusDays(1);
            sameMonth = checkDate.getMonth() == month;
        }
           
        PaymentInfo pi = pis[date.getDayOfYear()];
        if(pi != null)
        {
            expense += pi.getPayment();
        }
        
        return expense;
    }
    
    public static double getMonthlyExpense(Employee emp, int month, int year)
    {
        LocalDate date = LocalDate.of(year, month, 1);
        
        return getMonthlyExpense(emp, date);
    }
    
    /**
     * This method gets quarterly expense from a date
     * 
     * Subtracts the month value by 1 to make integer division work 
     * 
     * @param emp Employee that we're retrieving
     * @param date LocalDate that we are checking
     * @return double that represents the quarterly expense for the company for an employee
     */
    public static double getQuarterlyExpense(Employee emp, LocalDate date)
    {
        int month = date.getMonthValue() - 1;
        
        return getQuarterlyExpense(emp, month/3 + 1, date.getYear());
    }
    
    public static double getQuarterlyExpense(Employee emp, int quarter, int year)
    {
        double expense = 0;
        int month = (quarter * 3);
        for(int i = 0; i < 3; i++)
        {
            expense += getMonthlyExpense(emp, month, year);
            month--;
        }
        
        return expense;
    }
    
    
    public static double getYearlyExpense(Employee emp, int year)
    {
        double expense = 0;
        
        for(int i = 0; i < 4; i++)
        {
            expense += getQuarterlyExpense(emp, i + 1, year);
        }
        
        return expense;
    }
    
    public static double getYearlyExpense(Employee emp, LocalDate date)
    {
        return getYearlyExpense(emp, date.getYear());
    }
}
