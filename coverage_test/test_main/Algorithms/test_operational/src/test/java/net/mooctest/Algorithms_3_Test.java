package net.mooctest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.stream.IntStream;
import static org.junit.jupiter.api.Assertions.*;
public class Algorithms_3_Test
{
    private MedianOfRunningArrayByte medianOfRunningArrayByte;
    @BeforeEach
    public void setUp() {
        medianOfRunningArrayByte = new MedianOfRunningArrayByte();
    }
    @Test
    public void test_1005() throws Exception {
        assertEquals((byte) 5, medianOfRunningArrayByte.calculateAverage((byte) 10, (byte) 20));
    }
}