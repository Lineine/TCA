package net.mooctest;
import static org.junit.Assert.*;
import org.junit.Test;
import java.awt.*;
import org.junit.Before;
public class Game_70_Test
{
    private Rectangle rect1;
    private Rectangle rect2;
    @Before
    public void setUp() {
        rect1 = new Rectangle(10, 20, 30, 40);
        rect2 = new Rectangle(20, 30, 40, 50);
    }
    @Test
    public void test_363() throws Exception {
        Rectangle offsetRect = rect1.offset(5, 10);
        assertEquals(5, offsetRect.x);
        assertEquals(10, offsetRect.y);
        assertEquals(30, offsetRect.width);
        assertEquals(40, offsetRect.height);
    }
}