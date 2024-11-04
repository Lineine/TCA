package net.mooctest;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import java.awt.event.KeyEvent;
public class Game_21_Test
{
    private KeyboardInput keyboardInput;
    @Before
    public void setUp() {
        keyboardInput = new KeyboardInput();
    }
    
    private void simulateKeyPress(int keyCode) {
        KeyEvent keyEvent = new KeyEvent(new java.awt.Canvas(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, keyCode, KeyEvent.CHAR_UNDEFINED);
        keyboardInput.keyPressed(keyEvent);
    }
    private void simulateKeyRelease(int keyCode) {
        KeyEvent keyEvent = new KeyEvent(new java.awt.Canvas(), KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0, keyCode, KeyEvent.CHAR_UNDEFINED);
        keyboardInput.keyReleased(keyEvent);
    }
    @Test
    public void test_401() throws Exception {
        int keyCode = KeyEvent.VK_A;
        simulateKeyPress(keyCode);
        keyboardInput.poll();
        
        assertTrue(keyboardInput.keyDown(keyCode));
        assertTrue(keyboardInput.keyDownOnce(keyCode));
        
        keyboardInput.poll();
        
        assertTrue(keyboardInput.keyDown(keyCode));
        assertFalse(keyboardInput.keyDownOnce(keyCode));
    }
}