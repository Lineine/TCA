package net.mooctest;
import org.evosuite.shaded.org.mockito.InjectMocks;
import org.junit.Assert;
import org.junit.Test;
import org.evosuite.shaded.org.mockito.Mock;
import java.awt.*;
import org.junit.Before;
import java.util.LinkedList;
import static org.evosuite.shaded.org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
public class Game_3_Test
{
    private static final String TEST_LABEL = "Test Item";
    private static final Color TEST_COLOR = Color.YELLOW;
    private static final int WIDTH = 100;
    private static final int HEIGHT = 50;
    private static final String NEW_LABEL = "New Test Item";
    private static final Color NEW_COLOR = Color.BLUE;
    private GuiToolkit guiToolkit;
    private LinkedList<GuiActions> callQueue;
    @Before
    public void setup() {
        guiToolkit = new GuiToolkit();
        callQueue = new LinkedList<>();
    }
    @InjectMocks
    private TestFramework testFramework;
    
    @Mock
    private GameTime gameTimeMock;
    
    @Before
    public void setUp() {
        testFramework = new TestFramework();
    }
    @Test
    public void test_239() throws Exception {
        testFramework.initialize();
    }
    @Test
    public void test_240() throws Exception {
        testFramework.loadContent();
    }
    @Test
    public void test_226() throws Exception {
        assertEquals(String.valueOf(callQueue.size()), 0, "callQueue should be empty initially");
    }
    @Test
    public void test_90() throws Exception {
        MenuItem menuItem = new MenuItem("Test Label");
    }
    @Test
    public void test_87() throws Exception {
        MenuItem menuItem = new MenuItem("Test Label");
        Color customFontColor = Color.BLUE;
        menuItem.setFontColor(customFontColor);
        assertEquals(customFontColor, menuItem.fontColor);
    }
    @Test
    public void test_86() throws Exception {
        MenuItem menuItem = new MenuItem("Test Label", Color.RED);
        assertEquals(Color.RED, menuItem.hoverColor);
    }
    @Test
    public void test_225() throws Exception {
        MenuItem testItem = new MenuItem(TEST_LABEL, NEW_COLOR);
        Font newFont = new Font("Arial", Font.BOLD, 14);
        Color newColor = Color.RED;
        testItem.setFontColor(newColor);
        testItem.setFont(newFont);
        Assert.assertEquals(newFont, testItem.font);
        Assert.assertEquals(newColor, testItem.fontColor);
    }
    @Test
    public void test_224() throws Exception {
        MenuItem testItem = new MenuItem(TEST_LABEL);
        Assert.assertEquals(TEST_COLOR, testItem.hoverColor);
        
        MenuItem anotherItem = new MenuItem(TEST_LABEL, NEW_COLOR);
        Assert.assertEquals(NEW_COLOR, anotherItem.hoverColor);
    }
}