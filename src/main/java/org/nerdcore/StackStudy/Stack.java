package org.nerdcore.StackStudy;

import java.util.EmptyStackException;

public class Stack<T> {

    private static class StackNode<T>{
        private T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }

    private StackNode<T> top;

    public void push(T newData){
        StackNode<T> t = new StackNode<>(newData);
        t.next = top;
        top = t;
    }

    public boolean isFull(int size){
        StackNode<T> n = top;
        int count = 0;
        while(count++ < size){
            if(n == null)return false;
            n = n.next;
        }
        return true;

    }

    public T pop(){
        if(top == null) throw new EmptyStackException();
        T ret = top.data;
        top = top.next;
        return ret;
    }

    public T peek(){
        if(top == null) throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public void report(){
        if(top == null){
            System.out.println("[]");
            return;
        }
        System.out.printf("TOP: [%s",top.data);
        StackNode<T> n = top.next;
        while(n != null){
            System.out.printf(" -> %s", n.data);
            n=n.next;
        }
        System.out.printf("]%n");
    }

}
