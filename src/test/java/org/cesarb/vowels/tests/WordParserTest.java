package org.cesarb.vowels.tests;

import org.cesarb.vowels.parser.IWordParser;
import org.cesarb.vowels.parser.WordParser;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordParserTest {
    @Test
    public void parse_shouldParseFreeTextIntoACollectionOfWords() {
        String text = "this is a text";
        String[] expected = { "this", "is", "a", "text" };
        IWordParser parser = new WordParser();
        assertEquals(
                Arrays.asList(expected),
                parser.parse(text).collect(Collectors.toList())
        );
    }

    @Test
    public void parse_shouldSplitStringsOnAnyNumberOfWhiteSpaces() {
        String text = "  this   is    a     text    ";
        String[] expected = { "this", "is", "a", "text" };

        WordParser parser = new WordParser();
        Stream<String> result = parser.parse(text);
        assertArrayEquals(expected, result.toArray());
    }

    @Test
    public void parse_shouldIgnorePunctiationOnText() {
        String text = "this, is a text.";
        String[] expected = { "this", "is", "a", "text" };

        WordParser parser = new WordParser();
        Stream<String> result = parser.parse(text);
        assertArrayEquals(expected, result.toArray());
    }
}
