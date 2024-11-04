package net.mooctest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class HammingDistance_Test {
    @Test
    @Timeout(4000)
    public void testEqualStrings() throws Exception {
        String s1 = "hello";
        String s2 = "hello";
        int distance = HammingDistance.calculateHammingDistance(s1, s2);
        assertEquals(0, distance);
    }

    @Test
    @Timeout(4000)
    public void testDifferentStrings() throws Exception {
        String s1 = "hello";
        String s2 = "hullo";
        int distance = HammingDistance.calculateHammingDistance(s1, s2);
        assertEquals(2, distance);
    }

    @Test
    @Timeout(4000)
    public void testDifferentLengthStrings() {
        String s1 = "hello";
        String s2 = "hell";
        try {
            HammingDistance.calculateHammingDistance(s1, s2);
            fail("Expected Exception");
        } catch (Exception e) {
            assertEquals("String lengths must be equal", e.getMessage());
        }
    }

    @Test
    @Timeout(4000)
    public void testNullStrings() {
        String s1 = null;
        String s2 = "hello";
        try {
            HammingDistance.calculateHammingDistance(s1, s2);
            fail("Expected NullPointerException");
        } catch (Exception e) {
            // expected
        }
    }

    @Test
    @Timeout(4000)
    public void testEmptyStrings() throws Exception {
        String s1 = "";
        String s2 = "";
        int distance = HammingDistance.calculateHammingDistance(s1, s2);
        assertEquals(0, distance);
    }
}