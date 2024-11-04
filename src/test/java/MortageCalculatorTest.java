import org.junit.jupiter.api.Test;

import static org.example.Caculator.*;
import static org.junit.jupiter.api.Assertions.*;

public class MortageCalculatorTest {

    @Test
    public void calculateMaxloanTest_4000_true() {
        double expected = 2000 * 4.25;
        double actual = caculatemaxloan(2000, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void calculateMaxloan_4000_false() {
        double expected = 4000 * 4.25;
        double actual = caculatemaxloan(8000, 0);
        assertNotEquals(expected, actual);//Unit test fail omdat de test excepted dat antwoord niet waar is
    }

    @Test
    public void caculatemonthlinterest_400loan_7percent_false(){

        double loanAmount = 4000;
        double annualInterestRate = 7.0;

        double expected = loanAmount * (annualInterestRate / 100) / 12;

        double actual = caculatemonthlinterest(loanAmount, annualInterestRate);


        assertNotEquals(expected, actual);
    }



    @Test
    public void caculatemonthlinterest_2000loan_5percent_true(){
        double loanAmount = 2000;
        double annualInterestRate = 5.0;

        double expected = loanAmount * (annualInterestRate / 100) / 12;

        double actual = caculatemonthlinterest(loanAmount, annualInterestRate);


        assertEquals(expected, actual, 0.0001);


    }


    @Test
    public void calculateMonthlyRepayment_1000loan_totalmonths11_false() {

        double loanAmount = 1000;
        int totalMonths = 30 * 11;
        double expected = loanAmount / totalMonths;
        double actual = caculatemonthlyrepayment(loanAmount);
        assertNotEquals(expected, actual);
    }


    @Test
    public void calculateMonthlyRepayment_120000loan_totalmonts12_true() {


        double loanAmount = 120000;

        int totalMonths = 30 * 12;
        double expected = loanAmount / totalMonths;

        double actual = caculatemonthlyrepayment(loanAmount);

        assertEquals(expected, actual, 0.0001);
    }
}

