package org.cesarb.vowels.matcher;

import java.util.HashSet;
import java.util.Set;

public class LowerCaseVowelMatcher implements CharMatcher {
    private final String VOWELS = "aeiou";

    private Set<Character> validChars;

    public LowerCaseVowelMatcher() {
        validChars = new HashSet<>();
        VOWELS.chars().forEach(c -> validChars.add((char) c));
    }

    @Override
    public Set<Character> validChars() {
        return validChars;
    }
}