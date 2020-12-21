package org.nerdcore.LinkedListStudy;

public class SingleLinkedListNode {
    private int data;
    private SingleLinkedListNode next;

    public SingleLinkedListNode() {
    }

    public SingleLinkedListNode(int data, SingleLinkedListNode next) {
        this.data = data;
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public SingleLinkedListNode getNext() {
        return next;
    }

    public void setNext(SingleLinkedListNode next) {
        this.next = next;
    }

    public void print(){
        System.out.printf(",%d", this.data);
        if(this.next != null){
            this.next.print();
        }
    }
}
