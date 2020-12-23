package org.nerdcore.LinkedListStudy;

public class CustomHashMap {

    private HashLinkedList[] hashArray = new HashLinkedList[100];

    public CustomHashMap(){
        for(int i = 0; i < hashArray.length; i++){
            hashArray[i] = new HashLinkedList();
        }
    }

    public void put(Object key, Object value){
        hashArray[key.hashCode() % 100].append(key, value);
    }

    public Object get(Object key){
        return hashArray[key.hashCode() % 100].seek(key);

    }

    public void print(){
        for(int i = 0; i < hashArray.length; i++){
            System.out.printf(i + ": ");
            hashArray[i].print();
        }
    }

    private static class HashLinkedList{

        Node head;

        HashLinkedList() {}

        void append(Object key, Object value){
            if(this.head == null){
                this.head = new Node(key, value);
            } else {
                this.head.append(key, value);
            }
        }

        Object seek(Object key){
            return this.head != null ? this.head.seek(key) : null;
        }

        void print(){
            System.out.print('[');
            if(this.head != null)this.head.print(true);
            System.out.println(']');
        }

        void deleteByKey(Object key){
            if(this.head != null){}
        }
    }

    private static class Node{

        Object key;
        Object value;
        Node next;

        public Node(Object key, Object value) {
            this.key = key;
            this.value = value;
        }

        void deleteByKey(Object key){
            if(this.next != null){

            }
        }

        void append(Object key, Object value){
            if(this.next == null){
                this.next = new Node(key, value);
            } else {
                this.next.append(key, value);
            }
        }

        Object seek(Object key){

            return this.key.equals(key) ? this.value : (this.next != null ? this.next.seek(key) : null);
        }

        void print(boolean isHead){
            if(!isHead) System.out.print(" -> ");
            System.out.print(this);
            if(this.next != null) this.next.print(false);
        }


        @Override
        public String toString() {
            return "[" +
                    "key=" + key +
                    ", value=" + value +
                    ']';
        }
    }

    public static void main(String[] args) {
        CustomHashMap map = new CustomHashMap();
        for(int i = 0; i < 1000; i++){
            map.put(i,i);
        }

        map.print();
    }
}
