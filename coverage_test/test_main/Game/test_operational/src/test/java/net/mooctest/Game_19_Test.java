package net.mooctest;
import static org.junit.Assert.*;
import java.awt.*;
import org.junit.Test;
public class Game_19_Test
{
    
    @Test
    public void test_7() throws Exception {
        Color start = new Color(10, 20, 30, 40);
        Color end = new Color(50, 60, 70, 80);
        float amount = 0.5f;
        
        Color result = ColorHelper.smoothStep(start, end, amount);
        assertTrue(result.getRed() >= start.getRed() && result.getRed() <= end.getRed());
        assertTrue(result.getGreen() >= start.getGreen() && result.getGreen() <= end.getGreen());
        assertTrue(result.getBlue() >= start.getBlue() && result.getBlue() <= end.getBlue());
        assertTrue(result.getAlpha() >= start.getAlpha() && result.getAlpha() <= end.getAlpha());
        
        result = ColorHelper.smoothStep(start, end, 0f);
        assertEquals(start.getRed(), result.getRed());
        assertEquals(start.getGreen(), result.getGreen());
        assertEquals(start.getBlue(), result.getBlue());
        assertEquals(start.getAlpha(), result.getAlpha());
        
        result = ColorHelper.smoothStep(start, end, 1f);
        assertEquals(end.getRed(), result.getRed());
        assertEquals(end.getGreen(), result.getGreen());
        assertEquals(end.getBlue(), result.getBlue());
        assertEquals(end.getAlpha(), result.getAlpha());
    }
}