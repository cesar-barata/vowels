package org.cesarb.vowels.presenter;

import org.cesarb.vowels.Triple;
import org.cesarb.vowels.stats.TextPercentage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.Set;

public class FilePercentagePresenter implements Presenter {
    private Path inputPath;
    private Path outputPath;
    private TextPercentage textPercentage;

    public FilePercentagePresenter(TextPercentage textPercentage,
                                   Path inputPath, Path outputPath) {
        this.textPercentage = textPercentage;
        this.inputPath = inputPath;
        this.outputPath = outputPath;
    }

    private String formatVowels(Set<Character> vowels) {
        return vowels.toString()
                .replaceAll("\\[", "{")
                .replaceAll("\\]", "}");
    }

    private String formatPercentage(double percentage) {
        return String.valueOf(percentage);
    }

    private String formatOutput(Triple<String, Set<Character>,
            Double> result) {
        String out = "(" +
                formatVowels(result.second()) +
                ", " +
                result.first().length() +
                ")" +
                " -> " +
                formatPercentage(result.third()) +
                "\n";
        return out;
    }

    public void show() {
        try {
            String textInput = Files.readString(inputPath);
            Files.writeString(outputPath, "");
            textPercentage
                    .computeFor(textInput)
                    .map(this::formatOutput)
                    .forEach(output -> {
                        try {
                            Files.writeString(outputPath, output, StandardOpenOption.APPEND);
                        } catch (IOException e) {
                            System.err.println("Error while writing to " +
                                    "output file: " + e.getMessage());
                        }
                    });
        } catch (IOException e) {
            System.err.println("Error while reading input file: "
                    + e.getMessage());
        }
    }
}
