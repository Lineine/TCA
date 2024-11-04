package net.mooctest;
import static org.junit.Assert.*;
import java.awt.*;
import org.junit.Test;
public class Game_16_Test
{
    
    @Test
    public void test_505() throws Exception {
        Menu menu = new Menu("Test Menu");
        MenuItem menuItem = new MenuItem("Item");
        menu.add(menuItem);
    }
}