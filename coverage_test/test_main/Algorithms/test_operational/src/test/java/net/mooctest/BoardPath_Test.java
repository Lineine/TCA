package net.mooctest;


public class BoardPath_Test {
    public static void main(String[] args) {
        test_bpR();
        test_bpRS();
        test_bpIS();
    }

    public static void test_bpR() {
        System.out.println("Testing bpR...");
        int start = 0;
        int end = 10;
        long startTime = System.currentTimeMillis();
        int result = BoardPath.bpR(start, end);
        long endTime = System.currentTimeMillis();
        System.out.println("Result: " + result);
        System.out.println("Time taken: " + (endTime - startTime) + " ms");
        System.out.println();
    }

    public static void test_bpRS() {
        System.out.println("Testing bpRS...");
        int start = 0;
        int end = 10;
        int[] strg = new int[end + 1];
        long startTime = System.currentTimeMillis();
        int result = BoardPath.bpRS(start, end, strg);
        long endTime = System.currentTimeMillis();
        System.out.println("Result: " + result);
        System.out.println("Time taken: " + (endTime - startTime) + " ms");
        System.out.println();
    }

    public static void test_bpIS() {
        System.out.println("Testing bpIS...");
        int start = 0;
        int end = 10;
        int[] strg = new int[end + 1];
        long startTime = System.currentTimeMillis();
        int result = BoardPath.bpIS(start, end, strg);
        long endTime = System.currentTimeMillis();
        System.out.println("Result: " + result);
        System.out.println("Time taken: " + (endTime - startTime) + " ms");
        System.out.println();
    }
}