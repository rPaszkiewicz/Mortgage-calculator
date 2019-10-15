package com.karanProjects;

import java.text.DecimalFormat;

public class MortgageCalculator {
    private double amount;
    private double intrestRate;
    private int months;
    private int numberOfInstallment;

    private MortgageCalculator(double amount, double intrestRate, int months, int numberOfInstallment){
        this.amount=amount;
        this.intrestRate=intrestRate;
        this.months=months;
        this.numberOfInstallment=numberOfInstallment;
    }
    public static class Builder{
        private double amount;
        private double intrestRate;
        private int months;
        private int numberOfInstallment;

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
        public Builder setMonths(int months){
            this.months = months;
            return this;
        }
        public Builder setNumberOfInstallments(int numberOfInstallment){
            this.numberOfInstallment=numberOfInstallment;
            return this;
        }
        public MortgageCalculator build(){
            return new MortgageCalculator(amount,intrestRate,months,numberOfInstallment);
        }
    }
    public double fixedRate(){
        double q = 1+((intrestRate/100)/months);
        double score = amount*Math.pow(q,numberOfInstallment*months)*(q-1)/(Math.pow(q,numberOfInstallment*months)-1);
        return score;
    }
    public void printFixedRate(){
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println(df.format(fixedRate()));
    }
    public double adjustableRate(){
        double capitalPart = amount/(months*numberOfInstallment);
        double intrests = amount*(intrestRate/100)/months;
        return capitalPart + intrests;
    }
    public void printAdjustableRate(){
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println(df.format(adjustableRate()));
    }
    public double getAmount() {
        return amount;
    }
    public String getIntrests(){
        DecimalFormat df = new DecimalFormat("#.##");
        return df.format(fixedRate()*numberOfInstallment*months-amount);
    }
    public double getIntrestRate() {
        return intrestRate;
    }
    public int getMonths() {
        return months;
    }
    public int getNumberOfInstallment() {
        return numberOfInstallment*months;
    }
}