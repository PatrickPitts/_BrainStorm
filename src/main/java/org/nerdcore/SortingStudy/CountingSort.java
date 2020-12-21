package org.nerdcore.SortingStudy;

public class CountingSort {

    public static int[] sort(int[] arr) {

        int max = Integer.MIN_VALUE;
        int[] sorted = new int[arr.length];
        for (int val : arr) {
            if (val > max) max = val;
        }

        int[] aux = new int[max + 1];
        for(int i = 0; i < arr.length; i++){
            aux[arr[i]]++;
        }

        int j = 0;
        for(int i = 0; i <= max; i++){
            int value = aux[i];
            while(value-- > 0){
                sorted[j++] = i;
            }
        }
        return sorted;
    }
}
