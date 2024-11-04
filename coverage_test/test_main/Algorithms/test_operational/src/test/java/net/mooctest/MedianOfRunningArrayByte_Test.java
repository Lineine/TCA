package net.mooctest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MedianOfRunningArrayByte_Test {

    @Test
    @Timeout(4000)
    public void testCalculateAverage() {
        MedianOfRunningArrayByte medianCalculator = new MedianOfRunningArrayByte();
        Byte result = medianCalculator.calculateAverage((byte) 10, (byte) 20);
        assertEquals(Optional.of((byte) 15), result);
    }

    @Test
    @Timeout(4000)
    public void testCalculateAverage_EqualValues() {
        MedianOfRunningArrayByte medianCalculator = new MedianOfRunningArrayByte();
        Byte result = medianCalculator.calculateAverage((byte) 10, (byte) 10);
        assertEquals(Optional.of((byte) 10), result);
    }

    @Test
    @Timeout(4000)
    public void testCalculateAverage_NegativeValues() {
        MedianOfRunningArrayByte medianCalculator = new MedianOfRunningArrayByte();
        Byte result = medianCalculator.calculateAverage((byte) -10, (byte) 20);
        assertEquals(Optional.of((byte) 5), result);
    }

    @Test
    @Timeout(4000)
    public void testCalculateAverage_LargeValues() {
        MedianOfRunningArrayByte medianCalculator = new MedianOfRunningArrayByte();
        Byte result = medianCalculator.calculateAverage((byte) 100, (byte) 200);
        assertEquals(Optional.of((byte) 150), result);
    }

}
