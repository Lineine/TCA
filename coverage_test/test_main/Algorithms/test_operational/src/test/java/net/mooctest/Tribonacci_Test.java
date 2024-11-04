package net.mooctest;

final class Tribonacci {
    private Tribonacci() {
    }

    /**
     * Computes the n-th Tribonacci number.
     *
     * @param n the index of the Tribonacci number to compute
     * @return the n-th Tribonacci number
     */
    public static int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        int first = 0;
        int second = 1;
        int third = 1;

        for (int i = 3; i <= n; i++) {
            int next = first + second + third;
            first = second;
            second = third;
            third = next;
        }

        return third;
    }
}

class Tribonacci_Test {
    public static void main(String[] args) {
        testTribonacci();
    }

    public static void testTribonacci() {
        System.out.println("Testing Tribonacci class...");

        // Test cases
        int[][] testCases = {
                {0, 0},
                {1, 1},
                {2, 1},
                {3, 2},
                {4, 4},
                {5, 7},
                {6, 13},
                {7, 24},
                {8, 44},
                {9, 81},
        };

        for (int[] testCase : testCases) {
            int n = testCase[0];
            int expected = testCase[1];
            int actual = Tribonacci.tribonacci(n);
            if (actual!= expected) {
                System.out.println("Error: tribonacci(" + n + ") expected " + expected + " but got " + actual);
                return;
            }
        }

        System.out.println("All tests passed!");
    }
}