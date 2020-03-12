package org.cesarb.vowels.parser;

import java.util.Arrays;
import java.util.stream.Stream;

public class WordParser implements IWordParser {
    public Stream<String> parse(String text) {
        return Arrays
                .stream(
                        text.strip().split("\\s+")
                )
                .map(word -> word.replaceAll("[^a-zA-Z]", ""));
    }
}
