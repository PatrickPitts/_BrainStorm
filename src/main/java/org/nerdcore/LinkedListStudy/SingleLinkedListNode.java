package org.nerdcore.LinkedListStudy;

public class SingleLinkedListNode extends Node {


    public SingleLinkedListNode() {
    }

    public SingleLinkedListNode(int data, SingleLinkedListNode next) {
        this.data = data;
        this.next = next;
    }

    public SingleLinkedListNode(int data){
        this.data=data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(SingleLinkedListNode next) {
        this.next = next;
    }

    public void setNext(int nextData){
        this.next = new SingleLinkedListNode(nextData);
    }

    @Override
    void insert(int value, int index) throws IndexOutOfBoundsException, CloneNotSupportedException {
        if(index == 0){
            SingleLinkedListNode newNext = new SingleLinkedListNode(this.data, (SingleLinkedListNode) this.next);
            this.setNext(newNext);
            this.setData(value);

        }
        else if(this.next == null) {
            throw new IndexOutOfBoundsException();
        } else {
            this.next.insert(value, index - 1);
        }
    }
}
