package net.mooctest;
import java.awt.image.BufferedImage;
import org.junit.Before;
import static org.evosuite.shaded.org.mockito.Mockito.when;
import java.net.URL;
import java.awt.Font;
import net.mooctest.ImageHelper;
import java.awt.event.MouseEvent;
import java.awt.Color;
import org.junit.BeforeClass;
import java.io.File;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Test;
import java.awt.Point;
import net.mooctest.Quintic;
import java.awt.geom.Rectangle2D;
import static org.evosuite.shaded.org.mockito.Mockito.mock;
import javax.imageio.ImageIO;
import static org.junit.Assert.assertEquals;
import java.io.IOException;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
public class Game_0_Test
{
    private static final float DELTA = 0.0001f;
    @Before
    public void setUp() {
        GuiToolkit.callQueue.clear();
    }
    @BeforeClass
    public static void init() {
        FontHelper.initialize();
    }
    private MouseInput mouseInput;
    @Before
    public void setup() {
        mouseInput = new MouseInput();
    }
    private String existingImagePath = "path_to_existing_image.png";
    private String nonExistingImagePath = "non_existent_image.png";
    @Test
    public void test_94() throws Exception {
        GuiToolkit guiToolkit1 = new GuiToolkit();
        GuiToolkit guiToolkit2 = new GuiToolkit();
        assertSame(guiToolkit1.callQueue, guiToolkit2.callQueue);
    }
    @Test
    public void test_463() throws Exception {
        Vector4 vec1 = new Vector4(1, 2, 3, 4);
        Vector4 vec2 = new Vector4(1, 2, 3, 4);
        assertTrue(vec1.equals(vec2));
        Vector4 vec3 = new Vector4(5, 6, 7, 8);
        assertFalse(vec1.equals(vec3));
    }
    @Test
    public void test_498() throws Exception {
        assertEquals(9.39f, Back.easeOut(2, 5, 3, 4, null), 0.01);
    }
    @Test
    public void test_249() throws Exception {
        Quaternion a = new Quaternion(1, 2, 3, 4);
        Quaternion b = new Quaternion(2, 3, 4, 5);
        Quaternion result = Quaternion.add(a, b);
        Quaternion expected = new Quaternion(3, 5, 7, 9);
        assertEquals(expected, result);
    }
    @Test
    public void test_605() throws Exception {
        float result = Sinusoidal.easeOut(3, 1, 5, 10);
    assertEquals(5.8779, result, 0.001);     }
    @Test
    public void test_272() throws Exception {
        Vector4 vec1 = new Vector4(1.0f, 2.0f, 3.0f, 4.0f);
        Vector4 vec2 = new Vector4(5.0f, 6.0f, 7.0f, 8.0f);
        float result = vec1.dotProduct(vec2);
        assertEquals(70.0f, result);
    }
    @Test
    public void test_471() throws Exception {
        Vector4 vec = new Vector4(1, 2, 3, 4);
        Vector4 result = vec.negate();
        assertEquals(-1.0f, result.x, 0.001f);
        assertEquals(-2.0f, result.y, 0.001f);
        assertEquals(-3.0f, result.z, 0.001f);
        assertEquals(-4.0f, result.w, 0.001f);
    }
    @Test
    public void test_461() throws Exception {
        Vector4 vec4 = new Vector4(1, 2, 3, 4);
        Vector2 vec2 = new Vector2(5, 6);
        float result = Vector4.dotProduct(vec4, vec2);
        assertEquals(22.0f, result, 0.001f);
    }
    @Test
    public void test_62() throws Exception {
        assertEquals(5, MathHelper.clamp(5, 0, 10));
        assertEquals(0, MathHelper.clamp(-5, 0, 10));
        assertEquals(10, MathHelper.clamp(15, 0, 10));
    }
    @Test
    public void test_4() throws Exception {
        Linear.easeNone(0.0f, 0, 10, 0.0f);
    }
    @Test
    public void test_283() throws Exception {
        assertEquals(new Color(0, 0, 0, 0), ColorHelper.transparent);
    }
    @Test
    public void test_143() throws Exception {
        float result = Cubic.easeIn(2f, 1, 2, 4);
        assertEquals(2.25, result, DELTA);
    }
    @Test
    public void test_106() throws Exception {
        TestFramework test = new TestFramework();
    }
    @Test
    public void test_47() throws Exception {
        Template template = new Template();
        template.loadContent();
    }
    @Test
    public void test_58() throws Exception {
        BufferedImage bi = new BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB);
        Texture2D texture = new Texture2D(bi);
        assertEquals(bi, texture.getImage());
    }
    @Test
    public void test_278() throws Exception {
        Color start = new Color(0, 0, 0);
        Color end = new Color(255, 255, 255);
        assertEquals(start, ColorHelper.lerp(start, end, 0.0f));
        assertEquals(end, ColorHelper.lerp(start, end, 1.0f));
    }
    @Test
    public void test_570() throws Exception {
        float result1 = Quintic.easeInOut(2, 0, 10, 5);
        assertEquals(1.6, result1, 0.001);
        
        float result2 = Quintic.easeInOut(4, 0, 10, 5);
        assertEquals(8.4, result2, 0.001);
    }
    @Test
    public void test_381() throws Exception {
        assertEquals(0, Bounce.easeIn(0, 0, 100, 1), 0.01);
        assertEquals(100, Bounce.easeIn(1, 0, 100, 1), 0.01);
        assertEquals(50, Bounce.easeIn(0.5f, 0, 100, 1), 0.01);
    }
    @Test
    public void test_26() throws Exception {
        float time = 0.5f;
        int begin = 0;
        int change = 100;
        float duration = 1.0f;
        Float overshoot = 1.70158f;
        
        float result = Back.easeIn(time, begin, change, duration, overshoot);
        assertEquals(37.5f, result, 0.01f);
        
        result = Back.easeIn(time, begin, change, duration, null);
        assertEquals(37.5f, result, 0.01f);
    }
    @Test
    public void test_256() throws Exception {
        float time = 0.5f;
        int begin = 0;
        int change = 100;
        float duration = 0.0f;
        float expected = 50;
        assertEquals(expected, Sinusoidal.easeOut(time, begin, change, duration), DELTA);
    }
    @Test
    public void test_561() throws Exception {
        assertEquals(10, MathHelper.max(5, 10));
        assertEquals(15, MathHelper.max(15, 15));
    }
    @Test
    public void test_536() throws Exception {
        assertEquals(5, Vector2.magnitude(new Vector2(3, 4)));
    }
    @Test
    public void test_535() throws Exception {
        assertEquals(Math.sqrt(8), Vector2.distance(new Vector2(1, 2), new Vector2(3, 4)));
    }
    @Test
    public void test_446() throws Exception {
        assertEquals(8.0f, Linear.easeInOut(2.0f, 4, 4, 3.0f), 0.0001f);
    }
    @Test
    public void test_400() throws Exception {
        Vector3 vec1 = new Vector3(1.0f, 2.0f, 3.0f);
        Vector3 vec2 = new Vector3(4.0f, 5.0f, 6.0f);
        float result = vec1.dotProduct(vec2);
        assertEquals(32.0f, result);
    }
    @Test
    public void test_534() throws Exception {
        assertEquals(11, Vector2.dotProduct(new Vector2(1, 2), new Vector2(3, 4)));
    }
    @Test
    public void test_209() throws Exception {
    float[] data1 = {1, 2, 3, 4};
    float[] data2 = {2, 2, 2, 2};
        Matrix a = new Matrix(data1, 2, 2);
        Matrix b = new Matrix(data2, 2, 2);
    Matrix expected = new Matrix(new float[]{3, 4, 5, 6}, 2, 2);
        assertEquals(expected, a.add(b));
    }
    @Test
    public void test_172() throws Exception {
        MouseEvent mouseEvent = mock(MouseEvent.class);
        when(mouseEvent.getButton()).thenReturn(1);
        
        mouseInput.mousePressed(mouseEvent);            mouseInput.poll();
        
        mouseInput.mouseReleased(mouseEvent);            mouseInput.poll();
        
        assert mouseInput.buttonDownOnce(1) == false;
    }
    @Test
    public void test_154() throws Exception {
        Font font = new Font("Arial", Font.PLAIN, 14);
        int ascent = FontHelper.getAscent(font);
        Assert.assertTrue(ascent > 0);
    }
    @Test
    public void test_25() throws Exception {
        float time = 1.0f;
        int begin = 0;
        int change = 10;
        float duration = 1.0f;
        
        float result = Quartic.easeInOut(time, begin, change, duration);
        assertEquals(10.0f, result, 0.01f);
    }
    @Test
    public void test_264() throws Exception {
        assertEquals(5, Linear.easeIn(0, 5, 10, 20), 0.001);
        assertEquals(10, Linear.easeIn(10, 5, 10, 20), 0.001);
        assertEquals(15, Linear.easeIn(20, 5, 10, 20), 0.001);
    }
    @Test
    public void test_35() throws Exception {
        float time = 1f;
        int begin = 0;
        int change = 10;
        float duration = 0f;
        
        Quadratic.easeInOut(time, begin, change, duration);
    }
    @Test
    public void test_425() throws Exception {
        BufferedImage originalImage = ImageHelper.load("/test_image.png");
        assertNotNull(String.valueOf(originalImage), "Image should be loaded successfully");
        
        int newWidth = 100;
        int newHeight = 100;
        BufferedImage resizedImage = ImageHelper.resize(originalImage, newWidth, newHeight);
        
        assertEquals(String.valueOf(newWidth), resizedImage.getWidth(), "Resized image width should match");
        assertEquals(String.valueOf(newHeight), resizedImage.getHeight(), "Resized image height should match");
    }
    @Test
    public void test_487() throws Exception {
        float result = Quartic.easeOut(3, 2, 5, 10);
        assertEquals(2.3625, result, 0.0001);
    }
    @Test
    public void test_0() throws Exception {
        assertEquals(0.0f, Linear.easeNone(0.0f, 0, 10, 10.0f), DELTA);
        assertEquals(5.0f, Linear.easeNone(5.0f, 0, 10, 10.0f), DELTA);
        assertEquals(10.0f, Linear.easeNone(10.0f, 0, 10, 10.0f), DELTA);
    }
    @Test
    public void test_207() throws Exception {
        assertEquals(2, MathHelper.max(1, 2));
        assertEquals(2, MathHelper.max(2, 2));
    }
    @Test
    public void test_119() throws Exception {
        float time = 0.5f;
        int begin = 10;
        int change = 20;
        float duration = 1.0f;
        float expected = 15.707106f;         float actual = Sinusoidal.easeIn(time, begin, change, duration);
        Assert.assertEquals(expected, actual, 0.001f);
        
        time = 0.0f;
        expected = 10.0f;
        actual = Sinusoidal.easeIn(time, begin, change, duration);
        Assert.assertEquals(expected, actual, 0.001f);
        
        time = 1.0f;
        expected = 30.0f;
        actual = Sinusoidal.easeIn(time, begin, change, duration);
        Assert.assertEquals(expected, actual, 0.001f);
    }
    @Test
    public void test_563() throws Exception {
        int random = MathHelper.random(10);
        assertTrue(random >= 0 && random <= 10);
    }
    @Test
    public void test_197() throws Exception {
        Texture2D texture = new Texture2D("path_to_image");
        Texture2D resizedTexture = Texture2D.resize(texture, 50, 50);
        assertNotNull(resizedTexture);
    }
    @Test
    public void test_30() throws Exception {
        float time = 1f;
        int begin = 0;
        int change = 10;
        float duration = 1f;
        
        float result = Quadratic.easeOut(time, begin, change, duration);
        assertEquals(0.0f, result, 0.01f);
    }
    @Test
    public void test_270() throws Exception {
        Vector4 vec1 = new Vector4(1.0f, 2.0f, 3.0f, 4.0f);
        Vector4 result = vec1.multiply(2.0f);
        assertEquals(2.0f, result.x);
        assertEquals(4.0f, result.y);
        assertEquals(6.0f, result.z);
        assertEquals(8.0f, result.w);
    }
    @Test
    public void test_263() throws Exception {
        assertEquals(5, Linear.easeNone(0, 5, 10, 20), 0.001);
        assertEquals(10, Linear.easeNone(10, 5, 10, 20), 0.001);
        assertEquals(15, Linear.easeNone(20, 5, 10, 20), 0.001);
    }
    @Test
    public void test_133() throws Exception {
        Color nonTransparentColor = new Color(255, 0, 0, 255);         Color expectedTransparentColor = new Color(255, 0, 0, 0);
        Color result = ColorHelper.createTransparentColor(nonTransparentColor);
        assertEquals("Colors should be equal", expectedTransparentColor, result);
    }
    @Test
    public void test_130() throws Exception {
        Color startColor = new Color(0, 0, 0, 255);         Color endColor = new Color(255, 255, 255, 255);         Color expectedColor = new Color(128, 128, 128, 255);
        Color result = ColorHelper.lerp(startColor, endColor, 0.5f);
        assertEquals("Colors should be equal", expectedColor, result);
    }
    @Test
    public void test_61() throws Exception {
        BufferedImage bi = new BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB);
        Texture2D texture = new Texture2D(bi);
        Texture2D resized = Texture2D.resize(texture, 20, 20);
        assertEquals(20, resized.getImage().getWidth());
        assertEquals(20, resized.getImage().getHeight());
        
        resized = Texture2D.resize(bi, 30, 30);
        assertEquals(30, resized.getImage().getWidth());
        assertEquals(30, resized.getImage().getHeight());
    }
    @Test
    public void test_179() throws Exception {
        assertEquals(0f, Elastic.easeInOut(0f, 0, 100, 1f, null, null), DELTA);
        
        assertEquals(100f, Elastic.easeInOut(1f, 0, 100, 1f, null, null), DELTA);
        
        assertEquals(50f, Elastic.easeInOut(0.5f, 0, 100, 1f, null, null), DELTA);
        
        assertEquals(-50f, Elastic.easeInOut(0.5f, 0, -100, 1f, null, null), DELTA);
    }
    @Test
    public void test_194() throws Exception {
        Texture2D texture = new Texture2D("path_to_image");
        assertNotNull(texture.getImage());
    }
    @Test
    public void test_397() throws Exception {
        Vector3 vec1 = new Vector3(4.0f, 5.0f, 6.0f);
        Vector3 vec2 = new Vector3(1.0f, 2.0f, 3.0f);
        Vector3 result = vec1.subtract(vec2);
        assertEquals(3.0f, result.x);
        assertEquals(3.0f, result.y);
        assertEquals(3.0f, result.z);
    }
    @Test
    public void test_484() throws Exception {
        float result = Cubic.easeInOut(2.0f, 1, 3, 4.0f);
        assertEquals(4.0f, result, 0.01);
    }
    @Test
    public void test_28() throws Exception {
        float time = 0.25f;
        int begin = 0;
        int change = 100;
        float duration = 1.0f;
        Float overshoot = 1.70158f;
        
        float result = Back.easeInOut(time, begin, change, duration, overshoot);
        assertEquals(12.5f, result, 0.01f);
        
        result = Back.easeInOut(time, begin, change, duration, null);
        assertEquals(12.5f, result, 0.01f);
        
        time = 0.75f;
        result = Back.easeInOut(time, begin, change, duration, overshoot);
        assertEquals(87.5f, result, 0.01f);
    }
    @Test
    public void test_212() throws Exception {
    float[] data1 = {2, 4, 6, 8};
        Matrix a = new Matrix(data1, 2, 2);
        assertEquals(a.divide(2), a.divide(2));
    }
    @Test
    public void test_453() throws Exception {
        Vector4 vector = new Vector4();
        assertEquals(0.0f, vector.x);
        assertEquals(0.0f, vector.y);
        assertEquals(0.0f, vector.z);
        assertEquals(0.0f, vector.w);
    }
    @Test
    public void test_260() throws Exception {
        assertEquals(5, Linear.easeIn(0, 5, 10, 10), 0.001);
        assertEquals(10, Linear.easeIn(5, 5, 10, 10), 0.001);
        assertEquals(15, Linear.easeIn(10, 5, 10, 10), 0.001);
    }
    @Test
    public void test_472() throws Exception {
        Color start = new Color(255, 0, 0, 255);
        Color end = new Color(0, 255, 0, 255);
        Color result = ColorHelper.lerp(start, end, 0.5f);
        assertEquals(new Color(127, 127, 0, 255), result);
    }
    @Test
    public void test_147() throws Exception {
        assertEquals(0.75f, Quartic.easeOut(0.5f, 0, 1, 1), 0.001f);
        
        assertEquals(15.3125f, Quartic.easeOut(3f, 10, 20, 5), 0.001f);
    }
    @Test
    public void test_603() throws Exception {
        Quaternion q = new Quaternion(1, 2, 3, 4);
        String str = q.toString();
        assertEquals("(1.0, 2.0, 3.0, 4.0)", str);
    }
    @Test
    public void test_301() throws Exception {
        assertEquals(0, Back.easeOut(0, 0, 100, 1, null), 0.0001);
        
        assertEquals(100, Back.easeOut(1, 0, 100, 1, null), 0.0001);
        
        assertEquals(72.9803, Back.easeOut(0.5f, 0, 100, 1, null), 0.0001);
        
        assertEquals(122.9803, Back.easeOut(0.5f, 50, 100, 1, 2.0f), 0.0001);
    }
    @Test
    public void test_399() throws Exception {
        Vector3 vec = new Vector3(2.0f, 4.0f, 6.0f);
        Vector3 result = vec.divide(2.0f);
        assertEquals(1.0f, result.x);
        assertEquals(2.0f, result.y);
        assertEquals(3.0f, result.z);
    }
    @Test
    public void test_552() throws Exception {
        assertEquals(5f, MathHelper.clamp(5f, 0f, 10f));
        assertEquals(0f, MathHelper.clamp(-5f, 0f, 10f));
        assertEquals(10f, MathHelper.clamp(15f, 0f, 10f));
    }
    @Test
    public void test_57() throws Exception {
        String validPath = "image.png";
        BufferedImage bi = Texture2D.loadBufferedImage(validPath);
        assertNotNull(bi);
        
        String invalidPath = "non-existent-image.png";
        bi = Texture2D.loadBufferedImage(invalidPath);
        assertNull(bi);
    }
    @Test
    public void test_305() throws Exception {
        assertEquals(0, Quadratic.easeInOut(0, 0, 100, 1), 0.0001);
        
        assertEquals(50, Quadratic.easeInOut(0.5f, 0, 100, 1), 0.0001);
        
        assertEquals(100, Quadratic.easeInOut(1, 0, 100, 1), 0.0001);
    }
    @Test
    public void test_103() throws Exception {
        float time = 2;
        int begin = 10;
        int change = 100;
        float duration = 2;
        
        float expected = 110.0f;
        float actual = Exponential.easeOut(time, begin, change, duration);
        
        assertEquals(expected, actual, 0.1);
    }
    @Test
    public void test_18() throws Exception {
        float time = 1.0f;
        int begin = 0;
        int change = 100;
        float duration = 1.0f;
        
        float result = Cubic.easeInOut(time, begin, change, duration);
        float expected = 100.0f;         assertEquals(expected, result, 0.01f);
    }
    @Test
    public void test_311() throws Exception {
        Vector2 vec1 = new Vector2(1.0f, 2.0f);
        assertEquals(1.0f, vec1.x);
        assertEquals(2.0f, vec1.y);
        
        Vector2 vec2 = new Vector2(1, 2);
        assertEquals(1.0f, vec2.x);
        assertEquals(2.0f, vec2.y);
        
        Vector2 vec3 = new Vector2(3.0f);
        assertEquals(3.0f, vec3.x);
        assertEquals(3.0f, vec3.y);
        
        Vector2 vec4 = new Vector2(3);
        assertEquals(3.0f, vec4.x);
        assertEquals(3.0f, vec4.y);
        
        Vector2 vec5 = new Vector2();
        assertEquals(0.0f, vec5.x);
        assertEquals(0.0f, vec5.y);
        
        Vector2 vec6 = new Vector2(vec1);
        assertEquals(1.0f, vec6.x);
        assertEquals(2.0f, vec6.y);
    }
    @Test
    public void test_54() throws Exception {
        float time = 0f;
        int begin = 10;
        int change = 20;
        float duration = 1f;
        float result = Elastic.easeIn(time, begin, change, duration, null, null);
        assertEquals(begin, result);
        
        time = 1f;
        result = Elastic.easeIn(time, begin, change, duration, null, null);
        assertEquals(begin + change, result);
    }
    @Test
    public void test_64() throws Exception {
    int[] a = {1, 2, 3};
    int[] b = {4, 5, 6};
        assertEquals(32, MathHelper.dotProduct(a, b));
        
        try {
        MathHelper.dotProduct(new int[] {1, 2}, b);
            fail("Expected exception: IllegalArgumentException");
        } catch (IllegalArgumentException e) {
        }
    }
    @Test
    public void test_314() throws Exception {
        Vector2 vec1 = new Vector2(1.0f, 2.0f);
        Vector2 result = vec1.multiply(2.0f);
        assertEquals(2.0f, result.x);
        assertEquals(4.0f, result.y);
        
        result = vec1.multiply(2);
        assertEquals(2.0f, result.x);
        assertEquals(4.0f, result.y);
    }
    @Test
    public void test_1() throws Exception {
        assertEquals(0.0f, Linear.easeIn(0.0f, 0, 10, 10.0f), DELTA);
        assertEquals(5.0f, Linear.easeIn(5.0f, 0, 10, 10.0f), DELTA);
        assertEquals(10.0f, Linear.easeIn(10.0f, 0, 10, 10.0f), DELTA);
    }
    @Test
    public void test_585() throws Exception {
        Vector3 vector1 = new Vector3(2.0f, 3.0f, 4.0f);
        Vector3 vector2 = new Vector3(5.0f, 6.0f, 7.0f);
        
        float dotProduct1 = Vector3.dotProduct(vector1, vector2);
        assertEquals(56.0f, dotProduct1, 0.0f);
        
        float dotProduct2 = vector1.dotProduct(vector2);
        assertEquals(56.0f, dotProduct2, 0.0f);
    }
    @Test
    public void test_345() throws Exception {
        assertEquals(0, Elastic.easeOut(0, 0, 100, 1, null, null), 0.001);
        assertEquals(100, Elastic.easeOut(1, 0, 100, 1, null, null), 0.001);
        assertEquals(50, Elastic.easeOut(0.5f, 0, 100, 1, null, null), 0.001);
    }
    @Test
    public void test_584() throws Exception {
        Vector3 vector1 = new Vector3(3.0f, 4.0f, 12.0f);
        
        float magnitude1 = Vector3.magnitude(vector1);
        assertEquals(13.0f, magnitude1, 0.0f);
        
        float magnitude2 = vector1.magnitude();
        assertEquals(13.0f, magnitude2, 0.0f);
    }
    @Test
    public void test_59() throws Exception {
        BufferedImage bi = new BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB);
        Texture2D texture = new Texture2D(bi);
        BufferedImage newBi = new BufferedImage(20, 20, BufferedImage.TYPE_INT_ARGB);
        texture.setImage(newBi);
        assertEquals(newBi, texture.getImage());
    }
    @Test
    public void test_502() throws Exception {
        float result1 = Quadratic.easeInOut(4, 1, 3, 8);
        assertEquals(3.0, result1, 0.001);
        
        float result2 = Quadratic.easeInOut(6, 2, 5, 9);
        assertEquals(4.166, result2, 0.001);
    }
    @Test
    public void test_32() throws Exception {
        float time = 1f;
        int begin = 0;
        int change = 10;
        float duration = 1f;
        
        float result = Quadratic.easeInOut(time, begin, change, duration);
        assertEquals(10.0f, result, 0.01f);
    }
    @Test
    public void test_151() throws Exception {
        Font font = new Font("Arial", Font.PLAIN, 14);
        String text = "Hello, World!";
        int width = FontHelper.getStringWidth(text, font);
        Assert.assertTrue(width > 0);
    }
    @Test
    public void test_14() throws Exception {
        assertEquals(0.0f, Circular.easeInOut(0.0f, 0, 100, 1.0f), 0.01f);
        assertEquals(25.0f, Circular.easeInOut(0.25f, 0, 100, 1.0f), 0.01f);
        assertEquals(75.0f, Circular.easeInOut(0.75f, 0, 100, 1.0f), 0.01f);
        assertEquals(100.0f, Circular.easeInOut(1.0f, 0, 100, 1.0f), 0.01f);
        assertEquals(10.0f, Circular.easeInOut(0.0f, 10, 20, 2.0f), 0.01f);
        assertEquals(22.5f, Circular.easeInOut(0.5f, 10, 20, 2.0f), 0.01f);
    }
    @Test
    public void test_351() throws Exception {
        MathPad.vector3Test();
    }
    @Test
    public void test_75() throws Exception {
        float time = 0.25f;
        int begin = 10;
        int change = 20;
        float duration = 1.0f;
        
        float result = Bounce.easeInOut(time, begin, change, duration);
        assertEquals(15.46875f, result, 0.01f);
        time = 0.75f;
        result = Bounce.easeInOut(time, begin, change, duration);
    assertEquals(24.53125f, result, 0.01f);     }
    @Test
    public void test_3() throws Exception {
        assertEquals(0.0f, Linear.easeInOut(0.0f, 0, 10, 10.0f), DELTA);
        assertEquals(5.0f, Linear.easeInOut(5.0f, 0, 10, 10.0f), DELTA);
        assertEquals(10.0f, Linear.easeInOut(10.0f, 0, 10, 10.0f), DELTA);
    }
    @Test
    public void test_325() throws Exception {
        Vector2 vec = new Vector2(2.0f, 3.0f);
        Vector2 min = new Vector2(1.0f, 1.0f);
        Vector2 max = new Vector2(4.0f, 4.0f);
        Vector2 result = vec.clamp(min, max);
        assertEquals(2.0f, result.x);
        assertEquals(3.0f, result.y);
        
        vec = new Vector2(0.5f, 5.0f);
        result = vec.clamp(min, max);
        assertEquals(1.0f, result.x);
        assertEquals(4.0f, result.y);
    }
    @Test
    public void test_379() throws Exception {
        assertEquals(0, Quintic.easeOut(0, 0, 100, 1), 0.0001);
        
        assertEquals(100, Quintic.easeOut(1, 0, 100, 1), 0.0001);
        
        assertEquals(100 * ((0.5 - 1) * (0.5 - 1) * (0.5 - 1) * (0.5 - 1) * (0.5 - 1) + 1), Quintic.easeOut(0.5F, 0, 100, 1), 0.0001);
    }
    @Test
    public void test_266() throws Exception {
        assertEquals(5, Linear.easeInOut(0, 5, 10, 20), 0.001);
        assertEquals(10, Linear.easeInOut(10, 5, 10, 20), 0.001);
        assertEquals(15, Linear.easeInOut(20, 5, 10, 20), 0.001);
    }
    @Test
    public void test_528() throws Exception {
        float result = Elastic.easeOut(0.5f, 0, 100, 1.0f, null, null);
        assertEquals("EaseOut calculation is incorrect", 50.0f, result, 0.001f);
        
        result = Elastic.easeOut(0.25f, 0, 100, 1.0f, 50.0f, 0.3f);
        assertEquals("EaseOut calculation with amplitude and period is incorrect", 87.5f, result, 0.001f);
    }
    @Test
    public void test_500() throws Exception {
        float result = Quadratic.easeIn(2, 1, 3, 5);
        assertEquals(2.4, result, 0.001);
    }
    @Test
    public void test_555() throws Exception {
    float[] a = {1.1f, 2.2f, 3.3f};
    float[] b = {4.4f, 5.5f, 6.6f};
        assertEquals(38.72f, MathHelper.dotProduct(a, b));
    }
    @Test
    public void test_601() throws Exception {
        Quaternion q1 = new Quaternion(1, 2, 3, 4);
        Quaternion q2 = new Quaternion(2, 3, 4, 5);
        Quaternion result1 = Quaternion.multiply(q1, q2);
        assertEquals(new Quaternion(2, 6, 12, 20), result1);
        
        float scalar = 2;
        Quaternion result2 = Quaternion.multiply(q1, scalar);
        assertEquals(new Quaternion(2, 4, 6, 8), result2);
    }
    @Test
    public void test_60() throws Exception {
        String path = "image.png";
        Texture2D texture = new Texture2D(path);
        assertEquals(path, texture.getPath());
    }
    @Test
    public void test_591() throws Exception {
    float[] data = {1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f};
        Matrix3 matrix = new Matrix3(data);
        assertEquals(1.0f, matrix.M11);
        assertEquals(5.0f, matrix.M22);
        assertEquals(9.0f, matrix.M33);
    }
    @Test
    public void test_329() throws Exception {
        Vector2 vec1 = new Vector2(1.0f, 2.0f);
        Vector2 vec2 = new Vector2(3.0f, 4.0f);
        Vector2 result = vec1.lerp(vec2, 0.5f);
        assertEquals(2.0f, result.x);
        assertEquals(3.0f, result.y);
    }
    @Test
    public void test_116() throws Exception {
        String imagePath = "path/to/non/existent/image.png";
        File imageFile = new File(imagePath);
        assertTrue(!imageFile.exists());
        
        BufferedImage image = ImageHelper.load(imagePath);
        
        assertNull(image);
    }
    @Test
    public void test_541() throws Exception {
        Rectangle rect1 = new Rectangle(10, 10, 20, 20);
        Rectangle inflatedRect = Rectangle.inflate(rect1, 5, 5);
        assertEquals(15, inflatedRect.x);
        assertEquals(15, inflatedRect.y);
        assertEquals(25, inflatedRect.width);
        assertEquals(25, inflatedRect.height);
    }
    @Test
    public void test_442() throws Exception {
        assertEquals(0, Sinusoidal.easeInOut(0, 0, 100, 1), 0.001);
        
        assertEquals(50, Sinusoidal.easeInOut(0.5f, 0, 100, 1), 0.001);
        
        assertEquals(100, Sinusoidal.easeInOut(1, 0, 100, 1), 0.001);
    }
    @Test
    public void test_140() throws Exception {
        float result = Circular.easeIn(0f, 0, 100, 1f);
        assertEquals(0f, result, DELTA);
        
        result = Circular.easeIn(0.5f, 0, 100, 1f);
        assertEquals(29.629629f, result, DELTA);
        result = Circular.easeIn(1f, 0, 100, 1f);
        assertEquals(100f, result, DELTA);
    }
    @Test
    public void test_557() throws Exception {
        assertEquals(0.0f, MathHelper.smoothStep(0f, 1f, 0f));
        assertEquals(1.0f, MathHelper.smoothStep(0f, 1f, 1f));
        assertEquals(0.5f, MathHelper.smoothStep(0f, 1f, 0.5f));
    }
    @Test
    public void test_246() throws Exception {
        BufferedImage image = ImageHelper.load(nonExistingImagePath);
        assertNull(String.valueOf(image), "Expected image to be null for non-existent path");
    }
    @Test
    public void test_37() throws Exception {
        GameTime gameTime = new GameTime();
        gameTime.reset();
        gameTime.start();
        long startTime = System.currentTimeMillis();
        TimeUnit.SECONDS.sleep(2);         assertEquals(2000, gameTime.getGameTime(), 50);
        TimeUnit.SECONDS.sleep(1);         assertEquals(3000, gameTime.getGameTime(), 50);
    }
    @Test
    public void test_238() throws Exception {
        assertEquals(1.0f, Exponential.easeInOut(0, 0, 1, 1), DELTA);
        assertEquals(2.0f, Exponential.easeInOut(1, 0, 1, 1), DELTA);
        assertEquals(1.4773318f, Exponential.easeInOut(0.5f, 0, 1, 1), DELTA);
    }
    @Test
    public void test_569() throws Exception {
        float result = Quintic.easeOut(3, 0, 10, 5);
        assertEquals(8.8, result, 0.001);
    }
    @Test
    public void test_349() throws Exception {
        assertEquals(0, Elastic.easeInOut(0, 0, 100, 1, 50f, 0.5f), 0.001);
        assertEquals(100, Elastic.easeInOut(1, 0, 100, 1, 50f, 0.5f), 0.001);
        assertEquals(50, Elastic.easeInOut(0.5f, 0, 100, 1, 50f, 0.5f), 0.001);
    }
    @Test
    public void test_273() throws Exception {
        Vector4 vec1 = new Vector4(1.0f, 2.0f, 3.0f, 4.0f);
        float result = vec1.magnitude();
        assertEquals((float) Math.sqrt(30), result);
    }
    @Test
    public void test_2() throws Exception {
        assertEquals(0.0f, Linear.easeOut(0.0f, 0, 10, 10.0f), DELTA);
        assertEquals(5.0f, Linear.easeOut(5.0f, 0, 10, 10.0f), DELTA);
        assertEquals(10.0f, Linear.easeOut(10.0f, 0, 10, 10.0f), DELTA);
    }
    @Test
    public void test_599() throws Exception {
        Quaternion q = new Quaternion(1, 2, 3, 4);
        Quaternion result = Quaternion.conjugate(q);
        assertEquals(new Quaternion(-1, -2, -3, 4), result);
    }
    @Test
    public void test_248() throws Exception {
        Quaternion quaternion = new Quaternion(1, 2, 3, 4);
        assertNotNull(quaternion);
        
        Vector3 v = new Vector3(1, 2, 3);
        Quaternion quaternion2 = new Quaternion(v, 4);
        assertNotNull(quaternion2);
    }
    @Test
    public void test_455() throws Exception {
        Vector4 a = new Vector4(1.0f, 2.0f, 3.0f, 4.0f);
        Vector4 b = new Vector4(4.0f, 3.0f, 2.0f, 1.0f);
        Vector4 result = a.add(b);
        assertEquals(5.0f, result.x);
        assertEquals(5.0f, result.y);
        assertEquals(5.0f, result.z);
        assertEquals(5.0f, result.w);
    }
    @Test
    public void test_52() throws Exception {
        float time = 0.5f;
        int begin = 10;
        int change = 20;
        float duration = 1f;
        float result = Elastic.easeInOut(time, begin, change, duration, null, null);
        assertNotNull(result);
        assertTrue(result >= begin && result <= begin + change);
    }
    @Test
    public void test_587() throws Exception {
        assertEquals(10.0f, Exponential.easeOut(0, 10, 20, 5));
        assertEquals(30.0f, Exponential.easeOut(1, 10, 20, 5));
        assertEquals(50.0f, Exponential.easeOut(2, 10, 20, 5));
        assertEquals(70.0f, Exponential.easeOut(3, 10, 20, 5));
    }
    @Test
    public void test_473() throws Exception {
        Color start = new Color(255, 0, 0, 255);
        Color end = new Color(0, 255, 0, 255);
        Color result = ColorHelper.smoothStep(start, end, 0.5f);
        assertEquals(new Color(127, 127, 0, 255), result);
    }
    @Test
    public void test_395() throws Exception {
        Vector3 vec = new Vector3(1.0f, 2.0f, 3.0f);
        assertEquals(1.0f, vec.x);
        assertEquals(2.0f, vec.y);
        assertEquals(3.0f, vec.z);
    }
    @Test
    public void test_480() throws Exception {
        assertEquals(30.0f, Circular.easeOut(0.5f, 0, 100, 1), 0.001);
        assertEquals(5.0f, Circular.easeOut(0.1f, 0, 20, 1), 0.001);
    }
    @Test
    public void test_285() throws Exception {
        assertEquals(0, Circular.easeOut(0, 0, 100, 1), 0.0001);
        
        assertEquals(70.7107, Circular.easeOut(0.5f, 0, 100, 1), 0.0001);
        
        assertEquals(100, Circular.easeOut(1, 0, 100, 1), 0.0001);
    }
    @Test
    public void test_131() throws Exception {
        Color startColor = new Color(0, 0, 0, 255);         Color endColor = new Color(255, 255, 255, 255);         Color expectedColor = new Color(128, 128, 128, 255);
        Color result = ColorHelper.smoothStep(startColor, endColor, 0.5f);
        assertNotEquals("smoothStep should not return the exact halfway color", expectedColor, result);
    }
    @Test
    public void test_205() throws Exception {
        assertEquals(1, MathHelper.min(1, 2));
        assertEquals(2, MathHelper.min(2, 2));
    }
    @Test
    public void test_324() throws Exception {
        Vector2 p0 = new Vector2(0.0f, 0.0f);
        Vector2 p1 = new Vector2(1.0f, 1.0f);
        Vector2 p2 = new Vector2(2.0f, 2.0f);
        Vector2 p3 = new Vector2(3.0f, 3.0f);
        Vector2 result = Vector2.catmullRom(p0, p1, p2, p3, 0.5f);
        assertEquals(1.5f, result.x);
        assertEquals(1.5f, result.y);
    }
    @Test
    public void test_141() throws Exception {
        float result = Circular.easeOut(0f, 0, 100, 1f);
        assertEquals(0f, result, DELTA);
        
        result = Circular.easeOut(0.5f, 0, 100, 1f);
        assertEquals(60.75647f, result, DELTA);
        result = Circular.easeOut(1f, 0, 100, 1f);
        assertEquals(100f, result, DELTA);
    }
    @Test
    public void test_320() throws Exception {
        Vector2 vec1 = new Vector2(1.0f, 2.0f);
        Vector2 vec2 = new Vector2(1.0f, 2.0f);
        assertEquals(vec1.hashCode(), vec2.hashCode());
    }
    @Test
    public void test_289() throws Exception {
        assertEquals(0, Cubic.easeInOut(0, 0, 100, 1), 0.0001);
        
        assertEquals(50, Cubic.easeInOut(0.5f, 0, 100, 1), 0.0001);
        
        assertEquals(100, Cubic.easeInOut(1, 0, 100, 1), 0.0001);
    }
    @Test
    public void test_178() throws Exception {
        assertEquals(0f, Elastic.easeOut(0f, 0, 100, 1f, null, null), DELTA);
        
        assertEquals(100f, Elastic.easeOut(1f, 0, 100, 1f, null, null), DELTA);
        
        assertEquals(50f, Elastic.easeOut(0.5f, 0, 100, 1f, null, null), DELTA);
        
        assertEquals(-50f, Elastic.easeOut(0.5f, 0, -100, 1f, null, null), DELTA);
    }
    @Test
    public void test_319() throws Exception {
        Vector2 vec1 = new Vector2(1.0f, 2.0f);
        Vector2 vec2 = new Vector2(1.0f, 2.0f);
        Vector2 vec3 = new Vector2(3.0f, 4.0f);
        assertTrue(vec1.equals(vec2));
        assertFalse(vec1.equals(vec3));
    }
    @Test
    public void test_171() throws Exception {
        MouseEvent mouseEvent = mock(MouseEvent.class);
        when(mouseEvent.getPoint()).thenReturn(new Point(10, 20));
        
        mouseInput.mouseMoved(mouseEvent);
        
        assert mouseInput.getPosition().equals(new Point(10, 20));
    }
    @Test
    public void test_156() throws Exception {
        float time = 2f;
        int begin = 10;
        int change = 50;
        float duration = 20f;
        Float overshoot = 1.70158f;
        
        float expectedResult = 20f;
        
        float actualResult = Back.easeIn(time, begin, change, duration, overshoot);
        
        assertEquals(expectedResult, actualResult, 0.1);
    }
    @Test
    public void test_547() throws Exception {
        Texture2D texture = new Texture2D("invalid/path/image.png");
        assertNull(texture.getImage());
    }
    @Test
    public void test_66() throws Exception {
        int min = 0;
        int max = 10;
        int result = MathHelper.random(min, max);
        assertTrue(result >= min && result <= max);
    }
    @Test
    public void test_284() throws Exception {
        assertEquals(0, Circular.easeIn(0, 0, 100, 1), 0.0001);
        
        assertEquals(29.2893, Circular.easeIn(0.5f, 0, 100, 1), 0.0001);
        
        assertEquals(100, Circular.easeIn(1, 0, 100, 1), 0.0001);
    }
    @Test
    public void test_465() throws Exception {
        Vector4 vec = new Vector4(1, 2, 3, 4);
        Vector4 normalized = vec.normalize();
        assertEquals(0.182f, normalized.x, 0.001f);
        assertEquals(0.365f, normalized.y, 0.001f);
        assertEquals(0.547f, normalized.z, 0.001f);
        assertEquals(0.730f, normalized.w, 0.001f);
    }
    @Test
    public void test_355() throws Exception {
        for (int i = 0; i < 1000; i++) {
            Vector2 randomVector = Vector2.random();
            float magnitude = Vector2.magnitude(randomVector);
            assertTrue(magnitude >= 0.0f && magnitude <= 1.0f);
        }
    }
    @Test
    public void test_332() throws Exception {
        Vector2 vec1 = new Vector2(1.0f, 2.0f);
        Vector2 result = vec1.perpendicular();
        assertEquals(-2.0f, result.x);
        assertEquals(1.0f, result.y);
    }
    @Test
    public void test_198() throws Exception {
        assertEquals(1.0f, MathHelper.clamp(1.0f, 1.0f, 5.0f), DELTA);
        assertEquals(5.0f, MathHelper.clamp(10.0f, 1.0f, 5.0f), DELTA);
        assertEquals(1.0f, MathHelper.clamp(0.5f, 1.0f, 5.0f), DELTA);
    }
    @Test
    public void test_333() throws Exception {
        Vector2 vec1 = new Vector2(1.0f, 2.0f);
        Vector2 vec2 = new Vector2(3.0f, 4.0f);
        float scalarProjection = vec1.scalarProjection(vec2);
        Vector2 vectorProjection = vec1.vectorProjection(vec2);
        assertEquals(11.0f / 5.0f, scalarProjection);
        assertEquals(3.3f, vectorProjection.x, 0.0001);
        assertEquals(4.4f, vectorProjection.y, 0.0001);
    }
    @Test
    public void test_183() throws Exception {
    }
    @Test
    public void test_269() throws Exception {
        Vector4 vec1 = new Vector4(5.0f, 6.0f, 7.0f, 8.0f);
        Vector4 vec2 = new Vector4(1.0f, 2.0f, 3.0f, 4.0f);
        Vector4 result = vec1.subtract(vec2);
        assertEquals(4.0f, result.x);
        assertEquals(4.0f, result.y);
        assertEquals(4.0f, result.z);
        assertEquals(4.0f, result.w);
    }
    @Test
    public void test_588() throws Exception {
        assertEquals(10.0f, Exponential.easeInOut(0, 10, 20, 5));
        assertEquals(15.0f, Exponential.easeInOut(1, 10, 20, 5));
        assertEquals(35.0f, Exponential.easeInOut(2.5f, 10, 20, 5));
        assertEquals(30.0f, Exponential.easeInOut(3, 10, 20, 5));
        assertEquals(30.0f, Exponential.easeInOut(5, 10, 20, 5));
    }
    @Test
    public void test_560() throws Exception {
        assertEquals(10f, MathHelper.max(5f, 10f));
        assertEquals(15f, MathHelper.max(15f, 15f));
    }
    @Test
    public void test_335() throws Exception {
        Vector2 vec1 = new Vector2(1.0f, 2.0f);
        Vector2 vec2 = new Vector2(3.0f, 4.0f);
        Vector2 result = Vector2.smoothStep(vec1, vec2, 0.5f);
        assertEquals(2.0f, result.x);
        assertEquals(3.0f, result.y);
    }
    @Test
    public void test_302() throws Exception {
        assertEquals(0, Back.easeInOut(0, 0, 100, 1, null), 0.0001);
        
        assertEquals(100, Back.easeInOut(1, 0, 100, 1, null), 0.0001);
        
        assertEquals(50, Back.easeInOut(0.5f, 0, 100, 1, null), 0.0001);
        
        assertEquals(100, Back.easeInOut(0.5f, 50, 100, 1, 2.0f), 0.0001);
    }
    @Test
    public void test_586() throws Exception {
        assertEquals(10.0f, Exponential.easeIn(0, 10, 20, 5));
        assertEquals(30.0f, Exponential.easeIn(1, 10, 20, 5));
        assertEquals(50.0f, Exponential.easeIn(2, 10, 20, 5));
        assertEquals(70.0f, Exponential.easeIn(3, 10, 20, 5));
    }
    @Test
    public void test_122() throws Exception {
        float time = 5;
        int begin = 0;
        int change = 10;
        float duration = 10;
        
        float result = Linear.easeNone(time, begin, change, duration);
        
    }
    @Test
    public void test_128() throws Exception {
        Vector4 vec1 = new Vector4(8, 10, 12, 14);
        Vector4 vec2 = new Vector4(4, 6, 8, 10);
        Vector4 result = Vector4.subtract(vec1, vec2);
        assertEquals(4, result.x);
        assertEquals(4, result.y);
        assertEquals(4, result.z);
        assertEquals(4, result.w);
    }
    @Test
    public void test_380() throws Exception {
        assertEquals(0, Quintic.easeInOut(0, 0, 100, 1), 0.0001);
        
        assertEquals(100, Quintic.easeInOut(1, 0, 100, 1), 0.0001);
        
        assertEquals(100 / 2 * 0.5 * 0.5 * 0.5 * 0.5 * 0.5 + 0, Quintic.easeInOut(0.5F, 0, 100, 1), 0.0001);
        
        assertEquals(100 / 2 * ((0.75 * 2 - 2) * (0.75 * 2 - 2) * (0.75 * 2 - 2) * (0.75 * 2 - 2) * (0.75 * 2 - 2) + 2), Quintic.easeInOut(0.75F, 0, 100, 1), 0.0001);
    }
    @Test
    public void test_149() throws Exception {
        Font font = FontHelper.loadFont("/path/to/your/fontfile.ttf", 14f);
        Assert.assertNotNull(font);
    }
    @Test
    public void test_265() throws Exception {
        assertEquals(5, Linear.easeOut(0, 5, 10, 20), 0.001);
        assertEquals(10, Linear.easeOut(10, 5, 10, 20), 0.001);
        assertEquals(15, Linear.easeOut(20, 5, 10, 20), 0.001);
    }
    @Test
    public void test_327() throws Exception {
        Vector2 vec1 = new Vector2(1.0f, 2.0f);
        Vector2 vec2 = new Vector2(4.0f, 6.0f);
        assertEquals(5.0f, vec1.distance(vec2));
    }
    @Test
    public void test_304() throws Exception {
        assertEquals(0, Quadratic.easeOut(0, 0, 100, 1), 0.0001);
        
        assertEquals(75, Quadratic.easeOut(0.5f, 0, 100, 1), 0.0001);
        
        assertEquals(100, Quadratic.easeOut(1, 0, 100, 1), 0.0001);
    }
    @Test
    public void test_565() throws Exception {
    float[] data = {1.0f, 2.0f, 3.0f, 4.0f};
        int rows = 2;
        int columns = 2;
        Matrix matrix = new Matrix(data, rows, columns);
        
        assertNotNull(matrix);
        assertArrayEquals(data, matrix.data, 0.0f);
        assertEquals(rows, matrix.ROWS);
        assertEquals(columns, matrix.COLUMNS);
    }
    @Test
    public void test_247() throws Exception {
        BufferedImage originalImage = ImageHelper.load(existingImagePath);
        assertNotNull(String.valueOf(originalImage), "Original Image should not be null");
        
        int newWidth = 100;
        int newHeight = 100;
        BufferedImage resizedImage = ImageHelper.resize(originalImage, newWidth, newHeight);
        
        assertNotNull(String.valueOf(resizedImage), "Resized Image should not be null");
        assertEquals(String.valueOf(newWidth), resizedImage.getWidth(), "Width does not match");
        assertEquals(String.valueOf(newHeight), resizedImage.getHeight(), "Height does not match");
    }
    @Test
    public void test_558() throws Exception {
        assertEquals(5f, MathHelper.min(5f, 10f));
        assertEquals(10f, MathHelper.min(15f, 10f));
    }
    @Test
    public void test_124() throws Exception {
        float time = 5;
        int begin = 0;
        int change = 10;
        float duration = 10;
        
        float result = Linear.easeOut(time, begin, change, duration);
    }
    @Test
    public void test_330() throws Exception {
        Vector2 vec1 = new Vector2(1.0f, 2.0f);
        Vector2 vec2 = new Vector2(3.0f, 1.0f);
        Vector2 max = Vector2.max(vec1, vec2);
        Vector2 min = Vector2.min(vec1, vec2);
        assertEquals(3.0f, max.x);
        assertEquals(2.0f, max.y);
        assertEquals(1.0f, min.x);
        assertEquals(1.0f, min.y);
    }
    @Test
    public void test_161() throws Exception {
        float result = Quadratic.easeInOut(0, 0, 1, 1);
        assertEquals(0, result, 0.1);
        
        result = Quadratic.easeInOut(1, 0, 1, 1);
        assertEquals(1, result, 0.1);
        
    }
    @Test
    public void test_540() throws Exception {
        Rectangle rect1 = new Rectangle(10, 10, 20, 20);
        Rectangle rect2 = new Rectangle(5, 5, 30, 30);
        assertFalse(rect1.equals(rect2));
    }
    @Test
    public void test_572() throws Exception {
        float result = Bounce.easeOut(1.0f, 0, 10, 4.0f);
        assertEquals(2.5f, result, 0.0f);
    }
    @Test
    public void test_92() throws Exception {
        assertEquals(0, GuiToolkit.callQueue.size());
    }
    @Test
    public void test_571() throws Exception {
        float result = Bounce.easeIn(2.0f, 0, 10, 4.0f);
        assertEquals(6.25f, result, 0.0f);
    }
    @Test
    public void test_318() throws Exception {
        Vector2 vec1 = new Vector2(1.0f, 2.0f);
        Vector2 vec2 = new Vector2(3.0f, 4.0f);
        assertEquals(11.0f, vec1.dotProduct(vec2));
    }
    @Test
    public void test_193() throws Exception {
        Texture2D texture = new Texture2D("path_to_image");
        assertEquals("path_to_image", texture.getPath());
    }
    @Test
    public void test_39() throws Exception {
        GameTime gameTime = new GameTime();
        gameTime.reset();
        gameTime.start();
        long startTime = System.currentTimeMillis();
        TimeUnit.SECONDS.sleep(2);         gameTime.reset();
        assertEquals(0.0f, gameTime.getGameTime(), 0.0f);
    }
    @Test
    public void test_567() throws Exception {
    float[] dataA = {1.0f, 2.0f, 3.0f, 4.0f};
    float[] dataB = {2.0f, 3.0f, 4.0f, 5.0f};
        int rows = 2;
        int columns = 2;
        Matrix matrixA = new Matrix(dataA, rows, columns);
        Matrix matrixB = new Matrix(dataB, rows, columns);
        
        Matrix result = Matrix.add(matrixA, matrixB);
        
        assertNotNull(result);
    float[] expectedData = {3.0f, 5.0f, 7.0f, 9.0f};
        assertArrayEquals(expectedData, result.data, 0.0f);
    }
    @Test
    public void test_542() throws Exception {
        Rectangle rect1 = new Rectangle(10, 10, 20, 20);
        Rectangle rect2 = new Rectangle(15, 15, 20, 20);
        Rectangle intersectionRect = rect1.intersection(rect2);
        assertEquals(15, intersectionRect.x);
        assertEquals(15, intersectionRect.y);
        assertEquals(15, intersectionRect.width);
        assertEquals(15, intersectionRect.height);
    }
    @Test
    public void test_118() throws Exception {
        ImageHelper.resize(null, 100, 100);
    }
    @Test
    public void test_255() throws Exception {
        float time = 0.0f;
        int begin = 0;
        int change = 100;
        float duration = 1.0f;
        float expected = 0;
        assertEquals(expected, Sinusoidal.easeOut(time, begin, change, duration), DELTA);
    }
    @Test
    public void test_214() throws Exception {
        float result = Quintic.easeIn(0, 0, 100, 1);
        assertEquals("Result should be 0", 0, result, 0);
        
        result = Quintic.easeIn(0.5f, 0, 100, 1);
        assertEquals("Result should be 15.625", 15.625, result, 0.001);
        
        result = Quintic.easeIn(1, 0, 100, 1);
        assertEquals("Result should be 100", 100, result, 0);
    }
    @Test
    public void test_204() throws Exception {
        assertEquals(1.0f, MathHelper.min(1.0f, 2.0f), DELTA);
        assertEquals(2.0f, MathHelper.min(2.0f, 2.0f), DELTA);
    }
    @Test
    public void test_105() throws Exception {
        TestFramework test = new TestFramework();
    }
    @Test
    public void test_423() throws Exception {
        BufferedImage image = ImageHelper.load("/test_image.png");
        assertNotNull(String.valueOf(image), "Image should be loaded successfully");
    }
    @Test
    public void test_470() throws Exception {
        Vector4 vec1 = new Vector4(5, 6, 7, 8);
        Vector4 vec2 = new Vector4(1, 2, 3, 4);
        Vector4 result = vec1.subtract(vec2);
        assertEquals(4.0f, result.x, 0.001f);
        assertEquals(4.0f, result.y, 0.001f);
        assertEquals(4.0f, result.z, 0.001f);
        assertEquals(4.0f, result.w, 0.001f);
    }
    @Test
    public void test_132() throws Exception {
        Color randomColorOne = ColorHelper.randomColor();
        Color randomColorTwo = ColorHelper.randomColor();
        
        assertNotEquals("Random colors should not be equal", randomColorOne, randomColorTwo);
    }
    @Test
    public void test_51() throws Exception {
        float time = 0.5f;
        int begin = 10;
        int change = 20;
        float duration = 1f;
        float amplitude = 30f;
        float period = 0.5f;
        float result = Elastic.easeOut(time, begin, change, duration, amplitude, period);
        assertNotNull(result);
        assertTrue(result >= begin && result <= begin + change);
    }
    @Test
    public void test_474() throws Exception {
        Color result = ColorHelper.randomColor();
        assert(result != null);
    }
    @Test
    public void test_115() throws Exception {
        String imagePath = "path/to/exists/image.png";
        File imageFile = new File(imagePath);
        assertTrue(imageFile.exists());
        
        BufferedImage image = ImageHelper.load(imagePath);
        
        assertNotNull(image);
    }
    @Test
    public void test_315() throws Exception {
        Vector2 vec1 = new Vector2(1.0f, 2.0f);
        Vector2 result = vec1.divide(2.0f);
        assertEquals(0.5f, result.x);
        assertEquals(1.0f, result.y);
        
        result = vec1.divide(2);
        assertEquals(0.5f, result.x);
        assertEquals(1.0f, result.y);
        
        Vector2 vec2 = new Vector2(4.0f, 6.0f);
        result = vec2.divide(vec1);
        assertEquals(4.0f, result.x);
        assertEquals(3.0f, result.y);
    }
    @Test
    public void test_460() throws Exception {
        Vector4 vec4 = new Vector4(1, 2, 3, 4);
        Vector3 vec3 = new Vector3(5, 6, 7);
        float result = Vector4.dotProduct(vec4, vec3);
        assertEquals(38.0f, result, 0.001f);
    }
    @Test
    public void test_170() throws Exception {
        MouseEvent mouseEvent = mock(MouseEvent.class);
        when(mouseEvent.getButton()).thenReturn(2);
        
        mouseInput.mouseReleased(mouseEvent);
        
        assert mouseInput.buttonDownOnce(2) == false;
    }
    @Test
    public void test_68() throws Exception {
        int result = MathHelper.random();
        assertTrue(result >= 0 && result <= Integer.MAX_VALUE);
    }
    @Test
    public void test_93() throws Exception {
        assertTrue(GuiToolkit.callQueue instanceof LinkedList);
    }
    @Test
    public void test_545() throws Exception {
        Rectangle rect1 = new Rectangle(10, 10, 20, 20);
        Rectangle offsetRect = rect1.offset(5, 5);
        assertEquals(5, offsetRect.x);
        assertEquals(5, offsetRect.y);
        assertEquals(20, offsetRect.width);
        assertEquals(20, offsetRect.height);
    }
    @Test
    public void test_242() throws Exception {
        Matrix3 a = new Matrix3(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Matrix3 b = new Matrix3(9, 8, 7, 6, 5, 4, 3, 2, 1);
        Matrix3 expected = new Matrix3(30, 24, 18, 84, 69, 54, 138, 114, 90);
        
        assertEquals(expected, a.multiply(b));
    }
    @Test
    public void test_72() throws Exception {
        float time = 0.0f;
        int begin = 0;
        int change = 100;
        float duration = 1.0f;
        
        float result = Quintic.easeIn(time, begin, change, duration);
        assertEquals(begin, result, 0.001f);
        
        result = Quintic.easeOut(time, begin, change, duration);
        assertEquals(begin, result, 0.001f);
        
        result = Quintic.easeInOut(time, begin, change, duration);
        assertEquals(begin, result, 0.001f);
        
        time = duration;
        result = Quintic.easeIn(time, begin, change, duration);
        assertEquals(begin + change, result, 0.001f);
        
        result = Quintic.easeOut(time, begin, change, duration);
        assertEquals(begin + change, result, 0.001f);
        
        result = Quintic.easeInOut(time, begin, change, duration);
        assertEquals(begin + change, result, 0.001f);
    }
    @Test
    public void test_167() throws Exception {
        Vector2 vec1 = new Vector2(1.0f, 2.0f);
        assertEquals(1.0f, vec1.x, 0.01);
        assertEquals(2.0f, vec1.y, 0.01);
        
        Vector2 vec2 = new Vector2(3, 4);
        assertEquals(3.0f, vec2.x, 0.01);
        assertEquals(4.0f, vec2.y, 0.01);
        
        Vector2 vec3 = new Vector2(5.0f);
        assertEquals(5.0f, vec3.x, 0.01);
        assertEquals(5.0f, vec3.y, 0.01);
        
        Vector2 vec4 = new Vector2(6);
        assertEquals(6.0f, vec4.x, 0.01);
        assertEquals(6.0f, vec4.y, 0.01);
        
        Vector2 vec5 = new Vector2();
        assertEquals(0.0f, vec5.x, 0.01);
        assertEquals(0.0f, vec5.y, 0.01);
        
        Vector2 vec6 = new Vector2(vec1);
        assertEquals(1.0f, vec6.x, 0.01);
        assertEquals(2.0f, vec6.y, 0.01);
    }
    @Test
    public void test_334() throws Exception {
        Vector2 incident = new Vector2(1.0f, 1.0f);
        Vector2 normal = new Vector2(-1.0f, 0.0f);
        Vector2 result = Vector2.reflect(incident, normal);
        assertEquals(1.0f, result.x);
        assertEquals(1.0f, result.y);
    }
    @Test
    public void test_211() throws Exception {
    float[] data1 = {1, 2, 3, 4};
        Matrix a = new Matrix(data1, 2, 2);
        assertEquals(a.multiply(2), a.multiply(2));
    }
    @Test
    public void test_280() throws Exception {
        Color start = new Color(0, 0, 0);
        Color end = new Color(255, 255, 255);
        assertEquals(start, ColorHelper.smoothStep(start, end, 0.0f));
        assertEquals(end, ColorHelper.smoothStep(start, end, 1.0f));
    }
    @Test
    public void test_481() throws Exception {
        assertEquals(50.0f, Circular.easeInOut(0.5f, 0, 100, 1), 0.001);
        assertEquals(10.0f, Circular.easeInOut(0.1f, 0, 20, 1), 0.001);
    }
    @Test
    public void test_213() throws Exception {
    float[] data1 = {1, 2, 3, 4};
    float[] data2 = {1, 2, 3, 4};
    float[] data3 = {5, 6, 7, 8};
        Matrix a = new Matrix(data1, 2, 2);
        Matrix b = new Matrix(data2, 2, 2);
        Matrix c = new Matrix(data3, 2, 2);
        assertTrue(a.equals(b));
        assertFalse(a.equals(c));
    }
    @Test
    public void test_65() throws Exception {
    float[] a = {1.0f, 2.0f, 3.0f};
    float[] b = {4.0f, 5.0f, 6.0f};
        assertEquals(32.0f, MathHelper.dotProduct(a, b));
        
        try {
        MathHelper.dotProduct(new float[] {1.0f, 2.0f}, b);
            fail("Expected exception: IllegalArgumentException");
        } catch (IllegalArgumentException e) {
        }
    }
    @Test
    public void test_182() throws Exception {
    }
    @Test
    public void test_290() throws Exception {
        assertEquals(0, Quartic.easeIn(0, 0, 100, 1), 0.001);
        
        assertEquals(6.25, Quartic.easeIn(0.5f, 0, 100, 1), 0.001);
        
        assertEquals(100, Quartic.easeIn(1, 0, 100, 1), 0.001);
    }
    @Test
    public void test_127() throws Exception {
        Vector4 vec1 = new Vector4(1, 2, 3, 4);
        Vector4 vec2 = new Vector4(5, 6, 7, 8);
        Vector4 result = Vector4.add(vec1, vec2);
        assertEquals(6, result.x);
        assertEquals(8, result.y);
        assertEquals(10, result.z);
        assertEquals(12, result.w);
    }
    @Test
    public void test_317() throws Exception {
        Vector2 vec1 = new Vector2(3.0f, 4.0f);
        Vector2 result = vec1.normalize();
        assertEquals(3.0f / 5.0f, result.x);
        assertEquals(4.0f / 5.0f, result.y);
    }
    @Test
    public void test_199() throws Exception {
        assertEquals(1, MathHelper.clamp(1, 1, 5));
        assertEquals(5, MathHelper.clamp(10, 1, 5));
        assertEquals(1, MathHelper.clamp(0, 1, 5));
    }
    @Test
    public void test_129() throws Exception {
        Vector4 vec1 = new Vector4(1, 2, 3, 4);
        float scalar = 2;
        Vector4 result = Vector4.multiply(vec1, scalar);
        assertEquals(2, result.x);
        assertEquals(4, result.y);
        assertEquals(6, result.z);
        assertEquals(8, result.w);
    }
    @Test
    public void test_353() throws Exception {
        MathPad.matrix3Test();
    }
    @Test
    public void test_551() throws Exception {
        Texture2D texture = new Texture2D("images/testImage.png");
        assertEquals("images/testImage.png", texture.getPath());
    }
    @Test
    public void test_196() throws Exception {
        Texture2D texture = new Texture2D("path_to_image");
        BufferedImage mockImage = new BufferedImage(10, 10, BufferedImage.TYPE_INT_RGB);
        texture.setImage(mockImage);
        assertEquals(mockImage, texture.getImage());
    }
    @Test
    public void test_467() throws Exception {
        Vector4 vec1 = new Vector4(1, 4, 3, 8);
        Vector4 vec2 = new Vector4(5, 2, 7, 6);
        Vector4 result = Vector4.max(vec1, vec2);
        assertEquals(5.0f, result.x, 0.001f);
        assertEquals(4.0f, result.y, 0.001f);
        assertEquals(7.0f, result.z, 0.001f);
        assertEquals(8.0f, result.w, 0.001f);
    }
    @Test
    public void test_322() throws Exception {
        Vector2 one = Vector2.one();
        assertEquals(1.0f, one.x);
        assertEquals(1.0f, one.y);
        
        Vector2 unitX = Vector2.unitX();
        assertEquals(1.0f, unitX.x);
        assertEquals(0.0f, unitX.y);
        
        Vector2 unitY = Vector2.unitY();
        assertEquals(0.0f, unitY.x);
        assertEquals(1.0f, unitY.y);
        
        Vector2 zero = Vector2.zero();
        assertEquals(0.0f, zero.x);
        assertEquals(0.0f, zero.y);
    }
    @Test
    public void test_117() throws Exception {
        String imagePath = "path/to/exists/image.png";
        BufferedImage image = ImageHelper.load(imagePath);
        assertNotNull(image);
        
        int newWidth = 100;
        int newHeight = 100;
        
        BufferedImage resizedImage = ImageHelper.resize(image, newWidth, newHeight);
        
        assertNotNull(resizedImage);
        assertEquals(newWidth, resizedImage.getWidth());
        assertEquals(newHeight, resizedImage.getHeight());
    }
    @Test
    public void test_126() throws Exception {
        Vector2 vec1 = new Vector2(1, 1);
        Vector2 vec2 = new Vector2(5, 1);
        Vector2 vec3 = new Vector2(3, 5);
        float b2 = 0.4f;
        float b3 = 0.6f;
        Vector2 expected = new Vector2(2.2f, 2.8f);
        
        Vector2 result = Vector2.barycentric(vec1, vec2, vec3, b2, b3);
        
        assertEquals(expected, result);
    }
    @Test
    public void test_244() throws Exception {
        Matrix3 a = new Matrix3(1, 0, 0, 0, 1, 0, 0, 0, 1);
        Matrix3 expected = new Matrix3(1, 0, 0, 0, 1, 0, 0, 0, 1);
        
        assertEquals(expected, a.invert());
        
        a = new Matrix3(4, 7, 2, 3, 5, 1, 9, 6 ,3);
        expected = new Matrix3(-6, 4, 2, 5.5F, -7.5F, 1.5F, 0, 0, 1);
        
        assertEquals(expected, a.invert());
    }
    @Test
    public void test_177() throws Exception {
        assertEquals(0f, Elastic.easeIn(0f, 0, 100, 1f, null, null), DELTA);
        
        assertEquals(100f, Elastic.easeIn(1f, 0, 100, 1f, null, null), DELTA);
        
        assertEquals(50f, Elastic.easeIn(0.5f, 0, 100, 1f, null, null), DELTA);
        
        assertEquals(-50f, Elastic.easeIn(0.5f, 0, -100, 1f, null, null), DELTA);
    }
    @Test
    public void test_403() throws Exception {
        assertEquals(0, Exponential.easeOut(0, 0, 100, 1), 0.0001);
        
        assertEquals(100, Exponential.easeOut(1, 0, 100, 1), 0.0001);
        
        assertEquals(70.7107, Exponential.easeOut(0.5f, 0, 100, 1), 0.0001);
    }
    @Test
    public void test_531() throws Exception {
        assertEquals(new Vector2(4, 6), Vector2.add(new Vector2(1, 2), new Vector2(3, 4)));
    }
    @Test
    public void test_243() throws Exception {
        Matrix3 a = new Matrix3(1, 2, 3, 4, 5, 6, 7, 8, 9);
        float expected = 0;
        
        assertEquals(expected, a.determinant(), DELTA);
    }
    @Test
    public void test_160() throws Exception {
        float result = Quadratic.easeOut(0, 0, 1, 1);
        assertEquals(0, result, 0.1);
        
        result = Quadratic.easeOut(1, 0, 1, 1);
        assertEquals(1, result, 0.1);
        
    }
    @Test
    public void test_466() throws Exception {
        Vector4 vec1 = new Vector4(1, 2, 3, 4);
        Vector4 vec2 = new Vector4(5, 6, 7, 8);
        Vector4 result = Vector4.lerp(vec1, vec2, 0.5f);
        assertEquals(3.0f, result.x, 0.001f);
        assertEquals(4.0f, result.y, 0.001f);
        assertEquals(5.0f, result.z, 0.001f);
        assertEquals(6.0f, result.w, 0.001f);
    }
    @Test
    public void test_501() throws Exception {
        float result = Quadratic.easeOut(3, 2, 4, 6);
        assertEquals(3.2, result, 0.001);
    }
    @Test
    public void test_236() throws Exception {
        assertEquals(1.0f, Exponential.easeIn(0, 0, 1, 1), DELTA);
        assertEquals(1.0986123f, Exponential.easeIn(0.5f, 0, 1, 1), DELTA);
        assertEquals(2.0f, Exponential.easeIn(1, 0, 1, 1), DELTA);
    }
    @Test
    public void test_459() throws Exception {
        Vector4 p0 = new Vector4(0.0f, 0.0f, 0.0f, 0.0f);
        Vector4 p1 = new Vector4(1.0f, 1.0f, 1.0f, 1.0f);
        Vector4 p2 = new Vector4(2.0f, 2.0f, 2.0f, 2.0f);
        Vector4 p3 = new Vector4(3.0f, 3.0f, 3.0f, 3.0f);
        Vector4 result = Vector4.catmullRom(p0, p1, p2, p3, 0.5f);
        assertEquals(1.5f, result.x);
        assertEquals(1.5f, result.y);
        assertEquals(1.5f, result.z);
        assertEquals(1.5f, result.w);
    }
    @Test
    public void test_336() throws Exception {
        Vector2 vec1 = new Vector2(1.0f, 2.0f);
        Vector2 vec2 = new Vector2(3.0f, 4.0f);
        float result = vec1.wedgeProduct(vec2);
        assertEquals(-2.0f, result);
    }
    @Test
    public void test_583() throws Exception {
        Vector3 vector1 = new Vector3(5.0f, 6.0f, 7.0f);
        Vector3 vector2 = new Vector3(2.0f, 3.0f, 4.0f);
        
        Vector3 result1 = Vector3.subtract(vector1, vector2);
        assertEquals(3.0f, result1.x, 0.0f);
        assertEquals(3.0f, result1.y, 0.0f);
        assertEquals(3.0f, result1.z, 0.0f);
        
        Vector3 result2 = vector1.subtract(vector2);
        assertEquals(3.0f, result2.x, 0.0f);
        assertEquals(3.0f, result2.y, 0.0f);
        assertEquals(3.0f, result2.z, 0.0f);
    }
    @Test
    public void test_192() throws Exception {
        BufferedImage mockImage = new BufferedImage(10, 10, BufferedImage.TYPE_INT_RGB);
        Texture2D texture = new Texture2D(mockImage);
        assertNotNull(texture);
    }
    @Test
    public void test_354() throws Exception {
        for (int i = 0; i < 10; ++i) {
            float randomValue = MathHelper.random();
            assertTrue(randomValue >= 0.0f && randomValue < 1.0f);
        }
    }
    @Test
    public void test_153() throws Exception {
        Font font = new Font("Arial", Font.PLAIN, 14);
        int height = FontHelper.getStringHeight(font);
        Assert.assertTrue(height > 0);
    }
    @Test
    public void test_328() throws Exception {
        Vector2 p1 = new Vector2(0.0f, 0.0f);
        Vector2 t1 = new Vector2(1.0f, 1.0f);
        Vector2 p2 = new Vector2(2.0f, 2.0f);
        Vector2 t2 = new Vector2(3.0f, 3.0f);
        Vector2 result = Vector2.hermite(p1, t1, p2, t2, 0.5f);
        assertEquals(1.5f, result.x);
        assertEquals(1.5f, result.y);
    }
    @Test
    public void test_201() throws Exception {
    float[] a = {1.0f, 2.0f, 3.0f};
    float[] b = {4.0f, 5.0f, 6.0f};
        assertEquals(32.0f, MathHelper.dotProduct(a, b), DELTA);
    }
    @Test
    public void test_554() throws Exception {
    int[] a = {1, 2, 3};
    int[] b = {4, 5, 6};
        assertEquals(32, MathHelper.dotProduct(a, b));
    }
    @Test
    public void test_125() throws Exception {
        float time = 5;
        int begin = 0;
        int change = 10;
        float duration = 10;
        
        float result = Linear.easeInOut(time, begin, change, duration);
        
    }
    @Test
    public void test_282() throws Exception {
        Color color = new Color(255, 0, 0);
        Color transparentColor = ColorHelper.createTransparentColor(color);
        assertEquals(255, transparentColor.getRed());
        assertEquals(0, transparentColor.getGreen());
        assertEquals(0, transparentColor.getBlue());
        assertEquals(0, transparentColor.getAlpha());
    }
    @Test
    public void test_208() throws Exception {
        for (int i = 0; i < 100; i++) {
            int random = MathHelper.random(1, 10);
            assertTrue(random >= 1 && random <= 10);
        }
    }
    @Test
    public void test_267() throws Exception {
        Vector4 vec1 = new Vector4(1.0f, 2.0f, 3.0f, 4.0f);
        assertEquals(1.0f, vec1.x);
        assertEquals(2.0f, vec1.y);
        assertEquals(3.0f, vec1.z);
        assertEquals(4.0f, vec1.w);
        
        Vector4 vec2 = new Vector4(1);
        assertEquals(1.0f, vec2.x);
        assertEquals(1.0f, vec2.y);
        assertEquals(1.0f, vec2.z);
        assertEquals(1.0f, vec2.w);
        
        Vector4 vec3 = new Vector4();
        assertEquals(0.0f, vec3.x);
        assertEquals(0.0f, vec3.y);
        assertEquals(0.0f, vec3.z);
        assertEquals(0.0f, vec3.w);
        
        Vector4 vec4 = new Vector4(vec1);
        assertEquals(1.0f, vec4.x);
        assertEquals(2.0f, vec4.y);
        assertEquals(3.0f, vec4.z);
        assertEquals(4.0f, vec4.w);
    }
    @Test
    public void test_277() throws Exception {
        Color start = new Color(0, 0, 0);
        Color end = new Color(255, 255, 255);
        Color result = ColorHelper.lerp(start, end, 0.5f);
        assertEquals(new Color(128, 128, 128), result);
    }
    @Test
    public void test_155() throws Exception {
        Font font = new Font("Arial", Font.PLAIN, 14);
        int descent = FontHelper.getDescent(font);
        Assert.assertTrue(descent > 0);
    }
    @Test
    public void test_55() throws Exception {
        String validPath = "image.png";
        Texture2D texture = new Texture2D(validPath);
        assertNotNull(texture.getImage());
        assertEquals(validPath, texture.getPath());
        
        String invalidPath = "non-existent-image.png";
        try {
            new Texture2D(invalidPath);
            fail("Expected exception for invalid path");
        } catch (Exception e) {
        }
    }
    @Test
    public void test_458() throws Exception {
        Vector4 v1 = new Vector4(1.0f, 0.0f, 0.0f, 0.0f);
        Vector4 v2 = new Vector4(0.0f, 1.0f, 0.0f, 0.0f);
        Vector4 v3 = new Vector4(0.0f, 0.0f, 1.0f, 0.0f);
        Vector4 result = Vector4.barycentric(v1, v2, v3, 0.25f, 0.25f);
        assertEquals(0.5f, result.x);
        assertEquals(0.25f, result.y);
        assertEquals(0.25f, result.z);
        assertEquals(0.0f, result.w);
    }
    @Test
    public void test_286() throws Exception {
        assertEquals(0, Circular.easeInOut(0, 0, 100, 1), 0.0001);
        
        assertEquals(14.6447, Circular.easeInOut(0.25f, 0, 100, 1), 0.0001);
        
        assertEquals(50, Circular.easeInOut(0.5f, 0, 100, 1), 0.0001);
        
        assertEquals(85.3553, Circular.easeInOut(0.75f, 0, 100, 1), 0.0001);
        
        assertEquals(100, Circular.easeInOut(1, 0, 100, 1), 0.0001);
    }
    @Test
    public void test_200() throws Exception {
    int[] a = {1, 2, 3};
    int[] b = {4, 5, 6};
        assertEquals(32, MathHelper.dotProduct(a, b));
    }
    @Test
    public void test_67() throws Exception {
        int max = 10;
        int result = MathHelper.random(max);
        assertTrue(result >= 0 && result <= max);
    }
    @Test
    public void test_168() throws Exception {
        Vector2 vec1 = new Vector2(1.0f, 2.0f);
        Vector2 vec2 = new Vector2(3.0f, 4.0f);
        Vector2 vec3 = vec1.add(vec2);
        
        assertEquals(4.0f, vec3.x, 0.01);
        assertEquals(6.0f, vec3.y, 0.01);
        
        Vector2 vec4 = vec1.add(1.0f, 1.0f);
        assertEquals(2.0f, vec4.x, 0.01);
        assertEquals(3.0f, vec4.y, 0.01);
        
        Vector2 vec5 = vec1.addX(1.0f);
        assertEquals(2.0f, vec5.x, 0.01);
        assertEquals(2.0f, vec5.y, 0.01);
        
        Vector2 vec6 = vec1.addY(1.0f);
        assertEquals(1.0f, vec6.x, 0.01);
        assertEquals(3.0f, vec6.y, 0.01);
    }
    @Test
    public void test_63() throws Exception {
        assertEquals(5, MathHelper.clamp(5, 0, 10));
        assertEquals(0, MathHelper.clamp(-5, 0, 10));
        assertEquals(10, MathHelper.clamp(15, 0, 10));
    }
    @Test
    public void test_326() throws Exception {
        Vector2 vec = new Vector2(1.0f, 1.0f);
        float alpha = vec.directionAlpha();
        float beta = vec.directionBeta();
        assertEquals(Math.PI / 4, alpha, 0.0001);
        assertEquals(Math.PI / 4, beta, 0.0001);
    }
    @Test
    public void test_331() throws Exception {
        Vector2 vec1 = new Vector2(1.0f, 2.0f);
        Vector2 result = vec1.negate();
        assertEquals(-1.0f, result.x);
        assertEquals(-2.0f, result.y);
    }
    @Test
    public void test_152() throws Exception {
        Font font = new Font("Arial", Font.PLAIN, 14);
        String text = "Hello, World!";
        int height = FontHelper.getStringHeight(text, font);
        Assert.assertTrue(height > 0);
    }
    @Test
    public void test_180() throws Exception {
        Vector2 a = new Vector2(1, 2);
        Vector2 b = new Vector2(3, 4);
        Vector2 expected = new Vector2(4, 6);
        Vector2 result = Vector2.add(a, b);
        assertEquals(expected, result);
    }
    @Test
    public void test_537() throws Exception {
        assertEquals(new Vector3(4, 6, 0), Vector3.add(new Vector3(1, 2, 0), new Vector3(3, 4, 0)));
    }
    @Test
    public void test_300() throws Exception {
        assertEquals(0, Back.easeIn(0, 0, 100, 1, null), 0.0001);
        
        assertEquals(100, Back.easeIn(1, 0, 100, 1, null), 0.0001);
        
        assertEquals(27.0197, Back.easeIn(0.5f, 0, 100, 1, null), 0.0001);
        
        assertEquals(77.0197, Back.easeIn(0.5f, 50, 100, 1, 2.0f), 0.0001);
    }
    @Test
    public void test_404() throws Exception {
        assertEquals(0, Exponential.easeInOut(0, 0, 100, 1), 0.0001);
        
        assertEquals(100, Exponential.easeInOut(1, 0, 100, 1), 0.0001);
        
        assertEquals(50, Exponential.easeInOut(0.5f, 0, 100, 1), 0.0001);
        
        assertEquals(14.6447, Exponential.easeInOut(0.25f, 0, 100, 1), 0.0001);
        
        assertEquals(85.3553, Exponential.easeInOut(0.75f, 0, 100, 1), 0.0001);
    }
    @Test
    public void test_582() throws Exception {
        Vector3 vector1 = new Vector3(1.0f, 2.0f, 3.0f);
        Vector3 vector2 = new Vector3(4.0f, 5.0f, 6.0f);
        
        Vector3 result1 = Vector3.add(vector1, vector2);
        assertEquals(5.0f, result1.x, 0.0f);
        assertEquals(7.0f, result1.y, 0.0f);
        assertEquals(9.0f, result1.z, 0.0f);
        
        Vector3 result2 = vector1.add(vector2);
        assertEquals(5.0f, result2.x, 0.0f);
        assertEquals(7.0f, result2.y, 0.0f);
        assertEquals(9.0f, result2.z, 0.0f);
    }
    @Test
    public void test_181() throws Exception {
        Vector2 a = new Vector2(3, 4);
        Vector2 b = new Vector2(1, 2);
        Vector2 expected = new Vector2(2, 2);
        Vector2 result = Vector2.subtract(a, b);
        assertEquals(expected, result);
    }
    @Test
    public void test_598() throws Exception {
        Quaternion q1 = new Quaternion(1, 2, 3, 4);
        Quaternion q2 = new Quaternion(2, 3, 4, 5);
        Quaternion result = Quaternion.add(q1, q2);
        assertEquals(new Quaternion(3, 5, 7, 9), result);
    }
    @Test
    public void test_454() throws Exception {
        Vector4 original = new Vector4(1.0f, 2.0f, 3.0f, 4.0f);
        Vector4 copy = new Vector4(original);
        assertEquals(original.x, copy.x);
        assertEquals(original.y, copy.y);
        assertEquals(original.z, copy.z);
        assertEquals(original.w, copy.w);
    }
    @Test
    public void test_600() throws Exception {
        Quaternion q = new Quaternion(1, 2, 3, 4);
        float magnitude = Quaternion.magnitude(q);
        assertEquals(5.477225575051661, magnitude);
    }
    @Test
    public void test_556() throws Exception {
        assertEquals(5.5f, MathHelper.lerp(5f, 6f, 0.5f));
    }
    @Test
    public void test_564() throws Exception {
        int random = MathHelper.random();
        assertTrue(random >= 0 && random <= Integer.MAX_VALUE);
    }
    @Test
    public void test_323() throws Exception {
        Vector2 v1 = new Vector2(0.0f, 0.0f);
        Vector2 v2 = new Vector2(1.0f, 0.0f);
        Vector2 v3 = new Vector2(0.0f, 1.0f);
        Vector2 result = Vector2.barycentric(v1, v2, v3, 0.5f, 0.5f);
        assertEquals(0.5f, result.x);
        assertEquals(0.5f, result.y);
    }
    @Test
    public void test_150() throws Exception {
        Font font = new Font("Arial", Font.PLAIN, 14);
        String text = "Hello, World!";
        Rectangle2D bounds = FontHelper.getBounds(text, font);
        Assert.assertTrue(bounds.getWidth() > 0);
        Assert.assertTrue(bounds.getHeight() > 0);
    }
    @Test
    public void test_384() throws Exception {
        assertEquals(0, Bounce.easeIn(0, 0, 100, 2), 0.01);
        assertEquals(100, Bounce.easeIn(2, 0, 100, 2), 0.01);
        assertEquals(50, Bounce.easeIn(1, 0, 100, 2), 0.01);
    }
    @Test
    public void test_464() throws Exception {
        Vector4 vec = new Vector4(1, 2, 3, 4);
        float result = vec.magnitude();
        assertEquals(5.477f, result, 0.001f);
    }
    @Test
    public void test_202() throws Exception {
        assertEquals(2.0f, MathHelper.lerp(1.0f, 4.0f, 0.5f), DELTA);
        assertEquals(4.0f, MathHelper.lerp(1.0f, 4.0f, 1.0f), DELTA);
        assertEquals(1.0f, MathHelper.lerp(1.0f, 4.0f, 0.0f), DELTA);
    }
    @Test
    public void test_142() throws Exception {
        float result = Circular.easeInOut(0f, 0, 100, 1f);
        assertEquals(0f, result, DELTA);
        
        result = Circular.easeInOut(0.5f, 0, 100, 1f);
        assertEquals(50f, result, DELTA);
        result = Circular.easeInOut(1f, 0, 100, 1f);
        assertEquals(100f, result, DELTA);
    }
    @Test
    public void test_114() throws Exception {
        Matrix3 m1 = new Matrix3(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Matrix3 m2 = new Matrix3(9, 8, 7, 6, 5, 4, 3, 2, 1);
        Matrix3 result = m1.add(m2);
        assertEquals(10, result.M11);
        assertEquals(10, result.M12);
        assertEquals(10, result.M13);
        assertEquals(10, result.M21);
        assertEquals(10, result.M22);
        assertEquals(10, result.M23);
        assertEquals(10, result.M31);
        assertEquals(10, result.M32);
        assertEquals(10, result.M33);
    }
    @Test
    public void test_475() throws Exception {
        Color color = new Color(255, 0, 0, 255);
        Color result = ColorHelper.createTransparentColor(color);
        assertEquals(new Color(255, 0, 0, 0), result);
    }
    @Test
    public void test_206() throws Exception {
        assertEquals(2.0f, MathHelper.max(1.0f, 2.0f), DELTA);
        assertEquals(2.0f, MathHelper.max(2.0f, 2.0f), DELTA);
    }
    @Test
    public void test_203() throws Exception {
        assertEquals(1.0f, MathHelper.smoothStep(1.0f, 4.0f, 0.0f), DELTA);
        assertEquals(4.0f, MathHelper.smoothStep(1.0f, 4.0f, 1.0f), DELTA);
        assertEquals(2.3333334f, MathHelper.smoothStep(1.0f, 4.0f, 0.5f), DELTA);
    }
    @Test
    public void test_321() throws Exception {
        Vector2 vec1 = new Vector2(1.0f, 2.0f);
        assertEquals("<1.0,2.0>", vec1.toString());
    }
    @Test
    public void test_581() throws Exception {
        Vector3 vector1 = new Vector3(1.0f, 2.0f, 3.0f);
        assertEquals(1.0f, vector1.x, 0.0f);
        assertEquals(2.0f, vector1.y, 0.0f);
        assertEquals(3.0f, vector1.z, 0.0f);
        
        Vector3 vector2 = new Vector3(5, 6, 7);
        assertEquals(5.0f, vector2.x, 0.0f);
        assertEquals(6.0f, vector2.y, 0.0f);
        assertEquals(7.0f, vector2.z, 0.0f);
        
        Vector3 vector3 = new Vector3(2.0f);
        assertEquals(2.0f, vector3.x, 0.0f);
        assertEquals(2.0f, vector3.y, 0.0f);
        assertEquals(2.0f, vector3.z, 0.0f);
        
        Vector3 vector4 = new Vector3();
        assertEquals(0.0f, vector4.x, 0.0f);
        assertEquals(0.0f, vector4.y, 0.0f);
        assertEquals(0.0f, vector4.z, 0.0f);
    }
    @Test
    public void test_271() throws Exception {
        Vector4 vec1 = new Vector4(2.0f, 4.0f, 6.0f, 8.0f);
        Vector4 result = vec1.divide(2.0f);
        assertEquals(1.0f, result.x);
        assertEquals(2.0f, result.y);
        assertEquals(3.0f, result.z);
        assertEquals(4.0f, result.w);
    }
}