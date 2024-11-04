package net.mooctest;
import java.awt.image.BufferedImage;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import java.awt.Toolkit;
import java.net.URL;
import java.awt.Cursor;
import javax.swing.JFrame;
public class Game_36_Test
{
    private static JFrame testFrame;
    @Before
    public void setUp() {
        testFrame = new JFrame();
        testFrame.setSize(800, 600);
        testFrame.setTitle("Test Frame");
        testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        testFrame.setVisible(true);
        GameHelper.setWindow(testFrame);
        GameHelper.setScreenWidth(800);
        GameHelper.setScreenHeight(600);
    }
    @Test
    public void test_390() throws Exception {
        URL path = GameHelper.osIndependentFilePath("/test_image.png");
        assertNotNull(String.valueOf(path), "Path should not be null");
    }
    @Test
    public void test_393() throws Exception {
        assertEquals(String.valueOf(800), GameHelper.WIDTH(), "Width should be 800");
        assertEquals(String.valueOf(600), GameHelper.HEIGHT(), "Height should be 600");
    }
    @Test
    public void test_392() throws Exception {
        GameHelper.setTitle("New Test Title");
        
        String retrievedTitle = GameHelper.getTitle();
        assertEquals("New Test Title", retrievedTitle, "Title should match the new title");
    }
    @Test
    public void test_391() throws Exception {
        BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        Cursor customCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new java.awt.Point(0, 0), "custom");
        
        GameHelper.setCursor(customCursor);
        
        Cursor retrievedCursor = GameHelper.getCursor();
        assertEquals("Cursor should match the custom cursor", customCursor, retrievedCursor);
    }
}