package org.nerdcore.SortingStudy;

import org.nerdcore.InsertSort;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class App {

    public static void main(String[] args) {
        Random r = new Random();
        int[] nums = new int[10];
        for(int i = 0; i < 10; i++){
            nums[i] = r.nextInt(1000);
        }
        System.out.println(Arrays.toString(nums));
        //System.out.println(Arrays.toString(CountingSort.sort(nums)));
        System.out.println(Arrays.toString(RadixSort.sort(nums)));
    }
}
