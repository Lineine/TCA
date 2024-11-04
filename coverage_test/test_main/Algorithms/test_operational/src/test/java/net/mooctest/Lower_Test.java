package net.mooctest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;



public class Lower_Test {
    @Test
    @Timeout(4000)
    public void testToLowercase() {
        assertEquals("abc", Lower.toLowerCase("ABC"));
        assertEquals("abc123", Lower.toLowerCase("ABC123"));
        assertEquals("abcabc", Lower.toLowerCase("abcABC"));
        assertEquals("", Lower.toLowerCase(""));
        assertEquals("123", Lower.toLowerCase("123"));
    }
}