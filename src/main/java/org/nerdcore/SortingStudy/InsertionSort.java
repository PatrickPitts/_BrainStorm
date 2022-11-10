package org.nerdcore.SortingStudy;

public class InsertionSort {

    public static int[] sort(int[] arr){

        for(int i = 1; i < arr.length; i++){
            int k = i-1;
            int temp = arr[i];
            while(k >= 0 && arr[k] > temp){
                arr[k+1] = arr[k];
                k--;
            }
            arr[k+1] = temp;

        }
        return arr;
    }
}
