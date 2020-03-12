package org.cesarb.vowels.matcher;

import java.util.*;
import java.util.stream.Collectors;

public interface CharMatcher {
    Set<Character> validChars();

    default boolean isMatch(char c) {
        return validChars().contains(c);
    }

    default List<Character> getMatches(String word) {
        return word
                .chars()
                .filter(ch -> isMatch((char) ch))
                .mapToObj(i -> (char) i)
                .collect(Collectors.toList());
    }
}