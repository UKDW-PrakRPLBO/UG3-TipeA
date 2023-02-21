package com.ug3.soal1;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Before;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Stream;

import static org.junit.Assert.*;

import static com.ug3.soal1.UGSoal1.*;


/**
 * Unit test for simple App.
 */
public class UGSoal1Test

{
    static UGSoal1 absen = new UGSoal1();

    private final  InputStream systemIn = System.in;
    private final PrintStream standardOut = System.out;
    private static final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();



    @BeforeEach
    public void setUp(){
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown(){
        System.setIn(systemIn);
        System.setOut(standardOut);
    }


    private static Stream<Arguments> forAbsenTest(){

    Date thisDate = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMMM-yy");
    SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
    String date= dateFormat.format(thisDate);
    String time = timeFormat.format(thisDate);
    String name = "Nana";
        return Stream.of(
                Arguments.of(name,date,time,"berhasil absensi\nAtas nama : " +
                        name + "\n" + "Pada tanggal : " + date + "\n" +
                        "Pukul : " + time)
        );
}
    @ParameterizedTest
    @MethodSource("forAbsenTest")
    public void absenTest(String name, String date, String time, String expected){
        Date thisDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMMM-yy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
        date= dateFormat.format(thisDate);
        time = timeFormat.format(thisDate);
        String input = "Nana";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        PrintStream printStream = new PrintStream(outputStreamCaptor);
        System.setOut(printStream);
        absen.absen(name,date,time);
        assertEquals( expected, outputStreamCaptor.toString().trim());


    }


}
