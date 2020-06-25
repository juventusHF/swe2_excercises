package ch.juventus.optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalExamples {

    public static void main(String[] args) {
        List<String> letters = Arrays.asList("a", "b", "c", "d");

        Optional<String> selectedLetter = letters.stream()
                .filter(letter -> letter.equals("b"))
                .findAny();

        System.out.println(selectedLetter.orElse("Not found"));

        Optional<String> otherSelectedLetter = letters.stream()
                .filter(letter -> letter.equals("z"))
                .findAny();

        System.out.println(otherSelectedLetter.orElse("Not found"));
    }
}
