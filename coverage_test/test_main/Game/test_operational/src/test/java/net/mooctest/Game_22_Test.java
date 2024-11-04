package net.mooctest;
import java.awt.image.BufferedImage;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
public class Game_22_Test
{
    private BufferedImage testImage;
    @Before
    public void setUp() {
        testImage = ImageHelper.load("test_image.png");
    }
    @Test
    public void test_596() throws Exception {
        int newWidth = 100;
        int newHeight = 100;
        BufferedImage resizedImage = ImageHelper.resize(testImage, newWidth, newHeight);
        assertEquals(newWidth, resizedImage.getWidth());
        assertEquals(newHeight, resizedImage.getHeight());
    }
    @Test
    public void test_594() throws Exception {
        assertNotNull(testImage);
    }
    @Test
    public void test_595() throws Exception {
        BufferedImage image = ImageHelper.load("invalid_image.png");
        assertNull(image);
    }
}