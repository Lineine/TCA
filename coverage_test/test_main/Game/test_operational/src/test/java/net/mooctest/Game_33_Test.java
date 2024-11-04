package net.mooctest;
import static org.junit.Assert.*;
import org.junit.Test;
import java.awt.*;
import org.junit.Before;
import java.awt.geom.Rectangle2D;
public class Game_33_Test
{
    @Before
    public void setup() {
        FontHelper.initialize();
    }
    @Test
    public void test_495() throws Exception {
        Font font = FontHelper.loadFont("/path/to/custom/font.ttf", 12.0f);
        int ascent = FontHelper.getAscent(font);
    assertEquals(10, ascent);     }
}