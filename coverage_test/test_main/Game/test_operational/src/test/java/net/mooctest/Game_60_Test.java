package net.mooctest;
import static org.junit.Assert.*;
import org.junit.Test;
import java.awt.*;
import org.junit.Before;
public class Game_60_Test
{
    private Rectangle rect1;
    private Rectangle rect2;
    @Before
    public void setUp() {
        rect1 = new Rectangle(10, 20, 30, 40);
        rect2 = new Rectangle(20, 30, 40, 50);
    }
    @Test
    public void test_356() throws Exception {
        assertEquals(10, rect1.x);
        assertEquals(20, rect1.y);
        assertEquals(30, rect1.width);
        assertEquals(40, rect1.height);
    }
}