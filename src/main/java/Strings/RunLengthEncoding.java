package Strings;

/**
 * Problem: Run-Length Encoding (String Compression)
 *
 * Description:
 * Given a string, compress it by replacing consecutive repeating characters
 * with the character followed by its frequency.
 *
 * Example:
 * Input:  "aabbcc"
 * Output: "a2b2c2"
 *
 * Input:  "aaabbc"
 * Output: "a3b2c1"
 *
 * ------------------------------------------------------------
 *
 * Approach:
 *
 * 1. Initialize a counter (count = 1)
 * 2. Traverse the string from index 1 to n-1
 * 3. Compare current character with previous character:
 *
 *    Case 1: Same character
 *            → Increment count
 *
 *    Case 2: Different character
 *            → Append previous character and its count to result
 *            → Reset count = 1
 *
 * 4. After loop ends:
 *    → Append the last character and its count
 *    (Important: last group is not handled inside loop)
 *
 * ------------------------------------------------------------
 *
 * Key Insight:
 * The encoding happens only when a "change" is detected.
 * The last group has no next character to trigger this change,
 * so we must handle it manually after the loop.
 *
 * ------------------------------------------------------------
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 */

public class RunLengthEncoding {

    public static String encode(String s) {
        // Edge case
        if (s == null || s.length() == 0) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        int count = 1;

        // Traverse string
        for (int i = 1; i < s.length(); i++) {

            if (s.charAt(i) == s.charAt(i - 1)) {
                count++; // same character → increase count
            } else {
                // character changed → append previous character and count
                result.append(s.charAt(i - 1));
                result.append(count);
                count = 1; // reset count
            }
        }

        // Handle last group
        result.append(s.charAt(s.length() - 1));
        result.append(count);

        return result.toString();
    }

    // Main method for testing
    public static void main(String[] args) {
        String input1 = "aabbcc";
        String input2 = "aaabbc";

        System.out.println("Input: " + input1);
        System.out.println("Encoded: " + encode(input1));

        System.out.println("Input: " + input2);
        System.out.println("Encoded: " + encode(input2));
    }
}