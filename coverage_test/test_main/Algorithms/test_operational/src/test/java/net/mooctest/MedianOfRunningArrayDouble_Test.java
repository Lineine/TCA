package net.mooctest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MedianOfRunningArrayDouble_Test {
    @Test
    @Timeout(4000)
    public void testCalculateAverage() {
        MedianOfRunningArrayDouble median = new MedianOfRunningArrayDouble();
        assertEquals(2.5, median.calculateAverage(2.0, 3.0), 0.01);
        assertEquals(1.5, median.calculateAverage(1.0, 2.0), 0.01);
        assertEquals(0.5, median.calculateAverage(0.0, 1.0), 0.01);
    }

}
