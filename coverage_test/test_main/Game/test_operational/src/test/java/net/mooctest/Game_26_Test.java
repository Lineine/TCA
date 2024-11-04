package net.mooctest;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import java.awt.event.KeyEvent;
import static org.evosuite.shaded.org.mockito.Mockito.*;
public class Game_26_Test
{
    private KeyboardInput mockKeyboardInput;
    @Before
    public void setUp() {
        mockKeyboardInput = mock(KeyboardInput.class);
        Keyboard.keyboard = mockKeyboardInput;
    }
    @Test
    public void test_412() throws Exception {
        int keyCode = KeyEvent.VK_A;
        when(mockKeyboardInput.keyDown(keyCode)).thenReturn(true);
        boolean result = Keyboard.keyDown(keyCode);
        verify(mockKeyboardInput).keyDown(keyCode);
        assertTrue(result);
    }
}