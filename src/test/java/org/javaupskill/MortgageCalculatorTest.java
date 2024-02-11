package org.javaupskill;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.*;


/**
 *Mortgage calculator  class unit test
 *
 */

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MortgageCalculatorTest {
    MortgageCalculator mortgageCalculator;

    @BeforeEach
    public  void setup(){
         mortgageCalculator = new MortgageCalculatorImpl();

    }


    @Test
    @DisplayName("Calculate monthly interest 5000 should equal 4.17")
    void calculateMonthlyInterest5000ShouldEqualFourPointOneSeven() throws Exception {
        var mortgageCalculator = new MortgageCalculatorImpl();
        DecimalFormat df = new DecimalFormat("#.##");
        String formattedNumber = df.format(mortgageCalculator.calculateMonthlyInterest(5000));
        assertEquals("4.17", formattedNumber);

    }
    @Test
    @DisplayName("Calculate monthly interest 1000 should equal 1")
    void calculateMonthlyInterest1000ShouldEqualOne() throws Exception {
        var mortgageCalculator = new MortgageCalculatorImpl();
        assertEquals(1, mortgageCalculator.calculateMonthlyInterest(1200));


    }
    @Test
    @DisplayName("Calculate monthly interest -4 should throw an exception")
    void calculateMonthlyInterestThrowExceptionWithNegativeNumbers() {
        var mortgageCalculator = new MortgageCalculatorImpl();
        assertThrows(Exception.class, ()-> mortgageCalculator.calculateMonthlyInterest(-4)) ;


    }
    @Test
    @DisplayName("Calculate mortgage should equal GH₵408,000.01")
    void calculateMortgageShouldReturnGHC4080000() throws Exception {
        var mortgageCalculator = new MortgageCalculatorImpl();

        float monthlyInterest = 3.4f;
        double principl = 120000;
        byte years = 12;
        String mortgage = mortgageCalculator.calculateMortgage(monthlyInterest, principl,years);
        assertEquals("GH₵408,000.01", mortgage);

    }
    @Test
    @DisplayName("Calculate mortgage should equal GH₵1,292,040.02")
    void calculateMortgageShouldReturnouerhgow() throws Exception {
        var mortgageCalculator = new MortgageCalculatorImpl();
        float monthlyInterest = 7.4f;
        double principal = 174600;
        byte years = 5;
        String mortgage = mortgageCalculator.calculateMortgage(monthlyInterest, principal,years);
        assertEquals("GH₵1,292,040.02", mortgage);

    }
    @Test
    @DisplayName("Calculate mortgage with negative monthly interest should throw an exception")
    void calculateMortgageShouldThrowExceptionWhenMonthlyInterestIsLessThan0() {
        var mortgageCalculator = new MortgageCalculatorImpl();

        float monthlyInterest = -7.4f;
        double principal = 174600;
        byte years = 5;
        assertThrows(Exception.class, ()-> mortgageCalculator.calculateMortgage(monthlyInterest, principal,years)) ;


    }
    @Test
    @DisplayName("Calculate mortgage with negative principal should throw an exception")
    void calculateMortgageShouldThrowExceptionWhenPrincipalIsLessThan0() {
        var mortgageCalculator = new MortgageCalculatorImpl();
        float monthlyInterest = 7.4f;
        double principal = - 174600;
        byte years = 5;
        assertThrows(Exception.class, ()-> mortgageCalculator.calculateMortgage(monthlyInterest, principal,years)) ;


    }
    @Test
    @DisplayName("Calculate mortgage with negative years should throw an exception")
    void calculateMortgageShouldThrowExceptionWhenYearsIsLessThan0() {
        var mortgageCalculator = new MortgageCalculatorImpl();
        float monthlyInterest = 7.4f;
        double principal = 174600;
        byte years = -5;
        assertThrows(Exception.class, ()-> mortgageCalculator.calculateMortgage(monthlyInterest, principal,years)) ;


    }

}