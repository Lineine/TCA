package net.mooctest;
import java.io.File;
import java.awt.image.BufferedImage;
import static org.junit.Assert.*;
import org.junit.Test;
import java.io.IOException;
import org.junit.Before;
import javax.imageio.ImageIO;
public class Game_34_Test
{
    private String validImagePath;
    private String invalidImagePath;
    @Before
    public void setUp() {
        validImagePath = "/path/to/valid/image.png";
        invalidImagePath = "/path/to/invalid/image.png";
    }
    @Test
    public void test_364() throws Exception {
        Texture2D texture = new Texture2D(validImagePath);
        texture.getImage();
    }
    @Test
    public void test_365() throws Exception {
        Texture2D texture = new Texture2D(invalidImagePath);
        assertNull(texture.getImage().toString(), "Image should not be loaded due to invalid path");
    }
    @Test
    public void test_366() throws Exception {
        BufferedImage image = Texture2D.loadBufferedImage(validImagePath);
        assertNotNull(String.valueOf(image), "BufferedImage should be loaded successfully");
    }
}