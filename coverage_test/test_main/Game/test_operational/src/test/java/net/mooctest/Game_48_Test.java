package net.mooctest;
import static org.junit.Assert.*;
import org.junit.Test;
import java.awt.*;
import org.junit.Before;
public class Game_48_Test
{
    private Rectangle rect1;
    private Rectangle rect2;
    @Before
    public void setUp() {
        rect1 = new Rectangle(10, 20, 30, 40);
        rect2 = new Rectangle(20, 30, 40, 50);
    }
    @Test
    public void test_360() throws Exception {
        Rectangle intersectionRect = rect1.intersection(rect2);
        assertEquals(20, intersectionRect.x);
        assertEquals(30, intersectionRect.y);
        assertEquals(20, intersectionRect.width);
        assertEquals(30, intersectionRect.height);
    }
}