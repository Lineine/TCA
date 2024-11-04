package net.mooctest;
import static org.junit.Assert.*;
import org.junit.Test;
import java.awt.Point;
import java.awt.event.MouseEvent;
import org.junit.Before;
public class Game_29_Test
{
    private MouseInput mouseInput;
    @Before
    public void setUp() {
        mouseInput = new MouseInput();
    }
    @Test
    public void test_515() throws Exception {
        assertFalse(mouseInput.buttonDownOnce(1));
        assertFalse(mouseInput.buttonDownOnce(2));
        assertFalse(mouseInput.buttonDownOnce(3));
    }
    @Test
    public void test_337() throws Exception {
        MouseEvent moveEvent = new MouseEvent(new java.awt.Canvas(), MouseEvent.MOUSE_MOVED, System.currentTimeMillis(), 0, 100, 200, 0, false);
        mouseInput.mouseMoved(moveEvent);
        
        Point newPosition = mouseInput.getPosition();
        assertEquals(new Point(100, 200), newPosition);
    }
    @Test
    public void test_518() throws Exception {
    }
    @Test
    public void test_338() throws Exception {
        MouseEvent pressEvent = new MouseEvent(new java.awt.Canvas(), MouseEvent.MOUSE_PRESSED, System.currentTimeMillis(), 0, 0, 0, 1, false, MouseEvent.BUTTON1);
        MouseEvent releaseEvent = new MouseEvent(new java.awt.Canvas(), MouseEvent.MOUSE_RELEASED, System.currentTimeMillis(), 0, 0, 0, 1, false, MouseEvent.BUTTON1);
        
        mouseInput.mousePressed(pressEvent);
        mouseInput.poll();
        assertTrue(mouseInput.buttonDownOnce(MouseEvent.BUTTON1));
        assertTrue(mouseInput.buttonDown(MouseEvent.BUTTON1));
        
        mouseInput.mouseReleased(releaseEvent);
        mouseInput.poll();
        assertFalse(mouseInput.buttonDownOnce(MouseEvent.BUTTON1));
        assertFalse(mouseInput.buttonDown(MouseEvent.BUTTON1));
    }
    @Test
    public void test_517() throws Exception {
        mouseInput.poll();
    }
    @Test
    public void test_514() throws Exception {
        Point position = mouseInput.getPosition();
        assertNotNull(position);
        assertEquals(0, position.x);
        assertEquals(0, position.y);
    }
}