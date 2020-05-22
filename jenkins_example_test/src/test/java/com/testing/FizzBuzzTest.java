package com.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {

    public FizzBuzz fb;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        fb=new FizzBuzz();
    }

    @DisplayName("Play FizzBuzz with number =1 ")
    @Test
    public void testNumber(){
       String fizzBuzz= fb.play(1);
        Assertions.assertEquals(fizzBuzz,"1");
    }

    @DisplayName("Play FizzBuzz with number =3 ")
    @Test
    public void testFizz(){
        String fizzBuzz= fb.play(3);
        Assertions.assertEquals(fizzBuzz,"Fizz");
    }

    @DisplayName("Play FizzBuzz with number =5 ")
    @Test
    public void testBuzz(){
        String fizzBuzz= fb.play(5);
        Assertions.assertEquals(fizzBuzz,"Buzz");
    }

    @DisplayName("Don't play FizzBuzz if number = 0")
    @Test
    public void testZero(){
        Assertions.assertThrows(IllegalArgumentException.class,() -> fb.play(0));

    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        fb=null;
    }
}