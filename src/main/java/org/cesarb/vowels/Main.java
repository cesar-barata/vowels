package org.cesarb.vowels;

import org.cesarb.vowels.matcher.CharMatcher;
import org.cesarb.vowels.matcher.LowerCaseVowelMatcher;
import org.cesarb.vowels.parser.LowerCaseWordParser;
import org.cesarb.vowels.parser.WordParser;
import org.cesarb.vowels.presenter.FilePercentagePresenter;
import org.cesarb.vowels.presenter.Presenter;
import org.cesarb.vowels.stats.MatchPercentage;
import org.cesarb.vowels.stats.TextPercentage;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        WordParser parser = new LowerCaseWordParser();
        CharMatcher matcher = new LowerCaseVowelMatcher();
        MatchPercentage matchPercentage = new MatchPercentage(matcher);
        TextPercentage textPercentage = new TextPercentage(parser, matchPercentage);

        Path input  = Paths.get("./INPUT.txt");
        Path output = Paths.get("./OUTPUT.txt");

        Presenter presenter = new FilePercentagePresenter(textPercentage, input, output);
        presenter.show();
    }
}
