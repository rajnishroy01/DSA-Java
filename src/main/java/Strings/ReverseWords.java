package Strings;

/**
 * Problem: Reverse Words in a Dot-Separated String
 *
 * Platform     : GeeksForGeeks
 * Difficulty   : Easy
 * Topic        : Stack, String Manipulation
 *
 * -------------------------------------------------------------------------
 * PROBLEM STATEMENT:
 * -------------------------------------------------------------------------
 * Given a string `s` where words are separated by dots (`.`),
 * reverse the order of the words.
 *
 * Example:
 *   Input  : ".i.like.this.program.very.much."
 *   Output : "much.very.program.this.like.i"
 *
 * Constraints:
 *   - String may have leading or trailing dots
 *   - Multiple consecutive dots should be handled (empty tokens ignored)
 *   - 1 <= |s| <= 10^5
 *
 * -------------------------------------------------------------------------
 * APPROACH: Stack
 * -------------------------------------------------------------------------
 * 1. Split the string on literal dot `\\.` (escaped for regex)
 * 2. Push each non-empty token onto a Stack
 * 3. Pop all tokens from the Stack into a StringBuilder (LIFO = reversed)
 * 4. Append a dot between words (not after the last word)
 * 5. Return the final string
 *
 * Why Stack?
 *   Stack follows LIFO (Last In, First Out), which naturally reverses
 *   the order of elements when popped.
 *
 * -------------------------------------------------------------------------
 * BUGS FIXED (from original attempt):
 * -------------------------------------------------------------------------
 * 1. `String[] arrList arrList`     → duplicate variable declaration
 * 2. `s.split(".")`                 → `.` in regex matches ANY character;
 *                                      use `\\.` for a literal dot
 * 3. `arrList.push(str)`            → arrays have no push(); use stack.push()
 * 4. `stack.pop` (no parentheses)   → must be stack.pop() — method call
 * 5. `stack.append(".")`            → Stack has no append(); use strBuilder
 * 6. `new String(strBuilder)`       → use strBuilder.toString() instead
 * 7. Empty string tokens            → leading/trailing dots produce empty
 *                                      strings after split(); filter with
 *                                      str.isEmpty() check before pushing
 *
 * -------------------------------------------------------------------------
 * COMPLEXITY:
 * -------------------------------------------------------------------------
 *   Time  : O(n) — single pass to split, push, and pop
 *   Space : O(n) — stack and StringBuilder both hold all tokens
 *
 * -------------------------------------------------------------------------
 * TEST CASES:
 * -------------------------------------------------------------------------
 *   Input                              | Expected Output
 *   -----------------------------------|-----------------------------
 *   ".i.like.this.program.very.much."  | "much.very.program.this.like.i"
 *   "hello.world"                      | "world.hello"
 *   "one"                              | "one"
 *   ".leading"                         | "leading"
 *   "trailing."                        | "trailing"
 *   "a..b"                             | "b.a"   (empty token skipped)
 */

import java.util.Stack;

class ReverseWords {

    /**
     * Reverses the order of dot-separated words in the given string.
     *
     * @param s dot-separated word string (may have leading/trailing dots)
     * @return  dot-separated string with word order reversed
     */
    public String reverseWords(String s) {
        // Step 1: Split on literal dot (escaped for regex)
        String[] arrList = s.split("\\.");

        // Step 2: Push non-empty tokens onto the stack
        Stack<String> stack = new Stack<>();
        for (String str : arrList) {
            if (!str.isEmpty()) {       // skip empty strings from leading/trailing dots
                stack.push(str);
            }
        }

        // Step 3: Pop tokens into StringBuilder (LIFO gives reversed order)
        StringBuilder strBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            strBuilder.append(stack.pop());
            if (!stack.isEmpty()) {
                strBuilder.append(".");  // dot between words, not after the last
            }
        }

        // Step 4: Convert StringBuilder to String and return
        return strBuilder.toString();
    }

    // -----------------------------------------------------------------------
    // Driver — quick local test
    // -----------------------------------------------------------------------
    public static void main(String[] args) {
        ReverseWords sol = new ReverseWords();

        String[] inputs = {
                ".i.like.this.program.very.much.",
                "hello.world",
                "one",
                ".leading",
                "trailing.",
                "a..b"
        };

        String[] expected = {
                "much.very.program.this.like.i",
                "world.hello",
                "one",
                "leading",
                "trailing",
                "b.a"
        };

        int passed = 0;
        for (int i = 0; i < inputs.length; i++) {
            String result = sol.reverseWords(inputs[i]);
            boolean ok = result.equals(expected[i]);
            if (ok) passed++;
            System.out.printf("[%s] Input: %-40s | Got: %-40s | Expected: %s%n",
                    ok ? "PASS" : "FAIL", inputs[i], result, expected[i]);
        }

        System.out.printf("%nResult: %d / %d tests passed%n", passed, inputs.length);
    }
}
