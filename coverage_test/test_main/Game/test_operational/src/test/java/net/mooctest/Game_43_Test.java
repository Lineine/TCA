package net.mooctest;
import static org.junit.Assert.*;
import org.junit.Test;
import java.awt.*;
import org.junit.Before;
public class Game_43_Test
{
    private Rectangle rect1;
    private Rectangle rect2;
    @Before
    public void setUp() {
        rect1 = new Rectangle(10, 20, 30, 40);
        rect2 = new Rectangle(20, 30, 40, 50);
    }
    @Test
    public void test_359() throws Exception {
        Rectangle inflatedRect = rect1.inflate(10, 20);
        assertEquals(5, inflatedRect.x);
        assertEquals(10, inflatedRect.y);
        assertEquals(40, inflatedRect.width);
        assertEquals(60, inflatedRect.height);
    }
}