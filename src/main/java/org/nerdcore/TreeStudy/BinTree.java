package org.nerdcore.TreeStudy;

import java.util.Random;

public class BinTree {

    private Node root;
    private int[] dataArr;
    private int[] inOrderArr;
    private final Random random = new Random();

    public BinTree() {
    }

    public BinTree(int[] arr) {
        this.dataArr = arr.clone();

        this.setRoot(insertLevelOrder(dataArr, this.getRoot(), 0));
    }





    public Node insertLevelOrder(int[] arr, Node root, int nodeNum) {
        if (nodeNum < arr.length) {
            root = new Node(arr[nodeNum]);
            root.setLeftNode(insertLevelOrder(arr, root.getLeftNode(), 2 * nodeNum + 1));
            root.setRightNode(insertLevelOrder(arr, root.getRightNode(), 2 * nodeNum + 2));
        }
        return root;
    }

    public void setData(int[] arr) {
        this.dataArr = arr.clone();
        this.setRoot(insertLevelOrder(dataArr, this.getRoot(), 0));
    }

    public int[] getDataArr() {
        return this.dataArr;
    }

    public void printInOrder(Node root) {
        if (root != null) {
            printInOrder(root.getLeftNode());
            System.out.print(root.getData() + ", ");
            printInOrder(root.getRightNode());
        }
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void printIndexAlgorithm() {
        System.out.println("Assuming a Complete Binary Tree");
        System.out.println("for the i'th node in arr[] data");
        System.out.println("left child is arr[2i+1]");
        System.out.println("right child is arr[2i+2]");
    }

    public void printHeapParameters() {
        System.out.println("Heaps are complete binary trees");
        System.out.println("every parent node is either higher or lower than its children");
        System.out.println("arr[i] > arr[2i+1] && arr[i] > [2i+2]");
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static boolean isMaxHeap(int[] arr) {
        return isMaxHeap(arr, 0);
    }

    public boolean isMaxHeap() {
        return isMaxHeap(this.dataArr, 0);
    }

    public static boolean isMaxHeap(int[] arr, int i) {
        //if node has no children
        if (2 * i + 1 > arr.length - 1) return true;

        //if node has only left child
        if (2 * i + 2 > arr.length - 1) return arr[i] >= arr[2 * i + 1] && isMaxHeap(arr, 2 * i + 1);

        //if node has 2 children
        return arr[i] >= arr[2 * i + 1]
                && arr[i] >= arr[2 * i + 2]
                && isMaxHeap(arr, 2 * i + 1)
                && isMaxHeap(arr, 2 * i + 2);
    }

    public static boolean isMinHeap(int[] arr) {
        return isMinHeap(arr, 0);
    }

    public static boolean isMinHeap(int[] arr, int i) {
        //if node has no children
        if (2 * i + 1 > arr.length - 1) return true;

        //if node has only left child
        if (2 * i + 2 > arr.length - 1) return arr[i] <= arr[2 * i + 1] && isMinHeap(arr, 2 * i + 1);

        //if node has 2 children
        return arr[i] <= arr[2 * i + 1]
                && arr[i] <= arr[2 * i + 2]
                && isMinHeap(arr, 2 * i + 1)
                && isMinHeap(arr, 2 * i + 2);
    }


    public void minHeapify() {
        minHeapify(this.dataArr, 0);
    }

    public static void minHeapify(int[] arr, int i) {
        if (2 * i + 1 > arr.length - 1) return;
        else if (i == 0) {
            minHeapify(arr, 1);
            minHeapify(arr, 2);
        } else {
            minHeapify(arr, 2 * i + 1);
            minHeapify(arr, 2 * i + 2);

            int smallest = arr[i];
            if (2 * i + 1 < arr.length - 1 && arr[2 * i + 1] < arr[i]) smallest = arr[2 * i + 1];
            if (2 * i + 2 < arr.length - 1 && arr[2 * i + 2] < arr[i]) smallest = arr[2 * i + 2];
            if (smallest != i) {
                int temp = arr[smallest];
                arr[smallest] = arr[i];
                arr[i] = temp;
            }

        }

    }

    public void maxHeapify() {
        maxHeapify(this.dataArr, 0, this.dataArr.length);
    }

    public static void maxHeapify(int[] arr, int i, int n) {

        if(i > n)return;
        int li = 2 * i + 1;
        int ri = 2 * i + 2;

        maxHeapify(arr, li, n);
        maxHeapify(arr, ri, n);

        int largest = i;
        if (li < n && arr[li] > arr[largest]) largest = li;
        if (ri < n && arr[ri] > arr[largest]) largest = ri;
        if(largest != i){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            maxHeapify(arr, largest, n);
        }
    }

    public Node dfs(int param) {
        if (this.root.getData() == param) {
            return this.root;
        }
        return null;
    }

    public Node dfs(int param, Node node) {
        System.out.printf("Checking: %s%n", node);
        if (node.getData() == param) return node;
        Node testNode;
        testNode = dfs(param, node.getLeftNode());
        if (testNode != null) return testNode;
        testNode = dfs(param, node.getRightNode());
        return testNode;
    }
}
