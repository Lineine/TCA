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
public class Game_23_Test
{
    @Mock
    private MouseInput mockMouseInput;
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    Mouse.mouse = mockMouseInput;      }
    @Test
    public void test_476() throws Exception {
        Point mockPoint = new Point(100, 200);
        when(mockMouseInput.getPosition()).thenReturn(mockPoint);
        
        Point result = Mouse.getPosition();
        
        assertEquals(mockPoint, result);
    verify(mockMouseInput).getPosition();      }
}