package net.mooctest;
import static org.junit.Assert.*;
import java.awt.*;
import org.junit.Test;
public class Game_62_Test
{
    
    @Test
    public void test_507() throws Exception {
        Menu menu = new Menu("Test Menu");
        menu.setProperties(Anchor.TOP, 0, 0, 100, 50);
        assertEquals(100, menu.getClosedWidth());
    }
}