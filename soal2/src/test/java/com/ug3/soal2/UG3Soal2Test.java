package com.ug3.soal2;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * Unit test for simple App.
 */
public class UG3Soal2Test
{

    static UG3Soal2 check = new UG3Soal2();
    private static ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeAll
    public static void init() {

    }

    @BeforeEach
    public void setUp() {
        //init stream captors fo every test case. so that not interfere with prev test parameterized test
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        //give back the System out to default. (actually not needed)
        System.setOut(System.out);
    }


    
}
