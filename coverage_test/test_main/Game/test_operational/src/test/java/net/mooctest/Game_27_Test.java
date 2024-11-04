package net.mooctest;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;
public class Game_27_Test
{
    private Bounce bounce;
    @Before
    public void setUp() {
        bounce = new Bounce();
    }
    @Test
    public void test_218() throws Exception {
        float result = bounce.easeOut(0.5f, 0, 100, 1.0f);
    assertEquals(75.0f, result, 0.1f);        }
}