package net.mooctest;
import static org.junit.Assert.*;
import java.awt.*;
import org.junit.Test;
public class Game_42_Test
{
    
    @Test
    public void test_6() throws Exception {
        Color start = new Color(10, 20, 30, 40);
        Color end = new Color(50, 60, 70, 80);
        float amount = 0.5f;
        
        Color result = ColorHelper.lerp(start, end, amount);
        assertEquals(30, result.getRed());
        assertEquals(40, result.getGreen());
        assertEquals(50, result.getBlue());
        assertEquals(60, result.getAlpha());
        
        result = ColorHelper.lerp(start, end, 0f);
        assertEquals(start.getRed(), result.getRed());
        assertEquals(start.getGreen(), result.getGreen());
        assertEquals(start.getBlue(), result.getBlue());
        assertEquals(start.getAlpha(), result.getAlpha());
        
        result = ColorHelper.lerp(start, end, 1f);
        assertEquals(end.getRed(), result.getRed());
        assertEquals(end.getGreen(), result.getGreen());
        assertEquals(end.getBlue(), result.getBlue());
        assertEquals(end.getAlpha(), result.getAlpha());
    }
}