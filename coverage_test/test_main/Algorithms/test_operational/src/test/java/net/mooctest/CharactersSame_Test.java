package net.mooctest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.*;

public class CharactersSame_Test {

    @Test
    @Timeout(4000)
    public void testEmptyString() {
        assertTrue(CharactersSame.isAllCharactersSame(""));
    }

    @Test
    @Timeout(4000)
    public void testSameCharacters() {
        assertTrue(CharactersSame.isAllCharactersSame("aaa"));
    }

    @Test
    @Timeout(4000)
    public void testDifferentCharacters() {
        assertFalse(CharactersSame.isAllCharactersSame("aab"));
    }

    @Test
    @Timeout(4000)
    public void testSingleCharacter() {
        assertTrue(CharactersSame.isAllCharactersSame("a"));
    }


}
