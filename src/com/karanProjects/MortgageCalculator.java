package com.karanProjects;

import java.text.DecimalFormat;

public class MortgageCalculator {
    private double amount;
    private double intrestRate;
    private int months;
    private int numberOfInstallment;

    public double fixedRate(){
        double q =1+((intrestRate/100)/months);
        return  amount*Math.pow(q,numberOfInstallment*months)*(q-1)/(Math.pow(q,numberOfInstallment*months)-1);
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setIntrestRate(double intrestRate) {
        this.intrestRate = intrestRate;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public void setInstallment(int years) {
        this.numberOfInstallment = years;
    }
}
