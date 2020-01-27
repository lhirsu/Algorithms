package problems.maximum_subarray;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Shamos implements MaximumSubArrayAlgo {

    @Override
    public String getName() {
        return "Shamos algorithm";
    }

    @Override
    public MaximumSubArray findMaxSubArray(int[] array) {
        return findMaxSubArray(array, 0, array.length - 1);
    }

    private MaximumSubArray findMaxCrossingSubArray(int[] array, int low, int mid, int high) {
        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;
        int sum = 0;
        int maxLeft = 0;
        int maxRight = 0;

        for (int i = mid + 1; i <= high; i++) {
            sum = sum + array[i];
            if (sum > rightSum) {
                rightSum = sum;
                maxRight = i;
            }
        }

        sum = 0;

        for (int i = mid; i >= low; i--) {
            sum = sum + array[i];
            if (sum > leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }

        return new MaximumSubArray(maxLeft, maxRight, leftSum + rightSum);
    }

    private MaximumSubArray findMaxSubArray(int[] array, int low, int high) {

        if (high == low) {
            return new MaximumSubArray(low, high, array[low]); // base case: only one element

        } else {
            int mid = (low + high) / 2;

            MaximumSubArray leftArray = findMaxSubArray(array, low, mid);
            MaximumSubArray rightArray = findMaxSubArray(array, mid + 1, high);
            MaximumSubArray crossArray = findMaxCrossingSubArray(array, low, mid, high);

            if (leftArray.getSum() >= rightArray.getSum() && leftArray.getSum() >= crossArray.getSum()) {
                return leftArray;
            } else if (rightArray.getSum() >= leftArray.getSum() && rightArray.getSum() >= crossArray.getSum()) {
                return rightArray;
            } else {
                return crossArray;
            }

        }
    }

}