package org.nerdcore.StackStudy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void isFull() {

        Stack<Integer> s = new Stack<>();
        s.push(9);
        s.push(3);
        s.push(5);
        s.push(7);


        assertTrue(s.isFull(3));
        assertTrue(s.isFull(4));
        assertFalse(s.isFull(5));
    }

    @Test
    void push() {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        assertEquals(1, s.peek());

        s.push(2);
        assertEquals(2, s.peek());

        s.push(3);

        assertEquals(3, s.peek());
    }

    @Test
    void isEmpty() {
        Stack<Integer> s = new Stack<>();
        assertTrue(s.isEmpty());
        s.push(1);
        assertFalse(s.isEmpty());
    }

    @Test
    void pop() {
    }

    @Test
    void peek() {
    }
}