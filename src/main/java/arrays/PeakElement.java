package arrays;

// File: PeakElement.java
// File: PeakElement.java

/**
 * Problem: Peak Element
 * -------------------------------------
 * Given an array arr[] of size n, find the index of any one peak element.
 *
 * A peak element is defined as an element that is strictly greater than its neighbors.
 *
 * For corner elements:
 * - The first element is a peak if arr[0] > arr[1]
 * - The last element is a peak if arr[n-1] > arr[n-2]
 *
 * Note:
 * - There may be multiple peaks, return index of any one.
 * - It is guaranteed that a peak always exists.
 *
 * Example:
 * Input:  arr = [1, 3, 20, 4, 1, 0]
 * Output: 2
 * Explanation: arr[2] = 20 is a peak element.
 *
 * -------------------------------------
 * Approach: Binary Search (Optimal)
 * -------------------------------------
 * Instead of scanning the entire array (O(n)),
 * we use Binary Search to achieve O(log n).
 *
 * Key Observation:
 * - If arr[mid] > arr[mid + 1], then a peak lies on the LEFT side (including mid)
 * - Else, a peak lies on the RIGHT side
 *
 * This works because at least one peak must exist.
 *
 * -------------------------------------
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 * -------------------------------------
 */

public class PeakElement {

    static class Solution {

        /**
         * Function to find a peak element index
         */
        public int peakElement(int[] arr) {
            int low = 0, high = arr.length - 1;

            while (low < high) {
                int mid = (low + high) / 2;

                // If mid element is greater than next,
                // peak lies on left side (including mid)
                if (arr[mid] > arr[mid + 1]) {
                    high = mid;
                } else {
                    // Else peak lies on right side
                    low = mid + 1;
                }
            }

            // Both low and high converge to peak index
            return low;
        }
    }

    /**
     * Main method for quick testing
     */
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr = {1, 3, 20, 4, 1, 0};

        int peakIndex = sol.peakElement(arr);

        System.out.println("Peak element index: " + peakIndex);
        System.out.println("Peak element value: " + arr[peakIndex]);
    }
}