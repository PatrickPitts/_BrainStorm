package org.nerdcore.SortingStudy;

import java.util.Random;

public class ArrayGenerator {

    public static int[] arbitraryWholeNumberArray(int arrLength, int maxValue){
        Random random = new Random();
        int[] ret = new int[arrLength];
        for(int i = 0; i < arrLength; i++){
            ret[i] = random.nextInt(maxValue + 1);
        }

        return  ret;
    }
}
