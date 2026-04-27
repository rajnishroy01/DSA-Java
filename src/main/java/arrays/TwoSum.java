package arrays;


import java.util.HashMap;

/**
 * Problem: Two Sum (Check if pair exists)
 *
 * Given an array and a target, return true if there exists
 * two numbers such that their sum equals the target.
 *
 * Approach:
 * - Use HashMap to store visited elements
 * - For each element, check if (target - element) exists
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class TwoSum {

    public static boolean twoSum(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];

            // Check if complement exists
            if (map.containsKey(complement)) {
                return true;
            }

            // Store current element
            map.put(arr[i], i);
        }

        return false;
    }

    // Test the function
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;

        boolean result = twoSum(arr, target);
        System.out.println("Pair exists: " + result);
    }
}