package net.mooctest;
import static org.junit.Assert.assertNull;
import java.io.IOException;
import org.junit.Test;
import java.lang.reflect.Array;
import org.junit.runner.RunWith;
import java.io.FileNotFoundException;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;
import java.util.LinkedHashSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.io.FileWriter;
import static org.junit.Assert.*;
import java.util.Locale;
import static org.junit.Assert.assertNotNull;
import java.util.List;
import java.util.TreeSet;
import static org.junit.Assert.assertTrue;
import java.util.Set;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
public class LLMAnagram_0_Test
{
    private Dictionary dictionary;
    @Test
    public void test_73() throws Exception {
        dictionary = new Dictionary();
        dictionary.loadDictionary("src/test/resources/wordlist.txt");
        assertNotNull(dictionary.getDictionaryKeyList());
    }
    @Test
    public void test_48() throws Exception {
        char[] charArray0 = new char[2];
        char[] charArray1 = Helper.setDifference(charArray0, charArray0);
        char[] charArray2 = Helper.setDifference(charArray0, charArray0);
        boolean boolean0 = Helper.isEquivalent(charArray1, charArray2);
        assertTrue(boolean0);
        assertEquals(0, charArray2.length);
    }
    @Test
    public void test_61() throws Exception {
        char[] charArray0 = new char[5];
        charArray0[2] = '\u001C';
        char[] charArray1 = new char[5];
        boolean boolean0 = Helper.isEquivalent(charArray0, charArray1);
        assertFalse(boolean0);
    }
    @Test
    public void test_106() throws Exception {
        Set<String> set1 = new HashSet<>(Arrays.asList("a", "b"));
        Set<String> set2 = new HashSet<>(Arrays.asList("1", "2"));
        Set<Set<String>> result = Helper.setMultiplication(set1, set2);
        assertEquals(4, result.size());
        assertTrue(result.contains(new HashSet<>(Arrays.asList("a", "1"))));
        assertTrue(result.contains(new HashSet<>(Arrays.asList("a", "2"))));
        assertTrue(result.contains(new HashSet<>(Arrays.asList("b", "1"))));
        assertTrue(result.contains(new HashSet<>(Arrays.asList("b", "2"))));
        assertNull(Helper.setMultiplication());
    }
    @Test
    public void test_82() throws Exception {
        assertTrue(Helper.isEquivalent("abc".toCharArray(), "cab".toCharArray()));
        assertFalse(Helper.isEquivalent("abc".toCharArray(), "abcd".toCharArray()));
    }
    @Test
    public void test_110() throws Exception {
        Dictionary dictionary = new Dictionary();
        dictionary.addWord("listen");
        Set<String> anagrams = dictionary.findSingleWordAnagrams("silent");
        assertEquals(1, anagrams.size());
        assertTrue(anagrams.contains("listen"));
    }
    @Test
    public void test_22() throws Exception {
    char[] charArr1 = {'a', 'b', 'c'};
    char[] charArr2 = {'c', 'b', 'a'};
        assertTrue(Helper.isEquivalent(charArr1, charArr2));
    }
    @Test
    public void test_30() throws Exception {
        Anagram anagram0 = null;
        try {
            anagram0 = new Anagram((String) null);
            
        } catch(NullPointerException e) {
            assertEquals(true, e instanceof NullPointerException);
        }
    }
    @Test
    public void test_162() throws Exception {
        Dictionary dictionary = new Dictionary();
        assertEquals(false, dictionary.addWord(""));
        assertEquals(true, dictionary.addWord("abc"));
        assertEquals(true, dictionary.addWord("abc rt"));
        assertEquals(true, dictionary.addWord("123"));
        dictionary.addWord("abc");
        dictionary.addWord("");
        dictionary.isDictionaryLoaded();
        dictionary.toString();
        dictionary.getDictionaryKeyList();
        Helper h1=new Helper();
    char[] chars1={'a','b','c'};
    char[] chars2={'a','b','c','d'};
    char[] chars3={'c','d','e','r'};
    char[] chars4={'d'};
    char[] chars5={'a','b','c','d'};
        Anagram ag=new Anagram(3,"abc");
        Set<String> set1 = new HashSet<String>();
        List<Character> l1=new  ArrayList();
        set1.add("a");
        
        try{
            dictionary.loadDictionary("demo.txt");
        }
        catch(Exception e)
        {
            
        }
        
        try{
            dictionary.findSingleWordAnagrams("");
        }
        catch(Exception e)
        {
            
        }
        try{
            dictionary.findSingleWordAnagrams("asdad");
        }
        catch(Exception e)
        {
            
        }
        try{
            dictionary.loadDictionaryWithSubsets("demo.txt", "abc", 3);
        }
        catch(Exception e)
        {
            
        }
        try{
            dictionary.loadDictionaryWithSubsets("", "abc", 3);
        }
        catch(Exception e)
        {
            
        }
        try{
            dictionary.loadDictionary(null);
        }
        catch(Exception e)
        {
            
        }
        try{
            dictionary.loadDictionary(null);
        }
        catch(Exception e)
        {
            
        }
        h1.isSubset(chars1, chars2);
        h1.isSubset(chars2, chars1);
        h1.isSubset(chars1, chars3);
        
        assertEquals(false, h1.isSubset(chars1, chars3));
        assertEquals(true, h1.isSubset(chars1, chars2));
        
        h1.sortWord("");
        assertEquals(null,  h1.sortWord(""));
        
        h1.setMultiplication(null);
        assertEquals(null, h1.setMultiplication(null));
        
        
        h1.setDifference(chars1,chars2);
        
        h1.isEquivalent(chars1, chars2);
        h1.isEquivalent(chars2, chars3);
        h1.isEquivalent(chars2, chars5);
        
        try {
            ag.findAllAnagrams("abc");
        } catch (Exception e) {
            
        }
        try {
            ag.findAllAnagrams("ab");
        } catch (Exception e) {
            
        }
        h1.setMultiplication(set1);
        try{
            ag.findAllAnagrams("abcd");
        }
        catch(Exception e)
        {
            
        }
        try{
            ag.findAllAnagrams("");
        }
        catch(Exception e)
        {
            
        }
        Anagram ag1=new Anagram(0,"abcdf");
        try{
            ag1.findAllAnagrams("");
        }
        catch(Exception e)
        {
            
        }
    }
    @Test
    public void test_27() throws Exception {
        Dictionary dictionary = new Dictionary();
        FileWriter writer=new FileWriter("path");
        writer.write("abcde\n");
        writer.write("abcba\n");
        try {
            dictionary.loadDictionary("src/main/resources/net/mooctest/demo.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        Anagram a1=new Anagram("src/main/resources/net/mooctest/demo.txt");
        Anagram a2=new Anagram(2, "src/main/resources/net/mooctest/demo.txt");
        HashSet<String> set = new HashSet<>();
        HashSet<String> set2=new HashSet<>();
        HashSet<String> set3=new HashSet<>();
        set.add("let");
        set2.add("apple");
        set3.add("qiqi");
        assertEquals(true, a1.findAllAnagrams("tel").contains(set));
        assertEquals(true, a2.findAllAnagrams("ppale").contains(set2));
        assertEquals(true, a1.findAllAnagrams("tel").contains(set));
        
    }
    @Test
    public void test_66() throws Exception {
        String string0 = Helper.sortWord("");
        assertNull(string0);
    }
    @Test
    public void test_64() throws Exception {
        char[] charArray0 = new char[5];
        charArray0[2] = '\u001C';
        char[] charArray1 = new char[5];
        boolean boolean0 = Helper.isSubset(charArray0, charArray1);
        assertFalse(boolean0);
    }
    @Test
    public void test_104() throws Exception {
        assertTrue(Helper.isEquivalent("listen".toCharArray(), "silent".toCharArray()));
        assertFalse(Helper.isEquivalent("apple".toCharArray(), "apples".toCharArray()));
        assertTrue(Helper.isEquivalent("".toCharArray(), "".toCharArray()));
        assertFalse(Helper.isEquivalent("a".toCharArray(), "b".toCharArray()));
    }
    @Test
    public void test_80() throws Exception {
        assertEquals(null, Helper.sortWord(""));
        assertEquals("aehrt", Helper.sortWord("heart"));
        assertEquals("dgo", Helper.sortWord("god"));
    }
    @Test
    public void test_116() throws Exception {
    assertTrue(Helper.isSubset(new char[]{'a', 'b', 'c'}, new char[]{'a', 'b', 'c', 'd', 'e'}));
    assertTrue(Helper.isSubset(new char[]{'a', 'b', 'c', 'a'}, new char[]{'a', 'b', 'c', 'a', 'a'}));
    assertFalse(Helper.isSubset(new char[]{'a', 'b', 'c', 'd'}, new char[]{'a', 'b', 'c'}));
    assertFalse(Helper.isSubset(new char[]{'a', 'b', 'c'}, new char[]{'a', 'b', 'd'}));
    }
    @Test
    public void test_102() throws Exception {
        assertEquals("aelrst", Helper.sortWord("alerts"));
        assertNull(Helper.sortWord(""));
        assertEquals("a", Helper.sortWord("a"));
        assertEquals("123", Helper.sortWord("321"));
    }
    @Test
    public void test_72() throws Exception {
        dictionary = new Dictionary();
        dictionary.loadDictionary("src/test/resources/wordlist.txt");
        Set<String> anagrams = new TreeSet<>();
        anagrams.add("cat");
        anagrams.add("act");
        anagrams.add("tac");
        anagrams.add("act");
        
        assertEquals(anagrams, dictionary.findSingleWordAnagrams("cat"));
    }
    @Test
    public void test_56() throws Exception {
        try {
            Helper.isEquivalent((char[]) null, (char[]) null);
            
        } catch(NullPointerException e) {
            assertEquals(true, e instanceof NullPointerException);
        }
    }
    @Test
    public void test_118() throws Exception {
    assertArrayEquals(new char[]{'a', 'c'}, Helper.setDifference(new char[]{'a', 'b', 'c'}, new char[]{'b'}));
    assertArrayEquals(new char[]{'a', 'b', 'c'}, Helper.setDifference(new char[]{'a', 'b', 'c'}, new char[]{}));
    assertArrayEquals(new char[]{}, Helper.setDifference(new char[]{}, new char[]{'a', 'b'}));
    }
    @Test
    public void test_161() throws Exception {
        Helper helper0 = new Helper();
    }
    @Test
    public void test_105() throws Exception {
        assertArrayEquals("ltern".toCharArray(), Helper.setDifference("alerts".toCharArray(), "a".toCharArray()));
        assertArrayEquals("".toCharArray(), Helper.setDifference("alerts".toCharArray(), "alerts".toCharArray()));
        assertArrayEquals("alerts".toCharArray(), Helper.setDifference("alerts".toCharArray(), "".toCharArray()));
        assertArrayEquals("".toCharArray(), Helper.setDifference("".toCharArray(), "alerts".toCharArray()));
    }
    @Test
    public void test_86() throws Exception {
        Dictionary dic= new Dictionary();
        
        try {
            String filepath="";
            dic.loadDictionary(filepath);
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().equals("file path invalid"));
        }
        try {
            String filepath1=null;
            dic.loadDictionary(filepath1);
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().equals("file path invalid"));
        }
        
        String filepath2="";
        assertFalse( dic.addWord(filepath2));
        String filepath3="123";
        assertTrue( dic.addWord(filepath3));
        Set<String> set1 = new HashSet<String>();
        try {
            dic.findSingleWordAnagrams("word");
            
        } catch (IllegalStateException e) {
            assertTrue(e.getMessage().equals("dictionary not loaded"));
        }
        
        String filepath4="C:\\mooctest\\projects\\2526\\8668\\Anagram\\src\\main\\resources\\net\\mooctest\\demo.txt";
        
        dic.loadDictionary(filepath4);
        try {
            dic.findSingleWordAnagrams("");
            
        } catch (IllegalStateException e) {
            assertTrue(e.getMessage().equals("word string invalid"));
        }
        try {
            dic.findSingleWordAnagrams(null);
            
        } catch (IllegalStateException e) {
            assertTrue(e.getMessage().equals("word string invalid"));
        }
        set1=dic.findSingleWordAnagrams("word");
        assertTrue(dic.isDictionaryLoaded());
        dic.getDictionaryKeyList();
        dic.toString();
    }
    @Test
    public void test_115() throws Exception {
        assertEquals("aabbcd", Helper.sortWord("abbacd"));
        assertEquals("abcde", Helper.sortWord("edcba"));
        assertNull(Helper.sortWord(""));
    }
    @Test
    public void test_68() throws Exception {
        Helper helper0 = new Helper();
    }
    @Test
    public void test_117() throws Exception {
    assertTrue(Helper.isEquivalent(new char[]{'a', 'b', 'c'}, new char[]{'c', 'b', 'a'}));
    assertTrue(Helper.isEquivalent(new char[]{'a', 'b', 'c', 'a'}, new char[]{'b', 'c', 'a', 'a'}));
    assertFalse(Helper.isEquivalent(new char[]{'a', 'b', 'c'}, new char[]{'a', 'b'}));
    assertFalse(Helper.isEquivalent(new char[]{'a', 'b', 'c'}, new char[]{'d', 'e', 'f'}));
    }
    @Test
    public void test_160() throws Exception {
        String string0 = Helper.sortWord("O");
        assertEquals("O", string0);
    }
    @Test
    public void test_13() throws Exception {
        String dictionaryFilePath = "test_dict_single_anagram.txt";
        Anagram anagram = new Anagram(dictionaryFilePath);
        Set<Set<String>> anagrams = anagram.findAllAnagrams("listen");
        assertEquals(1, anagrams.size());
        assertEquals("[silent]", anagrams.iterator().next().toString());
    }
    @Test
    public void test_85() throws Exception {
        String s1="";
        String s2= Helper.sortWord(s1);
        assertNull(s2);
        String s3="123";
        String s4= Helper.sortWord(s3);
        assertEquals(s3,s4);
        
    char[] charArr1={1,2,3};
    char[] charArr2={1,2};
    char[] charArr3={4};
    char[] charArr5={1,2,4};
        char[] charArr4=null;
        assertTrue(Helper.isSubset(charArr2, charArr1));
        assertFalse(Helper.isSubset(charArr1, charArr2));
        assertFalse(Helper.isSubset(charArr3, charArr1));
        assertTrue(Helper.isEquivalent(charArr1, charArr1));
        assertFalse(Helper.isEquivalent(charArr1, charArr2));
        assertFalse(Helper.isEquivalent(charArr2, charArr1));
        assertFalse(Helper.isEquivalent(charArr1, charArr5));
        char[] charArr6=Helper.setDifference(charArr1, charArr2);
    char[] charArr7={3};
        assertArrayEquals(charArr6, charArr7);
        Set<String> set = new HashSet<String>();
        String ss1="1";
        String ss2="2";
        String ss3="3";
        set.add(s1);
        set.add(s2);
        set.add(s3);
        Set<Set<String>> setar= new HashSet<Set<String>>();
        setar=Helper.setMultiplication(set);
        
        Set<String> set1 = new HashSet<String>();
        
        assertNull(Helper.setMultiplication(null));
        Set<String>[] setArray0 = (Set<String>[]) Array.newInstance(Set.class, 0);
        
        Set<Set<String>> set0 = Helper.setMultiplication(setArray0);
        assertNull(set0);
    }
    @Test
    public void test_24() throws Exception {
    char[] charArr1 = {'a', 'b', 'c'};
    char[] charArr2 = {'b', 'c'};
        char[] result = Helper.setDifference(charArr1, charArr2);
        assertEquals("a", new String(result));
    }
    @Test
    public void test_142() throws Exception {
        char[] charArray0 = new char[5];
        charArray0[0] = '(';
        char[] charArray1 = new char[5];
        boolean boolean0 = Helper.isEquivalent(charArray0, charArray1);
        assertFalse(boolean0);
    }
    @Test
    public void test_87() throws Exception {
        String filepath4="C:\\mooctest\\projects\\2526\\8668\\Anagram\\src\\main\\resources\\net\\mooctest\\demo.txt";
        Anagram anagram1=new Anagram(filepath4);
        Anagram anagram2=new Anagram(0,filepath4);
        try {
            Set<Set<String>> set0=anagram1.findAllAnagrams(filepath4);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test_103() throws Exception {
        assertTrue(Helper.isSubset("art".toCharArray(), "alerts".toCharArray()));
        assertFalse(Helper.isSubset("alerts".toCharArray(), "art".toCharArray()));
        assertTrue(Helper.isSubset("".toCharArray(), "alerts".toCharArray()));
        assertFalse(Helper.isSubset("abc".toCharArray(), "ab".toCharArray()));
    }
    @Test
    public void test_83() throws Exception {
        assertArrayEquals("cd".toCharArray(), Helper.setDifference("abcd".toCharArray(), "ab".toCharArray()));
    }
}