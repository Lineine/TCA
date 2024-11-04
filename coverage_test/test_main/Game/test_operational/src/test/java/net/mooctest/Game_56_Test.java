package net.mooctest;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;
public class Game_56_Test
{
    private MenuBar menuBar;
    @Before
    public void setUp() {
        menuBar = new MenuBar();
    }
    @Test
    public void test_579() throws Exception {
        Menu menu1 = new Menu("Menu1");
        Menu menu2 = new Menu("Menu2");
        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.initialize();
    }
    @Test
    public void test_580() throws Exception {
    }
}