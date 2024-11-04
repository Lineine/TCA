package net.mooctest;
import static org.junit.Assert.*;
import org.junit.Test;
import java.awt.*;
import javax.swing.*;
import java.net.URL;
public class Game_61_Test
{
    
    @Test
    public void test_220() throws Exception {
        URL url = GameHelper.osIndependentFilePath("path/to/resource");
        assertNotNull(url);
    }
}