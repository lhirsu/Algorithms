package problems.maximum_subarray;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Kadane implements MaximumSubArrayAlgo {

    @Override
    public String getName() {
        return "Kadane algorithm";
    }

    @Override
    public MaximumSubArray findMaxSubArray(int[] array) {
        MaximumSubArray maximumSubArray;
        int sum = 0;
        int maxSum = 0;

        int start = 0;
        int end = 0;
        int s = 0;

        boolean allNegative = true;
        int maxValue = Integer.MIN_VALUE;
        int maxValueIndex = 0;

        for (int i = 0; i < array.length; i++) {

            int currValue = array[i];
            sum = sum + currValue;

            if (sum < 0) {
                sum = 0;
                s = i + 1;
            }

            if (sum > maxSum) {
                maxSum = sum;
                start = s;
                end = i;
            }

            if (allNegative) {
                if (currValue < 0) {
                    if (currValue > maxValue) {
                        maxValue = currValue;
                        maxValueIndex = i;
                    }
                } else {
                    allNegative = false;
                }
            }

        }

        if (allNegative) {
            maximumSubArray = new MaximumSubArray(maxValueIndex, maxValueIndex, maxValue);
        } else {
            maximumSubArray = new MaximumSubArray(start, end, maxSum);
        }

        return maximumSubArray;
    }


    public static void main(String[] args) {

        int[] testArray = new int[]{-2, -3, 4, -1, -2, 1, 5, -3};

        int[] testArray1 = new int[]{-2, -5, 2, 3, -3, -1, 0, 2};

        int[] testArray2 = new int[]{-2, -3, 4, -1, -2, 1, 5, -6, -2, 8, 1, -2};

        int[] testArray3 = new int[]{-2, 8, 1, -6, -2, -3, 4, -1, -2, 1, 5, -2};

        int[] testArray4 = new int[]{-2, -3, -1, -8, -7};


        MaximumSubArray result = new Kadane().findMaxSubArray(testArray3);
        log.info("Largest Sum within Contiguous Subarray - Kadane's algorithm O(n) - is " + result.getSum() + " and the subarray is [" + result.getLow() + ".." + result.getHigh() + "]");

    }

}
