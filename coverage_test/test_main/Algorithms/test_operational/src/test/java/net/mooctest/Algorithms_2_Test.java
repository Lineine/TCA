package net.mooctest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.awt.Color;
import static org.junit.jupiter.api.Assertions.*;
public class Algorithms_2_Test
{
    private ColorContrastRatio colorContrastRatio;
    @BeforeEach
    public void setUp() {
        colorContrastRatio = new ColorContrastRatio();
    }
    @Test
    public void test_506() throws Exception {
        Color white = Color.WHITE;
        double whiteLuminance = colorContrastRatio.getRelativeLuminance(white);
        assertEquals(1.0, whiteLuminance, 0.0001);
    }
    @Test
    public void test_507() throws Exception {
        Color black = Color.BLACK;
        Color white = Color.WHITE;
        double highestColorRatio = colorContrastRatio.getContrastRatio(black, white);
        assertEquals(21.0, highestColorRatio, 0.0001);
    }
    @Test
    public void test_510() throws Exception {
        Color foreground = new Color(23, 103, 154);
        Color background = new Color(226, 229, 248);
        double contrastRatio = colorContrastRatio.getContrastRatio(foreground, background);
        assertEquals(4.878363954846178, contrastRatio, 0.0001);
    }
}