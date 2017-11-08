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
    public void testAddition() {
        double calculatedValue = 0;
        try {
            calculatedValue = calculatorService.add("200.25", "200.75");
        } catch (InvalidCalculatorInputFormat invalidCalculatorInputFormat) {
            invalidCalculatorInputFormat.printStackTrace();
        }
        System.out.println(calculatedValue);
        assertTrue("did not work", calculatedValue  == 200.25+200.75);
    }

    @Test
    public void testSubtraction(){
        double calculatedValue = 0;
        try {
            calculatedValue = calculatorService.subtract("124","200");
        } catch (InvalidCalculatorInputFormat invalidCalculatorInputFormat) {
            invalidCalculatorInputFormat.printStackTrace();
        }
        System.out.println(calculatedValue);
        assertTrue("did not work", calculatedValue == 124-200);
    }

    @Test
    public void testMultiplication(){
        double calculatedValue = 0;
        try {
            calculatedValue = calculatorService.multiply("10.1","100.75");
        } catch (InvalidCalculatorInputFormat invalidCalculatorInputFormat) {
            invalidCalculatorInputFormat.printStackTrace();
        }
        System.out.println(calculatedValue);
        assertTrue("Multiplication failed", calculatedValue == 10.1*100.75);

    }

    @Test
    public void testDivision(){
        double calculatedValue = 0;
        try {
            calculatedValue = calculatorService.divide("100", "10.2");
        } catch (InvalidCalculatorInputFormat invalidCalculatorInputFormat) {
            invalidCalculatorInputFormat.printStackTrace();
        }

        System.out.println(calculatedValue);
        assertTrue("Division failed", calculatedValue == 100D/10.2D);
    }

    @Test
    public void testNthFibonacci() {
        String calculatedValue = "";
        calculatedValue = calculatorService.getNthFibonacci("300");
    }




}