package se.nios.scrum.calculator;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class CalculatorServiceTest {
    private CalculatorService calculatorService;
    private Map<String, String> mFibonacciList;

    @Before
    public void init() {
        calculatorService = new CalculatorService();
        mFibonacciList = new HashMap<>();
    }

    @Test
    public void testAddition() {
        double calculatedValue = 0;
        try {
            calculatedValue = calculatorService.add("200,25", "200,75");
        } catch (InvalidCalculatorInputFormat invalidCalculatorInputFormat) {
            invalidCalculatorInputFormat.printStackTrace();
        }
        assertTrue("Addition test failed", calculatedValue == 200.25 + 200.75);
    }

    @Test
    public void testSubtraction() {
        double calculatedValue = 0;
        try {
            calculatedValue = calculatorService.subtract("124", "200");
        } catch (InvalidCalculatorInputFormat invalidCalculatorInputFormat) {
            invalidCalculatorInputFormat.printStackTrace();
        }
        assertTrue("Subtraction test failed", calculatedValue == 124 - 200);
    }

    @Test
    public void testMultiplication() {
        double calculatedValue = 0;
        try {
            calculatedValue = calculatorService.multiply("10,1", "100,75");
        } catch (InvalidCalculatorInputFormat invalidCalculatorInputFormat) {
            invalidCalculatorInputFormat.printStackTrace();
        }
        assertTrue("Multiplication test failed", calculatedValue == 10.1 * 100.75);
    }

    @Test
    public void testDivision() {
        double calculatedValue = 0;
        try {
            calculatedValue = calculatorService.divide("100", "10,2");
        } catch (InvalidCalculatorInputFormat invalidCalculatorInputFormat) {
            invalidCalculatorInputFormat.printStackTrace();
        }
        assertTrue("Division test failed", calculatedValue == 100D / 10.2D);
    }

    @Test
    public void testMemoryFunction() {
        double calculatedValue = 0;
        try {
            calculatedValue = calculatorService.add("10", "10");
            calculatorService.saveValue("m1", calculatedValue);
        } catch (InvalidCalculatorInputFormat invalidCalculatorInputFormat) {
            invalidCalculatorInputFormat.printStackTrace();
        }

        assertTrue("Memory test failed", calculatedValue == calculatorService.getMemValue("m1"));
    }


    @Test
    public void testNthFibonacci() {
        String calculatedValue = "";
        String fibListValue = "";
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\radia\\IdeaProjects\\Laboration1TDD\\test\\se\\nios\\scrum\\calculator\\fibonacci.list"))) {
            String currentLine = br.readLine();
            while (currentLine != null) {
                String fibNumber = currentLine.substring(0, currentLine.indexOf(':'));
                String fibValue = currentLine.substring(currentLine.indexOf(':') + 1);
                fibNumber = fibNumber.trim();
                fibValue = fibValue.trim();
                mFibonacciList.put(fibNumber, fibValue);
                currentLine = br.readLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < mFibonacciList.size(); i++) {
            calculatedValue = calculatorService.getNthFibonacci(String.valueOf(i));
            fibListValue = mFibonacciList.get(String.valueOf(i));
            assertTrue("Fibonacci test failed", calculatedValue.equals(fibListValue));
        }
    }
}