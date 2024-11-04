package net.mooctest;
import static org.junit.Assert.*;
import org.junit.Test;
import java.awt.*;
import javax.swing.*;
import java.net.URL;
public class Game_2_Test
{
    
    @Test
    public void test_222() throws Exception {
        GameHelper.setTitle("New Game");
        assertEquals("null", GameHelper.getTitle());
        
        JFrame frame = new JFrame();
        GameHelper.setWindow(frame);
        GameHelper.setTitle("My Game");
        assertEquals("My Game", GameHelper.getTitle());
    }
}