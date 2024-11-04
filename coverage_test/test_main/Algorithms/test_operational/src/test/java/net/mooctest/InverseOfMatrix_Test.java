package net.mooctest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InverseOfMatrix_Test {

    @Test
    @Timeout(4000)
    public void testInvert() {
        double[][] a = {
                {1, 2, 3},
                {0, 1, 4},
                {5, 6, 0}
        };
        double[][] expectedInverse = {
                {-24.0, 18.0, -5.0},
                {8.0, -11.0, 2.0},
                {5.0, -6.0, 1.0}
        };

        double[][] inverse = InverseOfMatrix.invert(a);

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                assertEquals(expectedInverse[i][j], inverse[i][j], 0.01);
            }
        }
    }
}
