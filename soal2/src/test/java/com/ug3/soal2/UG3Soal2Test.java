package com.ug3.soal2;


import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * Unit test for simple App.
 */
public class UG3Soal2Test
{

    private ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    UG3Soal2 testFib = new UG3Soal2();

    @BeforeAll
    public static void init() {

    }
    @BeforeEach
    public void setUp() {

        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(System.out);
    }

    private static Stream<Arguments> forFibonacciTest() {
        return Stream.of(
                Arguments.of("Halo halo bandung", "Bandung kota favoritku", "Bilangan Fibonacci\n" + "17 22 39 61 100 161 261 422 683 1105 1788")
        );
    };

    @ParameterizedTest
    @MethodSource("forFibonacciTest")
    public void fibonacciTest(String first, String second,String expected){
        testFib.fibonacci(first,second);

        assertEquals(expected,outputStreamCaptor.toString().trim());
    }
}
