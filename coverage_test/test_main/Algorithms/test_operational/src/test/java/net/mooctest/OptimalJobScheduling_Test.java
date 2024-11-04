package net.mooctest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OptimalJobScheduling_Test {
    @Test
    @Timeout(4000)
    public void testSimpleCase() {
        int numberProcesses = 2;
        int numberMachines = 2;
        int[][] run = {{1, 2}, {3, 4}};
        int[][] transfer = {{0, 1}, {1, 0}};

        OptimalJobScheduling scheduler = new OptimalJobScheduling(numberProcesses, numberMachines, run, transfer);
        scheduler.execute();

        int[][] expectedCosts = {{1, 2}, {4, 6}};

        for (int i = 0; i < numberProcesses; i++) {
            for (int j = 0; j < numberMachines; j++) {
                assertEquals(expectedCosts[i][j], scheduler.getCost(i, j));
            }
        }
    }

    @Test
    @Timeout(4000)
    public void testLargerCase() {
        int numberProcesses = 3;
        int numberMachines = 3;
        int[][] run = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] transfer = {{0, 1, 2}, {1, 0, 3}, {2, 3, 0}};

        OptimalJobScheduling scheduler = new OptimalJobScheduling(numberProcesses, numberMachines, run, transfer);
        scheduler.execute();

        int[][] expectedCosts = {{1, 2, 3}, {6, 8, 10}, {15, 18, 21}};

        for (int i = 0; i < numberProcesses; i++) {
            for (int j = 0; j < numberMachines; j++) {
                assertEquals(expectedCosts[i][j], scheduler.getCost(i, j));
            }
        }
    }
}
