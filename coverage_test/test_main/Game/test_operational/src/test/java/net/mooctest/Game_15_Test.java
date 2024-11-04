package net.mooctest;
import org.junit.Assert;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import java.awt.*;
import org.junit.Before;
import java.awt.event.KeyEvent;
import org.evosuite.shaded.org.mockito.Mockito;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
public class Game_15_Test
{
    Rectangle r1, r2, r3, r4;
    public void setup() {
        r1 = new Rectangle(10, 10, 20, 30);
        r2 = new Rectangle(20, 20, 30, 40);
        r3 = new Rectangle(5, 5, 200, 100);
        r4 = new Rectangle(r1);
    }
    @Before
    public void setUp() {
        Keyboard.keyboard = new KeyboardInput();
    }
    @Test
    public void test_111() throws Exception {
        KeyboardInput keyboardInput = Mockito.mock(KeyboardInput.class);
        Keyboard.keyboard = keyboardInput;
        Mockito.when(keyboardInput.keyDownOnce(Mockito.anyInt())).thenReturn(false);
        int keyCode = 123;
        boolean result = Keyboard.keyDownOnce(keyCode);
        
        Assert.assertFalse(result);
        Mockito.verify(keyboardInput).keyDownOnce(keyCode);
    }
    @Test
    public void test_185() throws Exception {
        Rectangle result = r1.inflate(5, 10);
        assertEquals(r3.x, result.x);
        assertEquals(r3.y, result.y);
        assertEquals(r3.width, result.width);
        assertEquals(r3.height, result.height);
    }
    @Test
    public void test_113() throws Exception {
        KeyboardInput keyboardInput = Mockito.mock(KeyboardInput.class);
        Keyboard.keyboard = keyboardInput;
        KeyEvent e = Mockito.mock(KeyEvent.class);
        
        Keyboard.keyReleased(e);
        
        Mockito.verify(keyboardInput).keyReleased(e);
    }
    @Test
    public void test_184() throws Exception {
    assertFalse(r1.equals(r2));         assertTrue(r1.equals(r4));     }
    @Test
    public void test_186() throws Exception {
        Rectangle result = r1.intersection(r2);
        assertEquals(20, result.x);
        assertEquals(20, result.y);
        assertEquals(10, result.width);
        assertEquals(10, result.height);
    }
    @Test
    public void test_188() throws Exception {
        Rectangle result = r1.offset(5, 10);
        assertEquals(r3.x, result.x);
        assertEquals(r3.y, result.y);
        assertEquals(r1.width, result.width);
        assertEquals(r1.height, result.height);
    }
    @Test
    public void test_190() throws Exception {
        Point result = Rectangle.center(r2);
        assertEquals(45, result.x);
        assertEquals(55, result.y);
    }
    @Test
    public void test_187() throws Exception {
        Rectangle r5 = new Rectangle(30, 30, 50, 50);
    assertTrue(r2.intersects(r5));         assertFalse(r3.intersects(r5));     }
    @Test
    public void test_107() throws Exception {
        Keyboard.poll();
    }
    @Test
    public void test_189() throws Exception {
        assertEquals(40, Rectangle.bottom(r2));
    }
}