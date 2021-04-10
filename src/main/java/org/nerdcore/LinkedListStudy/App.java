package org.nerdcore.LinkedListStudy;

import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        System.out.println(map.get(0));
    }

    public static SingleLinkedList sumReversed(SingleLinkedList list1, SingleLinkedList list2){
        int sum = 0;
        SingleLinkedList res = new SingleLinkedList();
        SingleLinkedList.Node n1 = list1.head;
        SingleLinkedList.Node n2 = list2.head;
        while(n1 != null && n2 != null){
            sum = (n1 != null) ? sum + n1.data : sum;
            sum = (n2 != null) ? sum + n2.data : sum;
            res.append(sum %10);
            sum = sum / 10;
            if(n1 != null){ n1 = n1.next;}
            if(n2 != null){ n2 = n2.next;}
        }
        if(sum > 0){
            res.append(sum);
        }
        return res;
    }

    public static SingleLinkedList removeDups(SingleLinkedList list) {
        //node value, count of value
        HashMap<Integer, Integer> counts = new HashMap<>();
        if (list.head == null) return list;
        SingleLinkedList newList = new SingleLinkedList();
        SingleLinkedList.Node n = list.head;

        do {
            if (counts.get(n.data) == null) {
                newList.append(n.data);
            }
            counts.put(n.data, 1);
            n = n.next;
        } while (n != null);

        return newList;
    }

    public SingleLinkedList partition(SingleLinkedList start, int partition) {
        SingleLinkedList lessThan = new SingleLinkedList();
        SingleLinkedList greaterThan = new SingleLinkedList();
        if (start.head == null || start.head.next == null) return start;
        SingleLinkedList.Node n = start.head;
        do {
            if (n.data >= partition) {
                greaterThan.append(n.data);
            } else {
                lessThan.append(n.data);
            }
            n = n.next;
        } while (n != null);
        if (lessThan.head == null) {
            return greaterThan;
        }
        if (greaterThan.head == null) {
            return lessThan;
        }
        n = lessThan.head;
        while (n.next != null) {
            n = n.next;
        }
        n.next = greaterThan.head;
        return lessThan;

    }

}
