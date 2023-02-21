package com.ug3.soal1;


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

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Unit test for simple App.
 */
public class UGSoal1Test {
    UGSoal1 absen = new UGSoal1();

    private ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

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

    private static Stream<Arguments> forAbsenTest() {
        Date thisDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMMM-yy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
        String date = dateFormat.format(thisDate);
        String time = timeFormat.format(thisDate);
        return Stream.of(
                Arguments.of("Nana", date, time, "berhasil absensi\nAtas nama : " +
                        "Nana" + "\n" + "Pada tanggal : " + date + "\n" +
                        "Pukul : " + time),
                Arguments.of("Dodi", date, time, "berhasil absensi\nAtas nama : " +
                        "Dodi" + "\n" + "Pada tanggal : " + date + "\n" +
                        "Pukul : " + time),
                Arguments.of("Anton", date, time, "berhasil absensi\nAtas nama : " +
                        "Anton" + "\n" + "Pada tanggal : " + date + "\n" +
                        "Pukul : " + time)
        );
    }

    @ParameterizedTest
    @MethodSource("forAbsenTest")
    public void absenTest(String name, String date, String time, String expected) {
        absen.absen(name, date, time);
        assertEquals(expected, outputStreamCaptor.toString().trim());
    }

}
