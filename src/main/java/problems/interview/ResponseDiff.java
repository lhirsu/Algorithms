package problems.interview;

import java.util.*;

public class ResponseDiff {

    public static List<String> diffKeys(Map<String, Object> expected, Map<String, Object> actual) {
        Set<String> allKeys = new HashSet<>();

        allKeys.addAll(expected.keySet());
        allKeys.addAll(actual.keySet());

        List<String> diffs = new ArrayList<>();

        for (String key : allKeys) {
            if (!Objects.equals(expected.get(key), actual.get(key))) {
                diffs.add(key);
            }
        }

        Collections.sort(diffs);

        return diffs;
    }

    public static void main(String[] args) {

        Map<String, Object> a = new HashMap<>();
        a.put("id", 1);
        a.put("status", "ACTIVE");
        a.put("retries", 3);

        Map<String, Object> b = new HashMap<>();
        b.put("id", 1);
        b.put("status", "INACTIVE");
        b.put("timeout", 30);

        System.out.println(diffKeys(a, b)); // [retries, status, timeout]
    }

}