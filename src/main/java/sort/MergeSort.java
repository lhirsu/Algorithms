package sort;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class MergeSort extends SortingAlgo {

    @Override
    public String getName() {
        return "Merge Sort";
    }

    /**
     * Runs merge sort algorithm to sort the array.
     *
     * @param toBeSorted the array to be sorted
     */
    @Override
    public void sort(int[] toBeSorted) {
        sort(toBeSorted, 0, toBeSorted.length - 1);
    }

    /**
     * Sorts the specified range of the array.
     *
     * @param toBeSorted the array to be sorted
     * @param left       the index of the first element, inclusive, to be sorted
     * @param right      the index of the last element, inclusive, to be sorted
     */
    private void sort(int[] toBeSorted, int left, int right) {

        if (left < right) {
            int middle = (left + right) / 2;
            sort(toBeSorted, left, middle);
            sort(toBeSorted, middle + 1, right);
            merge(toBeSorted, left, middle, right);
        }

    }

    /**
     * Merges array[left..middle] to array[middle+1..right] in a sorted way.
     *
     * @param array  the original array to be sorted
     * @param left   the index of the first element
     * @param middle the index of the middle element
     * @param right  the index of the last element
     */
    private void merge(int[] array, int left, int middle, int right) {

        int[] leftArray = Arrays.copyOfRange(array, left, middle + 1);
        int[] rightArray = Arrays.copyOfRange(array, middle + 1, right + 1);

        int i = 0;
        int j = 0;

        for (int k = left; k <= right; k++) {

            if (i < leftArray.length && j < rightArray.length) {

                if (leftArray[i] <= rightArray[j]) {
                    array[k] = leftArray[i];
                    i = i + 1;
                } else {
                    array[k] = rightArray[j];
                    j = j + 1;
                }

            } else if (i < leftArray.length) {
                array[k] = leftArray[i];
                i = i + 1;
            } else {
                array[k] = rightArray[j];
                j = j + 1;
            }

        }

    }

}