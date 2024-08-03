package net.mooctest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Assert;
import java.io.ByteArrayOutputStream;
import java.awt.Color;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Timeout;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import java.util.List;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.Before;
import java.util.HashSet;
import org.junit.After;
import java.util.HashMap;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import java.io.ByteArrayInputStream;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
public class Algorithms_0_Test
{
    private Solution solution = new Solution();private void assertMatrixEquals(double[][] expected, double[][] actual, double delta) {
        int rows = expected.length;
        int cols = expected[0].length;
        for (int i = 0; i < rows; i++) {
            assertArrayEquals(expected[i], actual[i], delta);
        }
    }MedianOfRunningArrayDouble testArray = new MedianOfRunningArrayDouble();@Test
    public void testIsPangram2() {
        assertTrue(Pangram.isPangram2("The quick brown fox jumps over the lazy dog"));
        assertFalse(Pangram.isPangram2("The quick brown fox jumps over the azy dog"));
        assertFalse(Pangram.isPangram2("+-1234 This string is not alphabetical"));
        assertFalse(Pangram.isPangram2("\u0000/\\"));
    }private final int start = 0;
    private final int end = 10;
    private final int[] storage = new int[11];private void assertMatrixEquals1(double[][] expected, double[][] actual, double delta) {
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i].length, actual[i].length);
            for (int j = 0; j < expected[i].length; j++) {
                assertEquals(expected[i][j], actual[i][j], delta);
            }
        }
    }private MedianOfRunningArrayLong medianCalculator = new MedianOfRunningArrayLong();private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream original = System.out;
    
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }
    @After
    public void cleanUpStreams() {
        System.setOut(original);
    }private Anagrams anagrams;
    @BeforeEach
    public void setUp() {
        anagrams = new Anagrams();
    }
    @Test
    public void test_94() throws Exception {
        assertEquals(0, ClimbingStairs.numberOfWays(-1));
    }
    @Test
    public void test_459() throws Exception {
        assertTrue(anagrams.approach2("deal", "lead"));
    }
    @Test
    public void test_1266() throws Exception {
        assertTrue(CheckVowels.hasVowels("hello"));
    }
    @Test
    public void test_251() throws Exception {
        List<List<Integer>> matrix = Arrays.asList(
        Arrays.asList(-5, -3, -1),
        Arrays.asList(-2, 0, 2),
        Arrays.asList(1, 3, 5)
        );
        assertEquals(0, MedianOfMatrix.median(matrix));
    }
    @Test
    public void test_1255() throws Exception {
        assertEquals("ABCABC", Upper.toUpperCase("ABCABC"));
    }
    @Test
    public void test_630() throws Exception {
        assertEquals(1, Tribonacci.compute(1));
    }
    @Test
    public void test_226() throws Exception {
    int[] arr = {50, 4, 10, 15, 34};
        assertTrue(SubsetSum.subsetSum(arr, 0));
    }
    @Test
    public void test_1320() throws Exception {
        MedianOfRunningArrayLong medianFinder = new MedianOfRunningArrayLong();
        medianFinder.insert(100L);
        medianFinder.insert(300L);
        medianFinder.insert(200L);
        medianFinder.insert(400L);
        assertEquals(200L, (long) medianFinder.median());
    }
    @Test
    public void test_1017() throws Exception {
        assertEquals(123456, MyAtoi.myAtoi("123456"));
    }
    @Test
    public void test_751() throws Exception {
        assertEquals(0, BoardPath.bpRS(start+1, start, storage));
    }
    @Test
    public void test_1063() throws Exception {
        assertEquals(3, LevenshteinDistance.optimizedLevenshteinDistance("Saturday", ""));
    }
    @Test
    public void test_1134() throws Exception {
    int[] arr2 = {-2, -3, 4, -1, -2, 1, 5, -3};
        assertTrue(KadaneAlgorithm.maxSum(arr2, 7));
    }
    @Test
    public void test_1051() throws Exception {
        assertEquals(3, EditDistance.editDistance("flaw", "lawn"));
    }
    @Test
    public void test_272() throws Exception {
        assertEquals(14, CatalanNumber.findNthCatalan(4));
    }
    @Test
    public void test_1110() throws Exception {
    int[] arr = {50, 4, 10, 15, 34};
        assertTrue(SubsetSum.subsetSum(arr, 64));
        assertTrue(SubsetSum.subsetSum(arr, 99));
        assertFalse(SubsetSum.subsetSum(arr, 5));
        assertFalse(SubsetSum.subsetSum(arr, 66));
    }
    @Test
    public void test_874() throws Exception {
        assertEquals("aa", solution.longestPalindrome("aa"));
    }
    @Test
    public void test_1251() throws Exception {
        List<String> ans = Arrays.asList("a", "boggle", "this", "NOTRE_PEATED", "is", "simple", "board");
        char[][] board = {
        {'t', 'h', 'i', 's', 'i', 's', 'a'},
        {'s', 'i', 'm', 'p', 'l', 'e', 'x'},
        {'b', 'x', 'x', 'x', 'x', 'e', 'b'},
        {'x', 'o', 'g', 'g', 'l', 'x', 'o'},
        {'x', 'x', 'x', 'D', 'T', 'r', 'a'},
        {'R', 'E', 'P', 'E', 'A', 'd', 'x'},
        {'x', 'x', 'x', 'x', 'x', 'x', 'x'},
        {'N', 'O', 'T', 'R', 'E', '_', 'P'},
        {'x', 'x', 'D', 'E', 'T', 'A', 'E'}
        };
        String[] words = {
            "this", "is", "not", "a", "simple", "test", "boggle", "board", "REPEATED", "NOTRE_PEATED"
        };
        assertEquals(ans, WordBoggle.boggleBoard(board, words));
    }
    @Test
    public void test_239() throws Exception {
        assertFalse(Pangram.isPangram("     "));
    }
    @Test
    public void test_971() throws Exception {
    int[] arr = {1, 1, 1, 1};
        int target = 2;
        assertEquals(4, SubsetCount.getCount(arr, target));
    }
    @Test
    public void test_736() throws Exception {
        assertEquals(5, WordLadder.ladderLength("qa", "sq", Arrays.asList("si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "wa", "na", "mg", "oy", "za", "bk", "it", "ez", "we", "za", "jp", "vg", "ux", "iz", "pk", "dh", "nz", "gu", "yl", "jd", "gl", "bp", "hd", "me", "re", "wm", "xa", "be", "ud", "sz", "vv", "lr", "os", "ld", "va")));
    }
    @Test
    public void test_62() throws Exception {
        assertEquals(0, EditDistance.minDistance("abc", "abc"));
    }
    @Test
    public void test_371() throws Exception {
        double[][] matrix = {
        {1, 2, 3},
        {0, 1, 4},
        {5, 6, 0}
        };
        double[][] expectedInverse = {
        {-24, 18, 5},
        {20, -15, -4},
        {-5, 4, 1}
        };
        double[][] actualInverse = InverseOfMatrix.invert(matrix);
        assertMatrixEquals1(expectedInverse, actualInverse, 0.0001);
    }
    @Test
    public void test_831() throws Exception {
    int[] arr = {10, 22, 9, 33, 49, 50, 31, 60};
        int n = arr.length;
        Assert.assertEquals(5, LongestAlternatingSubsequence.alternatingLength(arr, n));
    int[] arr2 = {1, 2, 3, 4, 5};
        n = arr2.length;
        Assert.assertEquals(5, LongestAlternatingSubsequence.alternatingLength(arr2, n));
    int[] arr3 = {5, 4, 3, 2, 1};
        n = arr3.length;
        Assert.assertEquals(5, LongestAlternatingSubsequence.alternatingLength(arr3, n));
    int[] arr4 = {1, 2, 3, 2, 3, 4, 5};
        n = arr4.length;
        Assert.assertEquals(5, LongestAlternatingSubsequence.alternatingLength(arr4, n));
    }
    @Test
    public void test_332() throws Exception {
        assertEquals(1, UniquePaths.uniquePaths2(1, 5));
    }
    @Test
    public void test_143() throws Exception {
    assertArrayEquals(new int[] {5, 5}, RangeInSortedArray.sortedRange(new int[] {1, 2, 3, 3, 3, 4, 5}, 4));
    }
    @Test
    public void test_230() throws Exception {
        assertEquals(0, HammingDistance.calculateHammingDistance("abc", "abc"));
    }
    @Test
    public void test_576() throws Exception {
        int[][] image = {
        {0, 0, 0},
        {0, 3, 0},
        {0, 0, 0}
        };
        BoundaryFill.boundaryFill(image, -1, -1, 5, 3);
        BoundaryFill.boundaryFill(image, 3, 3, 5, 3);
        int[][] expectedImage = {
        {0, 0, 0},
        {0, 3, 0},
        {0, 0, 0}
        };
        assertArrayEquals(expectedImage, image);
    }
    @Test
    public void test_106() throws Exception {
        assertEquals(36, DP.findWays(6, 2, 12));
    }
    @Test
    public void test_48() throws Exception {
        int[][] grid = {
        {-1, -2, -3},
        {-4, -5, -6},
        {-7, -8, -9}
        };
        assertEquals(-45, MinimumPathSum.minimumPathSum(grid));
    }
    @Test
    public void test_135() throws Exception {
        char[] values4 = "abcdef".toCharArray();
        Rotation.reverse(values4, 0, 0);
        assertArrayEquals("abcdef".toCharArray(), values4);
    }
    @Test
    public void test_1460() throws Exception {
        assertFalse(Isomorphic.checkStrings("hello", "world"));
    }
    @Test
    public void test_407() throws Exception {
        assertTrue(WildcardMatching.isMatch("hello", "h*o"));
    }
    @Test
    public void test_221() throws Exception {
        int[] strg = new int[6];
        assertEquals(1, BoardPath.bpIS(0, 0, strg));
        strg = new int[6];
        assertEquals(0, BoardPath.bpIS(1, 0, strg));
        strg = new int[6];
        assertEquals(1, BoardPath.bpIS(3, 3, strg));
        strg = new int[6];
        assertEquals(4, BoardPath.bpIS(0, 3, strg));
        strg = new int[6];
        assertEquals(24, BoardPath.bpIS(0, 5, strg));
    }
    @Test
    public void test_829() throws Exception {
    int[] array = {1, 2, 3, 4, 5};
        int expected = 5;
        int result = LongestIncreasingSubsequence.findLISLen(array);
        assertEquals(expected, result, "Expected increasing subsequence length to be 5");
    array = new int[]{5, 4, 3, 2, 1};
        expected = 1;
        result = LongestIncreasingSubsequence.findLISLen(array);
        assertEquals(expected, result, "Expected increasing subsequence length to be 1");
    array = new int[]{1, 5, 2, 3, 4};
        expected = 4;
        result = LongestIncreasingSubsequence.findLISLen(array);
        assertEquals(expected, result, "Expected increasing subsequence length to be 4");
    }
    @Test
    public void test_888() throws Exception {
    double[][] a = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        double[][] inverse = InverseOfMatrix.invert(a);
        for(int i = 0;
        i< a.length;
        i++){
            for(int j = 0; j< a[0].length; j++){
                Assertions.assertEquals(a[i][j], inverse[i][j]);
            }
        }
    }
    @Test
    public void test_792() throws Exception {
        assertFalse(Pangram.isPangram2("The quick brown fox jumps over the azy dog"));
    }
    @Test
    public void test_299() throws Exception {
    int[] array = {1, 3, 5, 4, 7};
        assertEquals(4, LongestIncreasingSubsequence.lis(array));
    }
    @Test
    public void test_386() throws Exception {
        assertEquals("a", Lower.toLowerCase("A"));
    }
    @Test
    public void test_24() throws Exception {
    int[] nums = {-1, -2, -3, -4, -5, 15};
        assertTrue(PartitionProblem.partition(nums));
    }
    @Test
    public void test_1145() throws Exception {
    int[] array4 = {50, 3, 10, 7, 40, 80};
        assertEquals(4, LongestIncreasingSubsequence.findLISLen(array4));
    }
    @Test
    public void test_1155() throws Exception {
    int[] array = {1, 6, 11, 5};
        int result = MinimumSumPartition.minimumSumPartition(array);
        assertEquals(1, result);
    }
    @Test
    public void test_435() throws Exception {
        assertEquals(4, HorspoolSearch.findFirst("test", "this test is a test string"));
    }
    @Test
    public void test_1404() throws Exception {
        assertTrue(NewManShanksPrime.nthManShanksPrime(1, 1));
    }
    @Test
    public void test_817() throws Exception {
    int[] array3 = {-2, -3, 4};
        int predicted_answer3 = 4;
        assertTrue(KadaneAlgorithm.maxSum(array3,predicted_answer3));
    }
    @Test
    public void test_388() throws Exception {
    int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        int n = 4;
        int expected = 10;
        assertEquals(expected, RodCutting.cutRod(price, n));
    }
    @Test
    public void test_763() throws Exception {
        assertTrue(Palindrome.isPalindromeTwoPointer("madam"));
    }
    @Test
    public void test_525() throws Exception {
        assertTrue(Isomorphic.checkStrings("abba", "abab"));
    }
    @Test
    public void test_1066() throws Exception {
        assertEquals(2, ClimbingStairs.numberOfWays(2));
    }
    @Test
    public void test_970() throws Exception {
        ColorContrastRatio ratio = new ColorContrastRatio();
        Color foreground = new Color(23, 103, 154);
        Color background = new Color(226, 229, 248);
        double contrastForegroundBackground = ratio.getContrastRatio(foreground, background);
        assertEquals(4.88, contrastForegroundBackground, 0.01);
    }
    @Test
    public void test_1056() throws Exception {
    int[] arr = {-1, 0, 1, 2, -1, -4};
        int target = 0;
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(List.of(-1, -1, 2));
        expected.add(List.of(-1, 0, 1));
        ThreeSumProblem ThreeSumProblem = new ThreeSumProblem();
        List<List<Integer>> result = ThreeSumProblem.twoPointer(arr, target);
        assertEquals(expected.size(), result.size());
        assertTrue(expected.containsAll(result));
        assertTrue(result.containsAll(expected));
    }
    @Test
    public void test_960() throws Exception {
        assertEquals("madam", ReverseString.reverse2("madam"));
    }
    @Test
    public void test_1075() throws Exception {
        assertEquals("a2b1", StringCompression.compress("aab"));
    }
    @Test
    public void test_1362() throws Exception {
        assertEquals(0, LongestValidParentheses.getLongestValidParentheses(")(())"));
    }
    @Test
    public void test_1328() throws Exception {
        String s = "-42";
        int expected = -42;
        int result = MyAtoi.myAtoi(s);
        assertEquals(expected, result);
    }
    @Test
    public void test_154() throws Exception {
        int[][] result = MirrorOfMatrix.mirrorMatrix(null);
        assertNull(result, "Expected null for null input.");
    }
    @Test
    public void test_682() throws Exception {
        assertEquals(2, longestNonRepeativeSubstring.lengthOfLongestSubstring("aab"));
    }
    @Test
    public void test_1233() throws Exception {
        assertTrue(WildcardMatching.isMatch("aa", "*"));
    }
    @Test
    public void test_949() throws Exception {
        assertEquals(null, Upper.toUpperCase(null));
    }
    @Test
    public void test_660() throws Exception {
        assertEquals(2, EditDistance.editDistance("ab", "bc"));
    }
    @Test
    public void test_264() throws Exception {
    int[] arr = {-3, -4, -12, -5, -2};
        int key = -9;
        assertTrue(SumOfSubset.subsetSum(arr, arr.length - 1, key));
    }
    @Test
    public void test_444() throws Exception {
        assertEquals(5, HorspoolSearch.findFirstInsensitive("!@#", "this !@# is a test string"));
    }
    @Test
    public void test_1431() throws Exception {
        assertEquals("", Lower.toLowerCase(""));
    }
    @Test
    public void test_1240() throws Exception {
    int[] coins1 = {2, 4, 5};
        assertEquals(3, CoinChange.minimumCoins(coins1, 12));
        assertEquals(0, CoinChange.minimumCoins(coins1, 0));
    }
    @Test
    public void test_749() throws Exception {
        assertEquals(18360, BoardPath.bpR(start, end));
    }
    @Test
    public void test_1099() throws Exception {
        assertEquals("321cba", ReverseStringRecursive.reverse("abc123"));
    }
    @Test
    public void test_0() throws Exception {
        assertEquals(0, Tribonacci.compute(0));
    }
    @Test
    public void test_1435() throws Exception {
        String text = "hello world";
        String pattern = "";
        int expectedIndex = -1;
        int actualIndex = HorspoolSearch.findFirst(pattern, text);
        assertEquals(expectedIndex, actualIndex);
    }
    @Test
    public void test_1302() throws Exception {
        assertEquals(1, PalindromePrime.reverse(100));
    }
    @Test
    public void test_1090() throws Exception {
    int[][] originalMatrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    int[][] expected = {{3, 2, 1}, {6, 5, 4}, {9, 8, 7}};
        int[][] mirroredMatrix = MirrorOfMatrix.mirrorMatrix(originalMatrix);
        assertArrayEquals(expected, mirroredMatrix);
    }
    @Test
    public void test_767() throws Exception {
        assertTrue(Palindrome.isPalindrome(null));
    }
    @Test
    public void test_197() throws Exception {
        assertEquals("a", ReverseStringRecursive.reverse("a"));
    }
    @Test
    public void test_673() throws Exception {
        assertEquals(3, LevenshteinDistance.optimizedLevenshteinDistance("testing", "tastet"));
    }
    @Test
    public void test_401() throws Exception {
    int[] input = {1};
    int[] expected = {1};
        Sort012D.sort012(input);
        assertArrayEquals(expected, input);
    }
    @Test
    public void test_598() throws Exception {
        assertTrue(CharactersSame.isAllCharactersSame("zzzzzz"));
    }
    @Test
    public void test_1244() throws Exception {
        String text = "This is a simple example.";
        String pattern = "complex";
        int expectedIndex = -1;
        int actualIndex = HorspoolSearch.findFirst(pattern, text);
        assertEquals(expectedIndex, actualIndex);
    }
    @Test
    public void test_76() throws Exception {
        assertEquals(0, LevenshteinDistance.naiveLevenshteinDistance("", ""));
    }
    @Test
    public void test_1281() throws Exception {
        assertFalse(Isomorphic.checkStrings("abc", "def"));
    }
    @Test
    public void test_917() throws Exception {
        String text = "abcde";
        String pattern = "a*e";
        assertTrue(WildcardMatching.isMatch(text, pattern));
    }
    @Test
    public void test_477() throws Exception {
        int n = 10;
    int[] a = {1, 2, 2, 3, 3, 4, 4, 4, 5, 6};
        assertFalse(CountFriendsPairing.countFriendsPairing(n, a));
    }
    @Test
    public void test_258() throws Exception {
    int[] arr = {3, 34, 4, 12, 5, 2};
        int key = 9;
        assertTrue(SumOfSubset.subsetSum(arr, arr.length - 1, key));
    }
    @Test
    public void test_665() throws Exception {
    int[] nums = {-1, 0, 1, 2, -1, -4};
        int target = 0;
        List<List<Integer>> expectedResult = Arrays.asList(Arrays.asList(-1, -1, 2), Arrays.asList(-1, 0, 1));
        ThreeSumProblem th = new ThreeSumProblem();
        assertEquals(expectedResult, th.hashMap(nums, target));
    }
    @Test
    public void test_130() throws Exception {
        char[] values6 = "".toCharArray();
        Rotation.rotation(values6, 2);
        assertArrayEquals("".toCharArray(), values6);
    }
    @Test
    public void test_61() throws Exception {
        assertEquals(0, EditDistance.editDistance("", ""));
    }
    @Test
    public void test_824() throws Exception {
        String str5 = "";
        String str6 = "DEF";
        assertEquals("", LongestCommonSubsequence.getLCS(str5, str6));
    }
    @Test
    public void test_589() throws Exception {
        Long result = medianCalculator.calculateAverage(-4L, -6L);
        assertEquals(-5L, result);
    }
    @Test
    public void test_1092() throws Exception {
        MedianOfRunningArrayInteger medianFinder = new MedianOfRunningArrayInteger();
        medianFinder.insert(1);
        medianFinder.insert(3);
        medianFinder.insert(2);
        medianFinder.insert(4);
        assertEquals(2, (int) medianFinder.median());
    }
    @Test
    public void test_526() throws Exception {
        assertTrue(Isomorphic.checkStrings("abcdefghijklmnopqrstuvwxyz", "bcdefghijklmnopqrstuvwxyza"));
    }
    @Test
    public void test_1058() throws Exception {
        assertEquals(3, LevenshteinDistance.naiveLevenshteinDistance("kitten", "sitting"));
    }
    @Test
    public void test_524() throws Exception {
        assertTrue(Isomorphic.checkStrings("foo", "bar"));
    }
    @Test
    public void test_1082() throws Exception {
    assertEquals(4, RangeInSortedArray.getCountLessThan(new int[] {1, 2, 3, 3, 3, 4, 5}, 4));
    }
    @Test
    public void test_1117() throws Exception {
        assertFalse(Pangram.isPangram("+-1234 This string is not alphabetical"));
    }
    @Test
    public void test_381() throws Exception {
        assertEquals(0, PalindromicPartitioning.minimalpartitions("anavolimilovana"));
    }
    @Test
    public void test_166() throws Exception {
    assertTrue(ValidParentheses.isValid("({[]})"));
    }
    @Test
    public void test_725() throws Exception {
        assertTrue(anagrams.approach4("silent", "listen"));
    }
    @Test
    public void test_964() throws Exception {
        assertTrue(CheckVowels.hasVowels("Olaf"));
    }
    @Test
    public void test_1316() throws Exception {
    int[] weights = {10, 20, 30};
    int[] values = {60, 100};
        Knapsack.knapSack(50, weights, values);
    }
    @Test
    public void test_165() throws Exception {
    assertTrue(ValidParentheses.isValid("({})"));
    }
    @Test
    public void test_138() throws Exception {
        KnapsackMemoization knapsack = new KnapsackMemoization();
        int capacity = 0;
    int[] weights = {10, 20, 30};
    int[] profits = {60, 100, 120};
        int numOfItems = weights.length;
        int expected = 0;
        assertEquals(expected, knapsack.knapSack(capacity, weights, profits, numOfItems));
    }
    @Test
    public void test_1055() throws Exception {
    int[] arr = {-1, 0, 1, 2, -1, -4};
        int target = 0;
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(List.of(-1, -1, 2));
        expected.add(List.of(-1, 0, 1));
        ThreeSumProblem ThreeSumProblem = new ThreeSumProblem();
        List<List<Integer>> result = ThreeSumProblem.bruteForce(arr, target);
        assertEquals(expected.size(), result.size());
        assertTrue(expected.containsAll(result));
        assertTrue(result.containsAll(expected));
    }
    @Test
    public void test_720() throws Exception {
        assertFalse(anagrams.approach1("hello", "world"));
    }
    @Test
    public void test_1495() throws Exception {
        MedianOfRunningArrayLong medianOfRunningArrayLong = new MedianOfRunningArrayLong();
        assertEquals(Long.valueOf(3), medianOfRunningArrayLong.calculateAverage(Long.valueOf(2), Long.valueOf(4)));
        assertEquals(Long.valueOf(5), medianOfRunningArrayLong.calculateAverage(Long.valueOf(4), Long.valueOf(6)));
        assertEquals(Long.valueOf(10), medianOfRunningArrayLong.calculateAverage(Long.valueOf(8), Long.valueOf(12)));
    }
    @Test
    public void test_515() throws Exception {
    int[] arr = {1, 2, 3, 4, 6};
        int target = 10;
        assertEquals(1, SubsetCount.getCount(arr, target));
    }
    @Test
    public void test_398() throws Exception {
    int[] input = {2, 2, 2, 2};
    int[] expected = {2, 2, 2, 2};
        Sort012D.sort012(input);
        assertArrayEquals(expected, input);
    }
    @Test
    public void test_452() throws Exception {
        char[][] board = {
        {'a', 'b'},
        {'c', 'd'}
        };
    String[] words = {};
        List<String> expected = List.of();
        List<String> result = WordBoggle.boggleBoard(board, words);
        assertEquals(expected, result);
    }
    @Test
    public void test_260() throws Exception {
    int[] arr = {};
        int key = 0;
        assertTrue(SumOfSubset.subsetSum(arr, arr.length - 1, key));
    }
    @Test
    public void test_1417() throws Exception {
        assertTrue(CheckAnagrams.isAnagrams("hello", "olleh"));
    }
    @Test
    public void test_39() throws Exception {
    int[] val = new int[] {60, 100, 120};
    int[] wt = new int[] {10, 20, 30};
        int w = 50;
        int n = val.length;
        assertEquals(220, BruteForceKnapsack.knapSack(w, wt, val, n));
    }
    @Test
    public void test_472() throws Exception {
        assertEquals("áéíóú".toUpperCase(), Upper.toUpperCase("áéíóú"));
    }
    @Test
    public void test_1319() throws Exception {
    int[] arr = {2, 3, 5, 1, 4};
        assertEquals(50, WineProblem.wpRecursion(arr, 0, arr.length - 1));
        assertEquals(50, WineProblem.wptd(arr, 0, arr.length - 1, new int[arr.length][arr.length]));
        assertEquals(50, WineProblem.wpbu(arr));
    }
    @Test
    public void test_685() throws Exception {
        assertEquals("ABBA", LongestPalindromicSubsequence.lps("BABA"));
    }
    @Test
    public void test_148() throws Exception {
    int[] range = new int[] {-1, -1};
    RangeInSortedArray.alteredBinSearchIter(new int[] {1, 2, 3, 3, 3, 4, 5}, 3, 0, 6, range, true);
        assertEquals(2, range[0]);
    RangeInSortedArray.alteredBinSearchIter(new int[] {1, 2, 3, 3, 3, 4, 5}, 3, 0, 6, range, false);
        assertEquals(4, range[1]);
    range = new int[] {-1, -1};
    RangeInSortedArray.alteredBinSearchIter(new int[] {1, 2, 3}, 4, 0, 2, range, true);
        assertEquals(-1, range[0]);
    RangeInSortedArray.alteredBinSearchIter(new int[] {1, 2, 3}, 4, 0, 2, range, false);
        assertEquals(-1, range[1]);
    }
    @Test
    public void test_533() throws Exception {
        assertFalse(PalindromePrime.prime(1));
    }
    @Test
    public void test_301() throws Exception {
    int[] array = {};
        assertEquals(0, LongestIncreasingSubsequence.findLISLen(array));
    }
    @Test
    public void test_1164() throws Exception {
        assertEquals(0, Fibonacci.fibMemo(0));
    }
    @Test
    public void test_608() throws Exception {
    int[] arr = {1, 2, 3, 4, 5};
        int expected = 38;
        int result = MatrixChainRecursiveTopDownMemoisation.memoizedMatrixChain(arr);
        assertEquals(expected, result, "Minimum number of multiplications should be 38");
    }
    @Test
    public void test_399() throws Exception {
    int[] input = {0, 1, 2, 0, 1, 2};
    int[] expected = {0, 0, 1, 1, 2, 2};
        Sort012D.sort012(input);
        assertArrayEquals(expected, input);
    }
    @Test
    public void test_57() throws Exception {
        assertEquals(1, EditDistance.editDistance("book", "back"));
    }
    @Test
    public void test_1221() throws Exception {
        assertTrue(CheckAnagrams.isAnagramsUnicode("rat", "art"));
    }
    @Test
    public void test_1345() throws Exception {
        int[][] result = MirrorOfMatrix.mirrorMatrix(null);
        assertNull(result);
    }
    @Test
    public void test_306() throws Exception {
    int[] array = {1, 3, 5, 4, 7};
        assertEquals(4, LongestIncreasingSubsequence.findLISLen(array));
    }
    @Test
    public void test_1282() throws Exception {
        assertFalse(Isomorphic.checkStrings("ab", "aa"));
    }
    @Test
    public void test_1249() throws Exception {
        String text = "This is a simple example.";
        String pattern = "simple";
        HorspoolSearch.findFirst(pattern, text);
    }
    @Test
    public void test_1452() throws Exception {
        assertTrue(CheckVowels.hasVowels("Hello   World"));
    }
    @Test
    public void test_308() throws Exception {
        int n = 1;
        int m = 4;
        int expected = 4;
        assertEquals(expected, EggDropping.minTrials(n, m));
    }
    @Test
    public void test_1088() throws Exception {
        int[][] originalMatrix = null;
        int[][] mirroredMatrix = MirrorOfMatrix.mirrorMatrix(originalMatrix);
        assertNull(mirroredMatrix);
    }
    @Test
    public void test_1069() throws Exception {
        String a = "BBABCBCAB";
        String b = "BABCBAB";
        String expectedA = "BCBCB";
        String expectedB = "BABAB";
        assertEquals(expectedA, LongestPalindromicSubsequence.lps(a));
        assertEquals(expectedB, LongestPalindromicSubsequence.lps(b));
    }
    @Test
    public void test_54() throws Exception {
        assertEquals(5, EditDistance.minDistance("hello", ""));
    }
    @Test
    public void test_828() throws Exception {
    int[] array = {1, 2, 3, 4, 5};
        int expected = 5;
        int result = LongestIncreasingSubsequence.lis(array);
        assertEquals(expected, result, "Expected increasing subsequence length to be 5");
    array = new int[]{5, 4, 3, 2, 1};
        expected = 1;
        result = LongestIncreasingSubsequence.lis(array);
        assertEquals(expected, result, "Expected increasing subsequence length to be 1");
    array = new int[]{1, 5, 2, 3, 4};
        expected = 4;
        result = LongestIncreasingSubsequence.lis(array);
        assertEquals(expected, result, "Expected increasing subsequence length to be 4");
    }
    @Test
    public void test_1120() throws Exception {
        assertFalse(Pangram.isPangramUsingSet("The quick brown fox jumps over the azy dog"));
    }
    @Test
    public void test_621() throws Exception {
        assertTrue(RegexMatching.regexRecursion("aa", "?"));
    }
    @Test
    public void test_64() throws Exception {
        assertEquals(0, EditDistance.editDistance("abc", "abc"));
    }
    @Test
    public void test_680() throws Exception {
        assertEquals(0, longestNonRepeativeSubstring.lengthOfLongestSubstring(""));
    }
    @Test
    public void test_315() throws Exception {
    int[] arr = {70, 55, 13, 2, 99, 2, 80, 80, 80, 44, 55, 70};
        int expected = 5;
        assertEquals(expected, LongestAlternatingSubsequence.alternatingLength(arr, arr.length));
    }
    @Test
    public void test_1321() throws Exception {
        MedianOfRunningArrayByte medianFinder = new MedianOfRunningArrayByte();
        medianFinder.insert((byte) 1);
        medianFinder.insert((byte) 3);
        medianFinder.insert((byte) 2);
        medianFinder.insert((byte) 4);
        assertEquals((byte) 2, medianFinder.median().byteValue());
    }
    @Test
    public void test_58() throws Exception {
        assertEquals(0, EditDistance.editDistance("hello", "hello"));
    }
    @Test
    public void test_585() throws Exception {
    int[] arr = {2, 3, 5, 1, 4};
        assertEquals(50, WineProblem.wpbu(arr));
    }
    @Test
    public void test_345() throws Exception {
        assertEquals(0, Fibonacci.fibBinet(0));
    }
    @Test
    public void test_584() throws Exception {
    int[] arr = {5};
        int[][] strg = new int[arr.length][arr.length];
        assertEquals(5, WineProblem.wptd(arr, 0, arr.length - 1, strg));
    }
    @Test
    public void test_965() throws Exception {
        assertTrue(CheckVowels.hasVowels("Ursula"));
    }
    @Test
    public void test_59() throws Exception {
        assertEquals(5, EditDistance.editDistance("", "hello"));
    }
    @Test
    public void test_1054() throws Exception {
        String input = "10 20\n20 30\n30 40\n";
        String expectedOutput = "A(1)  =  10  x  20\n" +
        "A(2)  =  20  x  30\n" +
        "A(3)  =  30  x  40\n" +
        "---------------------\n" +
        "  -1    0  120  240\n" +
        "  -1   -1    0  240\n" +
        "  -1   -1   -1    0\n" +
        "---------------------\n" +
        "  -1    1    1    1\n" +
        "  -1   -1    2    2\n" +
        "  -1   -1   -1    3\n" +
        "---------------------\n" +
        "Optimal solution : 240\n" +
        "Optimal parens : (A1(A2A3))";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setIn(in);
        System.setOut(new PrintStream(out));
        MatrixChainMultiplication.main(null);
        assertEquals(expectedOutput.trim(), out.toString().trim());
    }
    @Test
    public void test_657() throws Exception {
        assertEquals(1, EditDistance.editDistance("a", ""));
    }
    @Test
    public void test_760() throws Exception {
        assertTrue(Palindrome.isPalindromeRecursion("racecar"));
    }
    @Test
    public void test_502() throws Exception {
        assertFalse(CheckVowels.hasVowels("12345"));
    }
    @Test
    public void test_648() throws Exception {
        int[][] grid = {
        {1, 3, 1},
        {1, 5, 1},
        {4, 2, 1}
        };
        assertEquals(7, MinimumPathSum.minimumPathSum(grid));
        grid = new int[][] {
        {1, 1, 1},
        {1, 1, 1},
        {1, 1, 1}
        };
        assertEquals(5, MinimumPathSum.minimumPathSum(grid));
    grid = new int[][] {};
        assertEquals(0, MinimumPathSum.minimumPathSum(grid));
        grid = new int[][] {
        {1, 2, 3},
        {4, 8, 2},
        {1, 5, 1}
        };
        assertEquals(8, MinimumPathSum.minimumPathSum(grid));
    }
    @Test
    public void test_113() throws Exception {
        assertEquals("a2b2c2d2e2", StringCompression.compress("aabbccddeeff"));
    }
    @Test
    public void test_151() throws Exception {
    assertEquals(0, RangeInSortedArray.getCountLessThan(new int[] {1, 2, 3}, 0));
    }
    @Test
    public void test_769() throws Exception {
        assertTrue(Palindrome.isPalindromeRecursion(null));
    }
    @Test
    public void test_1115() throws Exception {
        assertTrue(Pangram.isPangram("The quick brown fox jumps over the lazy dog"));
    }
    @Test
    public void test_605() throws Exception {
        assertTrue(CharactersSame.isAllCharactersSame("a"));
    }
    @Test
    public void test_97() throws Exception {
        assertEquals(1346269, ClimbingStairs.numberOfWays(30));
    }
    @Test
    public void test_145() throws Exception {
    assertArrayEquals(new int[] {0, 0}, RangeInSortedArray.sortedRange(new int[] {1, 2, 3}, 1));
    }
    @Test
    public void test_700() throws Exception {
    assertEquals(0, RangeInSortedArray.getCountLessThan(new int[]{1, 2, 3, 4, 5}, 1));
    }
    @Test
    public void test_1204() throws Exception {
        double[][] matrix = {
        {1, 0, 0},
        {0, 1, 0},
        {0, 0, 1}
        };
        double[][] expectedInverse = {
        {1, 0, 0},
        {0, 1, 0},
        {0, 0, 1}
        };
        double[][] actualInverse = InverseOfMatrix.invert(matrix);
        assertMatrixEquals(expectedInverse, actualInverse, 0.0001);
    }
    @Test
    public void test_99() throws Exception {
        assertEquals(2, DP.findWays(2, 2, 3));
    }
    @Test
    public void test_770() throws Exception {
        assertTrue(Palindrome.isPalindromeRecursion(""));
    }
    @Test
    public void test_555() throws Exception {
        int weightCapacity = 50;
    int[] weights = {10, 20, 30};
    int[] values = {60, 100, 120};
        assertEquals(220, Knapsack.knapSack(weightCapacity, weights, values));
    }
    @Test
    public void test_367() throws Exception {
        assertTrue(NewManShanksPrime.nthManShanksPrime(9, 1393));
    }
    @Test
    public void test_594() throws Exception {
        MedianOfRunningArrayByte medianCalculator = new MedianOfRunningArrayByte();
        assertEquals((byte) 5, medianCalculator.calculateAverage((byte) 5, (byte) 5));
        assertEquals((byte) 3, medianCalculator.calculateAverage((byte) 2, (byte) 4));
        assertEquals((byte) -3, medianCalculator.calculateAverage((byte) -2, (byte) -4));
        assertEquals((byte) 0, medianCalculator.calculateAverage((byte) -1, (byte) 1));
        assertEquals((byte) -128, medianCalculator.calculateAverage((byte) -128, (byte) -128));
        assertEquals((byte) 127, medianCalculator.calculateAverage((byte) 127, (byte) 127));
        assertEquals((byte) 0, medianCalculator.calculateAverage((byte) -128, (byte) 127));
    }
    @Test
    public void test_663() throws Exception {
    int[] nums = {-1, 0, 1, 2, -1, -4};
        int target = 0;
        List<List<Integer>> expectedResult = Arrays.asList(Arrays.asList(-1, -1, 2), Arrays.asList(-1, 0, 1));
        ThreeSumProblem th = new ThreeSumProblem();
        assertEquals(expectedResult, th.bruteForce(nums, target));
    }
    @Test
    public void test_90() throws Exception {
        assertEquals(2, ClimbingStairs.numberOfWays(2));
    }
    @Test
    public void test_1108() throws Exception {
        int end = 6;
        int[] strg = new int[end + 1];
        assertEquals(1, BoardPath.bpRS(0, 0, new int[1]));
        assertEquals(1, BoardPath.bpRS(0, 1, new int[2]));
        assertEquals(2, BoardPath.bpRS(0, 2, new int[3]));
        assertEquals(4, BoardPath.bpRS(0, 3, new int[4]));
        assertEquals(8, BoardPath.bpRS(0, 4, new int[5]));
        assertEquals(16, BoardPath.bpRS(0, 5, new int[6]));
        assertEquals(32, BoardPath.bpRS(0, 6, strg));
    }
    @Test
    public void test_592() throws Exception {
        Long result = medianCalculator.calculateAverage(9223372036854775807L, 9223372036854775807L);
        assertEquals(9223372036854775807L, result);
    }
    @Test
    public void test_450() throws Exception {
        char[][] board = {
        {'a', 'b'},
        {'c', 'd'}
        };
    String[] words = {"ab", "bc", "cd", "da", "ac", "bd"};
        List<String> expected = List.of("ab", "bc", "cd", "da");
        List<String> result = WordBoggle.boggleBoard(board, words);
        assertEquals(expected.size(), result.size());
        assertTrue(expected.containsAll(result) && result.containsAll(expected));
    }
    @Test
    public void test_752() throws Exception {
        assertEquals(18360, BoardPath.bpRS(start, end, storage));
    }
    @Test
    public void test_756() throws Exception {
        assertTrue(Palindrome.isPalindrome("racecar"));
    }
    @Test
    public void test_1354() throws Exception {
        String original = "abcdefghijklmnopqrstuvwxyz";
        String reversed = "zyxwvutsrqponmlkjihgfedcba";
        assertEquals(reversed, ReverseStringRecursive.reverse(original));
    }
    @Test
    public void test_1180() throws Exception {
        assertEquals(1, Fibonacci.fibOptimized(2));
    }
    @Test
    public void test_1102() throws Exception {
        assertEquals(1, BoardPath.bpR(0, 1));
    }
    @Test
    public void test_440() throws Exception {
        assertTrue(HorspoolSearch.getLastComparisons() > 0);
    }
    @Test
    public void test_1344() throws Exception {
        assertEquals(13, ClimbingStairs.numberOfWays(6));
    }
    @Test
    public void test_246() throws Exception {
        assertTrue(Pangram.isPangramUsingSet("The quick BROWN fox JUMPS over the LAZY dog"));
    }
    @Test
    public void test_1347() throws Exception {
    int[][] original = new int[][] {{1}};
        int[][] result = MirrorOfMatrix.mirrorMatrix(original);
        assertEquals(1, result.length);
        assertEquals(1, result[0].length);
        assertEquals(1, result[0][0]);
    }
    @Test
    public void test_77() throws Exception {
        assertEquals(6, LevenshteinDistance.naiveLevenshteinDistance("", "kitten"));
    }
    @Test
    public void test_484() throws Exception {
        assertNull(ReverseString.reverse2(null));
    }
    @Test
    public void test_1123() throws Exception {
        assertTrue(Pangram.isPangramUsingSet("The quick brown fox jumps over the lazy dog"));
    }
    @Test
    public void test_1112() throws Exception {
        String s1 = "11111";
        String s2 = "11111";
        int expectedDistance = 0;
        int actualDistance = HammingDistance.calculateHammingDistance(s1, s2);
        assertEquals(expectedDistance, actualDistance);
    }
    @Test
    public void test_779() throws Exception {
        assertTrue(Pangram.isPangram("The quick brown fox jumps over the lazy dog"));
    }
    @Test
    public void test_1427() throws Exception {
        assertFalse(CheckAnagrams.isAnagramsOptimised("hello", "world"));
    }
    @Test
    public void test_834() throws Exception {
    int[] arr = {};
        int n = arr.length;
        Assert.assertEquals(0, LongestAlternatingSubsequence.alternatingLength(arr, n));
    }
    @Test
    public void test_599() throws Exception {
        assertFalse(CharactersSame.isAllCharactersSame("aab"));
    }
    @Test
    public void test_1264() throws Exception {
        assertEquals("321cba", ReverseString.reverse("abc123"));
    }
    @Test
    public void test_469() throws Exception {
        assertEquals("".toUpperCase(), Upper.toUpperCase(""));
    }
    @Test
    public void test_587() throws Exception {
    int[] arr = {5};
        assertEquals(5, WineProblem.wpbu(arr));
    }
    @Test
    public void test_473() throws Exception {
        assertEquals("aBcÁÉÍÓÚ".toUpperCase(), Upper.toUpperCase("aBcÁÉÍÓÚ"));
    }
    @Test
    public void test_671() throws Exception {
        assertEquals(4, LevenshteinDistance.optimizedLevenshteinDistance("test", ""));
    }
    @Test
    public void test_646() throws Exception {
        String x1 = "AGGTAB";
        String y1 = "GXTXAYB";
        int expected1 = 7;
        assertEquals(expected1, ShortestSuperSequence.shortestSuperSequence(x1, y1));
    }
    @Test
    public void test_1012() throws Exception {
    int[] p = {2, 3, 4};
        int expectedOutput = 14;
        assertEquals(expectedOutput, MatrixChainRecursiveTopDownMemoisation.memoizedMatrixChain(p));
    }
    @Test
    public void test_1037() throws Exception {
    assertFalse(PartitionProblem.partition(new int[]{1, 2, 3, 5}));
    }
    @Test
    public void test_131() throws Exception {
        char[] values7 = "a".toCharArray();
        Rotation.rotation(values7, 1);
        assertArrayEquals("a".toCharArray(), values7);
    }
    @Test
    public void test_1502() throws Exception {
        MedianOfRunningArrayByte medianCalculator = new MedianOfRunningArrayByte();
        Byte result = medianCalculator.calculateAverage((byte) 100, (byte) 200);
        assertEquals(Optional.of((byte) 150), result);
    }
    @Test
    public void test_1160() throws Exception {
        assertEquals(6, UniquePaths.uniquePaths(3, 3));
    }
    @Test
    public void test_1489() throws Exception {
        int numberProcesses = 3;
        int numberMachines = 3;
    int[][] run = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    int[][] transfer = {{0, 1, 2}, {1, 0, 3}, {2, 3, 0}};
        OptimalJobScheduling scheduler = new OptimalJobScheduling(numberProcesses, numberMachines, run, transfer);
        scheduler.execute();
    int[][] expectedCosts = {{1, 2, 3}, {6, 8, 10}, {15, 18, 21}};
        for (int i = 0;
        i < numberProcesses;
        i++) {
            for (int j = 0; j < numberMachines; j++) {
                assertEquals(expectedCosts[i][j], scheduler.getCost(i, j));
            }
        }
    }
    @Test
    public void test_359() throws Exception {
        Solution solution = new Solution();
        assertEquals("!@#@!", solution.longestPalindrome("!@#@!"));
    }
    @Test
    public void test_158() throws Exception {
        int[][] input = {
        {1, 2, 3, 4},
        {5, 6, 7, 8}
        };
        int[][] expected = {
        {4, 3, 2, 1},
        {8, 7, 6, 5}
        };
        int[][] result = MirrorOfMatrix.mirrorMatrix(input);
        assertArrayEquals(expected, result, "Expected mirrored matrix for rectangular matrix.");
    }
    @Test
    public void test_467() throws Exception {
        assertEquals("ABC".toUpperCase(), Upper.toUpperCase("ABC"));
    }
    @Test
    public void test_943() throws Exception {
        Double result = testArray.calculateAverage(2.0d, 3.0d);
        assertEquals(2.5d, result);
        result = testArray.calculateAverage(5.5d, 7.7d);
        assertEquals(6.6d, result);
        result = testArray.calculateAverage(1000000.0d, 5000000.0d);
        assertEquals(3000000.0d, result);
    }
    @Test
    public void test_1131() throws Exception {
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(Arrays.asList(1, 3, 5));
        matrix.add(Arrays.asList(2, 4, 6));
        matrix.add(Arrays.asList(7, 8, 9));
        int result = MedianOfMatrix.median(matrix);
        assertEquals(5, result);
    }
    @Test
    public void test_783() throws Exception {
    }
    
    @Test
    public void testIsPangramUsingSet() {
        assertTrue(Pangram.isPangramUsingSet("The quick brown fox jumps over the lazy dog"));
    }
    @Test
    public void test_198() throws Exception {
        assertEquals("olleh", ReverseStringRecursive.reverse("hello"));
    }
    @Test
    public void test_1272() throws Exception {
        ColorContrastRatio contrastRatio = new ColorContrastRatio();
        Color black = Color.BLACK;
        Color white = Color.WHITE;
        assertEquals(21, contrastRatio.getContrastRatio(black, white), 0.00001);
        Color foreground = new Color(23, 103, 154);
        Color background = new Color(226, 229, 248);
        assertEquals(4.878363954846178, contrastRatio.getContrastRatio(foreground, background), 0.00001);
    }
    @Test
    public void test_586() throws Exception {
    int[] arr = {};
        assertEquals(0, WineProblem.wpbu(arr));
    }
    @Test
    public void test_777() throws Exception {
        String s1 = "abcde";
        String s2 = "axcyez";
        try {
            HammingDistance.calculateHammingDistance(s1, s2);
            fail("Exception expected");
        } catch (Exception e) {
            assertEquals(e.getMessage(), "String lengths must be equal");
        }
    }
    @Test
    public void test_79() throws Exception {
        assertEquals(0, LevenshteinDistance.optimizedLevenshteinDistance("kitten", "kitten"));
    }
    @Test
    public void test_969() throws Exception {
        ColorContrastRatio ratio = new ColorContrastRatio();
        Color black = Color.BLACK;
        Color white = Color.WHITE;
        double contrastBlackWhite = ratio.getContrastRatio(black, white);
        assertEquals(21.0, contrastBlackWhite, 0.1);
    }
    @Test
    public void test_149() throws Exception {
    assertEquals(5, RangeInSortedArray.getCountLessThan(new int[] {1, 2, 3, 3, 3, 4, 5}, 3));
    }
    @Test
    public void test_1322() throws Exception {
        assertTrue(CharactersSame.isAllCharactersSame(""));
    }
    @Test
    public void test_265() throws Exception {
    int[] arr = {-3, 4, -12, 5, -2};
        int key = 0;
        assertTrue(SumOfSubset.subsetSum(arr, arr.length - 1, key));
    }
    @Test
    public void test_385() throws Exception {
        assertEquals("", Lower.toLowerCase(""));
    }
    @Test
    public void test_157() throws Exception {
        int[][] input = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
        };
        int[][] expected = {
        {3, 2, 1},
        {6, 5, 4},
        {9, 8, 7}
        };
        int[][] result = MirrorOfMatrix.mirrorMatrix(input);
        assertArrayEquals(expected, result, "Expected mirrored matrix for square matrix.");
    }
    @Test
    public void test_644() throws Exception {
        LetterCombinationsOfPhoneNumber.generateNumberToCharMap();
    }
    @Test
    public void test_124() throws Exception {
        assertEquals("a", Rotation.rotation("a", 1));
    }
    @Test
    public void test_96() throws Exception {
        assertEquals(10946, ClimbingStairs.numberOfWays(20));
    }
    @Test
    public void test_159() throws Exception {
        int[][] input = {
        {1, 2, 3},
        {4, 5},
        {6, 7, 8}
        };
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            MirrorOfMatrix.mirrorMatrix(input);
        });
        String expectedMessage = "The input is not a matrix.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    public void test_729() throws Exception {
        String input = "";
        String expected = "";
        String actual = ReverseStringRecursive.reverse(input);
        assertEquals(expected, actual);
    }
    @Test
    public void test_1048() throws Exception {
        assertEquals(7, EditDistance.editDistance("example", ""));
    }
    @Test
    public void test_950() throws Exception {
    double[][] mat = {{1, 0, 1}, {1, 1, 0}, {1, 0, 1}};
        double expectedSparsity = 0.33;
        double result = Sparsity.sparsity(mat);
        assertEquals(expectedSparsity, result, 0.01);
    }
    @Test
    public void test_573() throws Exception {
        int[][] image = {
        {0, 0, 0, 0, 0, 0, 0},
        {0, 3, 3, 3, 3, 0, 0},
        {0, 3, 0, 0, 3, 0, 0},
        {0, 3, 0, 0, 3, 3, 3},
        {0, 3, 3, 3, 0, 0, 3},
        {0, 0, 0, 3, 0, 0, 3},
        {0, 0, 0, 3, 3, 3, 3},
        };
        int[][] expectedImage = {
        {0, 0, 0, 0, 0, 0, 0},
        {0, 3, 3, 3, 3, 0, 0},
        {0, 3, 5, 5, 3, 0, 0},
        {0, 3, 5, 5, 3, 3, 3},
        {0, 3, 3, 3, 5, 5, 3},
        {0, 0, 0, 3, 5, 5, 3},
        {0, 0, 0, 3, 3, 3, 3},
        };
        BoundaryFill.boundaryFill(image, 2, 2, 5, 3);
        assertArrayEquals(expectedImage, image);
    }
    @Test
    public void test_318() throws Exception {
    int[] array = {1, -2, 3};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            MinimumSumPartition.minimumSumPartition(array);
        });
        assertEquals("Input array should not contain negative number(s).", exception.getMessage());
    }
    @Test
    public void test_958() throws Exception {
        assertNull(ReverseString.reverse(null));
    }
    @Test
    public void test_460() throws Exception {
        assertFalse(anagrams.approach2("deal", "load"));
    }
    @Test
    public void test_782() throws Exception {
        assertFalse(Pangram.isPangram("\u0000/\\"));
    }
    @Test
    public void test_650() throws Exception {
        assertEquals(1, EditDistance.minDistance("a", ""));
    }
    @Test
    public void test_1437() throws Exception {
        String text = "hello world";
        String pattern = "world";
        HorspoolSearch.findFirst(pattern, text);
    }
    @Test
    public void test_88() throws Exception {
        assertEquals(1, ClimbingStairs.numberOfWays(0));
    }
    @Test
    public void test_773() throws Exception {
        assertTrue(Palindrome.isPalindrome("a"));
    }
    @Test
    public void test_118() throws Exception {
        assertEquals("cdefab", Rotation.rotation("abcdef", 2));
    }
    @Test
    public void test_161() throws Exception {
        MedianOfRunningArrayInteger medianCalculator = new MedianOfRunningArrayInteger();
        assertEquals(-1, medianCalculator.calculateAverage(Integer.MAX_VALUE, Integer.MAX_VALUE));
        assertEquals(0, medianCalculator.calculateAverage(Integer.MIN_VALUE, Integer.MIN_VALUE));
    }
    @Test
    public void test_1438() throws Exception {
        int actualComparisons = HorspoolSearch.getLastComparisons();
        assertTrue(actualComparisons > 0);
    }
    @Test
    public void test_991() throws Exception {
        PalindromePrime.functioning(1);
    }
    @Test
    public void test_1114() throws Exception {
        String s1 = "";
        String s2 = "";
        int expectedDistance = 0;
        int actualDistance = HammingDistance.calculateHammingDistance(s1, s2);
        assertEquals(expectedDistance, actualDistance);
    }
    @Test
    public void test_1035() throws Exception {
        MedianOfRunningArrayFloat medianFinder = new MedianOfRunningArrayFloat();
        medianFinder.insert(1.0f);
        medianFinder.insert(3.0f);
        medianFinder.insert(2.0f);
        medianFinder.insert(4.0f);
        assertEquals(2.5f, medianFinder.median(), 0.0f);
    }
    @Test
    public void test_687() throws Exception {
        assertEquals("", LongestPalindromicSubsequence.lps("ABC"));
    }
    @Test
    public void test_84() throws Exception {
        assertEquals(6, LevenshteinDistance.optimizedLevenshteinDistance("", "kitten"));
    }
    @Test
    public void test_470() throws Exception {
        assertNull(Upper.toUpperCase(null));
    }
    @Test
    public void test_132() throws Exception {
        char[] values1 = "abcdef".toCharArray();
        Rotation.reverse(values1, 0, 5);
        assertArrayEquals("fedcba".toCharArray(), values1);
    }
    @Test
    public void test_1250() throws Exception {
        int expectedComparisons = HorspoolSearch.getLastComparisons();
        int actualComparisons = 7;
        assertEquals(expectedComparisons, actualComparisons);
    }
    @Test
    public void test_1425() throws Exception {
        assertTrue(CheckAnagrams.isAnagramsOptimised("listen", "silent"));
    }
    @Test
    public void test_86() throws Exception {
        String string1 = "kitten";
        String string2 = "sitting";
        assertEquals(LevenshteinDistance.naiveLevenshteinDistance(string1, string2), LevenshteinDistance.optimizedLevenshteinDistance(string1, string2));
    }
    @Test
    public void test_521() throws Exception {
    int[] arr = {1, 2, 3, 4, 5};
        int target = 5;
        assertEquals(SubsetCount.getCount(arr, target), SubsetCount.getCountSO(arr, target));
    }
    @Test
    public void test_1173() throws Exception {
        assertEquals(1, Fibonacci.fibBotUp(2));
    }
    @Test
    public void test_1491() throws Exception {
        int weightCapacity = -5;
    int[] weights = {2, 3, 5, 7};
    int[] values = {10, 20, 30, 40};
        try {
            Knapsack.knapSack(weightCapacity, weights, values);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Input arrays must not be null and must have the same length.", e.getMessage());
        }
    }
    @Test
    public void test_735() throws Exception {
        assertEquals(0, WordLadder.ladderLength("hit", "coda", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    }
    @Test
    public void test_672() throws Exception {
        assertEquals(4, LevenshteinDistance.optimizedLevenshteinDistance("", "test"));
    }
    @Test
    public void test_1422() throws Exception {
        assertTrue(CheckAnagrams.isAnagramsUnicode("listen", "silent"));
    }
    @Test
    public void test_655() throws Exception {
        assertEquals(4, EditDistance.minDistance("delete", "leet"));
    }
    @Test
    public void test_169() throws Exception {
        assertFalse(ValidParentheses.isValid("("));
    }
    @Test
    public void test_111() throws Exception {
        assertEquals("a2b3c2", StringCompression.compress("aabbbcc"));
    }
    @Test
    public void test_109() throws Exception {
        assertEquals("abc", StringCompression.compress("abc"));
    }
    @Test
    public void test_68() throws Exception {
        assertEquals(1, EditDistance.editDistance("abc", "abd"));
    }
    @Test
    public void test_75() throws Exception {
        assertEquals(1, LevenshteinDistance.naiveLevenshteinDistance("sittin", "sittin"));
    }
    @Test
    public void test_1234() throws Exception {
        assertTrue(WildcardMatching.isMatch("cb", "?a"));
    }
    @Test
    public void test_545() throws Exception {
        PalindromePrime.functioning(5);
    }
    @Test
    public void test_1318() throws Exception {
        int[][] image = {
        {0, 0, 0, 0, 0, 0, 0},
        {0, 3, 3, 3, 3, 0, 0},
        {0, 3, 0, 0, 3, 0, 0},
        {0, 3, 0, 0, 3, 3, 3},
        {0, 3, 3, 3, 0, 0, 3},
        {0, 0, 0, 3, 0, 0, 3},
        {0, 0, 0, 3, 3, 3, 3},
        };
        int[][] expectedImage = {
        {0, 0, 0, 0, 0, 0, 0},
        {0, 5, 5, 5, 5, 0, 0},
        {0, 5, 0, 0, 5, 0, 0},
        {0, 5, 0, 0, 5, 5, 5},
        {0, 5, 5, 5, 0, 0, 5},
        {0, 0, 0, 5, 0, 0, 5},
        {0, 0, 0, 5, 5, 5, 5},
        };
        BoundaryFill.boundaryFill(image, 2, 2, 5, 3);
        assertArrayEquals(expectedImage, image);
    }
    @Test
    public void test_244() throws Exception {
        assertTrue(Pangram.isPangram2("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"));
    }
    @Test
    public void test_689() throws Exception {
        assertEquals("AA", LongestPalindromicSubsequence.lps("CallりてくださいAACE"));
    }
    @Test
    public void test_439() throws Exception {
        HorspoolSearch.findFirst("test", "this is a test string");
    }
    @Test
    public void test_1424() throws Exception {
        assertFalse(CheckAnagrams.isAnagramsUnicode("hello", "world"));
    }
    @Test
    public void test_702() throws Exception {
    assertEquals(5, RangeInSortedArray.getCountLessThan(new int[]{1, 2, 3, 4, 5}, 6));
    }
    @Test
    public void test_341() throws Exception {
        assertEquals(3, Fibonacci.fibMemo(4));
    }
    @Test
    public void test_69() throws Exception {
        assertEquals(1, EditDistance.editDistance("xyz", "xy"));
    }
    @Test
    public void test_56() throws Exception {
        assertEquals(3, EditDistance.editDistance("kitten", "sitting"));
    }
    @Test
    public void test_523() throws Exception {
        assertTrue(Isomorphic.checkStrings("paper", "title"));
    }
    @Test
    public void test_196() throws Exception {
        assertEquals("", ReverseStringRecursive.reverse(""));
    }
    @Test
    public void test_441() throws Exception {
        HorspoolSearch.findFirst("hello", "this is a test string");
    }
    @Test
    public void test_220() throws Exception {
        int[] strg = new int[6];
        assertEquals(1, BoardPath.bpRS(0, 0, strg));
        strg = new int[6];
        assertEquals(0, BoardPath.bpRS(1, 0, strg));
        strg = new int[6];
        assertEquals(1, BoardPath.bpRS(3, 3, strg));
        strg = new int[6];
        assertEquals(4, BoardPath.bpRS(0, 3, strg));
        strg = new int[6];
        assertEquals(24, BoardPath.bpRS(0, 5, strg));
    }
    @Test
    public void test_696() throws Exception {
        String actual = PermuteString.swapString("ABC", 1, 2);
        String expected = "BAC";
        assertEquals(expected, actual);
    }
    @Test
    public void test_512() throws Exception {
    int[] arr = {5};
        int target = 5;
        assertEquals(1, SubsetCount.getCount(arr, target));
    }
    @Test
    public void test_1109() throws Exception {
        int end = 6;
        int[] strg = new int[end + 1];
        assertEquals(1, BoardPath.bpIS(0, 0, new int[1]));
        assertEquals(1, BoardPath.bpIS(0, 1, new int[2]));
        assertEquals(2, BoardPath.bpIS(0, 2, new int[3]));
        assertEquals(4, BoardPath.bpIS(0, 3, new int[4]));
        assertEquals(8, BoardPath.bpIS(0, 4, new int[5]));
        assertEquals(16, BoardPath.bpIS(0, 5, new int[6]));
        assertEquals(32, BoardPath.bpIS(0, 6, strg));
    }
    @Test
    public void test_50() throws Exception {
        assertEquals(3, EditDistance.minDistance("kitten", "sitting"));
    }
    @Test
    public void test_291() throws Exception {
    int[] array = {1, 2, 3, 4, 5};
        int predictedAnswer = 15;
        assertTrue(KadaneAlgorithm.maxSum(array, predictedAnswer));
    }
    @Test
    public void test_574() throws Exception {
        int[][] image = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
        };
        assertEquals(5, BoundaryFill.getPixel(image, 1, 1));
        assertEquals(9, BoundaryFill.getPixel(image, 2, 2));
        assertEquals(1, BoundaryFill.getPixel(image, 0, 0));
    }
    @Test
    public void test_1277() throws Exception {
        assertTrue(Isomorphic.checkStrings("egg", "add"));
    }
    @Test
    public void test_358() throws Exception {
        Solution solution = new Solution();
        assertEquals("Noon", solution.longestPalindrome("Noon"));
    }
    @Test
    public void test_199() throws Exception {
        assertEquals("olleh dlrow", ReverseStringRecursive.reverse("world hello"));
    }
    @Test
    public void test_144() throws Exception {
    assertArrayEquals(new int[] {-1, -1}, RangeInSortedArray.sortedRange(new int[] {0, 1, 2}, 3));
    }
    @Test
    public void test_295() throws Exception {
    int[] array = {-2, -3, 4, -1, -2, 1, 5, -3};
        int predictedAnswer = 7;
        assertTrue(KadaneAlgorithm.maxSum(array, predictedAnswer));
    }
    @Test
    public void test_748() throws Exception {
        assertEquals(0, BoardPath.bpR(start+1, start));
    }
    @Test
    public void test_1185() throws Exception {
        assertEquals(0, Fibonacci.fibBinet(0));
    }
    @Test
    public void test_353() throws Exception {
        assertEquals(1597, Fibonacci.fibBinet(17));
    }
    @Test
    public void test_602() throws Exception {
        assertFalse(CharactersSame.isAllCharactersSame("aaabbb"));
    }
    @Test
    public void test_89() throws Exception {
        assertEquals(1, ClimbingStairs.numberOfWays(1));
    }
    @Test
    public void test_1228() throws Exception {
    int[] input2 = { 2, 1, 0 };
    int[] expected2 = { 0, 1, 2 };
        Sort012D.sort012(input2);
        assertArrayEquals(expected2, input2);
    }
    @Test
    public void test_322() throws Exception {
    int[] array = {0, 0, 0, 0};
        assertEquals(0, MinimumSumPartition.minimumSumPartition(array));
    }
    @Test
    public void test_1091() throws Exception {
    int[][] originalMatrix = {{1, 2, 3}, {4, 5}, {7, 8, 9}};
        MirrorOfMatrix.mirrorMatrix(originalMatrix);
    }
    @Test
    public void test_698() throws Exception {
    assertArrayEquals(new int[]{5, 5}, RangeInSortedArray.sortedRange(new int[]{1, 2, 3, 3, 3, 4, 5}, 4));
    }
    @Test
    public void test_117() throws Exception {
        assertEquals("A2a2B2b2", StringCompression.compress("AAaaBBbb"));
    }
    @Test
    public void test_1349() throws Exception {
    int[][] original = new int[][] {{1, 2}, {3, 4, 5}};
        MirrorOfMatrix.mirrorMatrix(original);
    }
    @Test
    public void test_766() throws Exception {
        assertFalse(Palindrome.isPalindromeTwoPointer("hello"));
    }
    @Test
    public void test_1252() throws Exception {
        MedianOfRunningArrayDouble medianFinder = new MedianOfRunningArrayDouble();
        medianFinder.insert(1.0);
        medianFinder.insert(3.0);
        medianFinder.insert(2.0);
        medianFinder.insert(4.0);
        assertEquals(2.5, medianFinder.median(), 0.0);
    }
    @Test
    public void test_1330() throws Exception {
        String s = "4193 with words";
        int expected = 4193;
        int result = MyAtoi.myAtoi(s);
        assertEquals(expected, result);
    }
    @Test
    public void test_1119() throws Exception {
    }
    
    @Test
    public void testIsPangramUsingSet() {
        assertTrue(Pangram.isPangramUsingSet("The quick brown fox jumps over the lazy dog"));
    }
    @Test
    public void test_765() throws Exception {
        assertFalse(Palindrome.isPalindromeTwoPointer("java"));
    }
    @Test
    public void test_160() throws Exception {
        MedianOfRunningArrayInteger medianCalculator = new MedianOfRunningArrayInteger();
        assertEquals(2, medianCalculator.calculateAverage(1, 3));
        assertEquals(0, medianCalculator.calculateAverage(-1, 1));
        assertEquals(-2, medianCalculator.calculateAverage(-3, -1));
        assertEquals(0, medianCalculator.calculateAverage(0, 0));
        assertEquals(Integer.MAX_VALUE - 1, medianCalculator.calculateAverage(Integer.MAX_VALUE, Integer.MAX_VALUE - 2));
        assertEquals(Integer.MIN_VALUE + 1, medianCalculator.calculateAverage(Integer.MIN_VALUE, Integer.MIN_VALUE + 2));
    }
    @Test
    public void test_466() throws Exception {
        assertEquals("aBcDeF".toUpperCase(), Upper.toUpperCase("aBcDeF"));
    }
    @Test
    public void test_822() throws Exception {
        String str1 = "ABCDEF";
        String str2 = "ACDFE";
        assertEquals("ACDFE", LongestCommonSubsequence.getLCS(str1, str2));
    }
    @Test
    public void test_236() throws Exception {
        assertFalse(Pangram.isPangram(""));
    }
    @Test
    public void test_664() throws Exception {
    int[] nums = {-1, 0, 1, 2, -1, -4};
        int target = 0;
        List<List<Integer>> expectedResult = Arrays.asList(Arrays.asList(-1, -1, 2), Arrays.asList(-1, 0, 1));
        ThreeSumProblem th = new ThreeSumProblem();
        assertEquals(expectedResult, th.twoPointer(nums, target));
    }
    @Test
    public void test_1285() throws Exception {
        assertFalse(Isomorphic.checkStrings("abc", "ab"));
    }
    @Test
    public void test_647() throws Exception {
        String x2 = "ABC";
        String y2 = "BCA";
        int expected2 = 3;
        assertEquals(expected2, ShortestSuperSequence.shortestSuperSequence(x2, y2));
    }
    @Test
    public void test_775() throws Exception {
        assertTrue(Palindrome.isPalindromeTwoPointer("a"));
    }
    @Test
    public void test_192() throws Exception {
    assertTrue(ValidParentheses.isValid("({[({})]})[]{}"));
    }
    @Test
    public void test_1315() throws Exception {
        Knapsack.knapSack(50, null, null);
    }
    @Test
    public void test_776() throws Exception {
        String s1 = "abcde";
        String s2 = "axcye";
        int expectedHammingDistance = 2;
        try {
            int actualHammingDistance = HammingDistance.calculateHammingDistance(s1, s2);
            assertEquals(expectedHammingDistance, actualHammingDistance);
        } catch (Exception e) {
            fail("Exception not expected");
        }
    }
    @Test
    public void test_1311() throws Exception {
        int numberProcesses = 3;
        int numberMachines = 2;
        int[][] run = {
        {2, 3},
        {4, 1},
        {5, 6}
        };
        int[][] transfer = {
        {0, 2},
        {2, 0}
        };
        OptimalJobScheduling scheduler = new OptimalJobScheduling(numberProcesses, numberMachines, run, transfer);
        scheduler.execute();
        assertEquals(2, scheduler.getCost(0, 0));
        assertEquals(5, scheduler.getCost(0, 1));
        assertEquals(6, scheduler.getCost(1, 0));
        assertEquals(5, scheduler.getCost(1, 1));
        assertEquals(11, scheduler.getCost(2, 0));
        assertEquals(6, scheduler.getCost(2, 1));
    }
    @Test
    public void test_153() throws Exception {
    assertEquals(0, RangeInSortedArray.getCountLessThan(new int[] {}, 1));
    }
    @Test
    public void test_1455() throws Exception {
    int[] arr = {2, 3, 5, 6, 8, 10};
        int target = 10;
        int expected = 3;
        int actual = SubsetCount.getCountSO(arr, target);
        assertEquals(expected, actual);
    }
    @Test
    public void test_661() throws Exception {
        assertEquals(3, EditDistance.editDistance("sea", "eat"));
    }
    @Test
    public void test_201() throws Exception {
        assertEquals("!olleh", ReverseStringRecursive.reverse("hello!"));
    }
    @Test
    public void test_1076() throws Exception {
        String result = Rotation.rotation("abcdef", 2);
        assertEquals("cdefab", result);
    }
    @Test
    public void test_1257() throws Exception {
        assertEquals("", Upper.toUpperCase(""));
    }
    @Test
    public void test_383() throws Exception {
        assertEquals("abc", Lower.toLowerCase("ABC"));
    }
    @Test
    public void test_123() throws Exception {
        assertEquals("", Rotation.rotation("", 2));
    }
    @Test
    public void test_1411() throws Exception {
        double[][] a = {
        {1, 2, 3},
        {0, 1, 4},
        {5, 6, 0}
        };
        double[][] expectedInverse = {
        {-24.0, 18.0, -5.0},
        {8.0, -11.0, 2.0},
        {5.0, -6.0, 1.0}
        };
        double[][] inverse = InverseOfMatrix.invert(a);
        for (int i = 0;
        i < a.length;
        i++) {
            for (int j = 0; j < a[0].length; j++) {
                assertEquals(expectedInverse[i][j], inverse[i][j], 0.01);
            }
        }
    }
    @Test
    public void test_112() throws Exception {
        assertEquals("", StringCompression.compress(""));
    }
    @Test
    public void test_125() throws Exception {
        char[] values1 = "abcdef".toCharArray();
        Rotation.rotation(values1, 2);
        assertArrayEquals("cdefab".toCharArray(), values1);
    }
    @Test
    public void test_1118() throws Exception {
        assertFalse(Pangram.isPangram("\u0000/\\"));
    }
    @Test
    public void test_1332() throws Exception {
        MedianOfRunningArrayFloat medianCalculator = new MedianOfRunningArrayFloat();
        Float a = 10.0f;
        Float b = 20.0f;
        Float expected = 15.0f;
        Float actual = medianCalculator.calculateAverage(a, b);
        assertEquals(expected, actual, 0.0f);
    }
    @Test
    public void test_1279() throws Exception {
        assertTrue(Isomorphic.checkStrings("paper", "title"));
    }
    @Test
    public void test_51() throws Exception {
        assertEquals(1, EditDistance.minDistance("book", "back"));
    }
    @Test
    public void test_402() throws Exception {
    int[] input = {};
    int[] expected = {};
        Sort012D.sort012(input);
        assertArrayEquals(expected, input);
    }
    @Test
    public void test_155() throws Exception {
        int[][] input = new int[0][0];
        int[][] result = MirrorOfMatrix.mirrorMatrix(input);
        assertEquals(0, result.length, "Expected empty matrix for empty input.");
    }
    @Test
    public void test_55() throws Exception {
        assertEquals(0, EditDistance.minDistance("", ""));
    }
    @Test
    public void test_487() throws Exception {
        assertTrue(CheckVowels.hasVowels("AEIOU"));
    }
    @Test
    public void test_649() throws Exception {
        assertEquals(0, EditDistance.minDistance("", ""));
    }
    @Test
    public void test_577() throws Exception {
    int[] arr = {2, 3, 5, 1, 4};
        assertEquals(50, WineProblem.wpRecursion(arr, 0, arr.length - 1));
    }
    @Test
    public void test_1072() throws Exception {
        assertEquals("ab", StringCompression.compress("ab"));
    }
    @Test
    public void test_1350() throws Exception {
        MedianOfRunningArrayInteger medianCalculator = new MedianOfRunningArrayInteger();
        assertEquals(Optional.of(3), medianCalculator.calculateAverage(2, 4));
        assertEquals(Optional.of(5), medianCalculator.calculateAverage(4, 6));
        assertEquals(Optional.of(-3), medianCalculator.calculateAverage(-4, -2));
        assertEquals(Optional.of(-5), medianCalculator.calculateAverage(-6, -4));
        assertEquals(Optional.of(0), medianCalculator.calculateAverage(-2, 2));
        assertEquals(Optional.of(2), medianCalculator.calculateAverage(-4, 8));
    }
    @Test
    public void test_200() throws Exception {
        assertEquals("321", ReverseStringRecursive.reverse("123"));
    }
    @Test
    public void test_67() throws Exception {
        assertEquals(1, EditDistance.minDistance("xyz", "xy"));
    }
    @Test
    public void test_1111() throws Exception {
        String s1 = "10101";
        String s2 = "10011";
        int expectedDistance = 2;
        int actualDistance = HammingDistance.calculateHammingDistance(s1, s2);
        assertEquals(expectedDistance, actualDistance);
    }
    @Test
    public void test_522() throws Exception {
        assertTrue(Isomorphic.checkStrings("egg", "add"));
    }
    @Test
    public void test_1122() throws Exception {
        assertFalse(Pangram.isPangramUsingSet("\u0000/\\"));
    }
    @Test
    public void test_1100() throws Exception {
        String s1 = "(()";
        String s2 = ")()())";
        String s3 = "";
        String s4 = "()(()";
        String s5 = "()()";
        assertEquals(2, LongestValidParentheses.getLongestValidParentheses(s1));
        assertEquals(4, LongestValidParentheses.getLongestValidParentheses(s2));
        assertEquals(0, LongestValidParentheses.getLongestValidParentheses(s3));
        assertEquals(2, LongestValidParentheses.getLongestValidParentheses(s4));
        assertEquals(4, LongestValidParentheses.getLongestValidParentheses(s5));
    }
    @Test
    public void test_152() throws Exception {
    assertEquals(3, RangeInSortedArray.getCountLessThan(new int[] {1, 2, 3}, 3));
    }
    @Test
    public void test_43() throws Exception {
    int[][] grid = {{1, 2, 3}};
        assertEquals(6, MinimumPathSum.minimumPathSum(grid));
    }
    @Test
    public void test_1367() throws Exception {
        String s1 = "hello";
        String s2 = "hell";
        try {
            HammingDistance.calculateHammingDistance(s1, s2);
            fail("Expected Exception");
        } catch (Exception e) {
            assertEquals("String lengths must be equal", e.getMessage());
        }
    }
    @Test
    public void test_147() throws Exception {
    assertArrayEquals(new int[] {-1, -1}, RangeInSortedArray.sortedRange(new int[] {}, 1));
    }
    @Test
    public void test_180() throws Exception {
        assertTrue(ValidParentheses.isValid(""));
    }
    @Test
    public void test_651() throws Exception {
        assertEquals(1, EditDistance.minDistance("", "a"));
    }
    @Test
    public void test_300() throws Exception {
    int[] array = {2, 2, 2, 2, 2};
        assertEquals(1, LongestIncreasingSubsequence.lis(array));
    }
    @Test
    public void test_1353() throws Exception {
        assertEquals("olleh", ReverseStringRecursive.reverse("hello"));
    }
    @Test
    public void test_1258() throws Exception {
        assertNull(Upper.toUpperCase(null));
    }
    @Test
    public void test_42() throws Exception {
    int[][] grid = {{5}};
        assertEquals(5, MinimumPathSum.minimumPathSum(grid));
    }
    @Test
    public void test_762() throws Exception {
        assertFalse(Palindrome.isPalindromeRecursion("hello"));
    }
    @Test
    public void test_85() throws Exception {
        assertEquals(6, LevenshteinDistance.optimizedLevenshteinDistance("kitten", ""));
    }
    @Test
    public void test_224() throws Exception {
    int[] arr = {};
        assertFalse(SubsetSum.subsetSum(arr, 1));
        assertTrue(SubsetSum.subsetSum(arr, 0));
    }
    @Test
    public void test_600() throws Exception {
        assertFalse(CharactersSame.isAllCharactersSame("12345"));
    }
    @Test
    public void test_1490() throws Exception {
        int weightCapacity = 10;
    int[] weights = {2, 3, 5, 7};
    int[] values = {10, 20, 30, 40};
        int expectedMaxValue = 60;
        int actualMaxValue = Knapsack.knapSack(weightCapacity, weights, values);
        assertEquals(expectedMaxValue, actualMaxValue);
    }
    @Test
    public void test_1439() throws Exception {
        MedianOfRunningArrayDouble median = new MedianOfRunningArrayDouble();
        assertEquals(2.5, median.calculateAverage(2.0, 3.0), 0.01);
        assertEquals(1.5, median.calculateAverage(1.0, 2.0), 0.01);
        assertEquals(0.5, median.calculateAverage(0.0, 1.0), 0.01);
    }
    @Test
    public void test_1078() throws Exception {
        String input = "ABC";
        StringBuilder output = new StringBuilder();
        output.append("ABC\n");
        output.append("ACB\n");
        output.append("BAC\n");
        output.append("BCA\n");
        output.append("CBA\n");
        output.append("CAB\n");
        PermuteString.generatePermutation(input, 0, input.length());
    }
    @Test
    public void test_479() throws Exception {
        assertEquals("", ReverseString.reverse(""));
    }
    @Test
    public void test_1128() throws Exception {
        assertFalse(Pangram.isPangram2("The quick brown fox jumps over the azy dog"));
    }
    @Test
    public void test_1168() throws Exception {
        assertEquals(3, Fibonacci.fibMemo(4));
    }
    @Test
    public void test_1077() throws Exception {
        char[] values = "abcdef".toCharArray();
        Rotation.rotation(values, 2);
        assertEquals("cdefab", new String(values));
    }
    @Test
    public void test_384() throws Exception {
        assertEquals("abcabc", Lower.toLowerCase("abcABC"));
    }
    @Test
    public void test_156() throws Exception {
    int[][] input = {{1}};
    int[][] expected = {{1}};
        int[][] result = MirrorOfMatrix.mirrorMatrix(input);
        assertArrayEquals(expected, result, "Expected mirrored matrix for single element matrix.");
    }
    @Test
    public void test_923() throws Exception {
    int[] coins = {2, 4, 5};
        int amount1 = 12;
        int expectedCombinations1 = 4;
        int expectedMinCoins1 = 3;
        System.out.println("Test case 1");
        System.out.println("Expected number of combinations: " + expectedCombinations1);
        System.out.println("Actual number of combinations: " + CoinChange.change(coins, amount1));
        System.out.println("Expected minimum number of coins: " + expectedMinCoins1);
        System.out.println("Actual minimum number of coins: " + CoinChange.minimumCoins(coins, amount1));
        System.out.println();
        int amount2 = 13;
        int expectedCombinations2 = 7;
        int expectedMinCoins2 = 3;
        System.out.println("Test case 2");
        System.out.println("Expected number of combinations: " + expectedCombinations2);
        System.out.println("Actual number of combinations: " + CoinChange.change(coins, amount2));
        System.out.println("Expected minimum number of coins: " + expectedMinCoins2);
        System.out.println("Actual minimum number of coins: " + CoinChange.minimumCoins(coins, amount2));
    }
    @Test
    public void test_202() throws Exception {
        String longString = "This is a long string to test the reverse method.";
        String reversedLongString = ".dohtem esrever eht tset ot gnirts gnol a si sihT";
        assertEquals(reversedLongString, ReverseStringRecursive.reverse(longString));
    }
    @Test
    public void test_108() throws Exception {
        assertEquals("a", StringCompression.compress("a"));
    }
    @Test
    public void test_142() throws Exception {
    assertArrayEquals(new int[] {2, 4}, RangeInSortedArray.sortedRange(new int[] {1, 2, 3, 3, 3, 4, 5}, 3));
    }
    @Test
    public void test_87() throws Exception {
        String string1 = "abcdefghijklmnopqrstuvwxyz";
        String string2 = "xyzabcdefghijklmnopqrstuvw";
        assertEquals(LevenshteinDistance.naiveLevenshteinDistance(string1, string2), LevenshteinDistance.optimizedLevenshteinDistance(string1, string2));
    }
    @Test
    public void test_1038() throws Exception {
    int[] val = {60, 100, 120};
    int[] wt = {10, 20, 30};
        int W = 50;
        int n = val.length;
        int expectedValue = 220;
        int actualValue = Knapsack.knapSack(W, wt, val);
        assertEquals(expectedValue, actualValue);
    }
    @Test
    public void test_786() throws Exception {
        assertFalse(Pangram.isPangramUsingSet("\u0000/\\"));
    }
    @Test
    public void test_662() throws Exception {
        assertEquals(4, EditDistance.editDistance("delete", "leet"));
    }
    @Test
    public void test_263() throws Exception {
    int[] arr = {3, 34, 4, 12, 5, 2};
        int key = 0;
        assertTrue(SumOfSubset.subsetSum(arr, arr.length - 1, key));
    }
    @Test
    public void test_114() throws Exception {
        assertEquals("12a3", StringCompression.compress("111aa"));
    }
    @Test
    public void test_755() throws Exception {
        assertTrue(Palindrome.isPalindrome("madam"));
    }
    @Test
    public void test_1444() throws Exception {
        assertEquals(null, Upper.toUpperCase(null));
    }
    @Test
    public void test_1039() throws Exception {
        int[][] grid = {
        {1, 3, 1},
        {1, 5, 1},
        {4, 2, 1}
        };
        int result = MinimumPathSum.minimumPathSum(grid);
        assertEquals(7, result);
    }
    @Test
    public void test_478() throws Exception {
        assertEquals("321cba", ReverseString.reverse("abc123"));
    }
    @Test
    public void test_83() throws Exception {
        assertEquals(0, LevenshteinDistance.optimizedLevenshteinDistance("", ""));
    }
    @Test
    public void test_581() throws Exception {
    int[] arr = {2, 3, 5, 1, 4};
        int[][] strg = new int[arr.length][arr.length];
        assertEquals(50, WineProblem.wptd(arr, 0, arr.length - 1, strg));
    }
}