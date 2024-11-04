package net.mooctest;


public class LongestPalindromicSubsequence_Test {

    public static void main(String[] args) {
        testLPS();
    }

    public static void testLPS() {
        // Test 1
        String original1 = "BBABCBCAB";
        String expected1 = "BCBCAB";
        String result1 = LongestPalindromicSubsequence.lps(original1);
        assertResult(original1, expected1, result1);

        // Test 2
        String original2 = "BABCBAB";
        String expected2 = "BABCBAB";
        String result2 = LongestPalindromicSubsequence.lps(original2);
        assertResult(original2, expected2, result2);

        // Test 3
        String original3 = "ABC";
        String expected3 = "A or B or C";
        String result3 = LongestPalindromicSubsequence.lps(original3);
        assertResult(original3, expected3, result3);

        // Test 4
        String original4 = "";
        String expected4 = "";
        String result4 = LongestPalindromicSubsequence.lps(original4);
        assertResult(original4, expected4, result4);

        System.out.println("All tests passed!");
    }

    public static void assertResult(String original, String expected, String result) {
        if (!result.equals(expected)) {
            System.out.println("Test failed for input: " + original);
            System.out.println("Expected: " + expected);
            System.out.println("Got: " + result);
            System.exit(1);
        }
    }
}