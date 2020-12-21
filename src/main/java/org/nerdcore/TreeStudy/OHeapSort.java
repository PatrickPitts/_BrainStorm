package org.nerdcore.TreeStudy;

public class OHeapSort {

    public static void sort(int[] arr){
        int n = arr.length;
        for(int i = n/2-1; i >= 0; i--){
            sortHeapify(arr, n, i);
        }

        for(int i = n-1; i >= 0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            sortHeapify(arr, i, 0);
        }
    }

    public static void sortHeapify(int[] arr, int n, int i){

        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;
        if(l < n && arr[l] > arr[largest])largest=l;
        if(r < n && arr[r] > arr[largest])largest=r;
        if(largest != i){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
        }
    }
}
