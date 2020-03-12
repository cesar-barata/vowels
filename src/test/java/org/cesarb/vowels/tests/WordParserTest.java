package org.cesarb.vowels.tests;

import org.cesarb.vowels.parser.IWordParser;
import org.cesarb.vowels.parser.WordParser;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordParserTest {
    @Test
    public void parse_parsesFreeTextIntoACollectionOfWords() {
        String text = "this is a text";
        String[] expected = { "this", "is", "a", "text" };
        IWordParser parser = new WordParser();
        assertEquals(
                Arrays.asList(expected),
                parser.parse(text).collect(Collectors.toList())
        );
    }
}
