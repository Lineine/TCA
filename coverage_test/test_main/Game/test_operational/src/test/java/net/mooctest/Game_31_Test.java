package net.mooctest;
import java.awt.image.BufferedImage;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import java.awt.Graphics2D;
public class Game_31_Test
{
    private Template game;
    private BufferedImage testImage;
    private Graphics2D testGraphics;
    @Before
    public void setUp() {
        game = new Template();
        testImage = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        testGraphics = testImage.createGraphics();
    }
    @Test
    public void test_343() throws Exception {
        game.draw(testGraphics);
    }
    @Test
    public void test_341() throws Exception {
        game.unloadContent();
    }
    @Test
    public void test_342() throws Exception {
        GameTime gameTime = new GameTime();
        game.update(gameTime);
    }
    @Test
    public void test_339() throws Exception {
        game.initialize();
    }
}