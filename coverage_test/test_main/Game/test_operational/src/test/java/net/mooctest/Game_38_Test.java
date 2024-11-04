package net.mooctest;
import static org.junit.Assert.*;
import org.junit.Test;
import java.awt.*;
import javax.swing.*;
import org.junit.Before;
import java.net.URL;
public class Game_38_Test
{
    @Before
    public void setup() {
        JFrame frame = new JFrame();
        frame.setSize(800, 600);
        GameHelper.setWindow(frame);
        GameHelper.setScreenWidth(800);
        GameHelper.setScreenHeight(600);
    }
    @Test
    public void test_80() throws Exception {
        Cursor cursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
        GameHelper.setCursor(cursor);
        
        assertEquals(cursor, GameHelper.getCursor());
    }
}