package net.mooctest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HorspoolSearch_Test {
    @Test
    @Timeout(4000)
    public void testFindFirst() {
        String text = "hello world";
        String pattern = "world";
        int expectedIndex = 6;
        int actualIndex = HorspoolSearch.findFirst(pattern, text);
        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    @Timeout(4000)
    public void testFindFirstNotFound() {
        String text = "hello world";
        String pattern = "foo";
        int expectedIndex = -1;
        int actualIndex = HorspoolSearch.findFirst(pattern, text);
        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    @Timeout(4000)
    public void testFindFirstEmptyPattern() {
        String text = "hello world";
        String pattern = "";
        int expectedIndex = -1;
        int actualIndex = HorspoolSearch.findFirst(pattern, text);
        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    @Timeout(4000)
    public void testFindFirstInsensitive() {
        String text = "Hello World";
        String pattern = "WORLD";
        int expectedIndex = 6;
        int actualIndex = HorspoolSearch.findFirstInsensitive(pattern, text);
        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    @Timeout(4000)
    public void testGetLastComparisons() {
        String text = "hello world";
        String pattern = "world";
        HorspoolSearch.findFirst(pattern, text);
        int actualComparisons = HorspoolSearch.getLastComparisons();
        assertTrue(actualComparisons > 0);
    }

}
