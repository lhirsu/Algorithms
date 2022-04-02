package problems.interview;

import java.util.HashMap;
import java.util.Map;

public class Palindrome {

    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        System.out.println("caiac could be a palindrome: " + palindrome.couldBePalindrome("caiac"));
        System.out.println("ccaai could be a palindrome: " + palindrome.couldBePalindrome("ccaai"));
        System.out.println("etalate could be a palindrome: " + palindrome.couldBePalindrome("etalate"));
        System.out.println("etalat could be a palindrome: " + palindrome.couldBePalindrome("etalat"));
    }

    public boolean couldBePalindrome(String s) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            String key = String.valueOf(s.charAt(i));
            int count = map.getOrDefault(key, 0);
            map.put(key, count + 1);
        }

        long counter = map.entrySet()
                .stream()
                .filter(entry -> entry.getValue() % 2 == 1)
                .count();

        return counter <= 1;
    }

}