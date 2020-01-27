import lombok.extern.slf4j.Slf4j;
import sort.InsertionSort;
import sort.JavaSort;
import sort.MergeSort;
import sort.SortingAlgo;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class SortingTestDrive {

    // used for logging
    public List<Integer> fromArrayToList(int[] array) {
        return Arrays.stream(array).boxed().collect(Collectors.toList());
    }

    public int[] generateArray(int elementNo) {
        return IntStream.generate(() -> new Random().nextInt(elementNo)).limit(elementNo).toArray();
    }

    public void measureSortPerformanceFor(List<SortingAlgo> sortAlgorithms, int randomNumberOfElements) {
        int[] testArray = generateArray(randomNumberOfElements);

        sortAlgorithms.forEach(algorithm -> {
            int[] toBeSorted = Arrays.copyOf(testArray, testArray.length);
            long startTime = System.currentTimeMillis();
            algorithm.sort(toBeSorted);
            long endTime = System.currentTimeMillis();
            log.info(algorithm.getName() + " performance for {} elements is {} milliseconds", testArray.length, endTime - startTime);
        });

    }

    public static void main(String[] args) {

        SortingTestDrive main = new SortingTestDrive();

        SortingAlgo insertionSortAlgorithm = new InsertionSort();
        SortingAlgo mergeSort = new MergeSort();
        SortingAlgo javaSort = new JavaSort();

        List<SortingAlgo> algorithms = Arrays.asList(insertionSortAlgorithm, mergeSort, javaSort);

        main.measureSortPerformanceFor(algorithms, 100);
        main.measureSortPerformanceFor(algorithms, 500);
        main.measureSortPerformanceFor(algorithms, 1000);
        main.measureSortPerformanceFor(algorithms, 10000);
        main.measureSortPerformanceFor(algorithms, 100000);
        main.measureSortPerformanceFor(algorithms, 500000);
        main.measureSortPerformanceFor(algorithms, 1000000);

    }
}