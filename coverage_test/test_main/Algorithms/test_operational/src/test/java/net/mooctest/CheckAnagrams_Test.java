package net.mooctest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckAnagrams_Test {

    @Test
    @Timeout(4000)
    public void testIsAnagrams_SimpleCase() {
        assertTrue(CheckAnagrams.isAnagrams("listen", "silent"));
        assertTrue(CheckAnagrams.isAnagrams("hello", "olleh"));
        assertFalse(CheckAnagrams.isAnagrams("hello", "world"));
    }

    @Test
    @Timeout(4000)
    public void testIsAnagrams_CaseInsensitive() {
        assertTrue(CheckAnagrams.isAnagrams("Listen", "Silent"));
        assertTrue(CheckAnagrams.isAnagrams("Hello", "OLLEH"));
        assertFalse(CheckAnagrams.isAnagrams("Hello", "WORLD"));
    }

    @Test
    @Timeout(4000)
    public void testIsAnagramsUnicode_SimpleCase() {
        assertTrue(CheckAnagrams.isAnagramsUnicode("listen", "silent"));
        assertTrue(CheckAnagrams.isAnagramsUnicode("hello", "olleh"));
        assertFalse(CheckAnagrams.isAnagramsUnicode("hello", "world"));
    }

    @Test
    @Timeout(4000)
    public void testIsAnagramsOptimised_SimpleCase() {
        assertTrue(CheckAnagrams.isAnagramsOptimised("listen", "silent"));
        assertTrue(CheckAnagrams.isAnagramsOptimised("hello", "olleh"));
        assertFalse(CheckAnagrams.isAnagramsOptimised("hello", "world"));
    }

}
