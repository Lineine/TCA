package net.mooctest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class MedianOfRunningArrayFloat_Test {
    @Test
    @Timeout(4000)
    public void testCalculateAverage() {
        MedianOfRunningArrayFloat medianCalculator = new MedianOfRunningArrayFloat();
        Float a = 10.0f;
        Float b = 20.0f;
        Float expected = 15.0f;
        Float actual = medianCalculator.calculateAverage(a, b);
        assertEquals(expected, actual, 0.0f);
    }

}
