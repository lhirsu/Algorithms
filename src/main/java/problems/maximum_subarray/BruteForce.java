package problems.maximum_subarray;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BruteForce implements MaximumSubArrayAlgo {

    @Override
    public String getName() {
        return "Brute Force algorithm";
    }

    @Override
    public MaximumSubArray findMaxSubArray(int[] array) {

        int sum = Integer.MIN_VALUE;
        int currSum = 0;
        int start = 0;
        int end = 0;
        int s;

        for (int i = 0; i < array.length; i++) {

            s = i;

            for (int j = i; j < array.length; j++) {
                currSum = currSum + array[j];
                if (currSum > sum) {
                    sum = currSum;
                    start = s;
                    end = j;
                }
            }

            currSum = 0;

        }

        return new MaximumSubArray(start, end, sum);
    }

}