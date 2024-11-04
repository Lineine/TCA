package net.mooctest;
import static org.junit.Assert.*;
import org.junit.Test;
import java.awt.Point;
import org.evosuite.shaded.org.mockito.Mock;
import net.mooctest.MouseInput;
import java.awt.event.MouseEvent;
import net.mooctest.MouseKeys;
import org.junit.Before;
import org.evosuite.shaded.org.mockito.MockitoAnnotations;
import net.mooctest.Mouse;
import static org.evosuite.shaded.org.mockito.Mockito.*;
public class Game_49_Test
{
    @Mock
    private MouseInput mockMouseInput;
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    Mouse.mouse = mockMouseInput;      }
    @Test
    public void test_477() throws Exception {
        int buttonId = 1;
        when(mockMouseInput.buttonDownOnce(buttonId)).thenReturn(true);
        
        boolean result = Mouse.buttonDownOnce(buttonId);
        
        assertTrue(result);
    verify(mockMouseInput).buttonDownOnce(buttonId);      }
}