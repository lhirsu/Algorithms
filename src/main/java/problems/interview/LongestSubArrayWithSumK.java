package problems.interview;

public class LongestSubArrayWithSumK {

    public static void main(String[] args) {
        LongestSubArrayWithSumK test = new LongestSubArrayWithSumK();
        System.out.println(test.getLengthOfTheLongestSubArrayWhoseSumIsEqualToK(new Integer[]{1, -1, 5, -2, 3}, 3));
        System.out.println(test.getLengthOfTheLongestSubArrayWhoseSumIsEqualToK(new Integer[]{1, -1, 5, -1, 3}, 3));
        System.out.println(test.getLengthOfTheLongestSubArrayWhoseSumIsEqualToK(new Integer[]{1, -1, 5, -1, 3}, 8));
        System.out.println(test.getLengthOfTheLongestSubArrayWhoseSumIsEqualToK(new Integer[]{1, -1, 5, -5, 5}, 5));
    }

    public int getLengthOfTheLongestSubArrayWhoseSumIsEqualToK(Integer[] numbers, int k) {
        int longestSubArrayLength = 0;

        for (int i = 0; i < numbers.length; i++) {

            int currentSubArrayLength = 0;
            int currentSum = 0;

            for (int j = i; j < numbers.length; j++) {

                int currentNumber = numbers[j];
                currentSubArrayLength += 1;
                currentSum += currentNumber;

                if (currentSum == k && longestSubArrayLength < currentSubArrayLength) {
                    longestSubArrayLength = currentSubArrayLength;
                }

            }
        }

        return longestSubArrayLength;
    }

}