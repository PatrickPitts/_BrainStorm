package org.nerdcore.SortingStudy;

import java.util.Arrays;

public class CountingSort {

    public static int[] sort(int[] arr) {
        System.out.println(arr.length);
        int max = arr[0];
        for(int n : arr){
            if(n > max)max = n;
        }
        int[] sorted = new int[arr.length];
        int[] counts = new int[max + 1];
        for(int n : arr){
            counts[n]++;
        }

        for(int i = 1; i < counts.length; i++){
            counts[i] += counts[i-1];
        }
        System.out.println(Arrays.toString(counts));
        System.out.println(sorted.length);
        for(int i = arr.length - 1; i > 0; i--){
            int val = arr[i];
            int index = --counts[val];
            //counts[val]--;
            sorted[index] = val;

            //sorted[counts[arr[i]]] = arr[counts[i]--];
        }

        return sorted;
    }
}
