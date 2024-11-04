package net.mooctest;



public class EditDistance_Test {

    public static void main(String[] args) {
        testEditDistance("kitten", "sitting", 3);
        testEditDistance("hello", "world", 4);
        testEditDistance("abc", "abc", 0);
        testEditDistance("abc", "", 3);
        testEditDistance("", "abc", 3);
        testEditDistance("abcdef", "azced", 3);
        testEditDistance("abcdef", "azcedf", 3);
    }

    private static void testEditDistance(String s1, String s2, int expected) {
        int actual = EditDistance.minDistance(s1, s2);
        if (actual == expected) {
            System.out.println("Passed: Edit distance between \"" + s1 + "\" and \"" + s2 + "\" is " + expected);
        } else {
            System.out.println("Failed: Edit distance between \"" + s1 + "\" and \"" + s2 + "\" is " + actual + ", expected " + expected);
        }
    }
}