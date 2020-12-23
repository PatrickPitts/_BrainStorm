package org.nerdcore.LinkedListStudy;

public class SingleLinkedList {

    private SingleLinkedListNode head;

    public SingleLinkedList() {
    }

    public SingleLinkedList(SingleLinkedListNode head) {
        this.head = head;
    }

    public SingleLinkedList(int data){
        this.head = new SingleLinkedListNode(data);
    }

    public SingleLinkedList(int[] arr){
        for(int num : arr){
            this.append(num);
        }
    }

    public void append(int data){
        if(this.head == null) {
            this.head = new SingleLinkedListNode(data);
        } else {
            this.head.append(new SingleLinkedListNode(data));
        }
    }

    public void append(Node node){
        this.head.append(node);
    }


    public void print(){
        if(this.head == null)return;
        if(this.head.getNext() != null){
            System.out.printf("[%d", this.head.getData());
            this.head.getNext().print();
            System.out.println("]");
        }
    }

    public int get(int index){
        try{
            return this.head.seekForIndex(index);
        } catch (IndexOutOfBoundsException e){
            String message = "Index %s is out of bounds.";
            throw new IndexOutOfBoundsException(String.format(message, index));
        }
    }

    public void insert(int value, int index){
        try{
            this.head.insert(value, index);
        } catch (IndexOutOfBoundsException e){
            String message = "Index %s is out of bounds.";
            throw new IndexOutOfBoundsException(String.format(message, index));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
