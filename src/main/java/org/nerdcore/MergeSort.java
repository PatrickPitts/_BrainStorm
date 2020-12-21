package org.nerdcore;

import java.util.Arrays;

public class MergeSort {

    public static int[] sort(int[] arr) {

        int temp;
        if (arr.length <= 1) {
            return arr;
        } else if (arr.length == 2) {
            if (arr[0] > arr[1]) {
                temp = arr[0];
                arr[0] = arr[1];
                arr[1] = temp;
            }
            return arr;
        }

        return merge(sort(Arrays.copyOfRange(arr, 0, arr.length/2)),
                sort(Arrays.copyOfRange(arr, arr.length/2, arr.length)));


    }

    public static int[] merge(int[] L, int[] R){

        int[] ret = new int[L.length + R.length];

        int li = 0, ri = 0;
        int j = 0;
        int i = 0;
        for (; j < ret.length; j++) {
            if (L[li] <= R[ri]) {
                ret[j] = L[li++];
            } else {
                ret[j] = R[ri++];
            }
            if (li >= L.length || ri >= R.length) {
                break;
            }
        }

        for (; li < L.length; ) {
            ret[++j] = L[li++];
        }

        for (; ri < R.length; ) {
            ret[++j] = R[ri++];
        }

        return ret;
    }


    public static int[] merge(int[] arr) {

        int c = 0;
        while (c < (arr.length - 1) && arr[c] <= arr[++c]) ;
        if (c == arr.length - 1) {
            return arr;
        }

        int n1 = c;
        int n2 = arr.length - c;

        int[] L = new int[n1];
        int[] R = new int[n2];
        int[] ret = new int[n1 + n2];

        int i = 0;
        for (; i < n1; i++) {
            L[i] = arr[i];
        }

        for (; i < n1 + n2; i++) {
            R[i - n1] = arr[i];
        }

        int li = 0, ri = 0;
        int j = 0;
        i = 0;
        for (; j < ret.length; j++) {
            if (L[li] <= R[ri]) {
                ret[j] = L[li++];
            } else {
                ret[j] = R[ri++];
            }
            if (li >= L.length || ri >= R.length) {
                break;
            }
        }

        for (; li < L.length; ) {
            ret[++j] = L[li++];
        }

        for (; ri < R.length; ) {
            ret[++j] = R[ri++];
        }

        return ret;

    }

}
