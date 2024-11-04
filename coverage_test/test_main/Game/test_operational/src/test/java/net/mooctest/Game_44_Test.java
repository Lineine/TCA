package net.mooctest;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class Game_44_Test
{
    private AcceleratedGame game;
    public class AcceleratedGame {
        public Vector2 calculateBarycentric(Vector2 vec1, Vector2 vec2, Vector2 vec3, float b2, float b3) {
            return Vector2.barycentric(vec1, vec2, vec3, b2, b3);
        }
        public String generateFrameInfo() {
            return "FPS: 60";
        }
        
    }
    @Before
    public void setUp() {
        game = new AcceleratedGame();
    }
    @Test
    public void test_447() throws Exception {
        Vector2 vec1 = new Vector2(1, 1);
        Vector2 vec2 = new Vector2(5, 1);
        Vector2 vec3 = new Vector2(3, 5);
        float b2 = 0.4f;
        float b3 = 0.6f;
        
        Vector2 result = game.calculateBarycentric(vec1, vec2, vec3, b2, b3);
        
    }
}