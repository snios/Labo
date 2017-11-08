package se.nios.scrum.calculator;

import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class CalculatorService {


    public double add(String first, String second) throws InvalidCalculatorInputFormat {
        Locale locale = Locale.getDefault();
        double firstValue = 0D;
        double secondValue = 0D;

        try{
            Scanner scanner = new Scanner(first);
            scanner.useLocale(locale);
            firstValue = scanner.nextDouble();
        }catch (InputMismatchException e){
            throw  new InvalidCalculatorInputFormat();
        }

        try{
            Scanner scanner = new Scanner(second);
            scanner.useLocale(locale);
            secondValue = scanner.nextDouble();
        }catch (InputMismatchException e){
            throw  new InvalidCalculatorInputFormat();

        }



        return firstValue + secondValue;
    }

    public double subtract(String first, String second) throws InvalidCalculatorInputFormat {
        Locale locale = Locale.getDefault();
        double firstValue = 0D;
        double secondValue = 0D;

        try{
            Scanner scanner = new Scanner(first);
            scanner.useLocale(locale);
            firstValue = scanner.nextDouble();
        }catch (InputMismatchException e){
            throw  new InvalidCalculatorInputFormat();
        }

        try{
            Scanner scanner = new Scanner(second);
            scanner.useLocale(locale);
            secondValue = scanner.nextDouble();
        }catch (InputMismatchException e){
            throw  new InvalidCalculatorInputFormat();

        }
        return firstValue - secondValue;
    }

    public double multiply(String first, String second) throws InvalidCalculatorInputFormat {
        Locale locale = Locale.getDefault();
        double firstValue = 0D;
        double secondValue = 0D;

        try{
            Scanner scanner = new Scanner(first);
            scanner.useLocale(locale);
            firstValue = scanner.nextDouble();
        }catch (InputMismatchException e){
            throw  new InvalidCalculatorInputFormat();
        }

        try{
            Scanner scanner = new Scanner(second);
            scanner.useLocale(locale);
            secondValue = scanner.nextDouble();
        }catch (InputMismatchException e){
            throw  new InvalidCalculatorInputFormat();

        }

        return firstValue * secondValue;
    }

    public double divide(String first, String second) throws InvalidCalculatorInputFormat {
        Locale locale = Locale.getDefault();
        double firstValue = 0D;
        double secondValue = 0D;

        try{
            Scanner scanner = new Scanner(first);
            scanner.useLocale(locale);
            firstValue = scanner.nextDouble();
        }catch (InputMismatchException e){
            throw  new InvalidCalculatorInputFormat();
        }

        try{
            Scanner scanner = new Scanner(second);
            scanner.useLocale(locale);
            secondValue = scanner.nextDouble();
        }catch (InputMismatchException e){
            throw  new InvalidCalculatorInputFormat();

        }
        return firstValue / secondValue;
    }

    public String getNthFibonacci(String value) {
        BigInteger firstFib = BigInteger.valueOf(0);
        BigInteger secondFib = BigInteger.valueOf(1);
        BigInteger currentFib = BigInteger.valueOf(0);
        int fibSteps = Integer.valueOf(value);

        if (value == "0" || value == "1"){
            return value;
        }


        for(int i = 0; i < fibSteps -1; i++){
            currentFib = firstFib.add(secondFib);
            firstFib = secondFib;
            secondFib = currentFib;
        }
        System.out.println("CurrentFib: " + currentFib);
        return String.valueOf(currentFib);



    }
}
