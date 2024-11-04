package net.mooctest;
import org.junit.Test;
import java.awt.*;
import javax.swing.*;
import java.net.URL;
import static org.junit.Assert.assertEquals;
public class Game_7_Test
{
    
    @Test
    public void test_576() throws Exception {
        int expectedWidth = 800;
        int expectedHeight = 600;
        
        GameHelper.setScreenWidth(expectedWidth);
        GameHelper.setScreenHeight(expectedHeight);
        
        int actualWidth = GameHelper.WIDTH();
        int actualHeight = GameHelper.HEIGHT();
        
        assertEquals(expectedWidth, actualWidth);
        assertEquals(expectedHeight, actualHeight);
    }
}