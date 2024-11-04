package net.mooctest;
import static org.junit.Assert.*;
import java.awt.*;
import org.junit.Test;
public class Game_57_Test
{
    
    @Test
    public void test_8() throws Exception {
        Color randomColor = ColorHelper.randomColor();
        assertNotNull(randomColor);
        assertTrue(randomColor.getRed() >= 0 && randomColor.getRed() <= 255);
        assertTrue(randomColor.getGreen() >= 0 && randomColor.getGreen() <= 255);
        assertTrue(randomColor.getBlue() >= 0 && randomColor.getBlue() <= 255);
    }
}