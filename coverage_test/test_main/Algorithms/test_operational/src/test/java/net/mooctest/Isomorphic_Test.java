package net.mooctest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class Isomorphic_Test {

    @Test
    @Timeout(4000)
    public void testIsomorphicStrings() {
        assertTrue(Isomorphic.checkStrings("egg", "add"));
        assertTrue(Isomorphic.checkStrings("paper", "title"));
        assertTrue(Isomorphic.checkStrings("hello", "hello"));
    }

    @Test
    @Timeout(4000)
    public void testNotIsomorphicStrings() {
        assertFalse(Isomorphic.checkStrings("foo", "bar"));
        assertFalse(Isomorphic.checkStrings("hello", "world"));
        assertFalse(Isomorphic.checkStrings("abc", "defg"));
    }

    @Test
    @Timeout(4000)
    public void testEmptyStrings() {
        assertTrue(Isomorphic.checkStrings("", ""));
    }

    @Test
    @Timeout(4000)
    public void testDifferentLengthStrings() {
        assertFalse(Isomorphic.checkStrings("abc", "abcd"));
        assertFalse(Isomorphic.checkStrings("abcd", "abc"));
    }
}
