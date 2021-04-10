package org.nerdcore.LinkedListStudy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleLinkedListTest {

    @Test
    public void check(){
        SingleLinkedList list = new SingleLinkedList();
        list.append(1).append(2).append(3).append(4).append(5);
        assertEquals("[1 -> 2 -> 3 -> 4 -> 5]", list.toString());

    }
    @Test
    public void removeDup(){
        SingleLinkedList list1 = new SingleLinkedList();
        SingleLinkedList list2 = new SingleLinkedList();
        SingleLinkedList list3 = new SingleLinkedList();
        SingleLinkedList list4 = new SingleLinkedList();

        list1.append(1).append(1).append(1).append(1).append(1);
        list2.append(1);
        list3.append(5).append(4).append(5).append(2).append(1);
        list4.append(1).append(2).append(3).append(4).append(5);

        list1 = App.removeDups(list1);
        System.out.println(list1);
        assertTrue(list1.equals(list2));

    }

    @Test
    public void testLength(){
        SingleLinkedList list = new SingleLinkedList();
        list.append(1).append(2).append(3).append(4).append(5);
        assertEquals(5, list.getLength());
        assertEquals(0, (new SingleLinkedList()).getLength());
    }

    @Test
    void getKthFromLast() {

        SingleLinkedList list1 = new SingleLinkedList(new int[]{1, 2, 3, 4, 5});
        SingleLinkedList list2 = new SingleLinkedList();
        assertEquals(4, list1.getKthFromLast(2).data);
        assertNotEquals(5, list2.getKthFromLast(5).data);
    }

    @Test
    void deleteMiddle(){
        SingleLinkedList list1 = new SingleLinkedList(new int[]{1,2,3,4,5});
        SingleLinkedList list2 = new SingleLinkedList(new int[]{1,2,4,5});
        list1.deleteMiddle(3);
        assertTrue(list1.equals(list2));

        list1.deleteMiddle(5);
        assertTrue(list1.equals(list2));
    }

    @Test
    void sumReversed(){
        SingleLinkedList list1 = new SingleLinkedList(new int[]{7,1,6});
        SingleLinkedList list2 = new SingleLinkedList(new int[]{5,9,2});
        SingleLinkedList result = new SingleLinkedList(new int[]{2,1,9});
        assertTrue(App.sumReversed(list1, list2).equals(result));
        assertTrue(App.sumReversed(
                new SingleLinkedList(new int[]{1}),
                new SingleLinkedList(new int[]{1})
        ).equals(new SingleLinkedList(new int[]{2})));

        assertTrue(App.sumReversed(
                new SingleLinkedList(new int[]{0,0,5}),
                new SingleLinkedList(new int[]{0,0,5})
        ).equals(new SingleLinkedList(new int[]{0,0,0,1})));

    }

}