package org.cesarb.vowels.parser;

import java.util.stream.Stream;

public interface WordParser {
    Stream<String> parse(String text);
}
