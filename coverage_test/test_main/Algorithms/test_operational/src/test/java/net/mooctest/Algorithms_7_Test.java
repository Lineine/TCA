package net.mooctest;
import org.junit.jupiter.api.Test;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
public class Algorithms_7_Test
{
    private ThreeSumProblem threeSumProblem;
    @BeforeEach
    public void setUp() {
        threeSumProblem = new ThreeSumProblem();
    }
    @Test
    public void test_74() throws Exception {
    int[] nums = {-1, -2, -3, -4, -5};
        int target = -6;
        List<List<Integer>> resultBruteForce = threeSumProblem.bruteForce(nums, target);
        List<List<Integer>> resultTwoPointer = threeSumProblem.twoPointer(nums, target);
        List<List<Integer>> resultHashMap = threeSumProblem.hashMap(nums, target);
        assertEquals(1, resultBruteForce.size());
        assertEquals(1, resultTwoPointer.size());
        assertEquals(1, resultHashMap.size());
        assertTrue(resultBruteForce.contains(List.of(-3, -2, -1)));
        assertTrue(resultTwoPointer.contains(List.of(-3, -2, -1)));
        assertTrue(resultHashMap.contains(List.of(-3, -2, -1)));
    }
    @Test
    public void test_72() throws Exception {
    int[] nums = {-1, 0, 1, 2, -1, -4};
        int target = 0;
        List<List<Integer>> result = threeSumProblem.hashMap(nums, target);
        assertEquals(2, result.size());
        assertTrue(result.contains(List.of(-1, -1, 2)));
        assertTrue(result.contains(List.of(-1, 0, 1)));
    }
    @Test
    public void test_70() throws Exception {
    int[] nums = {-1, 0, 1, 2, -1, -4};
        int target = 0;
        List<List<Integer>> result = threeSumProblem.bruteForce(nums, target);
        assertEquals(2, result.size());
        assertTrue(result.contains(List.of(-1, -1, 2)));
        assertTrue(result.contains(List.of(-1, 0, 1)));
    }
    @Test
    public void test_71() throws Exception {
    int[] nums = {-1, 0, 1, 2, -1, -4};
        int target = 0;
        List<List<Integer>> result = threeSumProblem.twoPointer(nums, target);
        assertEquals(2, result.size());
        assertTrue(result.contains(List.of(-1, -1, 2)));
        assertTrue(result.contains(List.of(-1, 0, 1)));
    }
}