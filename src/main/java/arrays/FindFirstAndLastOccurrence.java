package arrays;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * Problem: Find First and Last Occurrence of an Element
 *
 * Given an array and a target x, return the first and last
 * index of x. If not found, return [-1, -1].
 *
 * Approach:
 * - Traverse from left → find first occurrence
 * - Traverse from right → find last occurrence
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1) (excluding output list)
 */
public class FindFirstAndLastOccurrence {

    static class Solution {
        ArrayList<Integer> find(int arr[], int x) {
            ArrayList<Integer> al = new ArrayList<>();

            int start = -1;
            int end = -1;

            // Find first occurrence
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == x) {
                    start = i;
                    break;
                }
            }

            // Find last occurrence
            for (int i = arr.length - 1; i >= 0; i--) {
                if (arr[i] == x) {
                    end = i;
                    break;
                }
            }

            al.add(start);
            al.add(end);

            return al;
        }
    }

    // Test method
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr = {1, 2, 2, 2, 3, 4};
        int x = 2;

        ArrayList<Integer> result = sol.find(arr, x);

        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Target: " + x);
        System.out.println("First and Last Occurrence: " + result);
    }
}