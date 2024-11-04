package net.mooctest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestValidParentheses_Test {
    @Test
    @Timeout(4000)
    public void testEmptyString() {
        assertEquals(0, LongestValidParentheses.getLongestValidParentheses(""));
    }

    @Test
    @Timeout(4000)
    public void testSingleCharString() {
        assertEquals(0, LongestValidParentheses.getLongestValidParentheses("("));
        assertEquals(0, LongestValidParentheses.getLongestValidParentheses(")"));
    }

    @Test
    @Timeout(4000)
    public void testValidParentheses() {
        assertEquals(2, LongestValidParentheses.getLongestValidParentheses("()"));
        assertEquals(4, LongestValidParentheses.getLongestValidParentheses("(())"));
        assertEquals(6, LongestValidParentheses.getLongestValidParentheses("(()())"));
    }

    @Test
    @Timeout(4000)
    public void testInvalidParentheses() {
        assertEquals(0, LongestValidParentheses.getLongestValidParentheses(")("));
        assertEquals(0, LongestValidParentheses.getLongestValidParentheses(")(())"));
    }

    @Test
    @Timeout(4000)
    public void testMixedParentheses() {
        assertEquals(2, LongestValidParentheses.getLongestValidParentheses("(())()"));
        assertEquals(4, LongestValidParentheses.getLongestValidParentheses("()(()()"));
    }
}
