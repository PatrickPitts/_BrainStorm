package org.nerdcore;


import javax.swing.plaf.SliderUI;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.*;
import java.util.LinkedList.*;

class RandomStringChooser{

    private ArrayList<String> wordList;

    public RandomStringChooser(String[] wordArray){
        wordList = new ArrayList<>();
        for(String s : wordArray){
            wordList.add(s);
        }
    }

    public String getNext(){
        if(wordList.size() < 1)return "NONE";
        String ret = wordList.get((int) (Math.random() * wordList.size()));
        wordList.remove(ret);
        return ret;
    }
}



public class App {

    public static void main(String[] args){
        Stack<Integer> S = new Stack<>();
        S.push(14);
        S.push(4);
        S.push(3);
        S.push(2);
        S.push(1);
        S.push(3);
        S.push(8);
        S.push(17);
        S.push(9);
        S.push(99);
        S.push(9);
        S.push(17);
        S.push(8);
        S.push(3);
        System.out.println(S);
        switchPairs(S);
        System.out.println(S);
    }

    public static void switchPairs(Stack<Integer> S){
        Queue<Integer> Q = new LinkedList<>();
        int n = S.size();
        while(S.size() > 0){
            Q.offer(S.pop());
        }
        while(Q.size() > 0){
            S.push(Q.poll());
        }
        while(S.size() > 0){
            Q.offer(S.pop());
        }
        while(Q.size() > n % 2){
            int x = Q.poll();
            S.push(Q.poll());
            S.push(x);
        }
        if(Q.size() > 0) S.push(Q.poll());
        System.out.println(Q);
//        while(Q.size() > 0){
//            S.push(Q.poll());
//        }

    }

    /*
    * Uses recursion/backtracking to find the maximum sum of elements in L less than or equal to limit
    * */
    public static int maxSum(List<Integer> L, int limit){
        if(L.size() == 0)return 0;
        return maxSum(L, limit, 0, 0);
    }

    private static int maxSum(List<Integer> L, int limit, int sum, int index){
        if(sum > limit) return -1;
        if(index == L.size())return sum;
        return Math.max(maxSum(L, limit, sum, index + 1), maxSum(L, limit, sum + L.get(index), index + 1));

    }

    public static int getLongestRun(int[] values){
        int mri = -1;//maximum run index
        int mrl = 1;//Maximum run length
        int currentRunIndex = 0;
        int currentRunLength = 1;
        for(int i = 1; i < values.length; i++){
            if(values[i] == values[i-1]){
                currentRunLength++;
                if(currentRunLength > mrl){
                    mrl = currentRunLength;
                    mri = currentRunIndex;
                }
            } else {
                currentRunIndex = i;
                currentRunLength = 1;
            }
        }
        return mri;

    }




    public static int mode(int[] myNums){

        int[] freq = new int[max(myNums) + 1];
        int mode = 0;

        for(int i = 0; i < myNums.length; i++){
            freq[ myNums[i] ]++;
        }

        for(int i = 0; i < freq.length; i++){

            if(freq[i] > freq[mode]){
                mode = i;
            }
        }

        return mode;

    }

    public static int max(int[] myNums){
        int max = myNums[0];
        for(int i = 0; i < myNums.length; i++){

            int n = myNums[i];
            if(n > max) {
                max = n;
            };
        }

        return max;
    }

    public static int numberOfLeapYears(int year1, int year2){
        int counter = 0;
        for(int i = year1; i <= year2; i++){
            if(isLeapYear(i)){
                counter++;
            }
        }
        return counter;
    }

    public static int dayOfWeek(int month, int day, int year){
        int thisDay = firstDayOfYear(year) + dayOfYear(month, day, year) - 1;
        return thisDay % 7;
    }

    //Returns true if the year is a leap year, false otherwise
    public static boolean isLeapYear(int year){
        return true;
    }

    //Returns the integer value of the first day of the year
    //Sunday = 0, Monday = 1, Tuesday = 2, etc
    public static int firstDayOfYear(int year){
        return -1;
    }

    //Returns the number of days since January 1st of that year
    //Jan 3 = 3, Feb 3 = 34, etc
    public static int dayOfYear(int month, int day, int year){
        return -1;
    }


}


//----------------------------------------------------------------------------------------------------------------------
class KnightTourCP {
    static int N = 5;

    /* A utility function to check if i,j are
       valid indexes for N*N chessboard */
    static boolean isSafe(int x, int y, int sol[][]) {
        return (x >= 0 && x < N && y >= 0 && y < N
                && sol[x][y] == -1);
    }

    /* A utility function to print solution
       matrix sol[N][N] */
    static void printSolution(int sol[][]) {
        StringBuilder sb = new StringBuilder();
        for (int[] r : sol) {
            for (int c : r) {
                sb.append(String.format("[%s]", c >= 0 ? String.format("%1$2s",c) : "  "));
            }
            sb.append(String.format("%n"));
        }
        System.out.println(sb);
    }

