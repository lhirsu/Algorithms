package problems.interview;

import java.util.HashMap;
import java.util.Map;

// input    - AAABBCCCDDDD
// output   - A3B2C3D4
public class StringCollapse {

    public static void main(String[] args) {
        StringCollapse stringCollapse = new StringCollapse();
        String result = stringCollapse.collapseString("AAABBCCCDDDD");
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

}