package net.mooctest;


public class WildcardMatching_Test {
    public static void main(String[] args) {
        test("abcdef", "a*b*", true);
        test("abcdef", "a?b*", true);
        test("abcdef", "a*c*", false);
        test("abcdef", "*", true);
        test("abcdef", "?b*", true);
        test("abcdef", "a?", true);
        test("abcdef", "a*b*c*", true);
        test("abcdef", "a*b*c*d*e*f*", true);
        test("abcdef", "a*b*c*d*e*f*g*", false);
        test("", "", true);
        test("", "*", true);
        test("", "a", false);
        test("a", "", false);
        test("a", "a", true);
        test("a", "?", true);
        test("a", "*", true);
        test("ab", "a", false);
        test("ab", "b", false);
        test("ab", "a?", true);
        test("ab", "?b", true);
        test("ab", "*b", true);
        test("ab", "a*b", true);
    }

    private static void test(String text, String pattern, boolean expected) {
        boolean actual = WildcardMatching.isMatch(text, pattern);
        if (actual == expected) {
            System.out.println("Pass: text='" + text + "', pattern='" + pattern + "'");
        } else {
            System.out.println("Fail: text='" + text + "', pattern='" + pattern + "'. Expected " + expected + ", got " + actual);
        }
    }
}
