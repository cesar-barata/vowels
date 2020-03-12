package org.cesarb.vowels.parser;

import java.util.stream.Stream;

public interface IWordParser {
    Stream<String> parse(String text);
}
