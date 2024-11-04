package net.mooctest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubsetCount_Test {
    @Test
    @Timeout(4000)
    public void testGetCount() {
        int[] arr = {2, 3, 5, 6, 8, 10};
        int target = 10;
        int expected = 3; // subsets: {2, 8}, {3, 5, 2}, {10}
        int actual = SubsetCount.getCount(arr, target);
        assertEquals(expected, actual);
    }

    @Test
    @Timeout(4000)
    public void testGetCountSO() {
        int[] arr = {2, 3, 5, 6, 8, 10};
        int target = 10;
        int expected = 3; // subsets: {2, 8}, {3, 5, 2}, {10}
        int actual = SubsetCount.getCountSO(arr, target);
        assertEquals(expected, actual);
    }
}