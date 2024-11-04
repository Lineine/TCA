package net.mooctest;

import java.util.Scanner;

final class Sparsity {
    private Sparsity() {
    }

    /**
     * @return Sparsity of matrix
     *
     * where sparsity = number of zeroes/total elements in matrix
     *
     */
    static double sparsity(double[][] mat) {
        int zero = 0;
        // Traversing the matrix to count number of zeroes
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    zero++;
                }
            }
        }
        // return sparsity
        return ((double) zero / (mat.length * mat[0].length));
    }

    // Driver method
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of rows in matrix: ");
        int n = in.nextInt();
        System.out.println("Enter number of Columns in matrix: ");
        int m = in.nextInt();

        System.out.println("Enter Matrix elements: ");
        double[][] mat = new double[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = in.nextDouble();
            }
        }
        System.out.println("Sparsity of matrix is: " + sparsity(mat));
        in.close();
    }
}

// Unit test
public class Sparsity_Test {
    public static void main(String[] args) {
        double[][] mat1 = {{1, 0, 0}, {0, 2, 0}, {0, 0, 3}};
        double[][] mat2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        double[][] mat3 = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

        assert (Math.abs(Sparsity.sparsity(mat1) - 0.6666666666666666) < 0.0001);
        assert (Math.abs(Sparsity.sparsity(mat2) - 0.0) < 0.0001);
        assert (Math.abs(Sparsity.sparsity(mat3) - 1.0) < 0.0001);

        System.out.println("All unit tests passed.");
    }
}
