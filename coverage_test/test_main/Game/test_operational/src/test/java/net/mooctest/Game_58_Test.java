package net.mooctest;
import static org.junit.Assert.*;
import org.junit.Test;
import java.awt.*;
import org.junit.Before;
import java.awt.geom.Rectangle2D;
public class Game_58_Test
{
    @Before
    public void setup() {
        FontHelper.initialize();
    }
    @Test
    public void test_490() throws Exception {
        Font defaultFont = FontHelper.loadFont("/invalid/path/font.ttf", 12.0f);
        assertEquals("Serif", defaultFont.getFamily());
    }
}