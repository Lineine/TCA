package net.mooctest;
import static org.junit.Assert.*;
import org.junit.Test;
import java.awt.*;
import javax.swing.*;
import java.net.URL;
public class Game_65_Test
{
    
    @Test
    public void test_223() throws Exception {
        GameHelper.setScreenWidth(800);
        GameHelper.setScreenHeight(600);
        
        assertEquals(800, GameHelper.WIDTH());
        assertEquals(600, GameHelper.HEIGHT());
    }
}