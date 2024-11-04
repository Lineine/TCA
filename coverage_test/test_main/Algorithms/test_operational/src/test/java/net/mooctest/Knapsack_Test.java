package net.mooctest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class Knapsack_Test {

    @Test
    @Timeout(4000)
    public void testValidInput() {
        int weightCapacity = 10;
        int[] weights = {2, 3, 5, 7};
        int[] values = {10, 20, 30, 40};
        int expectedMaxValue = 60;
        int actualMaxValue = Knapsack.knapSack(weightCapacity, weights, values);
        assertEquals(expectedMaxValue, actualMaxValue);
    }

    @Test
    @Timeout(4000)
    public void testNegativeWeightCapacity() {
        int weightCapacity = -5;
        int[] weights = {2, 3, 5, 7};
        int[] values = {10, 20, 30, 40};
        try {
            // 运行会抛出异常的方法
            Knapsack.knapSack(weightCapacity, weights, values);
            // 如果没有抛出异常，测试失败
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // 验证异常的具体内容或属性（可选）
            assertEquals("Input arrays must not be null and must have the same length.", e.getMessage());
        }
    }

    @Test
    @Timeout(4000)
    public void testNullWeights() {
        int weightCapacity = 10;
        int[] weights = null;
        int[] values = {10, 20, 30, 40};
        try {
            // 运行会抛出异常的方法
            Knapsack.knapSack(weightCapacity, weights, values);
            // 如果没有抛出异常，测试失败
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // 验证异常的具体内容或属性（可选）
            assertEquals("Input arrays must not be null and must have the same length.", e.getMessage());
        }

    }

    @Test
    @Timeout(4000)
    public void testNonPositiveWeight() {
        int weightCapacity = 10;
        int[] weights = {2, 0, 5, 7};
        int[] values = {10, 20, 30, 40};
        try {
            // 运行会抛出异常的方法
            Knapsack.knapSack(weightCapacity, weights, values);
            // 如果没有抛出异常，测试失败
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // 验证异常的具体内容或属性（可选）
            assertEquals("Input arrays must not be null and must have the same length.", e.getMessage());
        }
    }

    @Test
    @Timeout(4000)
    public void testDifferentLengthArrays() {
        int weightCapacity = 10;
        int[] weights = {2, 3, 5};
        int[] values = {10, 20, 30, 40};
        try {
            // 运行会抛出异常的方法
            Knapsack.knapSack(weightCapacity, weights, values);
            // 如果没有抛出异常，测试失败
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // 验证异常的具体内容或属性（可选）
            assertEquals("Input arrays must not be null and must have the same length.", e.getMessage());
        }
    }
}