package arrays;

import java.util.Arrays;

/**
 * Problem: Move all zeroes to end
 *
 * Approach: Two Pointer Technique
 * - Traverse the array
 * - Move all non-zero elements to the front
 * - Fill remaining positions with zeros
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Example:
 * Input:  [1, 2, 0, 4, 0, 5]
 * Output: [1, 2, 4, 5, 0, 0]
 */
public class MoveAllZeroesToEnd {

    public static void pushZerosToEnd(int[] arr) {
        int j = 0;

        // Move non-zero elements forward
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[j] = arr[i];
                j++;
            }
        }

        // Fill remaining positions with zero
        for (int i = j; i < arr.length; i++) {
            arr[i] = 0;
        }
    }

    // Main method to test
    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 4, 0, 5};

        pushZerosToEnd(arr);

        System.out.println(Arrays.toString(arr));
    }
}