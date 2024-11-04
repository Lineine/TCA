package net.mooctest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseStringRecursive_Test {
    @Test
    @Timeout(4000)
    public void testEmptyString() {
        assertEquals("", ReverseStringRecursive.reverse(""));
    }

    @Test
    @Timeout(4000)
    public void testSingleCharacterString() {
        assertEquals("a", ReverseStringRecursive.reverse("a"));
    }

    @Test
    @Timeout(4000)
    public void testMultiCharacterString() {
        assertEquals("olleh", ReverseStringRecursive.reverse("hello"));
    }

    @Test
    @Timeout(4000)
    public void testLongString() {
        String original = "abcdefghijklmnopqrstuvwxyz";
        String reversed = "zyxwvutsrqponmlkjihgfedcba";
        assertEquals(reversed, ReverseStringRecursive.reverse(original));
    }
}
