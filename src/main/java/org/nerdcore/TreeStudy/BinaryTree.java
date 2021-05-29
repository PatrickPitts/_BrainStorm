package org.nerdcore.TreeStudy;

public class BinaryTree<E> {

    protected Node<E> root;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(Node<E> root) {
        this.root = root;
    }

    public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
        this.root = new Node<E>(data);
        if (leftTree != null) root.left = leftTree.root;
        if (rightTree != null) root.right = rightTree.root;
    }

    public BinaryTree<E> getLeftSubtree() {
        if (root != null && root.left != null) {
            return new BinaryTree<>(root.left);
        }
        return null;
    }

    public BinaryTree<E> getRightSubtree() {
        if (root != null && root.right != null) {
            return new BinaryTree<>(root.right);
        }
        return null;
    }

    public boolean isLeaf(){
        return root!=null && root.left==null && root.right ==null;
    }


    protected static class Node<E> {

        E data;
        Node<E> left, right;

        Node(E data) {
            this.data = data;
        }

        Node(E data, E left, E right) {
            this(data);
            this.left = new Node<E>(left);
            this.right = new Node<E>(right);
        }

        Node(E data, Node<E> left, Node<E> right) {
            this(data);
            this.left = left;
            this.right = right;
        }

        public String toString() {
            return data.toString();
        }
    }
}
