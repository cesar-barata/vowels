package org.cesarb.vowels.parser;

import java.util.Arrays;
import java.util.stream.Stream;

public class LowerCaseWordParser implements WordParser {
    public Stream<String> parse(String text) {
        return Arrays
                .stream(
                        text.strip().toLowerCase().split("\\s+")
                )
                .map(word -> word.replaceAll("[^a-zA-Z]", ""));
    }
}
