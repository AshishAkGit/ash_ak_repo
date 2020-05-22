package com.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class MathToolsTest {

    MathTools mathTools;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        mathTools=new MathTools();
    }

    @DisplayName("Valid Test: Non-zero Integers for denominators.")
    @Test
    public void testConvertToDecimalSuccess(){
       double result= mathTools.convertToDecimal(3,4);
        Assertions.assertEquals(0.75,result);
    }

    @DisplayName("Failure Test:  zero for denominators.")
    @Test
    public void testConvertToDecimalInvalidDenominator(){
        Assertions.assertThrows(IllegalArgumentException.class,() -> mathTools.convertToDecimal(3,0));
    }

    @DisplayName("Even number Test: check if number is even.")
    @Test
    public void testIsEvenSuccessful(){
        Assertions.assertTrue(mathTools.isEven(2));
        Assertions.assertFalse(mathTools.isEven(1));
        Assertions.assertThrows(IllegalArgumentException.class,() -> mathTools.isEven(0));
    }

    @ParameterizedTest
    @ValueSource(ints = {2,4,6,8,10})
    public void testIsEven(int number){
        Assertions.assertTrue(mathTools.isEven(number));
    }


    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        mathTools=null;
    }

}