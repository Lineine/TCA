package net.mooctest;


public class MyAtoi_Test {
    public static void main(String[] args) {
        testMyAtoi();
    }

    public static void testMyAtoi() {
        // Test cases
        System.out.println("Testing myAtoi...");

        // Valid inputs
        System.out.println("Input: \"42\". Expected: 42. Actual: " + MyAtoi.myAtoi("42"));
        System.out.println("Input: \"   -42\". Expected: -42. Actual: " + MyAtoi.myAtoi("   -42"));
        System.out.println("Input: \"4193 with words\". Expected: 4193. Actual: " + MyAtoi.myAtoi("4193 with words"));
        System.out.println("Input: \"+1\". Expected: 1. Actual: " + MyAtoi.myAtoi("+1"));

        // Edge cases
        System.out.println("Input: \"\". Expected: 0. Actual: " + MyAtoi.myAtoi(""));
        System.out.println("Input: \"   \". Expected: 0. Actual: " + MyAtoi.myAtoi("   "));
        System.out.println("Input: \"words and 987\". Expected: 0. Actual: " + MyAtoi.myAtoi("words and 987"));

        // Overflow cases
        System.out.println("Input: \"-91283472332\". Expected: -2147483648. Actual: " + MyAtoi.myAtoi("-91283472332"));
        System.out.println("Input: \"91283472332\". Expected: 2147483647. Actual: " + MyAtoi.myAtoi("91283472332"));

        // Special cases
        System.out.println("Input: \"0032\". Expected: 3. Actual: " + MyAtoi.myAtoi("0032"));
        System.out.println("Input: \"-0 123\". Expected: 0. Actual: " + MyAtoi.myAtoi("-0 123"));
    }
}