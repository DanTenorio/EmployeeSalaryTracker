package com.tenorio.estracker.model;


import java.time.*;

public class PaymentInfo
{

    private LocalDate localDate;
    private double hrsWorked;
    private double wage;

    public PaymentInfo(LocalDate date, double hrsWorked, double wage)
    {
        this.setLocalDate(date);
        this.setHrsWorked(hrsWorked);
        this.setWage(wage);
    }
    public PaymentInfo(double hrsWorked, double wage)
    {
       this(LocalDate.now(), hrsWorked, wage);
    }
    public double getHrsWorked()
    {
        return hrsWorked;
    }
    public void setHrsWorked(double hrsWorked)
    {
        this.hrsWorked = hrsWorked;
    }
    public double getWage()
    {
        return wage;
    }
    public void setWage(double wage)
    {
        this.wage = wage;
    }
    public double getPayment()
    {
        return hrsWorked * wage;
    }
    public LocalDate getLocalDate()
    {
        return localDate;
    }
    public void setLocalDate(LocalDate localDate)
    {
        this.localDate = localDate;
    }
}
