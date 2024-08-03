package net.mooctest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class Algorithms_8_Test
{
    private MedianOfRunningArrayDouble medianCalculator;
    @BeforeEach
    public void setUp() {
        medianCalculator = new MedianOfRunningArrayDouble();
    }
    @Test
    public void test_456() throws Exception {
        Double result = medianCalculator.calculateAverage(0.0001, 0.0002);
        assertEquals(0.00015, result, 0.0001);
    }
}