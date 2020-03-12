package org.cesarb.vowels.stats;

import org.cesarb.vowels.Triple;
import org.cesarb.vowels.parser.WordParser;

import java.util.Set;
import java.util.stream.Stream;

public class TextPercentage {
    private WordParser parser;
    private MatchPercentage matchPercentage;

    public TextPercentage(WordParser parser, MatchPercentage matchPercentage) {
        this.parser = parser;
        this.matchPercentage = matchPercentage;
    }

    public Stream<Triple<String, Set<Character>, Double>> computeFor(String text) {
        return parser.parse(text)
                .map(word -> matchPercentage.computeFor(word));
    }
}
