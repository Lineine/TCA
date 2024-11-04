package net.mooctest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.*;

public class CheckVowels_Test {

    @Test
    @Timeout(4000)
    public void testHasVowelsNullInput() {
        assertFalse(CheckVowels.hasVowels(null));
    }

    @Test
    @Timeout(4000)
    public void testHasVowelsEmptyString() {
        assertFalse(CheckVowels.hasVowels(""));
    }

    @Test
    @Timeout(4000)
    public void testHasVowelsOnlyConsonants() {
        assertFalse(CheckVowels.hasVowels("bcdfghjklmnpqrstvwxyz"));
    }

    @Test
    @Timeout(4000)
    public void testHasVowelsOnlyVowels() {
        assertTrue(CheckVowels.hasVowels("aeiou"));
    }

    @Test
    @Timeout(4000)
    public void testHasVowelsMixedCase() {
        assertTrue(CheckVowels.hasVowels("Hello World"));
    }

    @Test
    @Timeout(4000)
    public void testHasVowelsWithSpaces() {
        assertTrue(CheckVowels.hasVowels("Hello   World"));
    }

    @Test
    @Timeout(4000)
    public void testHasVowelsWithPunctuation() {
        assertTrue(CheckVowels.hasVowels("Hello, World!"));
    }
}
