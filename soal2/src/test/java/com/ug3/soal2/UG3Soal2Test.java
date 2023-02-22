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
                Arguments.of("Halo halo bandung", "Bandung kota favoritku", "Bilangan Fibonacci\n" + "17 22 39 61 100 161 261 422 683 1105 1788"),
                Arguments.of("Matcha latte itu enak","Kopi susu is better","Bilangan Fibonacci\n" + "21 19 40 59 99 158 257 415 672 1087 1759"),
                Arguments.of("jalan jalan ke Bali","Bali adalah tempat favoritku","Bilangan Fibonacci\n" + "19 28 47 75 122 197 319 516 835 1351 2186"),
                Arguments.of("I miss you","ich liebe dich","Bilangan Fibonacci\n" + "10 14 24 38 62 100 162 262 424 686 1110"),
                Arguments.of("do re mi fa","sol la si do","Bilangan Fibonacci\n" + "11 12 23 35 58 93 151 244 395 639 1034")
        );
    };

    @ParameterizedTest
    @MethodSource("forFibonacciTest")
    public void fibonacciTest(String first, String second,String expected){
        testFib.fibonacci(first,second);

        assertEquals(expected,outputStreamCaptor.toString().trim());
    }
}