    /* This function solves the Knight Tour problem
       using Backtracking.  This  function mainly
       uses solveKTUtil() to solve the problem. It
       returns false if no complete tour is possible,
       otherwise return true and prints the tour.
       Please note that there may be more than one
       solutions, this function prints one of the
       feasible solutions.  */
    static boolean solveKT() {
        int sol[][] = new int[N][N];

        /* Initialization of solution matrix */
        for (int x = 0; x < N; x++)
            for (int y = 0; y < N; y++)
                sol[x][y] = -1;

        /* xMove[] and yMove[] define next move of Knight.
           xMove[] is for next value of x coordinate
           yMove[] is for next value of y coordinate */
        int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};

        // Since the Knight is initially at the first block
        sol[0][0] = 0;

        /* Start from 0,0 and explore all tours using
           solveKTUtil() */
        if (!solveKTUtil(0, 0, 1, sol, xMove, yMove)) {
            System.out.println("Solution does not exist");
            return false;
        } else
            printSolution(sol);

        return true;
    }

    /* A recursive utility function to solve Knight
       Tour problem */
    static boolean solveKTUtil(int x, int y, int movei,
                               int sol[][], int xMove[],
                               int yMove[]) {
        int k, next_x, next_y;
        if (movei == N * N)
            return true;

        /* Try all next moves from the current coordinate
            x, y */
        for (k = 0; k < 8; k++) {
            next_x = x + xMove[k];
            next_y = y + yMove[k];
            if (isSafe(next_x, next_y, sol)) {
                sol[next_x][next_y] = movei;
                if (solveKTUtil(next_x, next_y, movei + 1,
                        sol, xMove, yMove))
                    return true;
                else
                    sol[next_x][next_y]
                            = -1; // backtracking
            }
        }

        return false;
    }

    /* Driver Code */
    public static void main(String args[]) {
        // Function Call
        solveKT();
    }
}
class KnightTour {
    static int N = 5;

    static boolean isSafe(int x, int y, int[][] sol) {
        return x < N && x >= 0 &&
                y < N && y >= 0 &&
                sol[x][y] == -1;
    }

    static void printBoard(int[][] sol) {
        StringBuilder sb = new StringBuilder();
        for (int[] r : sol) {
            for (int c : r) {
                sb.append(String.format("[%s]", c >= 0 ? String.format("%1$2s",c) : "  "));
            }
            sb.append(String.format("%n"));
        }
        System.out.println(sb);
    }

    static boolean solve() {
        int[][] sol = new int[N][N];
//        for (int[] r : sol) {
////            Arrays.fill(r, -1);
////        }
        for(int x = 0; x < N; x++){
            for(int y = 0; y < N; y++){
                sol[x][y] = -1;
            }
        }

//        int[][] steps = new int[][]{
//                {2, 1},
//                {1, 2},
//                {-2, 1},
//                {-1, 2},
//                {2, -1},
//                {1, -2},
//                {-2, -1},
//                {-1, -2}
//        };
        int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};
        sol[0][0] = 0;
        if (!solveDrive(0, 0, 1, sol, xMove, yMove)) {
            System.out.println("No Solution");
            return false;
        } else {
            printBoard(sol);
        }
        return true;
    }

    static boolean solveDrive(int x, int y, int M, int[][] sol, int[] xMove, int[] yMove) {
        int nx, ny, k;
        if(M == N*N)return true;
        for (k = 0; k < 8; k++) {
            nx = x + xMove[k]; ny = y + yMove[k];
            if (isSafe(nx, ny, sol)) {
                sol[nx][ny] = M;
                if (solveDrive(nx, ny, M + 1, sol, xMove, yMove)) return true;
                else sol[nx][ny] = -1;
            }
        }
        return false;
    }
}

class Solution {
    public int hIndex(int[] citations) {
        int max = 0, n = citations.length;
        for (int x : citations) {
            max = Math.max(max, x);
        }
        int[] dp = new int[max + 1];
        for (int x : citations) {
            dp[x]++;
        }
        for (int i = 1; i < dp.length; i++) {
            dp[i] += dp[i - 1];
        }
        System.out.println(Arrays.toString(dp));
        for (int h = dp.length - 1; h >= 0; h--) {
            if (dp[h] == h) return h;
        }
        return 0;
    }
}


class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class LocalUtil {

    static int[] parseIntArray(String str) {
        str = str.replaceAll("\\[", "").replaceAll("]", "");
        String[] arr = str.split(",");
        int[] ret = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ret[i] = Integer.parseInt(arr[i]);
        }
        return ret;
    }

}

//Definition for a binary tree node.
class TreeNode {
    Integer val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(Integer val) {
        this.val = val;
    }

    TreeNode(Integer val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    //code for a simple binary tree

    //        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(9);
//        root.right = new TreeNode(20);
//        root.right.left = new TreeNode(15);
//        root.right.right = new TreeNode(7);


    @Override
    public String toString() {
        return String.format("(%s)", val);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "" + val;
    }
}


