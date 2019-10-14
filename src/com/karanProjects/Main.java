package com.karanProjects;

import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) {

        MortgageCalculator mortgageCalculator = new MortgageCalculator();
        mortgageCalculator.setAmount(100000);
        mortgageCalculator.setIntrestRate(3.5);
        mortgageCalculator.setInstallment(12);
        mortgageCalculator.setMonths(12);

        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println(mortgageCalculator.fixedRate());
        System.out.printf("%.2f%n",mortgageCalculator.fixedRate());
        System.out.println(df.format(mortgageCalculator.fixedRate()));

    }
}
