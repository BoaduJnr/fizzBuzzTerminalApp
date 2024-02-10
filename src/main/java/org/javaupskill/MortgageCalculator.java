package org.javaupskill;

public interface MortgageCalculator {

   float calculateMonthlyInterest(float annualInterestRate) throws Exception;
   String calculateMortgage(float monthlyInterest, double principal, byte years) throws Exception;

   void  startProcess() ;

    }
