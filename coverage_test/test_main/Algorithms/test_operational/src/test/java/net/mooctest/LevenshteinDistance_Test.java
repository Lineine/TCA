package net.mooctest;


// Unit test class
public class LevenshteinDistance_Test {
    public static void main(String[] args) {
        testNaiveLevenshteinDistance();
        testOptimizedLevenshteinDistance();
    }

    private static void testNaiveLevenshteinDistance() {
        System.out.println("Testing naiveLevenshteinDistance()...");

        assertEquals(7, LevenshteinDistance.naiveLevenshteinDistance("kitten", "sitting"));
        assertEquals(3, LevenshteinDistance.naiveLevenshteinDistance("car", "bar"));
        assertEquals(5, LevenshteinDistance.naiveLevenshteinDistance("hello", "world"));
        assertEquals(0, LevenshteinDistance.naiveLevenshteinDistance("hello", "hello"));
        assertEquals(4, LevenshteinDistance.naiveLevenshteinDistance("abcde", "ace"));

        System.out.println("tests passed.");
    }

    private static void testOptimizedLevenshteinDistance() {
        System.out.println("Testing optimizedLevenshteinDistance()...");

        assertEquals(7, LevenshteinDistance.optimizedLevenshteinDistance("kitten", "sitting"));
        assertEquals(3, LevenshteinDistance.optimizedLevenshteinDistance("car", "bar"));
        assertEquals(5, LevenshteinDistance.optimizedLevenshteinDistance("hello", "world"));
        assertEquals(0, LevenshteinDistance.optimizedLevenshteinDistance("hello", "hello"));
        assertEquals(4, LevenshteinDistance.optimizedLevenshteinDistance("abcde", "ace"));

        System.out.println("tests passed.");
    }

    private static void assertEquals(int expected, int actual) {
        if (expected!= actual) {
            throw new AssertionError("Expected " + expected + " but got " + actual);
        }
    }
}