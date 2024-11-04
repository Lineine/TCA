package net.mooctest;
import static org.junit.Assert.*;
import org.junit.Test;
import java.awt.*;
import java.awt.event.MouseEvent;
import javax.swing.*;
public class Game_68_Test
{
    
    @Test
    public void test_44() throws Exception {
        MouseInput mouseInput = new MouseInput();
        MouseEvent e1 = new MouseEvent(new JButton(), MouseEvent.MOUSE_PRESSED, System.currentTimeMillis(), 0, 0, 0, 1, false);
        mouseInput.mousePressed(e1);
        assertTrue(mouseInput.buttonDown(1));
        assertTrue(mouseInput.buttonDownOnce(1));
        MouseEvent e2 = new MouseEvent(new JButton(), MouseEvent.MOUSE_PRESSED, System.currentTimeMillis(), 0, 0, 0, 1, false);
        mouseInput.mousePressed(e2);
        assertTrue(mouseInput.buttonDown(1));
        assertFalse(mouseInput.buttonDownOnce(1));
    }
}