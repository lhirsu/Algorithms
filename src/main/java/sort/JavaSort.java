package sort;

import java.util.Arrays;

public class JavaSort extends SortingAlgo {
    @Override
    public String getName() {
        return "Java Sort";
    }

    @Override
    public void sort(int[] toBeSorted) {
        Arrays.sort(toBeSorted);
    }
}
