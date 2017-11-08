package se.nios.scrum.calculator;

import java.math.BigInteger;
import java.util.*;

public class CalculatorService {
    private Map<String,Double> mMemory;

    public CalculatorService(){
        mMemory = new HashMap<>();
    }


    public double add(String first, String second) throws InvalidCalculatorInputFormat {
        Locale locale = Locale.getDefault();
        double firstValue = 0D;
        double secondValue = 0D;
        firstValue = getFormattedValue(first, locale);
        secondValue = getFormattedValue(second, locale);
        double calcValue = firstValue + secondValue;
        mMemory.put("m"+mMemory.size(),calcValue);
        return calcValue;
    }

    public double subtract(String first, String second) throws InvalidCalculatorInputFormat {
        Locale locale = Locale.getDefault();
        double firstValue = 0D;
        double secondValue = 0D;
        firstValue = getFormattedValue(first, locale);
        secondValue = getFormattedValue(second, locale);
        double calcValue = firstValue - secondValue;
        mMemory.put("m"+mMemory.size(),calcValue);
        return calcValue;
    }

    public double multiply(String first, String second) throws InvalidCalculatorInputFormat {
        Locale locale = Locale.getDefault();
        double firstValue = 0D;
        double secondValue = 0D;
        firstValue = getFormattedValue(first, locale);
        secondValue = getFormattedValue(second, locale);
        double calcValue = firstValue * secondValue;
        mMemory.put("m"+mMemory.size(),calcValue);
        return calcValue;
    }

    public double divide(String first, String second) throws InvalidCalculatorInputFormat {
        Locale locale = Locale.getDefault();
        double firstValue = 0D;
        double secondValue = 0D;
        firstValue = getFormattedValue(first, locale);
        secondValue = getFormattedValue(second, locale);
        double calcValue = firstValue / secondValue;
        mMemory.put("m"+mMemory.size(),calcValue);
        return calcValue;
    }

    public String getNthFibonacci(String value) {
        BigInteger firstFib = BigInteger.valueOf(0);
        BigInteger secondFib = BigInteger.valueOf(1);
        BigInteger currentFib = BigInteger.valueOf(0);
        int fibSteps = Integer.valueOf(value);
        if (value.equals("0")|| value.equals("1")) {
            return value;
        }
        for (int i = 0; i < fibSteps - 1; i++) {
            currentFib = firstFib.add(secondFib);
            firstFib = secondFib;
            secondFib = currentFib;
        }
        return String.valueOf(currentFib);


    }

    private double getFormattedValue(String value, Locale locale) throws InvalidCalculatorInputFormat {
        double firstValue;
        try {
            Scanner scanner = new Scanner(value);
            scanner.useLocale(locale);
            firstValue = scanner.nextDouble();
        } catch (InputMismatchException e) {
            throw new InvalidCalculatorInputFormat();
        }
        return firstValue;
    }

    public double getMemValue(String m1) {
        return mMemory.get(m1);
    }
}
