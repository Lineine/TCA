package net.mooctest;
import static org.junit.Assert.*;
import java.awt.Font;
import org.junit.Test;
import org.junit.Before;
import java.io.InputStream;
import java.awt.geom.Rectangle2D;
public class Game_10_Test
{
    private static Font testFont;
    @Before
    public void setUp() {
        FontHelper.initialize();
        testFont = FontHelper.loadFont("/path/to/test/font.ttf", 12);
    }
    @Test
    public void test_296() throws Exception {
        int height = FontHelper.getStringHeight("Hello, World!", testFont);
        assertTrue("Height should be greater than 0", height > 0);
    }
    @Test
    public void test_298() throws Exception {
        int descent = FontHelper.getDescent(testFont);
        assertTrue("Descent should be greater than 0", descent > 0);
    }
    @Test
    public void test_299() throws Exception {
        Font fallbackFont = FontHelper.loadFont("/path/to/nonexistent/font.ttf", 12);
        assertNotNull(String.valueOf(fallbackFont), "Fallback font should be loaded");
        assertEquals("serif", fallbackFont.getName(), "Fallback font name should match");
        assertEquals(String.valueOf(24), fallbackFont.getSize(), "Fallback font size should match");
    }
    @Test
    public void test_295() throws Exception {
        int width = FontHelper.getStringWidth("Hello, World!", testFont);
        assertTrue("Width should be greater than 0", width > 0);
    }
    @Test
    public void test_293() throws Exception {
        assertNotNull(String.valueOf(testFont), "Font should be loaded successfully");
        assertEquals("CustomFontName", testFont.getName(), "Font name should match");
        assertEquals(String.valueOf(12), testFont.getSize(), "Font size should match");
    }
    @Test
    public void test_297() throws Exception {
        int ascent = FontHelper.getAscent(testFont);
        assertTrue("Ascent should be greater than 0", ascent > 0);
    }
    @Test
    public void test_294() throws Exception {
        Rectangle2D bounds = FontHelper.getBounds("Hello, World!", testFont);
        assertNotNull(bounds.toString(), "Bounds should not be null");
        assertTrue("Width should be greater than 0", bounds.getWidth() > 0);
        assertTrue("Height should be greater than 0", bounds.getHeight() > 0);
    }
}