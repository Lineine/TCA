package net.mooctest;
import org.evosuite.shaded.org.mockito.InjectMocks;
import static org.junit.Assert.*;
import org.junit.Test;
import org.evosuite.runtime.MockitoExtension;
import java.awt.Point;
import org.evosuite.shaded.org.mockito.Mock;
import java.awt.event.MouseEvent;
import org.junit.Before;
import static org.evosuite.shaded.org.mockito.Mockito.when;
public class Game_6_Test
{
    @InjectMocks
    private Mouse mouse;
    @Mock
    private MouseInput mouseInput;
    @Mock
    private MouseEvent mouseEvent;
    @Mock
    private MouseKeys mouseKeys;
    @Before
    public void setUp() {
        mouse = new Mouse();
    }
    @Test
    public void test_137() throws Exception {
        int button = 1;
        when(mouseInput.buttonDown(button)).thenReturn(true);
        
        boolean result = mouse.buttonDown(button);
        assertTrue(result);
    }
    @Test
    public void test_135() throws Exception {
        Point point = new Point(10, 10);
        when(mouseInput.getPosition()).thenReturn(point);
        
        Point position = mouse.getPosition();
        assertTrue(position.equals(point));
    }
    @Test
    public void test_139() throws Exception {
        mouse.mouseReleased(mouseEvent);
    }
    @Test
    public void test_138() throws Exception {
        mouse.mousePressed(mouseEvent);
    }
    @Test
    public void test_134() throws Exception {
        mouse.poll();
    }
}