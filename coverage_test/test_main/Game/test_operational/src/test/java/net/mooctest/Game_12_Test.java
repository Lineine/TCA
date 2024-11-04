package net.mooctest;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;
public class Game_12_Test
{
    private Quaternion q1;
    private Quaternion q2;
    @Before
    public void setUp() {
        q1 = new Quaternion(1, 2, 3, 4);
        q2 = new Quaternion(5, 6, 7, 8);
    }
    @Test
    public void test_437() throws Exception {
        Quaternion result = Quaternion.normalize(q1);
        float magnitude = Quaternion.magnitude(q1);
        assertEquals(1 / magnitude, result.x);
        assertEquals(2 / magnitude, result.y);
        assertEquals(3 / magnitude, result.z);
        assertEquals(4 / magnitude, result.w);
    }
    @Test
    public void test_433() throws Exception {
        float result = Quaternion.magnitudeSquared(q1);
        assertEquals(1*1 + 2*2 + 3*3 + 4*4, result);
    }
    @Test
    public void test_430() throws Exception {
        Quaternion q3 = new Quaternion(1, 2, 3, 4);
        assertTrue(q1.equals(q3));
        assertFalse(q1.equals(q2));
    }
    @Test
    public void test_439() throws Exception {
        String result = q1.toString();
        assertEquals("(1.0, 2.0, 3.0, 4.0)", result);
    }
    @Test
    public void test_429() throws Exception {
        float result = Quaternion.dotProduct(q1, q2);
        assertEquals((1*5) + (2*6) + (3*7) + (4*8), result);
    }
    @Test
    public void test_431() throws Exception {
        Quaternion identity = Quaternion.identity();
        assertEquals(0, identity.x);
        assertEquals(0, identity.y);
        assertEquals(0, identity.z);
        assertEquals(1, identity.w);
    }
}