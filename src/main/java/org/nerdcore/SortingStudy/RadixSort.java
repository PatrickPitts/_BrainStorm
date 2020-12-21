package org.nerdcore.SortingStudy;

import java.util.ArrayList;
import java.util.Arrays;

public class RadixSort {

    public static int[] sort(int[] arr) {
        int[] sorted = new int[arr.length], counts = new int[10];
        int max = getMax(arr, arr.length), digit;
        for(int exp = 1; max/exp > 0; exp *= 10){
            Arrays.fill(counts, 0);
            for(int num : arr){
                counts[getDigit(num, exp)]++;
            }
            for(int i = 1; i < counts.length; i++){
                counts[i] += counts[i-1];
            }

            for(int i = arr.length-1; i >= 0; i--){
                digit = getDigit(arr[i], exp);
                sorted[(counts[digit]--)-1] = arr[i];
                //counts[digit]--;
            }
            for(int i = 0; i < arr.length; i++){
                arr[i] = sorted[i];
            }

        }
        return arr;
    }

    public static int getDigit(int number, int exp){
        return (number/exp) % 10;
    }

    static int getMax(int[] arr, int n){
        int max = arr[0];
        for(int i = 1; i < n; i++){
            if(arr[i] > max) max = arr[i];
        }
        return max;
    }

    //does counting sort based on digit represented by exp
    static void countSort(int[] arr, int n, int exp){
        int[] output = new int[n], count = new int[10];
        int i;
        for(i = 0; i < n; i++){
            count[(arr[i] / exp) % 10]++;
        }

        for(i = 1; i < 10; i++){
            count[i] += count[i-1];
        }

        for(i = n - 1; i >= 0; i--){
            //this is the relevant digit for arr[i]
            int countIndex = (arr[i] / exp) % 10;
            output[count[countIndex] - 1] = arr[i];
            count[countIndex]--;
        }
        for(i=0; i < n; i++){
            arr[i] = output[i];
        }
    }

    public static void radixSort(int[] arr, int n){
        int m = getMax(arr, n);
        for(int exp = 1; m/exp >0; exp *=10 )countSort(arr, n, exp);
    }

    public static int[] oSort(int[] arr){
        int[] thisArr = arr.clone();
        radixSort(thisArr, thisArr.length);
        return thisArr;
    }
}
