package net.mooctest;
import static org.junit.Assert.*;
import org.junit.Test;
import javax.swing.*;
import java.awt.event.KeyEvent;
public class Game_41_Test
{
    
    @Test
    public void test_590() throws Exception {
        Keyboard.keyboard = new KeyboardInput();
        assertFalse(Keyboard.keyDownOnce(KeyEvent.VK_B));
        Keyboard.keyboard.keyPressed(new KeyEvent(new JPanel(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_B, 'b'));
        assertTrue(Keyboard.keyDownOnce(KeyEvent.VK_B));
        assertFalse(Keyboard.keyDownOnce(KeyEvent.VK_B));
    }
}