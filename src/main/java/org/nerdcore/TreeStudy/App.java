package org.nerdcore.TreeStudy;

import java.util.ArrayList;
import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        runTests();

    }

    public static void runTests(){
        ArrayList<int[]> arrs = new ArrayList<int[]>();
        {{
            arrs.add(new int[]{100,75,60,75,20,55,0});
            arrs.add(new int[]{2,7,26,25,19,17,1,90,3,39});
            arrs.add(new int[]{90,36,26,25,19,17,1,7,3,2});
            arrs.add(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15});
        }}
        for(int[] arr : arrs){
            BinTree tree = new BinTree(arr);
            System.out.printf("Starting Data Arr: %s%n", Arrays.toString(arr));
            boolean isMaxHeap = tree.isMaxHeap();
            System.out.printf("Is Max Heap: %s%n", isMaxHeap);
            if(!isMaxHeap){
                System.out.println("Max Heapifying...");
                tree.maxHeapify();
                System.out.printf("Heapification complete!%nNew Data Arr%s%n",Arrays.toString(tree.getDataArr()));
            }
            System.out.println("__________________________________________");
        }
    }
}
