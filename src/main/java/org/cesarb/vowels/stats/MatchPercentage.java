package org.cesarb.vowels.stats;

import org.cesarb.vowels.Triple;
import org.cesarb.vowels.matcher.CharMatcher;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class MatchPercentage {
    private CharMatcher matcher;

    public MatchPercentage(CharMatcher matcher) {
        this.matcher = matcher;
    }

    public CharMatcher getMatcher() {
        return matcher;
    }

    public Triple<String, Set<Character>, Double> computeFor(String word) {
        List<Character> matchesList = matcher.getMatches(word);
        Set<Character> matches = new LinkedHashSet<>(matchesList);
        double recPercentage = (double) word.length() / matches.size();
        return new Triple<>(word, matches, recPercentage);
    }
}
