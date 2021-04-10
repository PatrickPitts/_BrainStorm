package org.nerdcore.SortStudy2;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,1,1,1,1,1,1,1};
        BubbleSort.sort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
