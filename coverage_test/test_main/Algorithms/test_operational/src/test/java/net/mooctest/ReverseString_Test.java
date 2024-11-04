package net.mooctest;

class ReverseString {
    private ReverseString() {}

    public static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static String reverse2(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        char[] value = str.toCharArray();
        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
            char temp = value[i];
            value[i] = value[j];
            value[j] = temp;
        }
        return new String(value);
    }
}

public class ReverseString_Test {
    public static void main(String[] args) {
        testReverse("abc123", "321cba");
        testReverse("", "");
        testReverse(null, null);
        testReverse("a", "a");
        testReverse("ab", "ba");
    }

    private static void testReverse(String input, String expected) {
        String result1 = ReverseString.reverse(input);
        String result2 = ReverseString.reverse2(input);

        if (result1.equals(expected) && result2.equals(expected)) {
            System.out.println("Passed: Reversed '" + input + "' to '" + expected + "'");
        } else {
            System.out.println("Failed: Reversed '" + input + "' to '" + result1 + "' and '" + result2 + "'");
        }
    }
}
