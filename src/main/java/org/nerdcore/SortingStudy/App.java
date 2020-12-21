package org.nerdcore.SortingStudy;

import org.nerdcore.InsertSort;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class App {

    public static void main(String[] args) {
        int[] nums = {170, 45, 75, 90, 802, 24, 2, 66};
        RadixSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
