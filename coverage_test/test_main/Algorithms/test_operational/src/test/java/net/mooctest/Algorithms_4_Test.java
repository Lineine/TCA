package net.mooctest;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import org.junit.Before;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;
public class Algorithms_4_Test
{
    private List<List<Integer>> matrix;
    @Before
    public void setUp() {
        matrix = new ArrayList<>();
    }
    @Test
    public void test_809() throws Exception {
        try {
            MedianOfMatrix.median(matrix);
            fail("Expected an IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Matrix should not be empty");
        }
    }
    @Test
    public void test_796() throws Exception {
        assertEquals(5, MedianOfMatrix.median(matrix));
    }
}