package net.mooctest;
import static org.junit.Assert.*;
import org.junit.Before;
import java.util.Set;
import java.util.List;
import java.io.IOException;
import org.junit.Test;
public class LLMAnagram_1_Test
{
    private Dictionary dictionary;
    @Before
    public void setUp() {
        dictionary = new Dictionary();
    }
    @Test
    public void test_95() throws Exception {
        dictionary.loadDictionary("validFilePath.txt");         Set<String> anagrams = dictionary.findSingleWordAnagrams("word");
        assertNotNull(anagrams);
    }
    @Test
    public void test_97() throws Exception {
        dictionary.loadDictionary("validFilePath.txt");         List<String> keyList = dictionary.getDictionaryKeyList();
        assertNotNull(keyList);
        assertFalse(keyList.isEmpty());
    }
    @Test
    public void test_96() throws Exception {
        dictionary.loadDictionary("validFilePath.txt");         try {
            dictionary.findSingleWordAnagrams("");
            fail("Expected IOException to be thrown");
        } catch (IllegalStateException e) {
        }
    }
    @Test
    public void test_92() throws Exception {
        assertTrue(dictionary.addWord("word"));
    }
}