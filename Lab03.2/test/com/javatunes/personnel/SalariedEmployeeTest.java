package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class SalariedEmployeeTest {
    // object under test - called a "fixture" in JUnit
    private SalariedEmployee emp;
    private SalariedEmployee emp2;

    @Before
    public void setUp() {
        emp  = new SalariedEmployee("Lui", Date.valueOf("2019-06-03"), 2200.0);
        emp2 = new SalariedEmployee("Lui", Date.valueOf("2019-06-03"), 2200.0);
    }

    @Test
    public void hashCode_equalObjects_mustHaveEqualHashCodes() {
        assertEquals(emp.hashCode(), emp2.hashCode());
    }

    @Test
    public void equals_shouldReturnFalse_differentName_sameHireDate_sameSalary() {
        emp2.setName("Lulu");

        assertNotEquals(emp, emp2);
    }

    @Test
    public void equals_shouldReturnFalse_sameName_differentHireDate_sameSalary () {
        emp2.setHireDate(Date.valueOf("2020-01-01"));

        assertNotEquals(emp, emp2);
    }

    @Test
    public void equals_shouldReturnFalse_sameName_sameHireDate_differentSalary() {
        emp2.setSalary(1800.0);

        assertNotEquals(emp, emp2);
    }

    @Test
    public void equals_shouldReturnTrue_allPropertiesSame() {
        assertEquals(emp, emp2);
    }

    @Test
    public void testPay() {
        assertEquals(2200.0, emp.pay(), 0.01);
    }

    @Test
    public void testPayTaxes() {
        assertEquals(660.0, emp.payTaxes(), 0.01);
    }
}