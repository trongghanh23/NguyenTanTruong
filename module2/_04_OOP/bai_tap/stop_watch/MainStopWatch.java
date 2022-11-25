package _04_OOP.bai_tap.stop_watch;


import _04_OOP.bai_tap.stop_watch.StopWatch;

import java.util.Arrays;

public class MainStopWatch {

    public static void main(String[] args) {
        int[] array = new int[100000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        sort(array);
        stopWatch.stop();
        System.out.println(Arrays.toString(array));
        System.out.println("Time:" + stopWatch.getElapsedTime() + " Mili giây");
    }

    public static void sort(int... array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    int swap = array[i];
                    array[i] = array[j];
                    array[j] = swap;
                }
            }
        }
    }
}





