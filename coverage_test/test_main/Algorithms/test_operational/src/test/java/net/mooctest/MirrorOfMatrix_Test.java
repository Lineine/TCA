package net.mooctest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MirrorOfMatrix_Test {
    @Test
    @Timeout(4000)
    public void testNullInput() {
        int[][] result = MirrorOfMatrix.mirrorMatrix(null);
        assertNull(result);
    }

    @Test
    @Timeout(4000)
    public void testEmptyMatrix() {
        int[][] original = new int[0][0];
        int[][] result = MirrorOfMatrix.mirrorMatrix(original);
        assertEquals(0, result.length);
        assertEquals(0, result[0].length);
    }

    @Test
    @Timeout(4000)
    public void testSingleElementMatrix() {
        int[][] original = new int[][] {{1}};
        int[][] result = MirrorOfMatrix.mirrorMatrix(original);
        assertEquals(1, result.length);
        assertEquals(1, result[0].length);
        assertEquals(1, result[0][0]);
    }

    @Test
    @Timeout(4000)
    public void testMultipleElementsMatrix() {
        int[][] original = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] result = MirrorOfMatrix.mirrorMatrix(original);
        assertEquals(3, result.length);
        assertEquals(3, result[0].length);
        assertEquals(3, result[0][0]);
        assertEquals(2, result[0][1]);
        assertEquals(1, result[0][2]);
        assertEquals(6, result[1][0]);
        assertEquals(5, result[1][1]);
        assertEquals(4, result[1][2]);
        assertEquals(9, result[2][0]);
        assertEquals(8, result[2][1]);
        assertEquals(7, result[2][2]);
    }

    @Test
    @Timeout(4000)
    public void testInvalidMatrixInput() {
        int[][] original = new int[][] {{1, 2}, {3, 4, 5}};
        MirrorOfMatrix.mirrorMatrix(original);
    }
}
