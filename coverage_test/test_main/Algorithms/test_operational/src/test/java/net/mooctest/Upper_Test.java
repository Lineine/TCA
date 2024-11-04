package net.mooctest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Upper_Test {
    @Test
    @Timeout(4000)
    public void testUpperCase() {
        assertEquals("ABC", Upper.toUpperCase("ABC"));
        assertEquals("ABC123", Upper.toUpperCase("ABC123"));
        assertEquals("ABCABC", Upper.toUpperCase("abcABC"));
        assertEquals("ABC123ABC", Upper.toUpperCase("abc123ABC"));
        assertEquals(null, Upper.toUpperCase(null));
        assertEquals("", Upper.toUpperCase(""));
        assertEquals("123", Upper.toUpperCase("123"));
    }
}
