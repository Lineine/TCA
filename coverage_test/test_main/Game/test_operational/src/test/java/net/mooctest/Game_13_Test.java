package net.mooctest;
import static org.junit.Assert.*;
import org.junit.Test;
import java.awt.*;
import java.awt.event.MouseEvent;
import javax.swing.*;
public class Game_13_Test
{
    
    @Test
    public void test_42() throws Exception {
        MouseInput mouseInput = new MouseInput();
        MouseEvent e = new MouseEvent(new JButton(), MouseEvent.MOUSE_PRESSED, System.currentTimeMillis(), 0, 0, 0, 1, false);
        mouseInput.mousePressed(e);
        assertTrue(mouseInput.buttonDown(1));
        assertTrue(mouseInput.buttonDownOnce(1));
    }
}