package net.mooctest;
import static org.junit.Assert.*;
import java.awt.Graphics2D;
import org.junit.*;
import javax.swing.JFrame;
public class Game_69_Test
{
    private Template template;
    
    @Before
    public void setUp() {
        template = new Template();
    }
    
    @After
    public void tearDown() {
        template = null;
    }
    @Test
    public void test_173() throws Exception {
        template.initialize();
    }
}