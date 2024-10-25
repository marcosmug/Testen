package org.example;

public class Caculator {
    public static double caculatemaxloan (double yearlyincome, double studieschuld) {

        double maxloan = yearlyincome * 4.25;

        if (studieschuld > 0) {
            maxloan *= 0.75;
        }

        return maxloan;

    }


    public static double caculatemonthlinterest (double loanamount, double Renteprecentage) {
        double monthlyInterestRate = (Renteprecentage / 100 ) / 12;
        return loanamount * monthlyInterestRate;
    }

  public static double caculatemonthlyrepayment(double loanamount) {
        int totalmonth = 30*12;
        return loanamount / totalmonth;
  }

}
