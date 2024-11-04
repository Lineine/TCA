package net.mooctest;
import static org.junit.Assert.*;
import org.junit.Test;
import javax.swing.*;
import org.junit.Before;
import java.awt.event.KeyEvent;
public class Game_17_Test
{
    private KeyboardInput keyboardInput;
    @Before
    public void setUp() {
        keyboardInput = new KeyboardInput();
    }
    @Test
    public void test_98() throws Exception {
        KeyEvent keyPressedEvent1 = new KeyEvent(new JTextField(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_A);
        KeyEvent keyPressedEvent2 = new KeyEvent(new JTextField(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_B);
        
        keyboardInput.keyPressed(keyPressedEvent1);
        keyboardInput.keyPressed(keyPressedEvent2);
        
        keyboardInput.poll();
        
        assertTrue(keyboardInput.keyDown(KeyEvent.VK_A));
        assertTrue(keyboardInput.keyDownOnce(KeyEvent.VK_A));
        assertTrue(keyboardInput.keyDown(KeyEvent.VK_B));
        assertTrue(keyboardInput.keyDownOnce(KeyEvent.VK_B));
        
        KeyEvent keyReleasedEvent1 = new KeyEvent(new JTextField(), KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0, KeyEvent.VK_A);
        KeyEvent keyReleasedEvent2 = new KeyEvent(new JTextField(), KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0, KeyEvent.VK_B);
        
        keyboardInput.keyReleased(keyReleasedEvent1);
        keyboardInput.keyReleased(keyReleasedEvent2);
        
        keyboardInput.poll();
        
        assertFalse(keyboardInput.keyDownOnce(KeyEvent.VK_A));
        assertFalse(keyboardInput.keyDown(KeyEvent.VK_A));
        assertFalse(keyboardInput.keyDownOnce(KeyEvent.VK_B));
        assertFalse(keyboardInput.keyDown(KeyEvent.VK_B));
    }
}