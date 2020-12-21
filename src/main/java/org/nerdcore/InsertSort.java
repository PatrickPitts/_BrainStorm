package org.nerdcore;

import java.util.Arrays;

public class InsertSort {

    static int count = 0;

    public static int[] offSwap(int[] array){
        for(int i = 1; i < array.length; i++){
            for(int j = 0; j < i; j++){

                if(array[i] < array[j]){
                    int temp = array[j];
                    array[j] = array[i];
                    array[i--] = temp;
                }
                System.out.println(count++ + " " + Arrays.toString(array));
            }
        }
        return array;
    }

    public static int[] sort(int[] arr){

        for(int i = 1; i < arr.length; i++){
            int j = 0;
            while(j <= i && arr[j] < arr[i]){
                j++;
            }
            if(i != j){
                int temp = arr[i];
                for(int x = i; x > j; x--){
                    arr[x] = arr[x-1];
                }
                arr[j] = temp;
            }
        }
        return arr;
    }
}
