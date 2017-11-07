package se.nios.scrum.calculator;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class CalculatorService {
    Locale locale = Locale.getDefault();
    DecimalFormat decFormat = new DecimalFormat();
    DecimalFormatSymbols decSymbols;


    public double add(String s) throws ParseException {

        decSymbols = decFormat.getDecimalFormatSymbols();
        System.out.println("Decimal separator is : " + decSymbols.getDecimalSeparator());
        String localSeparator = String.valueOf(decSymbols.getDecimalSeparator());

        NumberFormat numberFormat = NumberFormat.getInstance(locale);
        String firstValue = s.substring(0,s.indexOf('+'));
        String secondValue = s.substring(s.indexOf('+')+1);
        firstValue = firstValue.replaceAll("\\s+","");
        secondValue = secondValue.replaceAll("\\s+","");
        System.out.println(firstValue);
        System.out.println(secondValue);

        Number n1 = numberFormat.parse(firstValue);
        Number n2 = numberFormat.parse(secondValue);



        double calculatedValue =  n1.doubleValue() + n2.doubleValue();
        return calculatedValue;
    }

    public double subtract(String s) {
        double firstValue = Double.valueOf(s.substring(0,s.indexOf('-') - 1));
        double secondValue = Double.valueOf(s.substring(s.indexOf('-')+1));
        double calculatedValue =  firstValue - secondValue;
        return calculatedValue;
    }
}
