package net.mooctest;
import static org.junit.Assert.*;
import org.junit.Test;
import java.awt.*;
import org.junit.Before;
public class Game_64_Test
{
    private Rectangle rect1;
    private Rectangle rect2;
    @Before
    public void setUp() {
        rect1 = new Rectangle(10, 20, 30, 40);
        rect2 = new Rectangle(20, 30, 40, 50);
    }
    @Test
    public void test_357() throws Exception {
        Rectangle rectCopy = new Rectangle(rect1);
        assertEquals(rect1.x, rectCopy.x);
        assertEquals(rect1.y, rectCopy.y);
        assertEquals(rect1.width, rectCopy.width);
        assertEquals(rect1.height, rectCopy.height);
    }
}