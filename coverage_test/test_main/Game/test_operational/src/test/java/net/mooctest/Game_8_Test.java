package net.mooctest;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;
public class Game_8_Test
{
    private Matrix3 identity;
    private Matrix3 matrixA;
    private Matrix3 matrixB;
    @Before
    public void setUp() {
        identity = new Matrix3(1, 0, 0, 0, 1, 0, 0, 0, 1);
        matrixA = new Matrix3(1, 2, 3, 4, 5, 6, 7, 8, 9);
        matrixB = new Matrix3(9, 8, 7, 6, 5, 4, 3, 2, 1);
    }
    @Test
    public void test_422() throws Exception {
        Matrix3 matrixC = new Matrix3(2, 0, 0, 0, 2, 0, 0, 0, 2);
        Matrix3 result = matrixC.invert();
        assertEquals(0.5, result.M11);
        assertEquals(0, result.M12);
        assertEquals(0, result.M13);
        assertEquals(0, result.M21);
        assertEquals(0.5, result.M22);
        assertEquals(0, result.M23);
        assertEquals(0, result.M31);
        assertEquals(0, result.M32);
        assertEquals(0.5, result.M33);
    }
    @Test
    public void test_420() throws Exception {
        assertEquals(0, matrixA.determinant());
        Matrix3 matrixC = new Matrix3(2, 0, 0, 0, 2, 0, 0, 0, 2);
        assertEquals(8, matrixC.determinant());
    }
    @Test
    public void test_421() throws Exception {
        Matrix3 result = matrixA.transpose();
        assertEquals(1, result.M11);
        assertEquals(4, result.M12);
        assertEquals(7, result.M13);
        assertEquals(2, result.M21);
        assertEquals(5, result.M22);
        assertEquals(8, result.M23);
        assertEquals(3, result.M31);
        assertEquals(6, result.M32);
        assertEquals(9, result.M33);
    }
    @Test
    public void test_417() throws Exception {
        Matrix3 result = matrixA.add(matrixB);
        assertEquals(10, result.M11);
        assertEquals(10, result.M12);
        assertEquals(10, result.M13);
        assertEquals(10, result.M21);
        assertEquals(10, result.M22);
        assertEquals(10, result.M23);
        assertEquals(10, result.M31);
        assertEquals(10, result.M32);
        assertEquals(10, result.M33);
    }
    @Test
    public void test_416() throws Exception {
        assertEquals(1, identity.M11);
        assertEquals(1, identity.M22);
        assertEquals(1, identity.M33);
        assertEquals(0, identity.M12);
        assertEquals(0, identity.M13);
        assertEquals(0, identity.M21);
        assertEquals(0, identity.M23);
        assertEquals(0, identity.M31);
        assertEquals(0, identity.M32);
    }
    @Test
    public void test_419() throws Exception {
        Matrix3 result = matrixA.multiply(matrixB);
        assertEquals(30, result.M11);
        assertEquals(24, result.M12);
        assertEquals(18, result.M13);
        assertEquals(84, result.M21);
        assertEquals(69, result.M22);
        assertEquals(54, result.M23);
        assertEquals(138, result.M31);
        assertEquals(114, result.M32);
        assertEquals(90, result.M33);
    }
}