package com.testing;

public class MathTools {

    public double convertToDecimal(int numerator, int denominator){
        if(denominator==0) throw new IllegalArgumentException("Denominator must not be 0");
        return (double)numerator / (double)denominator;
    }

    public boolean isEven(int number){
        if(number ==0) throw new IllegalArgumentException("number must not be 0");
        return number % 2 ==0;
    }

}
