package net.mooctest;
import static org.junit.Assert.*;
import java.awt.*;
import org.junit.Test;
public class Game_54_Test
{
    
    @Test
    public void test_9() throws Exception {
        Color color = new Color(100, 150, 200, 255);
        Color transparentColor = ColorHelper.createTransparentColor(color);
        assertEquals(color.getRed(), transparentColor.getRed());
        assertEquals(color.getGreen(), transparentColor.getGreen());
        assertEquals(color.getBlue(), transparentColor.getBlue());
        assertEquals(0, transparentColor.getAlpha());
    }
}