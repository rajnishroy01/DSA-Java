package arrays;

public class Kadane {

    // Returns the maximum subarray sum
    public static int maxSubarraySum(int[] arr) {
        int maxHere = arr[0];
        int maxSoFar = arr[0];

        for (int i = 1; i < arr.length; i++) {
            maxHere = Math.max(arr[i], maxHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxHere);
        }

        return maxSoFar;
    }

    // Also returns the subarray indices
    public static int[] maxSubarrayWithIndices(int[] arr) {
        int maxHere = arr[0];
        int maxSoFar = arr[0];
        int start = 0, end = 0, tempStart = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxHere + arr[i]) {
                maxHere = arr[i];
                tempStart = i;          // potential new start
            } else {
                maxHere += arr[i];
            }

            if (maxHere > maxSoFar) {
                maxSoFar = maxHere;
                start = tempStart;      // commit the start
                end = i;
            }
        }

        return new int[]{maxSoFar, start, end};
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        // Basic version
        System.out.println("Max sum: " + maxSubarraySum(arr));  // 6

        // With indices
        int[] result = maxSubarrayWithIndices(arr);
        System.out.println("Max sum: " + result[0]);            // 6
        System.out.println("Start index: " + result[1]);        // 3
        System.out.println("End index: " + result[2]);          // 6

        // Print the subarray
        System.out.print("Subarray: ");
        for (int i = result[1]; i <= result[2]; i++) {
            System.out.print(arr[i] + " ");                     // 4 -1 2 1
        }
    }
}