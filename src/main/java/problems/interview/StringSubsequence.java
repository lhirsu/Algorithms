package problems.interview;

import java.util.ArrayList;
import java.util.List;

public class StringSubsequence {

    public static void main(String[] args) {

        StringSubsequence test = new StringSubsequence();

        System.out.println(test.isSubsequence("bac", "abacga"));
        System.out.println(test.isSubsequence("bac", "abag"));
        System.out.println(test.isSubsequence("bac", "abcag"));
        System.out.println(test.isSubsequence("bac", "zcbabcag"));
        System.out.println(test.isSubsequence("bac", "zcbabagc"));
    }

    public boolean isSubsequence(String string1, String string2) {
        List<List<Integer>> occurrenceIndexes = new ArrayList<>();

        for (int i = 0; i < string1.length(); i++) {
            occurrenceIndexes.add(isCharInString(string1.charAt(i), string2));
        }

        System.out.println(occurrenceIndexes);

        if (occurrenceIndexes.stream().anyMatch(List::isEmpty)) {
            return false;
        }

        boolean isSubsequence = false;

        // first char
        for (int firstCharIndex : occurrenceIndexes.get(0)) {

            for (int i = 1; i < occurrenceIndexes.size(); i++) {
                if (occurrenceIndexes.get(i).contains(firstCharIndex + 1)) { // check if chars are consecutive
                    firstCharIndex += 1;
                    if (i == occurrenceIndexes.size() - 1) {
                        isSubsequence = true;
                    }
                } else {
                    break;
                }
            }
        }

        return isSubsequence;
    }

    public List<Integer> isCharInString(char c, String testString) {
        List<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < testString.length(); i++) {
            if (c == testString.charAt(i)) {
                indexes.add(i);
            }
        }

        return indexes;
    }

}