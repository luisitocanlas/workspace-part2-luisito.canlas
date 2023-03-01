package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class HourlyEmployeeTest {
    // fixture
    private HourlyEmployee emp;

    @Before
    public void setUp() {
        emp = new HourlyEmployee("Lui", Date.valueOf("2019-06-03"), 44.0, 40.0);
    }

    @Test
    public void testPay() {
//        emp.pay();
        assertEquals(1760.0, emp.pay(), 0.01);
    }

    @Test
    public void testPayTaxes() {
//        emp.payTaxes();
        assertEquals(440.0, emp.payTaxes(), 0.01);
    }
}