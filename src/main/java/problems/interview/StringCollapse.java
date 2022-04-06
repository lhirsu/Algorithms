package problems.interview;

import java.util.HashMap;
import java.util.Map;

// input    - AAABBCCCDDDD
// output   - A3B2C3D4
public class StringCollapse {

    public static void main(String[] args) {
        StringCollapse stringCollapse = new StringCollapse();
//        String result = stringCollapse.collapseString("AAABBCCCDDDD");
        String result = stringCollapse.collapseStringForRepeatedSequences("AAABBCCCDDDD");
        System.out.println(result);
    }

    public String collapseString(String s) {

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            String key = String.valueOf(s.charAt(i));
            int count = map.getOrDefault(key, 0);
            map.put(key, count + 1);
        }

        return map.entrySet()
                .stream()
                .map(e -> e.getKey() + e.getValue())
                .reduce("", String::concat);
    }

    public String collapseStringForRepeatedSequences(String s) {

        String currLetter = "";
        int currOccur = 0;
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            if (i > 0) {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    currOccur = currOccur + 1;
                } else {
                    result += currLetter + currOccur;
                    // reset
                    currLetter = String.valueOf(s.charAt(i));
                    currOccur = 1;
                }
            } else {
                currLetter = String.valueOf(s.charAt(i));
                currOccur = 1;
            }
        }

        result += currLetter + currOccur; // this is for the last sequence
        return result;
    }

}