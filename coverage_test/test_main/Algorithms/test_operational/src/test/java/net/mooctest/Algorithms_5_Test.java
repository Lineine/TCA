package net.mooctest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class Algorithms_5_Test
{
    private MedianOfRunningArrayFloat medianCalculator;
    @BeforeEach
    public void setUp() {
        medianCalculator = new MedianOfRunningArrayFloat();
    }
    @Test
    public void test_10() throws Exception {
        Float result = medianCalculator.calculateAverage(2.0f, 4.0f);
        assertEquals(3.0f, result, 0.0001);
    }
    @Test
    public void test_15() throws Exception {
        Float result = medianCalculator.calculateAverage(1000000.0f, 2000000.0f);
        assertEquals(1500000.0f, result, 0.0001);
    }
}