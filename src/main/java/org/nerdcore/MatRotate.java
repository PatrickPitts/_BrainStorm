package org.nerdcore;

import java.util.Arrays;

public class MatRotate {

    public static void oRotate(int[][] arr){
        int n = arr.length;
        for(int layer = 0; layer < n/2; layer++){
            int last = n - 1 - layer;
            for(int i = layer; i < last; i++){
                int offset = i - layer;
                int top = arr[layer][i];
                arr[layer][i] = arr[last-offset][layer];
                arr[last-offset][layer] = arr[last][last-offset];
                arr[last][last-offset] = arr[i][last];
                arr[i][last] = top;
            }
        }
    }

    public static void rotate(int[][] arr){
        int n = arr.length;

        for(int r = 0; r < n/2; r++){
            for(int c = 0; c < n/2; c++){
                int temp = arr[r][c];
                arr[r][c] = arr[n-c-1][r];
                arr[n-c-1][r] = arr[n-r-1][n-c-1];
                arr[n-c-1][r] = arr[n-r-1][n-c-1];
                arr[n-r-1][n-c-1] = arr[c][n-r-1];
                arr[c][n-r-1] = temp;


            }
        }
        if(arr.length % 2 == 1){
           int mid = n/2;
           for(int i =0; i < mid; i++){
               int temp = arr[i][mid];
               arr[i][mid] = arr[mid][i];
               arr[mid][i] = arr[n-i-1][mid];
               arr[n-i-1][mid] = arr[mid][n-i-1];
               arr[mid][n-i-1] = temp;


           }
        }

    }
}
