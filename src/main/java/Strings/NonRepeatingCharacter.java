package Strings;

/**
 * Problem: First Non-Repeating Character in a String
 *
 * Description:
 * Given a string, find the first character that does not repeat.
 * If all characters repeat, return '$'.
 *
 * Examples:
 * Input:  "aabbcc"
 * Output: '$'
 *
 * Input:  "aabbcde"
 * Output: 'c'
 *
 * ------------------------------------------------------------
 *
 * Approach (Brute Force with Marking):
 *
 * 1. Convert string to character array.
 * 2. Create a boolean array 'check' to track visited characters.
 * 3. Traverse each character:
 *    - If not visited:
 *        → Mark it visited
 *        → Count its occurrences by checking rest of the array
 *        → Mark duplicates as visited
 *    - If count == 1 → return that character immediately
 *
 * 4. If no non-repeating character found → return '$'
 *
 * ------------------------------------------------------------
 *
 * Optimized Approach (Using LinkedHashMap - Recommended):
 *
 * 1. Traverse string and store frequency in LinkedHashMap
 *    (maintains insertion order)
 * 2. Traverse map:
 *    → First character with frequency 1 is the answer
 *
 * ------------------------------------------------------------
 *
 * Time Complexity:
 * Brute Force: O(n^2)
 * Optimized:   O(n)
 *
 * Space Complexity: O(n)
 *
 */

import java.util.LinkedHashMap;
import java.util.Map;

public class NonRepeatingCharacter {

    /**
     * Brute Force Approach
     */
    public static char nonRepeatingCharBrute(String s) {
        char[] sArr = s.toCharArray();
        boolean[] check = new boolean[sArr.length];

        for (int i = 0; i < sArr.length; i++) {
            int count = 0;
            char ch = sArr[i];

            if (!check[i]) {
                check[i] = true;
                count++;

                for (int j = i + 1; j < sArr.length; j++) {
                    if (sArr[j] == ch) {
                        check[j] = true;
                        count++;
                    }
                }
            }

            if (count == 1) {
                return ch;
            }
        }

        return '$';
    }

    /**
     * Optimized Approach using LinkedHashMap
     */
    public static char nonRepeatingCharOptimized(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();

        // Count frequency
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Find first non-repeating
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return '$';
    }

    /**
     * Main method for testing
     */
    public static void main(String[] args) {
        String input1 = "aabbcc";
        String input2 = "aabbcde";

        System.out.println("Brute Force Approach:");
        System.out.println("Input: " + input1 + " -> Output: " + nonRepeatingCharBrute(input1));
        System.out.println("Input: " + input2 + " -> Output: " + nonRepeatingCharBrute(input2));

        System.out.println("\nOptimized Approach:");
        System.out.println("Input: " + input1 + " -> Output: " + nonRepeatingCharOptimized(input1));
        System.out.println("Input: " + input2 + " -> Output: " + nonRepeatingCharOptimized(input2));
    }
}
