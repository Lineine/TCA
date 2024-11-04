package net.mooctest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianOfRunningArrayInteger_Test {

    @Test
    @Timeout(4000)
    public void testCalculateAverage() {
        MedianOfRunningArrayInteger medianCalculator = new MedianOfRunningArrayInteger();
        
        // Test with positive numbers
        assertEquals(Optional.of(3), medianCalculator.calculateAverage(2, 4));
        assertEquals(Optional.of(5), medianCalculator.calculateAverage(4, 6));
        
        // Test with negative numbers
        assertEquals(Optional.of(-3), medianCalculator.calculateAverage(-4, -2));
        assertEquals(Optional.of(-5), medianCalculator.calculateAverage(-6, -4));
        
        // Test with mixed numbers
        assertEquals(Optional.of(0), medianCalculator.calculateAverage(-2, 2));
        assertEquals(Optional.of(2), medianCalculator.calculateAverage(-4, 8));
    }

}

