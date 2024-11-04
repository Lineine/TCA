package net.mooctest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UniquePaths_Test {

    @Test
    @Timeout(4000)
    public void testUniquePaths() {
        assertEquals(28, UniquePaths.uniquePaths(3, 7));
        assertEquals(28, UniquePaths.uniquePaths(7, 3));
        assertEquals(3, UniquePaths.uniquePaths(2, 3));
        assertEquals(3, UniquePaths.uniquePaths(3, 2));
        assertEquals(1, UniquePaths.uniquePaths(1, 1));
        assertEquals(1, UniquePaths.uniquePaths(1, 10));
        assertEquals(1, UniquePaths.uniquePaths(10, 1));
    }

    @Test
    @Timeout(4000)
    public void testUniquePaths2() {
        assertEquals(28, UniquePaths.uniquePaths2(3, 7));
        assertEquals(28, UniquePaths.uniquePaths2(7, 3));
        assertEquals(3, UniquePaths.uniquePaths2(2, 3));
        assertEquals(3, UniquePaths.uniquePaths2(3, 2));
        assertEquals(1, UniquePaths.uniquePaths2(1, 1));
        assertEquals(1, UniquePaths.uniquePaths2(1, 10));
        assertEquals(1, UniquePaths.uniquePaths2(10, 1));
    }
}
