package sort;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InsertionSort extends SortingAlgo {

    @Override
    public String getName() {
        return "Insertion Sort";
    }

    /**
     * Runs insertion sort algorithm to sort the array.
     *
     * @param toBeSorted the array to be sorted
     */
    @Override
    public void sort(int[] toBeSorted) {

        for (int j = 1; j < toBeSorted.length; j++) {
            int key = toBeSorted[j];
            int i = j - 1;
            while (i >= 0 && toBeSorted[i] > key) {
                toBeSorted[i + 1] = toBeSorted[i];
                i = i - 1;
            }
            toBeSorted[i + 1] = key;
        }

    }

}