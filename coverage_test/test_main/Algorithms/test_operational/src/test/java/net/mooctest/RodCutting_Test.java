package net.mooctest;


public class RodCutting_Test {

    public static void main(String[] args) {
        testCutRod();
    }

    public static void testCutRod() {
        int[] price1 = {1, 5, 8, 9, 10, 17, 17, 20};
        int n1 = 4;
        int expected1 = 10;
        int result1 = RodCutting.cutRod(price1, n1);
        System.out.println("Test 1: " + (result1 == expected1? "Passed" : "Failed"));

        int[] price2 = {3, 5, 8, 9, 10, 17, 17, 20};
        int n2 = 8;
        int expected2 = 22;
        int result2 = RodCutting.cutRod(price2, n2);
        System.out.println("Test 2: " + (result2 == expected2? "Passed" : "Failed"));

        int[] price3 = {1, 1, 1, 1, 1, 1, 1, 1};
        int n3 = 7;
        int expected3 = 7;
        int result3 = RodCutting.cutRod(price3, n3);
        System.out.println("Test 3: " + (result3 == expected3? "Passed" : "Failed"));

        int[] price4 = {};
        int n4 = 0;
        int expected4 = 0;
        int result4 = RodCutting.cutRod(price4, n4);
        System.out.println("Test 4: " + (result4 == expected4? "Passed" : "Failed"));
    }
}
