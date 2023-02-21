package com.ug3.soal2;

/**
 * Hello world!
 *
 */
public class UG3Soal2
{
    public static void main( String[] args ) throws InterruptedException {
        boolean red = true, yellow = false, green = false;
        int countDown = 0;
        trafficLight(red,yellow,green,countDown);
    }

    private static void trafficLight(
            boolean red,
            boolean yellow,
            boolean green,
            int countDown
    ) throws InterruptedException {
        if (red) {
            System.out.println("Lampu merah menyala selama");
            for(countDown = 20; countDown >0; countDown--){
                System.out.println(countDown);
                Thread.sleep(1000);
            }
            System.out.println("\nAkan berganti ke lampu kuning\n");
            red = false;
            yellow = true;
            Thread.sleep(2000);
            yellowTurnOn(red,yellow,green,countDown);
        }
    }

    private static void yellowTurnOn(
            boolean red,
            boolean yellow,
            boolean green,
            int countDown
    ) throws InterruptedException {
        if(yellow){
            System.out.println("Lampu kuning menyala selama");
            for(countDown = 2;countDown >0; countDown--){
                System.out.println(countDown);
                Thread.sleep(1000);
            }
            System.out.println("\nAkan berganti ke lampu hijau\n");
            yellow = false;
            green = true;
            Thread.sleep(1000);
            greenTurnedOn(red,yellow,green,countDown);
        }
    }

    private static void greenTurnedOn(
            boolean red,
            boolean yellow,
            boolean green,
            int countDown
    ) throws InterruptedException {
        if(green){
            System.out.println("Lampu hijau menyala selama");
            for(countDown = 15; countDown > 0; countDown--){
                System.out.println(countDown);
                Thread.sleep(1000);
            }
            System.out.println("\nAkan berganti ke lampu kuning");
            green = false;
            yellow = true;
            Thread.sleep(1000);
            if(yellow){
                System.out.println("Lampu kuning menyala selama");
                for(countDown = 2; countDown > 0; countDown--){
                    System.out.println(countDown);
                    Thread.sleep(1000);
                }
                System.out.println("\nAkan berganti ke lampu merah\n");
                yellow = false;
                red = true;
                Thread.sleep(1000);
                trafficLight(red,yellow,green,countDown);
            }
        }
    }
}
