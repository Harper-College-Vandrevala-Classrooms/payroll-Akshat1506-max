package com.csc;

import java.util.Scanner;

public class Payroll {

    private static final double REGULAR_HOURLY_RATE = 16.78;
    private static final double OVERTIME_RATE = REGULAR_HOURLY_RATE * 1.5;
    private static final double SOCIAL_SECURITY_TAX = 0.06;
    private static final double FEDERAL_TAX = 0.14;
    private static final double STATE_TAX = 0.05;
    private static final double UNION_DUES = 10.00;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Payroll Program!");

        // Get hours worked from the user
        System.out.print("How many hours did you work this week? ");
        double hoursWorked = scanner.nextDouble();

        // Get the number of dependents from the user
        System.out.print("How many children do you have? ");
        int dependents = scanner.nextInt();

        // Generate the payroll report
        generatePayrollReport(hoursWorked, dependents);

        // Exit message
        System.out.println("Goodbye!");
        scanner.close();
    }

    // Calculate gross pay with overtime handling
    public static double calculateGrossPay(double hoursWorked) {
        if (hoursWorked <= 40) {
            return hoursWorked * REGULAR_HOURLY_RATE;
        } else {
            double overtimeHours = hoursWorked - 40;
            return (40 * REGULAR_HOURLY_RATE) + (overtimeHours * OVERTIME_RATE);
        }
    }

    // Calculate insurance based on the number of dependents
    public static double calculateInsurance(int dependents) {
        return dependents >= 3 ? 35.00 : 15.00;
    }

    // Calculate total deductions (taxes, union dues, and insurance)
    public static double calculateDeductions(double grossPay, int dependents) {
        double insurance = calculateInsurance(dependents);
        return (grossPay * SOCIAL_SECURITY_TAX) + 
               (grossPay * FEDERAL_TAX) + 
               (grossPay * STATE_TAX) + UNION_DUES + insurance;
    }

    // Calculate net pay after all deductions
    public static double calculateNetPay(double grossPay, double deductions) {
        return grossPay - deductions;
    }

    // Generate the payroll report with all relevant information
    public static void generatePayrollReport(double hoursWorked, int dependents) {
        double grossPay = calculateGrossPay(hoursWorked);
        double deductions = calculateDeductions(grossPay, dependents);
        double netPay = calculateNetPay(grossPay, deductions);

        System.out.println("Payroll Stub:");
        System.out.printf("   Hours: %.2f%n", hoursWorked);
        System.out.printf("    Rate: %.2f $/hr%n", REGULAR_HOURLY_RATE);
        System.out.printf("   Gross: $%.2f%n", grossPay);
        System.out.printf("  SocSec: $%.2f%n", grossPay * SOCIAL_SECURITY_TAX);
        System.out.printf("  FedTax: $%.2f%n", grossPay * FEDERAL_TAX);
        System.out.printf("   StTax: $%.2f%n", grossPay * STATE_TAX);
        System.out.printf("   Union: $%.2f%n", UNION_DUES);
        System.out.printf("     Ins: $%.2f%n", calculateInsurance(dependents));
        System.out.printf("     Net: $%.2f%n", netPay);
    }
}