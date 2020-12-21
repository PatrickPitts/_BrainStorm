package org.nerdcore;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import org.nerdcore.SortingStudy.CountingSort;
import org.nerdcore.SortingStudy.RadixSort;

public class TestSorts {


    private static List<Function<int[], int[]>> sorts = new ArrayList<>();
    private static List<String> sortNames = new ArrayList<>();

    static {
        {
            //sorts.add(arr -> InsertSort.sort(arr));
            //sorts.add(arr -> BubbleSort.sort(arr));
            //sorts.add(arr -> MergeSort.sort(arr));
            //sorts.add(arr -> QuickSort.sort(arr));
            //sorts.add(arr -> CountingSort.sort(arr));
            sorts.add(arr -> RadixSort.oSort(arr));
            sorts.add(arr -> RadixSort.sort(arr));

            //sortNames.add("Insert");
            //sortNames.add("Bubble");
            //sortNames.add("Merge");
            //sortNames.add("Quick");
            //sortNames.add("Counting");
            sortNames.add("ProfRadix");
            sortNames.add("InitRadix");
        }
    }


    private static int[][][] lists = new int[][][]{
            {{1, 2, 3, 4}, {1, 2, 3, 4}},
            {{4, 3, 2, 1}, {1, 2, 3, 4}},
            {{1, 1, 1, 1, 1, 2, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 2}},
            {{}, {}},
            {{0}, {0}},
            {{1}, {1}},
            {{1, 1000, 10, 100000}, {1, 10, 1000, 100000}},
            {{}, {}}//7

    };

    public static int[] randomConsecutiveIntArray(int arrLength, int min) {
        int[] longArr = new int[arrLength];
        for (int i = min; i < min + arrLength; i++) {
            longArr[i-min] = i;
        }
        Random r = new Random();
        for (int i = arrLength - 1; i >= 0; i--) {
            int j = r.nextInt(i + 1);
            int temp = longArr[i];
            longArr[i] = longArr[j];
            longArr[j] = temp;
        }
        return longArr;
    }

    public static void main(String[] args) {

        int numTests = 50;
        int listSize = 100000;

        long[][] testResults = new long[sorts.size()][numTests];
        long[] averages = new long[sorts.size()];
        Stopwatch s = new Stopwatch();


        for (int j = 0; j < sorts.size(); j++) {
            for (int i = 0; i < numTests; i++) {
                int[] listToSort = randomConsecutiveIntArray(listSize,Integer.MAX_VALUE - listSize - 2);
                s.start();
                sorts.get(j).apply(listToSort.clone());
                s.stop();
                testResults[j][i] = s.getDuration();
            }
            long sumOfTimes = 0L;
            for (long time : testResults[j]) {
                sumOfTimes += time;
            }
            averages[j] = sumOfTimes / numTests;
        }
        String header = String.format("Number of lists tested : %d | Length of lists : %d", numTests, listSize);
        System.out.println(header);

        for (int i = 0; i < sortNames.size(); i++) {
            System.out.println(String.format(
                    "%16s | Average time : %d ms",
                    sortNames.get(i) + " Sort",
                    averages[i]
                    )
            );
        }
    }
}
