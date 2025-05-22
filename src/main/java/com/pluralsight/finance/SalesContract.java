package com.pluralsight.finance;

import com.pluralsight.Vehicle;

public class SalesContract extends Contract{
    private final double salesTaxAmount = 0.05;
    private final double recordingFee = 100;
    private double processingFee;
    private boolean financeOption;

    public SalesContract(String contractDate, String name, String email, Vehicle vehicleSold, double totalPrice, double monthlyPayment, double processingFee, boolean financeOption) {
        super(contractDate, name, email, vehicleSold, totalPrice, monthlyPayment);
        this.processingFee = processingFee;
        this.financeOption = financeOption;
    }

    public double getSalesTaxAmount() {
        return salesTaxAmount;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinanceOption() {
        return financeOption;
    }

    public void setFinanceOption(boolean financeOption) {
        this.financeOption = financeOption;
    }

    @Override
    public double getTotalPrice() {
        return getVehicleSold().getPrice() + salesTaxAmount + recordingFee + processingFee;
    }

    @Override
    public double getMonthlyPayment() {
        int numberOfPayments = 0;
        double interestRate = 0;
        if (financeOption) {
            if (getVehicleSold().getPrice() >= 10000) {
                numberOfPayments = 48;
                interestRate = 4.25 / 1200;
            } else {
                numberOfPayments = 24;
                interestRate = 5.25 / 1200;
            }

            double monthlyPayment = getTotalPrice() * (interestRate * Math.pow(1 + interestRate, numberOfPayments)) / (Math.pow(1 + interestRate, numberOfPayments) - 1);
            monthlyPayment = Math.round(monthlyPayment * 100);
            monthlyPayment /= 100;
            return monthlyPayment;
        } else {
            return 0.0;
        }
    }
}
//
//A SalesContract will include the following additional information:
//        • Sales Tax Amount (5%)
//• Recording Fee ($100)
//• Processing fee ($295 for vehicles under $10,000 and $495 for all others
//        • Whether they want to finance (yes/no)
//• Monthly payment (if financed) based on:
//        • All loans are at 4.25% for 48 months if the price is $10,000 or more
//• Otherwise they are at 5.25% for 24 month
//Methods will include a constructor and getters and setters for all fields except
//total price and monthly payment. You should provide overrides for
//getTotalPrice() and getMonthlyPayment() that will return computed values
//based on the rules above. It is possible that getMonthlyPayment() would return
//        0 if they chose the NO loan option.
