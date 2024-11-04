package net.mooctest;


public class StringCompression_Test {
    public static void main(String[] args) {
        testCompress("aabcccccaaa", "a2b1c5a3"); // compressed string
        testCompress("abcde", "abcde"); // no compression, original string
        testCompress("aaaa", "a4"); // compressed string
        testCompress("a", "a"); // single character, no compression
        testCompress("", ""); // empty string, no compression
        testCompress("aaaabbbccd", "a4b3c2d1"); // compressed string
    }

    private static void testCompress(String input, String expectedOutput) {
        String actualOutput = StringCompression.compress(input);
        if (actualOutput.equals(expectedOutput)) {
            System.out.println("PASS: Compressed string for '" + input + "' is '" + actualOutput + "'");
        } else {
            System.out.println("FAIL: Compressed string for '" + input + "' is '" + actualOutput + "', expected '" + expectedOutput + "'");
        }
    }
}