package org.nerdcore.SortStudy2;

import java.util.Arrays;

public class MergeSort {



    public static int[] sort(int[] arr){
            if(arr.length == 1)return arr;
            int M = arr.length / 2;
            return merge(sort(Arrays.copyOfRange(arr, 0, M)), sort(Arrays.copyOfRange(arr, M, arr.length)));

    }

    public static int[] merge(int[] A, int[] B){
        int[] ret = new int[A.length + B.length];
        int i = 0, a =0, b = 0, c;
        while(a < A.length || b < B.length){
            if(a < A.length && b < B.length){
                if(A[a] < B[b]){
                    ret[i++] = A[a++];
                } else {
                    ret[i++] = B[b++];
                }

            } else if (a >= A.length){
                ret[i++] = B[b++];
            } else {
                ret[i++] = A[a++];
            }

        }
        return ret;
    }
}
