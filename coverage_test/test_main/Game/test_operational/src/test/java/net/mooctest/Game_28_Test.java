package net.mooctest;
import static org.junit.Assert.*;
import org.junit.Test;
import java.awt.*;
import org.junit.Before;
import java.awt.geom.Rectangle2D;
public class Game_28_Test
{
    @Before
    public void setup() {
        FontHelper.initialize();
    }
    @Test
    public void test_491() throws Exception {
        Font font = FontHelper.loadFont("/path/to/custom/font.ttf", 12.0f);
        Rectangle2D bounds = FontHelper.getBounds("Test", font);
        assertEquals(30.0, bounds.getWidth());
        assertEquals(12.0, bounds.getHeight());
    }
}