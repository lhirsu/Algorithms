package problems.interview;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatedChar {

    public static void main(String[] args) {

        FirstNonRepeatedChar test = new FirstNonRepeatedChar();

        System.out.println(test.getFirstNonRepeatedChar("Swiss"));   // returns w
        System.out.println(test.getFirstNonRepeatedChar("Swi"));     // returns S
        System.out.println(test.getFirstNonRepeatedChar("wwi"));     // returns i

        System.out.println(test.getFirstNonRepeatedCharWithMap("Swiss"));    // returns w
        System.out.println(test.getFirstNonRepeatedCharWithMap("Swi"));      // returns S
    }

    public String getFirstNonRepeatedChar(String input) {

        for (int i = 0; i < input.length(); i++) {

            String currChar = String.valueOf(input.charAt(i));
            int currCharOccurrence = 1;

            for (int j = 0; j < input.length(); j++) {
                if (i != j && currChar.equalsIgnoreCase(String.valueOf(input.charAt(j)))) {
                    currCharOccurrence += 1;
                }
            }

            if (currCharOccurrence == 1) {
                return currChar;
            }

        }

        return null;
    }

    public String getFirstNonRepeatedCharWithMap(String input) {

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            String currChar = String.valueOf(input.charAt(i));
            map.put(currChar, map.getOrDefault(currChar, 0) + 1);
        }

        return map.entrySet().stream()
                .filter(entry -> !(input.contains(entry.getKey().toLowerCase()) && input.contains(entry.getKey().toUpperCase())))
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst().orElse(null);
    }

}