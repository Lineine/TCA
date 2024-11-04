package net.mooctest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianOfRunningArrayLong_Test {

    @Test
    @Timeout(4000)
    public void testCalculateAverage() {
        MedianOfRunningArrayLong medianOfRunningArrayLong = new MedianOfRunningArrayLong();
        assertEquals(Long.valueOf(3), medianOfRunningArrayLong.calculateAverage(Long.valueOf(2), Long.valueOf(4)));
        assertEquals(Long.valueOf(5), medianOfRunningArrayLong.calculateAverage(Long.valueOf(4), Long.valueOf(6)));
        assertEquals(Long.valueOf(10), medianOfRunningArrayLong.calculateAverage(Long.valueOf(8), Long.valueOf(12)));
    }

    @Test
    @Timeout(4000)
    public void testCalculateAverage_EqualNumbers() {
        MedianOfRunningArrayLong medianOfRunningArrayLong = new MedianOfRunningArrayLong();
        assertEquals(Long.valueOf(5), medianOfRunningArrayLong.calculateAverage(Long.valueOf(5), Long.valueOf(5)));
    }

    @Test
    @Timeout(4000)
    public void testCalculateAverage_NegativeNumbers() {
        MedianOfRunningArrayLong medianOfRunningArrayLong = new MedianOfRunningArrayLong();
        assertEquals(Long.valueOf(-3), medianOfRunningArrayLong.calculateAverage(Long.valueOf(-4), Long.valueOf(-2)));
    }

    @Test
    @Timeout(4000)
    public void testCalculateAverage_OneNegativeOnePositive() {
        MedianOfRunningArrayLong medianOfRunningArrayLong = new MedianOfRunningArrayLong();
        assertEquals(Long.valueOf(0), medianOfRunningArrayLong.calculateAverage(Long.valueOf(-2), Long.valueOf(2)));
    }
}

