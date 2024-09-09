package com.csc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestPayroll {

    Payroll payroll;

    @Test
    public void testGrossPayRegularHours() {
        assertEquals(671.20, Payroll.calculateGrossPay(40), 0.01);
    }

    @Test
    public void testGrossPayOvertime() {
        assertEquals(721.54, Payroll.calculateGrossPay(42), 0.01);
    }

    @Test
    public void testInsuranceWithThreeDependents() {
        assertEquals(35.00, Payroll.calculateInsurance(3), 0.01);
    }

    @Test
    public void testInsuranceWithLessThanThreeDependents() {
        assertEquals(15.00, Payroll.calculateInsurance(2), 0.01);
    }

    @Test
    public void testDeductions() {
        double grossPay = 754.91;
        assertEquals(213.73, Payroll.calculateDeductions(grossPay, 2), 0.01);  // Updated expected value
    }

    @Test
    public void testNetPay() {
        double grossPay = 754.91;
        double deductions = 213.73;
        assertEquals(541.18, Payroll.calculateNetPay(grossPay, deductions), 0.01);
    }
}