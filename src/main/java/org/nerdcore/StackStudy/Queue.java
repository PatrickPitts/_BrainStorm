package org.nerdcore.StackStudy;

public class Queue{
    public static class Node{
        int data;
        Node next;
        Node submin;

        public Node(int data) {
            this.data = data;
        }

        public Node checkSubmin(){
            if(this.next == null) {
                this.submin = this;
            } else {
                Node test = this.next.checkSubmin();
                this.submin = (test.data < this.data) ? test : this;
            }
            return this.submin;



        }

    }

    public Node front;
    public Node end;

    public Node getMin(){
        return front.checkSubmin();
    }

    //adds a node to the end of the queue
    public void add(int item){

        if(front == null) {
            front = new Node(item);
        }
        else if(end == null) {
            end = new Node(item);

            front.next = end;

        } else {
            end.next = new Node(item);
            end = end.next;
        }
    }

    //removes the item at the front
    public int remove() throws Exception {
        if(front == null) throw new Exception("Empty Queue");
        int data = front.data;
        front = front.next;
        end = (front == null) ? null : end;
        return data;
    }

    //returns the data from the front of the queue
    public int peek() throws Exception {
        if(front == null)throw new Exception("Empty Queue");
        return front.data;
    }

    //checks if the queue is empty
    public boolean isEmpty(){return front == null;}
}
