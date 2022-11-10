package org.nerdcore;

public class BinarySearch {

    //returns the index of the target value in arr, or -1 otherwise
    public static int search(int[] arr, int target){
        int ret = -1, L = 0, R = arr.length-1;

        while(L <= R){
            int M = (L + R)/2;
            if(arr[M] == target){
                ret = M;
                break;
            } else if (arr[M] > target){
                R = M - 1;
            } else {
                L = M + 1;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6};
        for(int i = 0; i < arr.length; i++){
            System.out.println(search(arr, i));
        }

    }
}
