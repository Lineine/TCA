package net.mooctest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianOfRunningArray_Test {

    @Test
    @Timeout(4000)
    public void testMedian() {
        MedianOfRunningArray<Double> medianFinder = new MedianOfRunningArray<Double>() {
            @Override
            public Double calculateAverage(Double a, Double b) {
                return (a + b) / 2.0;
            }
        };

        medianFinder.insert(1.0);
        assertEquals(1.0, medianFinder.median(), 0.0);

        medianFinder.insert(2.0);
        assertEquals(1.5, medianFinder.median(), 0.0);

        medianFinder.insert(3.0);
        assertEquals(2.0, medianFinder.median(), 0.0);

        medianFinder.insert(4.0);
        assertEquals(2.5, medianFinder.median(), 0.0);

        medianFinder.insert(5.0);
        assertEquals(3.0, medianFinder.median(), 0.0);

        medianFinder.insert(6.0);
        assertEquals(3.5, medianFinder.median(), 0.0);

        medianFinder.insert(7.0);
        assertEquals(4.0, medianFinder.median(), 0.0);

        medianFinder.insert(8.0);
        assertEquals(4.5, medianFinder.median(), 0.0);

        medianFinder.insert(9.0);
        assertEquals(5.0, medianFinder.median(), 0.0);
    }

    @Test
    @Timeout(4000)
    public void testMedianEmpty() {
        MedianOfRunningArray<Double> medianFinder = new MedianOfRunningArray<Double>() {
            @Override
            public Double calculateAverage(Double a, Double b) {
                return (a + b) / 2.0;
            }
        };
        medianFinder.median();
    }
}