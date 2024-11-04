package net.mooctest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class MedianOfMatrix {
    private MedianOfMatrix() {}

    public static int median(List<List<Integer>> matrix) {
        // Flatten the matrix into a 1D list
        List<Integer> linear = new ArrayList<>();
        for (List<Integer> row : matrix) {
            linear.addAll(row);
        }

        // Sort the 1D list
        Collections.sort(linear);

        // Calculate the middle index
        int mid = linear.size() / 2;

        // If the total number of elements is odd, return the middle element
        if (linear.size() % 2!= 0) {
            return linear.get(mid);
        }
        // If the total number of elements is even, return the average of the two middle elements
        else {
            return (linear.get(mid - 1) + linear.get(mid)) / 2;
        }
    }
}

// Unit test
public class MedianOfMatrix_Test {
    public static void main(String[] args) {
        List<List<Integer>> matrix1 = Arrays.asList(
            Arrays.asList(1, 3, 5),
            Arrays.asList(6, 7, 12),
            Arrays.asList(11, 14, 14)
        );
        assert MedianOfMatrix.median(matrix1) == 8;

        List<List<Integer>> matrix2 = Arrays.asList(
            Arrays.asList(1, 2),
            Arrays.asList(1, 3)
        );
        assert MedianOfMatrix.median(matrix2) == 2;

        List<List<Integer>> matrix3 = Arrays.asList(
            Arrays.asList(1, 2, 3),
            Arrays.asList(4, 5, 6)
        );
        assert MedianOfMatrix.median(matrix3) == 4;

        System.out.println("All test cases pass.");
    }
}
