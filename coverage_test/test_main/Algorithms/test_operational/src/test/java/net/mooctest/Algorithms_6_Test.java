package net.mooctest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
public class Algorithms_6_Test
{
    @BeforeEach
    public void setUp() {
        LetterCombinationsOfPhoneNumber.generateNumberToCharMap();
    }
    @Test
    public void test_18() throws Exception {
    int[] numbers = {2, 0, 3};
        List<String> result = LetterCombinationsOfPhoneNumber.printWords(numbers, numbers.length, 0, "");
        assertEquals(List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"), result);
    }
}