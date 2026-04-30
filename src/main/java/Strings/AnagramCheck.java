package Strings;

// File: AnagramCheck.java

import java.util.Arrays;

/**
 * Problem: Check if Two Strings are Anagrams
 * -----------------------------------------
 * Two strings are anagrams if they contain the same characters
 * with the same frequency, but possibly in a different order.
 *
 * Example:
 * Input:  s1 = "listen", s2 = "silent"
 * Output: true
 *
 * Input:  s1 = "hello", s2 = "world"
 * Output: false
 *
 * -----------------------------------------
 * Approach:
 * 1. If lengths differ → not anagrams
 * 2. Convert strings to char arrays
 * 3. Sort both arrays
 * 4. Compare character by character
 *
 * -----------------------------------------
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */

public class AnagramCheck {

    static class Solution {

        public static boolean areAnagrams(String s1, String s2) {

            // Handle null cases
            if (s1 == null || s2 == null) return false;

            // If lengths differ, cannot be anagrams
            if (s1.length() != s2.length()) return false;

            // Convert to char arrays
            char[] charArr1 = s1.toCharArray();
            char[] charArr2 = s2.toCharArray();

            // Sort both arrays
            Arrays.sort(charArr1);
            Arrays.sort(charArr2);

            // Compare sorted arrays
            for (int i = 0; i < charArr1.length; i++) {
                if (charArr1[i] != charArr2[i]) {
                    return false;
                }
            }

            return true;
        }
    }

    // Optional main method for testing
    public static void main(String[] args) {
        System.out.println(Solution.areAnagrams("listen", "silent")); // true
        System.out.println(Solution.areAnagrams("hello", "world"));   // false
    }
}
