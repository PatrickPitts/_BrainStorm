package org.nerdcore.StackStudy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @Test
    void getMin() throws Exception {
        Queue q1 = new Queue();
        q1.add(1);
        q1.add(2);
        q1.add(3);
        assertEquals(1, q1.getMin().data);

        Queue q2 = new Queue();
        q2.add(3);
        q2.add(2);
        q2.add(1);
        q2.add(2);
        q2.add(3);

        assertEquals(1, q2.getMin().data);

    }

    @Test
    void peek() throws Exception {
        Queue q = new Queue();
        q.front = new Queue.Node(1);
        assertEquals(new Integer(1), q.peek());
    }


    @Test
    void add() throws Exception {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);

        assertEquals(new Integer(1), q.front.data);
        assertEquals(new Integer(2), q.front.next.data);
        assertEquals(new Integer(3), q.front.next.next.data);

    }

    @Test
    void remove() throws Exception {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        assertEquals(new Integer(1), q.peek());
        q.remove();
        assertEquals(new Integer(2), q.peek());



    }



    @Test
    void isEmpty() {
        Queue q = new Queue();
        assertTrue(q.isEmpty());
        q.add(1);
        assertFalse(q.isEmpty());
    }
}