package net.mooctest;
import org.junit.Test;
import java.awt.*;
import javax.swing.*;
import java.net.URL;
import static org.junit.Assert.assertEquals;
public class Game_67_Test
{
    
    @Test
    public void test_577() throws Exception {
        String imagePath = "images/test.png";
        URL expectedURL = this.getClass().getResource(imagePath);
        
        URL actualURL = GameHelper.osIndependentFilePath(imagePath);
        
        assertEquals(expectedURL, actualURL);
    }
}