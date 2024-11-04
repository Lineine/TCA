package net.mooctest;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import java.util.LinkedList;
public class Game_20_Test
{
    @Before
    public void setUp() {
        GuiToolkit.callQueue.clear();
    }
    @Test
    public void test_394() throws Exception {
        assertTrue(GuiToolkit.callQueue.isEmpty());
        assertEquals(0, GuiToolkit.callQueue.size());
    }
}