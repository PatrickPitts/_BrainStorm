package org.nerdcore.Tools;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathToolsTest {

    @Test
    void average() {
        assertEquals(4., MathTools.average(4, 4));
        assertEquals(3., MathTools.average(3,3,3));
        assertEquals(6., MathTools.average(5,7,5,7,5,7));
        assertEquals(0., MathTools.average());
    }


    @Test
    void dist() {
//        assertEquals(5., MathTools.dist(0,3,0,4));
    }
}