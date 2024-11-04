package net.mooctest;
import static org.junit.Assert.*;
import org.junit.Test;
import java.awt.*;
import org.junit.Before;
public class Game_51_Test
{
    private Rectangle rect1;
    private Rectangle rect2;
    @Before
    public void setUp() {
        rect1 = new Rectangle(10, 20, 30, 40);
        rect2 = new Rectangle(20, 30, 40, 50);
    }
    @Test
    public void test_362() throws Exception {
        assertTrue(rect1.intersects(15, 25));
        assertFalse(rect1.intersects(50, 60));
    }
}