package Strings;

import java.util.*;

/**
 * Problem: Remove All Adjacent Duplicates Recursively
 *
 * Given a string s, remove all adjacent duplicate characters recursively,
 * until there are no adjacent duplicate characters left.
 *
 * If the resultant string becomes empty, return an empty string.
 *
 * Examples:
 * Input:  "geeksforgeek"
 * Output: "gksforgk"
 * Explanation: g(ee)ksforg(ee)k -> gksforgk
 *
 * Input:  "abccbccba"
 * Output: ""
 * Explanation: ab(cc)b(cc)ba -> abbba -> a(bbb)a -> aa -> (aa) -> ""
 *
 * Input:  "abcd"
 * Output: "abcd"
 * Explanation: No adjacent duplicates found
 *
 * Constraints: 1 <= s.length() <= 10^5
 */

/**
 * Intuition:
 * ------------
 * The key insight is that removing adjacent duplicates can CREATE new adjacent
 * duplicates that weren't adjacent in the original string. This means we need
 * to process the string recursively (or iteratively with multiple passes) until
 * no more duplicates remain.
 *
 * Example of cascading removals:
 * "abccbccba" -> remove "cc" at positions 2-3 -> "abbba"
 * "abbba"     -> remove "bbb" at positions 1-3 -> "aa"
 * "aa"        -> remove "aa" at positions 0-1 -> ""
 *
 * Approach 1: Recursive (clean but O(n^2) worst case)
 * - Scan string left to right
 * - When we find adjacent duplicates, skip all consecutive occurrences
 * - Build result string and recurse if any removals were made
 *
 * Approach 2: Stack-based (O(n) time, O(n) space)
 * - Use a stack to track characters and their consecutive counts
 * - When count reaches 2, pop from stack (duplicates eliminated)
 * - This handles cascading removals in a single pass
 */

public class RemoveAdjacentDuplicates {

    // ============================================
    // APPROACH 1: Recursive (Intuitive, Easy to Understand)
    // ============================================
    public static String removeRecursive(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int i = 0;
        boolean changed = false;

        while (i < n) {
            // Check if current char has adjacent duplicate
            if (i < n - 1 && s.charAt(i) == s.charAt(i + 1)) {
                changed = true;
                char dupChar = s.charAt(i);
                // Skip ALL consecutive duplicates (handles "aaa", "bbbb", etc.)
                while (i < n && s.charAt(i) == dupChar) {
                    i++;
                }
            } else {
                sb.append(s.charAt(i));
                i++;
            }
        }

        // If we made changes, recurse because new adjacent duplicates may have formed
        if (changed) {
            return removeRecursive(sb.toString());
        }

        return s;
    }

    // ============================================
    // APPROACH 2: Stack-based (Optimal O(n) Time)
    // ============================================
    public static String removeStack(String s) {
        // Stack stores pairs of [character, consecutive_count]
        Deque<Pair> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!stack.isEmpty() && stack.peek().ch == c) {
                // Same as top, increment count
                stack.peek().count++;
            } else {
                // Different character - check if previous run was duplicates
                if (!stack.isEmpty() && stack.peek().count >= 2) {
                    stack.pop(); // Remove the duplicate run
                    i--;         // Re-process current character with new top
                    continue;
                }
                stack.push(new Pair(c, 1));
            }
        }

        // Clean up any remaining duplicate runs at the end
        if (!stack.isEmpty() && stack.peek().count >= 2) {
            stack.pop();
        }

        // Build result from stack (reverse order since stack is LIFO)
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Pair p = stack.removeLast(); // Remove from bottom to maintain order
            for (int i = 0; i < p.count; i++) {
                sb.append(p.ch);
            }
        }

        return sb.toString();
    }

    // Helper class for stack approach
    private static class Pair {
        char ch;
        int count;
        Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

    // ============================================
    // TEST CASES
    // ============================================
    public static void main(String[] args) {
        // Test cases from problem statement
        String[] tests = {
                "geeksforgeek",   // Expected: "gksforgk"
                "abccbccba",      // Expected: ""
                "abcd",           // Expected: "abcd"
                "aaaa",           // Expected: ""
                "aabba",          // Expected: ""
                "azxxzy",         // Expected: "ay"
        };

        System.out.println("=== Remove Adjacent Duplicates Recursively ===\n");

        for (String test : tests) {
            System.out.println("Input:    \"" + test + "\"");
            System.out.println("Recursive: \"" + removeRecursive(test) + "\"");
            System.out.println("Stack:     \"" + removeStack(test) + "\"");
            System.out.println();
        }
    }
}
