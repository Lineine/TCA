package net.mooctest;
import static org.junit.Assert.*;
import org.junit.Test;
import java.awt.*;
import org.junit.Before;
import java.awt.event.KeyEvent;
public class Game_59_Test
{
    KeyboardInput keyboardInput;
    @Before
    public void setUp() {
        keyboardInput = new KeyboardInput();
    }
    
    
    
    private char charForKeyCode(int keyCode) {
        return KeyEvent.getKeyText(keyCode).charAt(0);
    }
    @Test
    public void test_233() throws Exception {
        int keyCode = 25;         assertFalse(keyboardInput.keyDown(keyCode));
    keyboardInput.keyPressed(new KeyEvent(new Component() {}, KeyEvent.KEY_PRESSED, 0, 0, keyCode, charForKeyCode(keyCode)));
        assertTrue(keyboardInput.keyDown(keyCode));
    }
}