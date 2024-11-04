package net.mooctest;


public class ValidParentheses_Test {
    public static void main(String[] args) {
        testValidParentheses();
    }

    private static void testValidParentheses() {
        // Test cases
        String[] testCases = {
            "()", // true
            "()[]{}", // true
            "(]", // false
            "([)]", // false
            "{[]}", // true
            "(abc)", // true
            ")(abc)", // false
            "", // true
            null // should throw NullPointerException
        };

        for (String testCase : testCases) {
            try {
                boolean isValid = ValidParentheses.isValid(testCase);
                System.out.println("Test case: '" + testCase + "': " + isValid);
            } catch (NullPointerException e) {
                System.out.println("Test case: null: threw NullPointerException as expected");
            }
        }
    }
}
