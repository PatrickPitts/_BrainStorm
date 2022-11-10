package org.nerdcore.DivideAndConquer;

public class MaximumSubarray {

    public int findMaximumSubarray(int[] A){
        return findMaximumSubarray(A, 0, A.length-1)[2];
    }

    public int[] findMaximumSubarray(int[] A, int low, int high){
        if(high == low)return new int[]{low, high, A[low]};
        int mid = (low + high) / 2;
        //TODO finish max subarray

        return A;
    }

    private static int[] findMaxCrossingSubarray(int[] A, int low, int mid, int high){
        int leftSum = Integer.MIN_VALUE, rightSum = Integer.MIN_VALUE;
        int sum = 0;
        int maxLeft = mid, maxRight = mid;
        for(int i = mid; i >= low; i--){
            sum += A[i];
            if(sum > leftSum){
                leftSum = sum;
                maxLeft = i;
            }
        }
        sum = 0;
        for(int i = mid + 1; i <= high; i++){
            sum += A[i];
            if(sum > rightSum){
                rightSum = sum;
                maxRight = i;
            }
        }
        return new int[]{maxLeft, maxRight, leftSum + rightSum};
    }
}
