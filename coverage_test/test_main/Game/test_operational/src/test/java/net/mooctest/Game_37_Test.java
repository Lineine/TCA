package net.mooctest;
import static org.junit.Assert.*;
import java.awt.*;
import org.junit.Test;
public class Game_37_Test
{
    
    @Test
    public void test_503() throws Exception {
        Menu menu = new Menu("Test Menu", Color.RED);
        assertEquals("Test Menu", menu.LABEL);
    }
}