package net.mooctest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class NewManShanksPrime_Test {

    @Test
    @Timeout(4000)
    public void testNthManShanksPrime() {
        assertTrue(NewManShanksPrime.nthManShanksPrime(0, 1));
        assertTrue(NewManShanksPrime.nthManShanksPrime(1, 1));
        assertTrue(NewManShanksPrime.nthManShanksPrime(2, 3));
        assertTrue(NewManShanksPrime.nthManShanksPrime(3, 7));
        assertTrue(NewManShanksPrime.nthManShanksPrime(4, 17));
        assertTrue(NewManShanksPrime.nthManShanksPrime(5, 41));
    }

    @Test
    @Timeout(4000)
    public void testNthManShanksPrime_InvalidInput() {
        // Test with negative input
        assertFalse(NewManShanksPrime.nthManShanksPrime(-1, 1));
        // Test with non-integer input
        assertFalse(NewManShanksPrime.nthManShanksPrime(1, 2));
    }
}