package org.nerdcore.SortingStudy;

import java.util.ArrayList;
import java.util.Arrays;

public class RadixSort {

    public static int[] sort(int[] arr){
        int[] counts;
        int[] temp = Arrays.copyOf(arr, arr.length);
        int[] sorted  = new int[arr.length];
        int max = arr[0];
        for(int n : arr){
            if(n > max)max = n;
        }

        for(int i = 0; i < (int)Math.log10(max) + 1; i++){
            counts = new int[10];
            for(int n : arr){
                int d = n / (int) Math.pow(10, i) % 10;
                counts[d]++;
            }
            for(int j = 1; j < counts.length; j++){
                counts[j] += counts[j-1];
            }
            for(int j = temp.length - 1; j >= 0; j--){
                int v = temp[j];
                int index = v/ (int) Math.pow(10, i) % 10;
                index = --counts[index];
                sorted[index] = v;
            }
            temp=Arrays.copyOf(sorted, sorted.length);
        }
        return sorted;
    }
}
