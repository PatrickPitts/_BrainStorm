package org.nerdcore;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;


public class App {



    public static void main(String[] args) {

        Solution s = new Solution();
        Stopwatch st = new Stopwatch();
        for(String A : args){
            System.out.println(A);

            //System.out.println(s.pivotIndex(parseIntArray(A)));
        }
    }
    static int[] parseIntArray(String str){
        str = str.replaceAll("\\[", "").replaceAll("]", "");
        String[] arr = str.split(",");
        int[] ret = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            ret[i] = Integer.parseInt(arr[i]);
        }
        return ret;
    }
}


//----------------------------------------------------------------------------------------------------------------------
class Solution {
    public int pivotIndex(int[] nums) {
        int R = 0, L = 0, p = 0;
        for(int i = 1; i < nums.length; i++){
            R += nums[i];
        }
        while(L != R && p < nums.length - 1){
            L += nums[p];
            p++;
            R -= nums[p];
        }
        return L == R ? p : -1;
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


