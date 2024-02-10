package org.javaupskill;

import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Building A Mortgage Calculator
 * Requirement Specs:
 * 1. Principal:100000
 * 2.Annual Interest Rates:4.2
 * 3. Period(Years):30
 * 4. Mortgage:$?
 * 5.
 */





public class MortgageCalculatorImpl  implements  MortgageCalculator{

    /**
     * Now It’s time for a small project:
     * Use what you’ve learned in the section and build a mortgage calculator
     * When we run this program we get few questions:
     * Principal – Amount Of Loan We want to get – $ 100000
     * Annual Interest Rate: 3.92 will be divided by 100 then /12
     * Period(Years)- 30 to be * 12 – number of payments
     * Add Error Handling!!
     * */


        static final byte MONTHS_IN_YEAR=12;
        static  final byte PERCENT=100;

        public  float  calculateMonthlyInterest(float annualInterestRate) throws Exception {
            if(annualInterestRate < 0 ){
                throw  new Exception("Annual rate can not be less than 0");
            }
            return annualInterestRate / PERCENT / MONTHS_IN_YEAR;

        }
        public   String calculateMortgage(float monthlyInterest, double principal, byte years) throws Exception {
            if(monthlyInterest < 0 || principal < 0 || years < 0){
                throw  new Exception("Entered number can not be less than 0");
            }
            int numberOfPayments = years * MONTHS_IN_YEAR;

            double mortgage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)) / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

            return NumberFormat.getCurrencyInstance().format(mortgage);
        }

        public  void startProcess(){

            try(
                    Scanner scanner=new Scanner(System.in)
            ) {

                System.out.println("Principal:");
                int principal ;
                try {
                    principal = scanner.nextInt();
                }catch (Exception e){
                    throw new Exception("Enter valid amount" );
                }

                if (principal < 1000 || principal >= 1_000_000) {
                    throw  new Exception("Enter A Value Between 1000 and 1000000");
                }


                System.out.println("Annual Interest Rate:");
                float annualInterestRate;
                try {
                    annualInterestRate = scanner.nextFloat();
                }catch (Exception e){
                    throw new Exception("Enter valid rate");
                }

                float monthlyInterest = calculateMonthlyInterest(annualInterestRate);

                System.out.println("Period(Years):");
                byte years ;
                try {
                    years = scanner.nextByte();
                }catch (Exception e){
                    throw  new Exception("Enter a valid number of years");
                }



                String mortgageFormatted = calculateMortgage(monthlyInterest,principal,years);
                System.out.println("Mortgage:" + mortgageFormatted);



            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

}
