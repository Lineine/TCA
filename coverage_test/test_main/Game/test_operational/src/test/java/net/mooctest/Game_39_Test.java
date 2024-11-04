package net.mooctest;
import org.junit.Test;
import org.evosuite.shaded.org.mockito.Mock;
import static org.evosuite.shaded.org.mockito.Mockito.verify;
import org.junit.Before;
import java.awt.Graphics2D;
public class Game_39_Test
{
    @Mock
    private Game mockGame;
    @Mock
    private GameTime mockGameTime;
    @Mock
    private Graphics2D mockGraphics2D;
    private TestFramework testFramework;
    @Before
    public void setUp() {
        testFramework = new TestFramework();
    }
    @Test
    public void test_410() throws Exception {
    TestFramework.main(new String[]{});
    }
    @Test
    public void test_408() throws Exception {
        testFramework.update(mockGameTime);
        verify(mockGame).update(mockGameTime);
    }
    @Test
    public void test_409() throws Exception {
        testFramework.draw(mockGraphics2D);
        verify(mockGame).draw(mockGraphics2D);
    }
    @Test
    public void test_405() throws Exception {
        testFramework.initialize();
        verify(mockGame).initialize();
    }
}