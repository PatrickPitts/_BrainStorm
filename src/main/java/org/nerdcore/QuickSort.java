package org.nerdcore;

import java.util.Arrays;

public class QuickSort {

//    public static int partition(Comparable[] arr, int high, int low){
//
//        int L = low, R = high - 1; Comparable partition = arr[high];
//
//        while(true){
//            while(arr[L].compareTo(partition) < 0){L++;}
//            while(R > 0 && arr[R].compareTo(partition) > 0){R--;}
//            if(L >= R){
//                break;
//            }
//            Comparable temp = arr[L];
//            arr[L] = arr[R];
//            arr[R] = temp;
//        }
//
//        Comparable temp = arr[high];
//        arr[high] = arr[L];
//        arr[L] = temp;
//
//        return L;
//
//    }
//
//    public static void sort(Comparable[] arr, int low, int high){
//
//        if(low >= high){
//            return;
//        }
//
//    }

    //Uses the Lomuto partition scheme, that is, always chooses the last element in the list as the pivot
    public static int partition(int[] arr, int high, int low){
        int L = low, R = high - 1, pivot = arr[high];
        //while(true){
        //System.out.println(String.format("L %d  R %d | %s", L, R, Arrays.toString(arr)));
        while(L < R){
            while(arr[L] < pivot){L++;}
            while(R > 0 && arr[R] > pivot ){R--;}
            if(L>R){
            //if(L >= R){
                break;
            }

            int temp = arr[L];
            arr[L] = arr[R];
            arr[R] = temp;
        }

        arr[high] = arr[L];
        arr[L] = pivot;
        return L;
    }

    public static void sort(int[] arr, int low, int high){

        if(high <= low){
            return;
        }

        int partition = partition(arr, high, low);
        sort(arr, low, partition - 1);
        sort(arr, partition+1, high);
    }

    public static int[] sort(int[] arr){
        sort(arr, 0, arr.length-1);
        return arr;
    }

}

