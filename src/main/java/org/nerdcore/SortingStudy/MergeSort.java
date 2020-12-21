package org.nerdcore.SortingStudy;

import java.util.Arrays;

public class MergeSort {

    public int[] sort(int[] arr){
        return sort(Arrays.copyOfRange(arr, 0, arr.length/2), Arrays.copyOfRange(arr, arr.length/2, arr.length));
    }

    public int[] sort(int[] l, int[] r){
        if(l.length==0){
            return r;
        }
        if(r.length==0){
            return l;
        }
        if(l.length == 1 && r.length == 1){
            return l[0] > r[0] ? new int[]{r[0], l[0]} : new int[]{l[0], r[0]};
        }

        else {
            return merge(sort(Arrays.copyOfRange( l, 0, l.length/2), sort(Arrays.copyOfRange(l, l.length/2, l.length))),
                    sort(Arrays.copyOfRange( r, 0, r.length/2), sort(Arrays.copyOfRange(r, r.length/2, r.length)))
                    );
        }
    }

    public int[] merge(int[] l, int[] r){
        int resLen = l.length + r.length;
        int[] res = new int[resLen];
        int left = 0 , right = 0, resIndex = 0;
        while(left < l.length && right < r.length){
            if(l[left] > r[right]){
                res[resIndex++] = r[right++];
            } else {
                res[resIndex++] = l[left++];
            }
        }

        while(left < l.length){
            res[resIndex++] = l[left++];
        }

        while(right < r.length){
            res[resIndex++] = r[right++];
        }

        return res;
    }
}
