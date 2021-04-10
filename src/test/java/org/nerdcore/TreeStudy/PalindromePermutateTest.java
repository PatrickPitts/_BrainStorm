package org.nerdcore.TreeStudy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromePermutateTest {

    @Test
    public void check(){
        assertTrue(PalindromePermutate.check("aatt"));
        assertFalse(PalindromePermutate.check("asdf"));
        assertTrue(PalindromePermutate.check(""));
        assertTrue(PalindromePermutate.check("                tacocat"));
        assertFalse(PalindromePermutate.check("aaaaasssd"));

    }

}