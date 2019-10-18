package com.karanProjects;

import java.text.DecimalFormat;

public class MortgageCalculator {
    private double amount;
    private double intrestRate;
    private final int months;
    private int yearsOfInstallments;


    private MortgageCalculator(double amount, double intrestRate, int yearsOfInstallments){
        this.amount=amount;
        this.intrestRate=intrestRate;
        this.months=12;
        this.yearsOfInstallments=yearsOfInstallments;

    }
    public static class Builder{
        private double amount;
        private double intrestRate;
        private int months = 12;
        private int yearsOfInstallments;

        public Builder(){
        }
        public Builder setAmount(double amount){
            this.amount = amount;
            return this;
        }
        public Builder setIntrestRate(double intrestRate){
            this.intrestRate = intrestRate;
            return this;
        }
        public Builder setYearsOfInstallment(int yearsOfInstallments){
            this.yearsOfInstallments=yearsOfInstallments;
            return this;
        }
        public MortgageCalculator build(){
            return new MortgageCalculator(amount,intrestRate,yearsOfInstallments);
        }
    }
    public double fixedRate(){
        double q = 1+((intrestRate/100)/months);
        return amount*Math.pow(q,yearsOfInstallments*months)*(q-1) / (Math.pow(q,yearsOfInstallments*months)-1);
    }
    public void printFixedRate(){
        DecimalFormat df = new DecimalFormat("#.##");
        for (int i=1; i<=months*yearsOfInstallments;i++) {
            System.out.println(i + ". " + df.format(fixedRate()));
        }
    }
    public String[] adjustableRate(){
        DecimalFormat df = new DecimalFormat("#.##");
        String[] storedInstallments = new String[months*yearsOfInstallments];
        int numberOfInstallments = months * yearsOfInstallments;
        double percent = intrestRate/100;

        for (int i = 0; i < numberOfInstallments; i++) {
            storedInstallments[i] = df.format(amount / numberOfInstallments * (1 + (numberOfInstallments - i + 1) * percent / months));
        }

        return storedInstallments;
    }
    public void printAdjustableRate(){
            for (String s : adjustableRate())
                System.out.println(s);
        }

    public double getAmount() {
        return amount;
    }
    public String getIntrests(){
        DecimalFormat df = new DecimalFormat("#.##");
        return df.format(fixedRate()*yearsOfInstallments*months-amount);
    }
    public double getIntrestRate() {
        return intrestRate;
    }
    public int getNumberOfInstallment() {
        return yearsOfInstallments*months;
    }
}