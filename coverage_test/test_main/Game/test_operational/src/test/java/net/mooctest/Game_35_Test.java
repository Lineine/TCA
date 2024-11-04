package net.mooctest;
import static org.junit.Assert.*;
import java.awt.*;
import org.junit.Test;
public class Game_35_Test
{
    
    @Test
    public void test_5() throws Exception {
        Color transparentColor = ColorHelper.transparent;
        assertEquals(0, transparentColor.getRed());
        assertEquals(0, transparentColor.getGreen());
        assertEquals(0, transparentColor.getBlue());
        assertEquals(0, transparentColor.getAlpha());
    }
}