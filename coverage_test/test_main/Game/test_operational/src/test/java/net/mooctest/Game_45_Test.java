package net.mooctest;
import static org.junit.Assert.*;
import org.junit.Test;
import java.awt.*;
import java.awt.event.MouseEvent;
import javax.swing.*;
public class Game_45_Test
{
    
    @Test
    public void test_41() throws Exception {
        MouseInput mouseInput = new MouseInput();
        MouseEvent e = new MouseEvent(new JButton(), MouseEvent.MOUSE_MOVED, System.currentTimeMillis(), 0, 10, 20, 0, false);
        mouseInput.mouseMoved(e);
        assertEquals(new Point(10, 20), mouseInput.getPosition());
    }
}