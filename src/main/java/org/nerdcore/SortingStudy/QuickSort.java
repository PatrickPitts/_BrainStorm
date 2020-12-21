package org.nerdcore.SortingStudy;

public class QuickSort {

    public int[] sort(int[] arr){
        sort(arr, 0, arr.length-1);
        return arr;
    }

    public void sort(int[]arr, int l, int r){
        if(l < r){
            int m = partition(arr, l, r);
            sort(arr, l, m);
            sort(arr, m+1, r);
        }
    }

    public int partition(int[] arr, int l, int r){
        int mid = (r + l)/2;
        int pivot = arr[mid];
        int li = l, ri = r;
        while(li < ri){
            while(arr[ri] > pivot)ri--;
            while(arr[li] < pivot)li++;
            if(li < ri){
                int temp = arr[ri];
                arr[ri--] = arr[li];
                arr[li++] = temp;
            }
        }


        return mid;
    }
}
