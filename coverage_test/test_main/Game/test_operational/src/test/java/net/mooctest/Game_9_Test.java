package net.mooctest;
import static org.junit.Assert.*;
import org.junit.Test;
import java.awt.*;
import javax.swing.*;
import java.net.URL;
public class Game_9_Test
{
    
    @Test
    public void test_221() throws Exception {
        GameHelper.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        assertEquals(Cursor.getDefaultCursor(), GameHelper.getCursor());
        
        JFrame frame = new JFrame();
        GameHelper.setWindow(frame);
        GameHelper.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        assertEquals(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR), GameHelper.getCursor());
    }
}