package problems.interview;

import java.util.*;

public class FlakyTestsFinder {

    public static List<String> findFlakyTests(List<String> results) {
        Map<String, Set<String>> history = new HashMap<>();

        for (String result : results) {

            String[] parts = result.split(":");

            if (parts.length != 2) {
                continue;
            }

            String testName = parts[0];
            String status = parts[1];

            history.computeIfAbsent(testName, k -> new HashSet<>()).add(status);
        }

        List<String> flaky = new ArrayList<>();

        for (Map.Entry<String, Set<String>> entry : history.entrySet()) {
            Set<String> statuses = entry.getValue();

            if (statuses.contains("PASS") && statuses.contains("FAIL")) {
                flaky.add(entry.getKey());
            }
        }

        Collections.sort(flaky);

        return flaky;
    }

    public static void main(String[] args) {
        List<String> input = Arrays.asList(
                "LoginTest:PASS",
                "CartTest:FAIL",
                "LoginTest:FAIL",
                "CartTest:FAIL",
                "LoginTest:PASS",
                "LoginTest:FAIL",
                "PaymentTest:PASS",
                "PaymentTest:FAIL"
        );

        System.out.println(findFlakyTests(input)); // [LoginTest, PaymentTest]
    }
}