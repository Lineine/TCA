package net.mooctest;
import static org.junit.Assert.*;
import org.junit.Test;
import java.awt.*;
import org.junit.Before;
import java.awt.geom.Rectangle2D;
public class Game_46_Test
{
    @Before
    public void setup() {
        FontHelper.initialize();
    }
    @Test
    public void test_489() throws Exception {
        Font customFont = FontHelper.loadFont("/path/to/custom/font.ttf", 12.0f);
        assertNotNull(customFont);
    }
}