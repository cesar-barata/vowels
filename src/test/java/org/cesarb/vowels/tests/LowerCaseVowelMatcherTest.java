package org.cesarb.vowels.tests;

import org.cesarb.vowels.matcher.LowerCaseVowelMatcher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LowerCaseVowelMatcherTest {

    @Test
    public void isMatch_shouldMatchOnlyVowels() {
        LowerCaseVowelMatcher vowelMatcher = new LowerCaseVowelMatcher();

        "aeiou".chars().forEach(ch ->
                assertTrue(vowelMatcher.isMatch((char) ch))
        );

        "bcdfghjklmnpqrstvwxyz".chars().forEach(ch ->
                assertFalse(vowelMatcher.isMatch((char) ch))
        );
    }

    @Test
    public void getMatches_shouldReturnListWithAllVowelsInWord() {
        String text = "word";
        LowerCaseVowelMatcher matcher = new LowerCaseVowelMatcher();
        var result = matcher.getMatches(text);
        assertEquals(1, result.size());
        assertEquals('o', result.get(0));

        text = "easy";
        result = matcher.getMatches(text);
        assertEquals(2, result.size());
        assertEquals('e', result.get(0));
        assertEquals('a', result.get(1));

        text = "meet";
        result = matcher.getMatches(text);
        assertEquals(2, result.size());
        assertEquals('e', result.get(0));
        assertEquals('e', result.get(1));
    }

}
