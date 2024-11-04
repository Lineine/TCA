package net.mooctest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PalindromicPartitioning_Test {
    @Test
    @Timeout(4000)
    public void testMinimalPartitions() {
        assertEquals(1, PalindromicPartitioning.minimalpartitions("aab")); // "aab" can be partitioned into 1 palindrome: "aab"
        assertEquals(1, PalindromicPartitioning.minimalpartitions("aba")); // "aba" can be partitioned into 1 palindrome: "aba"
        assertEquals(3, PalindromicPartitioning.minimalpartitions("abcba")); // "abcba" can be partitioned into 3 palindromes: "a", "b", "cba"
        assertEquals(2, PalindromicPartitioning.minimalpartitions("abab")); // "abab" can be partitioned into 2 palindromes: "aba", "b"
    }
}
