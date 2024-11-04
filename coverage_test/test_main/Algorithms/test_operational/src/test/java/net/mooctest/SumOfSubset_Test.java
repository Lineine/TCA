package net.mooctest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SumOfSubset_Test {

    @Test
    @Timeout(4000)
    public void testEmptyArray() {
        int[] arr = new int[0];
        assertFalse(SumOfSubset.subsetSum(arr, 0, 5));
    }

    @Test
    @Timeout(4000)
    public void testSingleElementArray() {
        int[] arr = new int[]{5};
        assertTrue(SumOfSubset.subsetSum(arr, 0, 5));
        assertFalse(SumOfSubset.subsetSum(arr, 0, 10));
    }

    @Test
    @Timeout(4000)
    public void testMultipleElementsArray() {
        int[] arr = new int[]{3, 9, 8, 4, 5, 7};
        assertTrue(SumOfSubset.subsetSum(arr, arr.length - 1, 15));
        assertTrue(SumOfSubset.subsetSum(arr, arr.length - 1, 20));
        assertFalse(SumOfSubset.subsetSum(arr, arr.length - 1, 30));
    }

    @Test
    @Timeout(4000)
    public void testKeyGreaterThanArraySum() {
        int[] arr = new int[]{1, 2, 3, 4};
        assertFalse(SumOfSubset.subsetSum(arr, arr.length - 1, 15));
    }

    @Test
    @Timeout(4000)
    public void testKeyEqualToArraySum() {
        int[] arr = new int[]{1, 2, 3, 4};
        assertTrue(SumOfSubset.subsetSum(arr, arr.length - 1, 10));
    }
}
