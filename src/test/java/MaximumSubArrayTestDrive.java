import lombok.extern.slf4j.Slf4j;
import problems.maximum_subarray.BruteForce;
import problems.maximum_subarray.Kadane;
import problems.maximum_subarray.MaximumSubArrayAlgo;
import problems.maximum_subarray.Shamos;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Slf4j
public class MaximumSubArrayTestDrive {

    public int[] generateArray(int elementNo) {
        return IntStream.generate(() -> new Random().nextInt(elementNo)).limit(elementNo).toArray();
    }

    public void measurePerformanceFor(List<MaximumSubArrayAlgo> maximumSubArrayAlgos, int randomNumberOfElements) {
        int[] testArray = generateArray(randomNumberOfElements);

        maximumSubArrayAlgos.forEach(algorithm -> {
            int[] array = Arrays.copyOf(testArray, testArray.length);
            long startTime = System.currentTimeMillis();
            algorithm.findMaxSubArray(array);
            long endTime = System.currentTimeMillis();
            log.info(algorithm.getName() + " performance for {} elements is {} milliseconds", testArray.length, endTime - startTime);
        });

    }

    public static void main(String[] args) {

        MaximumSubArrayTestDrive testDrive = new MaximumSubArrayTestDrive();


        MaximumSubArrayAlgo kadaneAlgo = new Kadane();
        MaximumSubArrayAlgo shamosAlgo = new Shamos();
        MaximumSubArrayAlgo bruteForceAlgo = new BruteForce();

        List<MaximumSubArrayAlgo> algorithms = Arrays.asList(kadaneAlgo, shamosAlgo, bruteForceAlgo);

        testDrive.measurePerformanceFor(algorithms, 100);
        testDrive.measurePerformanceFor(algorithms, 500);
        testDrive.measurePerformanceFor(algorithms, 1000);
        testDrive.measurePerformanceFor(algorithms, 10000);
        testDrive.measurePerformanceFor(algorithms, 100000);
        testDrive.measurePerformanceFor(algorithms, 500000);
        testDrive.measurePerformanceFor(algorithms, 1000000);


    }

}
