package net.mooctest;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;
public class Game_1_Test
{
    Vector3 v1, v2, v3;
    @Before
    public void setUp() {
        v1 = new Vector3(1, 2, 3);
        v2 = new Vector3(1, 2, 4);
        v3 = new Vector3(2, 2, 4);
    }
    private GameTime gameTime;
    @Before
    public void setup() {
        gameTime = new GameTime();
    }
    @Test
    public void test_227() throws Exception {
        Vector3 actual = Vector3.add(v1, v2);
        Vector3 expected = new Vector3(2, 4, 7);
        assertEquals(expected, actual);
    }
    @Test
    public void test_231() throws Exception {
        boolean actual = Vector3.equals(v1, v2);
        assertTrue(actual);
    }
    @Test
    public void test_230() throws Exception {
        Vector3 actual = Vector3.crossProduct(v1, v2);
        Vector3 expected = new Vector3(0, 0, -1);
        assertEquals(expected, actual);
    }
    @Test
    public void test_162() throws Exception {
        gameTime.reset();
        assertEquals(0.0f, gameTime.getGameTime(), 0);
    }
    @Test
    public void test_164() throws Exception {
        gameTime.tick();
        float deltaTimeOne = gameTime.getDeltaTime();
        assertTrue(deltaTimeOne >= 0);
        
        gameTime.tick();
        float deltaTimeTwo = gameTime.getDeltaTime();
        assertTrue(deltaTimeTwo >= 0);
        
        assertTrue(deltaTimeTwo > deltaTimeOne);
    }
    @Test
    public void test_228() throws Exception {
        Vector3 actual = Vector3.subtract(v1, v2);
        Vector3 expected = new Vector3(0, 0, -1);
        assertEquals(expected, actual);
    }
    @Test
    public void test_232() throws Exception {
        float actual = v1.magnitude();
        float expected = 3.74166f;         assertEquals(expected, actual, 0.00001);
    }
    @Test
    public void test_229() throws Exception {
        float actual = Vector3.dotProduct(v1, v2);
        float expected = 20;
        assertEquals(expected, actual, 0.1);
    }
    @Test
    public void test_163() throws Exception {
        gameTime.reset();
        gameTime.tick();
        assertNotEquals(0.0f, gameTime.getGameTime());
    }
    @Test
    public void test_166() throws Exception {
        gameTime.start();
        gameTime.tick();
        float gameTimeOne = gameTime.getGameTime();
        
        gameTime.stop();
        gameTime.start();
        gameTime.tick();
        float gameTimeTwo = gameTime.getGameTime();
        
        assertTrue(gameTimeTwo > gameTimeOne);
    }
}