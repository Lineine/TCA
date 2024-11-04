package net.mooctest;
import static org.junit.Assert.*;
import org.junit.Test;
import java.awt.*;
import java.awt.event.MouseEvent;
import javax.swing.*;
public class Game_30_Test
{
    
    @Test
    public void test_40() throws Exception {
        MouseInput mouseInput = new MouseInput();
        assertEquals(new Point(0, 0), mouseInput.getPosition());
        assertFalse(mouseInput.buttonDownOnce(1));
        assertFalse(mouseInput.buttonDown(1));
    }
}