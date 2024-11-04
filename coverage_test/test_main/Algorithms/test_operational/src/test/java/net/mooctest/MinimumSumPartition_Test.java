package net.mooctest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumSumPartition_Test {

    @Test
    @Timeout(4000)
    public void testEmptyArray() {
        int[] array = new int[0];
        assertEquals(0, MinimumSumPartition.minimumSumPartition(array));
    }

    @Test
    @Timeout(4000)
    public void testSingleElementArray() {
        int[] array = new int[]{5};
        assertEquals(5, MinimumSumPartition.minimumSumPartition(array));
    }

    @Test
    @Timeout(4000)
    public void testEvenSumArray() {
        int[] array = new int[]{1, 2, 3, 4};
        assertEquals(1, MinimumSumPartition.minimumSumPartition(array));
    }

    @Test
    @Timeout(4000)
    public void testOddSumArray() {
        int[] array = new int[]{1, 2, 3, 5};
        assertEquals(3, MinimumSumPartition.minimumSumPartition(array));
    }

    @Test
    @Timeout(4000)
    public void testNegativeNumberArray() {
        int[] array = new int[]{1, 2, -3, 4};
        MinimumSumPartition.minimumSumPartition(array);
    }

    @Test
    @Timeout(4000)
    public void testLargeArray() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertEquals(1, MinimumSumPartition.minimumSumPartition(array));
    }
}
