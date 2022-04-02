package problems.interview;

import java.util.HashMap;
import java.util.Map;

// input    - A3B2C3D4
// output   - AAABBCCCDDDD
public class StringExpand {

    public static void main(String[] args) {
        StringExpand stringExpand = new StringExpand();
        String result = stringExpand.expandString("A3B2C3D4");
        System.out.println(result);
    }

    public String expandString(String s) {

        StringBuilder result = new StringBuilder();

        for (int i = 1; i <= s.length(); i = i + 2) {
            int charOccur = Integer.parseInt(String.valueOf(s.charAt(i)));
            for (int j = 1; j <= charOccur; j++) {
                result.append(s.charAt(i - 1));
            }
        }

        return result.toString();
    }

}