package org.nerdcore.LinkedListStudy;

import java.util.Arrays;

public class SingleLinkedList {

    Node head;

    public SingleLinkedList(Node head) {
        this.head = head;
    }

    public SingleLinkedList() {
    }


    public SingleLinkedList(int[] arr) {
        for (int j : arr) {
            this.append(j);
        }
    }

    public void deleteMiddle(int value) {
        deleteMiddle(new Node(value));
    }

    public void deleteMiddle(Node nodeToDelete) {
        if (this.head == null || this.head.next == null) return;
        Node thisNode = this.head.next;
        while (thisNode.next != null && thisNode.next.next != null) {
            if (thisNode.next.equals(nodeToDelete)) {
                thisNode.next = thisNode.next.next;
                break;
            }
            thisNode = thisNode.next;
        }
    }

    public SingleLinkedList append(Node endNode) {
        if (head == null) {
            this.head = endNode;
        } else {
            Node n = this.head;
            while (n.next != null) {
                n = n.next;
            }
            n.setNext(endNode);
        }
        return this;
    }

    public SingleLinkedList append(int data) {
        return append(new Node(data));
    }

    @Override
    public String toString() {
        if (head == null) {
            return "[]";
        }
        StringBuilder s = new StringBuilder("[" + head.data);
        Node n = head;
        while (n.next != null) {
            n = n.next;
            s.append(" -> ").append(n.data);
        }
        s.append("]");
        return s.toString();

    }

    public boolean equals(SingleLinkedList other) {
        Node thisNode = this.head;
        Node otherNode = other.head;
        if (thisNode.data != otherNode.data) return false;
        while (thisNode.next != null && otherNode.next != null) {
            thisNode = thisNode.next;
            otherNode = otherNode.next;
            if (thisNode.data != otherNode.data) return false;
        }
        return thisNode.next == null && otherNode.next == null;
    }

    public int getLength(Node n) {
        if (n == null) return 0;
        if (n.next == null) return 1;
        return getLength(n.next) + 1;
    }

    public int getLength() {
        return getLength(this.head);
    }

    public Node getKthFromLast(int K) {
        if (this.getLength() < K) return null;
        Node toEnd = this.head;
        Node kth = this.head;
        for (int i = 0; i < K; i++) {
            toEnd = toEnd.next;
        }
        while (toEnd != null) {
            kth = kth.next;
            toEnd = toEnd.next;
        }
        return kth;
    }

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        void setNext(int data) {
            this.next = new Node(data);
        }

        void setNext(Node next) {
            this.next = next;
        }

        boolean equals(Node other) {
            return this.data == other.data;
        }
    }
}


