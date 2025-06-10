package problems.interview;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Palindrome {

    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        System.out.println("caiac could be a palindrome: " + palindrome.couldBePalindrome("caiac"));
        System.out.println("ccaai could be a palindrome: " + palindrome.couldBePalindrome("ccaai"));
        System.out.println("etalate could be a palindrome: " + palindrome.couldBePalindrome("etalate"));
        System.out.println("etalat could be a palindrome: " + palindrome.couldBePalindrome("etalat"));

        System.out.println("------------------------------------------------------------");

        System.out.println("caiac is palindrome: " + palindrome.isPalindrome("caiac"));
        System.out.println("ccaai is palindrome: " + palindrome.isPalindrome("ccaai"));
        System.out.println("etalate is palindrome: " + palindrome.isPalindrome("etalate"));
        System.out.println("etalat is palindrome: " + palindrome.isPalindrome("etalat"));
    }

    public boolean couldBePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character key = s.charAt(i);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        return map.values().stream().filter(value -> value % 2 == 1).count() <= 1;
    }

    public boolean isPalindrome(String s) {
        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            deque.add(s.charAt(i));
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }

        return true;
    }

}