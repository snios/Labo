package se.nios.scrum.calculator;

import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.assertTrue;

public class CalculatorServiceTest {
    private CalculatorService calculatorService;

    @Before
    public void init(){
        calculatorService = new CalculatorService();

    }

    @Test
    public void testAddition() throws InvalidCalculatorInputFormat {
        double calculatedValue = 0;
        try {
            calculatedValue = calculatorService.add("124.22+200.23 ");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(calculatedValue);
        assertTrue("did not work", calculatedValue  == 124.22+200.23);
    }

    @Test
    public void testSubtraction(){
        double calculatedValue = calculatorService.subtract("124   -   200");
        assertTrue("did not work", calculatedValue == 124-200);
    }


}