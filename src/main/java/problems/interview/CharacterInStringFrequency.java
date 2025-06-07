package problems.interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CharacterInStringFrequency {

    public static final String SPACE = " ";

    public static void main(String[] args) {
        CharacterInStringFrequency test = new CharacterInStringFrequency();
        String result = test.getSentenceWithFrequencyAddendum("Ana are mere", Arrays.asList("m"));
        System.out.println(result);
    }

    public String getSentenceWithFrequencyAddendum(String sentence, List<String> discardList) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        StringBuilder toReturn = new StringBuilder();

        for (int i = 0; i < sentence.length(); i++) {
            String currChar = String.valueOf(sentence.charAt(i)).toLowerCase();
            if (!currChar.equals(SPACE) && !discardList.contains(currChar)) {
                frequencyMap.put(currChar, frequencyMap.getOrDefault(currChar, 0) + 1);
            }
        }

        for (int i = 0; i < sentence.length(); i++) {
            String currChar = String.valueOf(sentence.charAt(i)).toLowerCase();
            toReturn.append(currChar);
            if (frequencyMap.get(currChar) != null) {
                toReturn.append(frequencyMap.get(currChar));
            }
        }

        return toReturn.toString();
    }

}