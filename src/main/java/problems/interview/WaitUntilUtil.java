package problems.interview;

import java.util.function.Supplier;

public class WaitUntilUtil {

    public static boolean waitUntil(Supplier<Boolean> condition, long timeoutMs, long pollMs) {

        long endTime = System.currentTimeMillis() + timeoutMs;

        while (System.currentTimeMillis() < endTime) {
            if (condition.get()) {
                return true;
            }

            try {
                System.out.println("Sleeping..");
                Thread.sleep(pollMs);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return false;
            }
        }

        return condition.get();
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        boolean result = waitUntil(
                () -> System.currentTimeMillis() - start >= 5000,
                5000,
                500
        );

        System.out.println(result); // true
    }

}