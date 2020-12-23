package org.nerdcore;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        int n = 25;
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j =0; j < n ; j++){
                arr[i][j] = j + i*n;
            }
        }

        Stopwatch s = new Stopwatch();

        s.start();
        MatRotate.rotate(arr);
        s.stop();
        System.out.printf("%sms%n", s.getDurationString());
        for(int[] row : arr){
            System.out.println(Arrays.toString(row));
        }

        s.start();
        MatRotate.oRotate(arr);
        s.stop();
        System.out.printf("%sms%n", s.getDurationString());
        for(int[] row : arr){
            System.out.println(Arrays.toString(row));
        }

    }
}

