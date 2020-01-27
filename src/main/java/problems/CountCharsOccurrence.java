package problems;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CountCharsOccurrence {

    private String countCharOccurrence(String input) {

        StringBuilder toBeReturned = new StringBuilder();
        char[] array = input.toCharArray();
        char currChar = array[0];
        int counter = 1;

        for (int i = 1; i < array.length; i++) {

            if (array[i] == array[i - 1]) {
                counter++;
            } else {
                toBeReturned.append(currChar).append(counter);
                currChar = array[i];
                counter = 1;
            }

            if (i == array.length - 1) {
                toBeReturned.append(currChar).append(counter);
            }

        }

        return toBeReturned.toString();
    }

    public static void main(String[] args) {

        String testString = "aabbbccccaaa";
        String testString1 = "abcdbbcccca";
        String result = new CountCharsOccurrence().countCharOccurrence(testString1);
        log.info("Result is " + result);

    }

}