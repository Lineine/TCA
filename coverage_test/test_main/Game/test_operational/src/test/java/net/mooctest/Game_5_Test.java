package net.mooctest;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;
public class Game_5_Test
{
    private GameTime gameTime;
    
    @Before
    public void setup() {
        gameTime = new GameTime();
    }
    private Matrix matrix1;
    private Matrix matrix2;
    @Before
    public void setUp() {
    float[] data1 = {1, 2, 3, 4};
    float[] data2 = {5, 6, 7, 8};
        matrix1 = new Matrix(data1, 2, 2);
        matrix2 = new Matrix(data2, 2, 2);
    }
    @Test
    public void test_371() throws Exception {
        Matrix result = matrix1.subtract(matrix2);
    float[] expectedData = {-4, -4, -4, -4};
    }
    @Test
    public void test_373() throws Exception {
        Matrix result = matrix1.multiply(matrix2);
    float[] expectedData = {19, 22, 43, 50};
    }
    @Test
    public void test_508() throws Exception {
        gameTime.start();
        assertTrue(gameTime.getGameTime() > 0);
    }
    @Test
    public void test_511() throws Exception {
        assertTrue(gameTime.getDeltaTimeSeconds() >= 0);
    }
    @Test
    public void test_376() throws Exception {
        Matrix matrix3 = new Matrix(matrix1);
        assertEquals(matrix1, matrix3);
        assertNotEquals(matrix1, matrix2);
    }
    @Test
    public void test_512() throws Exception {
        gameTime.reset();
        assertEquals(0, gameTime.getGameTime(), 0.001);
    }
    @Test
    public void test_375() throws Exception {
        Matrix result = matrix1.divide(matrix2);
    float[] expectedData = {1/5f, 2/6f, 3/7f, 4/8f};
    }
    @Test
    public void test_509() throws Exception {
        gameTime.stop();
        assertTrue(gameTime.getGameTime() > 0);
    }
    @Test
    public void test_377() throws Exception {
        Matrix identity = Matrix.identity(2);
    float[] expectedData = {1, 0, 0, 1};
    }
}