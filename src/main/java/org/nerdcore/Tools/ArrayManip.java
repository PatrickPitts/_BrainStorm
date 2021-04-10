package org.nerdcore.Tools;

import java.util.Arrays;

public class ArrayManip {

    public static int[][] getAllSubarrays(int[] arr){
        int[][] ret = new int[arr.length * (arr.length +1) / 2][];
        int p = 0;
        for(int L = 1; L <= arr.length; L++){
            for(int i = 0; i < arr.length - L + 1; i++){
                ret[p++] = Arrays.copyOfRange(arr, i, i+L);
            }
        }
        return ret;
    }
}
