package search;

public class BinarySearch {


    public static void main(String[] args) {
        int[] sortedArray = {1, 3, 5, 7, 9, 11, 13, 15};
        int target = 9;

        System.out.println("Element found Iterative at index " + binarySearchIterative(sortedArray, target));
        System.out.println("Element found Recursive at index " + binarySearchRecursive(sortedArray, 0, sortedArray.length - 1, target));
    }

    // Iterative implementation of Binary Search
    public static int binarySearchIterative(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;  // Calculate the mid-point to avoid overflow

            // Check if the target is present at mid
            if (arr[mid] == target) {
                return mid;
            }

            // If target is greater, ignore the left half
            if (arr[mid] < target) {
                low = mid + 1;
            }
            // If target is smaller, ignore the right half
            else {
                high = mid - 1;
            }
        }

        // Return -1 if the element is not found
        return -1;
    }

    // Recursive implementation of Binary Search
    public static int binarySearchRecursive(int[] arr, int low, int high, int target) {

        if (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if the target is present at mid
            if (arr[mid] == target) {
                return mid;
            }

            // If target is greater, search the right half
            if (arr[mid] < target) {
                return binarySearchRecursive(arr, mid + 1, high, target);
            }
            // If target is smaller, search the left half
            return binarySearchRecursive(arr, low, mid - 1, target);
        }

        // Return -1 if the element is not found
        return -1;
    }

}