package net.mooctest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class Algorithms_1_Test
{
    private OptimalJobScheduling scheduler;
    private int numberProcesses = 3;
    private int numberMachines = 2;
    private int[][] run;
    private int[][] transfer;
    @BeforeEach
    public void setUp() {
        run = new int[][]{
        {1, 2},             {3, 4},             {5, 6}          };
            transfer = new int[][]{
            {0, 1},             {1, 0}          };
                scheduler = new OptimalJobScheduling(numberProcesses, numberMachines, run, transfer);
                scheduler.execute();
            }
            @Test
            public void test_548() throws Exception {
                int[][] expectedCost = {
                {1, 2},             {4, 5},             {9, 10}         };
                    for (int i = 0;
                    i < numberProcesses;
                    i++) {
                        for (int j = 0; j < numberMachines; j++) {
                            assertEquals(expectedCost[i][j], scheduler.getCost(i, j));
                        }
                    }
                }
                @Test
                public void test_549() throws Exception {
                    assertEquals(run[0][0], scheduler.getCost(0, 0));
                }
                @Test
                public void test_554() throws Exception {
                    assertEquals(10, scheduler.getCost(2, 1));
                }
            }