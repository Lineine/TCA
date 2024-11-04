package net.mooctest;
import static org.junit.Assert.*;
import org.junit.Test;
import java.awt.*;
import org.junit.BeforeClass;
public class Game_52_Test
{
    @BeforeClass
    public static void setup() {
        Mouse.mouse = new MouseInput();
    }
    @Test
    public void test_10() throws Exception {
        Mouse.poll();
        
    }
}