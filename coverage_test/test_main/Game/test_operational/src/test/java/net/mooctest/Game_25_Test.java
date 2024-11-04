package net.mooctest;
import static org.junit.Assert.*;
import org.junit.Test;
import javax.swing.*;
import java.awt.event.KeyEvent;
public class Game_25_Test
{
    
    @Test
    public void test_589() throws Exception {
        Keyboard.keyboard = new KeyboardInput();
        assertFalse(Keyboard.keyDown(KeyEvent.VK_A));
        Keyboard.keyboard.keyPressed(new KeyEvent(new JPanel(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_A, 'a'));
        assertTrue(Keyboard.keyDown(KeyEvent.VK_A));
    }
}