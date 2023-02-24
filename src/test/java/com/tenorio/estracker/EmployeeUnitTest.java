package com.tenorio.estracker;

import org.junit.Before;
import org.junit.Test;

import com.tenorio.estracker.model.Employee;

import junit.framework.Assert;

public class EmployeeUnitTest
{
    Employee employee;

    @Before
    public void setUp() throws Exception
    {
        employee = new Employee("John", 20.50);
    }

    @Test
    public void testName()
    {
        Assert.assertEquals(employee.getName(), "John");
    }

}
