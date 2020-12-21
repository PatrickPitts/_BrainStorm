package org.nerdcore;

public class BubbleSort {

    public static int[] sort(int[] arr){

        int n = arr.length;
        int temp;
        for (int i = 0; i < n; i++) {
            boolean terminateEarlyFlag = true;
            for (int j = 0; j < n - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    terminateEarlyFlag = false;
                }
            }
            if (terminateEarlyFlag) {
                break;
            }
        }
        return arr;
    }
}
