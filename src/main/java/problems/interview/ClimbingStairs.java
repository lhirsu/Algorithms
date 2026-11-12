package problems.interview;

public class ClimbingStairs {

    /**
     * You are climbing a staircase. It takes n steps to reach the top.
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     * <p>
     * Example 1:
     * <p>
     * Input: n = 2
     * Output: 2
     * Explanation: There are two ways to climb to the top.
     * <p>
     * 1. 1 step + 1 step
     * 2. 2 steps
     * <p>
     * Example 2:
     * <p>
     * Input: n = 3
     * Output: 3
     * Explanation: There are three ways to climb to the top.
     * <p>
     * 1. 1 step + 1 step + 1 step
     * 2. 1 step + 2 steps
     * 3. 2 steps + 1 step
     * <p>
     * Example 3:
     * <p>
     * Input: n = 4
     * Output: 5
     * <p>
     * 1. 1 step + 1 step + 1 step + 1 step
     * 2. 2 steps + 1 step + 1 step
     * 3. 2 steps + 2 steps
     * 4. 1 step + 1 step + 2 steps
     * 5. 1 step + 2 steps + 1 step
     */

    public static void main(String[] args) {
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(4));
        System.out.println(climbStairs(5));
        System.out.println(climbStairs(6));
        System.out.println(climbStairs(7));
    }

    public static int climbStairs(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be >= 0");
        }

        if (n == 2) {
            return 2;
        }

        if (n == 3) {
            return 3;
        }

        return climbStairs(n - 1) + climbStairs(n - 2);
    }

}
