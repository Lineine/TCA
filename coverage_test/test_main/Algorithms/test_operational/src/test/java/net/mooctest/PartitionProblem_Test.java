package net.mooctest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PartitionProblem_Test {
    @Test
    @Timeout(4000)
    public void testPartition() {
        // Test case 1: Even sum, can be partitioned
        int[] nums1 = {1, 2, 3, 4};
        assertTrue(PartitionProblem.partition(nums1));

        // Test case 2: Odd sum, cannot be partitioned
        int[] nums2 = {1, 2, 3};
        assertFalse(PartitionProblem.partition(nums2));

        // Test case 3: Empty array, cannot be partitioned
        int[] nums3 = {};
        assertFalse(PartitionProblem.partition(nums3));

        // Test case 4: Single element array, cannot be partitioned
        int[] nums4 = {1};
        assertFalse(PartitionProblem.partition(nums4));

        // Test case 5: Multiple elements, can be partitioned
        int[] nums5 = {1, 1, 2, 2, 3, 3};
        assertTrue(PartitionProblem.partition(nums5));
    }
}
