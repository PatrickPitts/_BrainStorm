package org.nerdcore;


import javax.swing.plaf.SliderUI;
import java.util.*;
import java.util.LinkedList.*;

public class App {


    public static void main(String[] args) {

        String S = "TENNESSEE";
        Map<String, Integer> words = new HashMap<>();
        for(int i = 0; i < S.length(); i++){
            for(int j = 0; j < S.length(); j++){
                for(int k = 0; k < S.length(); k++){
                    if(i != j && j != k&& k != i){
                        String str = new String(new char[]{S.charAt(i), S.charAt(j), S.charAt(k)});
                        words.put(str, words.getOrDefault(str, 0)+1);
                    }
                }
            }
        }
        System.out.println(words.size());
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


