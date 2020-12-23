package org.nerdcore.LinkedListStudy;

public abstract class Node {
    int data;
    Node next;

    public Node(){}

    public Node(int data, Node next){
        this.data = data;
        this.next = next;
    }

    public Node(int data){
        this.data = data;
    }

    void print(){
        System.out.printf(" -> %d", this.data);
        if(this.next != null){next.print();}
    }

    void append(Node node){
        if(this.next == null){
            this.next = node;
        } else {
            this.next.append(node);
        }
    }

    int seekForIndex(int n) throws IndexOutOfBoundsException{
        if(n==0)return this.data;
        if(this.next == null) throw new IndexOutOfBoundsException();
        return this.next.seekForIndex(n-1);
    }


    abstract void insert(int value, int index) throws IndexOutOfBoundsException, CloneNotSupportedException;
}
