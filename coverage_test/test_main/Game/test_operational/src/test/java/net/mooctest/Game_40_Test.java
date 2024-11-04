package net.mooctest;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;
public class Game_40_Test
{
    private GameTime gameTime;
    @Before
    public void setUp() {
        gameTime = new GameTime();
    }
    
    
    
    
    
    private long getBaseTime() {
        try {
            java.lang.reflect.Field field = GameTime.class.getDeclaredField("baseTime");
            field.setAccessible(true);
            return (long) field.get(gameTime);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private long getPrevTime() {
        try {
            java.lang.reflect.Field field = GameTime.class.getDeclaredField("prevTime");
            field.setAccessible(true);
            return (long) field.get(gameTime);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void test_309() throws Exception {
        gameTime.reset();
        gameTime.tick();
        float initialDeltaTime = gameTime.getDeltaTime();
        
        Thread.sleep(100);
        
        gameTime.tick();
        float newDeltaTime = gameTime.getDeltaTime();
        
        assertTrue(newDeltaTime > initialDeltaTime);
    }
    @Test
    public void test_308() throws Exception {
        gameTime.reset();
        gameTime.stop();
        
        assertEquals(0.0f, gameTime.getGameTime(), 0.001);
    }
    @Test
    public void test_306() throws Exception {
        assertEquals(0.0f, gameTime.getGameTime(), 0.001);
        assertEquals(0.0f, gameTime.getDeltaTime(), 0.001);
        assertEquals(0.0f, gameTime.getDeltaTimeSeconds(), 0.001);
    }
}