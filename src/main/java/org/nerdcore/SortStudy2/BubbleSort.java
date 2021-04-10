package org.nerdcore.SortStudy2;

import java.util.Arrays;

public class BubbleSort {

    public static void sort(int[]arr){
        System.out.printf("Starting: %s%n", Arrays.toString(arr));
        int globalCount = 0;
        for(int i = 0; i < arr.length - 1; i++){
            int n = 0;

            while( n < arr.length - 1 &&  arr[n] > arr[n+1]){
                System.out.println(displayStr(arr, n));


                int temp = arr[n];
                arr[n] = arr[n+1];
                arr[n+1] = temp;
                System.out.println(displayStr(arr, n) + " Global Swaps: " + ++globalCount);
                n++;
            }
        }
    }

    public static String displayStr(int[] arr, int n){
        StringBuilder sb = new StringBuilder();

        sb.append(Arrays.toString(Arrays.copyOfRange(arr, 0, n)).replaceAll("]", ""));
        if(n > 0){

        sb.append(", ");
        }
                sb.append(Arrays.toString(Arrays.copyOfRange(arr, n, n+2)));
        if(n < arr.length - 2){

        sb.append(", ");
        }
                sb.append(Arrays.toString(Arrays.copyOfRange(arr, n+2, arr.length)).replaceAll("\\[", ""));
        return sb.toString();
    }
}
