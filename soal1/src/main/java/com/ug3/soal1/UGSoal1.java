package com.ug3.soal1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class UGSoal1
{
    public static void main( String[] args )
    {
        String date="";
        String time="";
        String name="";
        Scanner scan = new Scanner(System.in);
        System.out.println("Absen disini\nNama karyawan: ");
        name = scan.nextLine();
        absen(name,date,time);
    }
    public static void absen(String name, String date, String time){



        Date thisDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMMM-yy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");


        date = dateFormat.format(thisDate);
        time = timeFormat.format(thisDate);

        System.out.println(
                "\n\nberhasil absensi\nAtas nama : " +
                        name + "\n" + "Pada tanggal : " + date + "\n" +
                        "Pukul : " + time
        );
    }
}