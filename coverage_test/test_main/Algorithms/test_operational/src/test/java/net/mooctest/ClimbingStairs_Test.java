package net.mooctest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClimbingStairs_Test {

    @Test
    @Timeout(4000)
    public void testNumberOfWays() {
        assertEquals(0, ClimbingStairs.numberOfWays(0));
        assertEquals(1, ClimbingStairs.numberOfWays(1));
        assertEquals(2, ClimbingStairs.numberOfWays(2));
        assertEquals(3, ClimbingStairs.numberOfWays(3));
        assertEquals(5, ClimbingStairs.numberOfWays(4));
        assertEquals(8, ClimbingStairs.numberOfWays(5));
        assertEquals(13, ClimbingStairs.numberOfWays(6));
    }
}