package net.mooctest;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import java.awt.event.KeyEvent;
import static org.evosuite.shaded.org.mockito.Mockito.*;
public class Game_18_Test
{
    private KeyboardInput mockKeyboardInput;
    @Before
    public void setUp() {
        mockKeyboardInput = mock(KeyboardInput.class);
        Keyboard.keyboard = mockKeyboardInput;
    }
    @Test
    public void test_415() throws Exception {
        KeyEvent mockKeyEvent = mock(KeyEvent.class);
        Keyboard.keyReleased(mockKeyEvent);
        verify(mockKeyboardInput).keyReleased(mockKeyEvent);
    }
}