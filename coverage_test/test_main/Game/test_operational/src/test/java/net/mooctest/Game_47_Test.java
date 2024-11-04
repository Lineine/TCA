package net.mooctest;
import static org.junit.Assert.*;
import org.junit.Test;
import java.awt.*;
import javax.swing.*;
import org.junit.Before;
import java.net.URL;
public class Game_47_Test
{
    @Before
    public void setup() {
        JFrame frame = new JFrame();
        frame.setSize(800, 600);
        GameHelper.setWindow(frame);
        GameHelper.setScreenWidth(800);
        GameHelper.setScreenHeight(600);
    }
    @Test
    public void test_79() throws Exception {
        String path = "image.png";
        URL url = GameHelper.osIndependentFilePath(path);
        assertNotNull(url);
        
        path = "non-existent-file.txt";
        url = GameHelper.osIndependentFilePath(path);
        assertNull(url);
    }
}