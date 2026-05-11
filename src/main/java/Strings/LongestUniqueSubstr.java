package Strings;

/**
 * ============================================================
 *  PROBLEM: Longest Substring With All Distinct Characters
 * ============================================================
 *
 * DIFFICULTY : Medium
 * PLATFORM   : GeeksForGeeks
 * TOPIC      : Sliding Window, HashMap
 *
 * ------------------------------------------------------------
 * PROBLEM STATEMENT
 * ------------------------------------------------------------
 * Given a string s, find the length of the longest substring
 * that contains all distinct (non-repeating) characters.
 *
 * Examples:
 *   Input : "geeksforgeeks"   →  Output : 7   ("eksforg")
 *   Input : "aaa"             →  Output : 1   ("a")
 *   Input : "abcdefabcbb"     →  Output : 6   ("abcdef")
 *
 * ------------------------------------------------------------
 * INTUITION
 * ------------------------------------------------------------
 * Imagine you have a magnifying glass (window) that you slide
 * over the string from left to right.
 *
 * - You EXPAND the window to the right as long as all characters
 *   inside it are unique.
 * - The moment you spot a DUPLICATE inside your window, you
 *   SHRINK from the left — just enough to remove that old
 *   duplicate occurrence.
 * - At every step, record the window size if it's the largest
 *   seen so far.
 *
 * This way you never go backwards; both pointers only move
 * forward → O(n) time.
 *
 * ------------------------------------------------------------
 * APPROACH: SLIDING WINDOW + HASHMAP
 * ------------------------------------------------------------
 *
 * Use two pointers:
 *   left  = start of the current window
 *   right = end   of the current window  (the for-loop variable)
 *
 * Use a HashMap that stores:
 *   character  →  last index where it was seen
 *
 * RULES:
 *   ✅ If the character at `right` is NOT in the window
 *      → simply add/update it in the map.
 *
 *   ❌ If the character at `right` IS already inside the window
 *      (map.get(ch) >= left)
 *      → move `left` to  map.get(ch) + 1
 *        (jump just past the old occurrence)
 *
 *   📏 After each step:
 *      window_size = right - left + 1
 *      update max if window_size is bigger.
 *
 * KEY CHECK:  map.get(ch) >= left
 * -----------------------------------
 * The map remembers ALL past positions, even ones outside the
 * current window. We only care about duplicates INSIDE the
 * window, so we check:
 *
 *   previous position >= left  →  it's inside  → shrink left
 *   previous position <  left  →  it's outside → ignore, safe to include
 *
 * ------------------------------------------------------------
 * WRONG APPROACHES (and why they fail)
 * ------------------------------------------------------------
 *
 * ❌ APPROACH 1 — Reset entire map on duplicate
 *    Problem: You throw away characters that are still valid
 *    for the next window.
 *    Example: "abcbd"
 *      On seeing 2nd 'b', you reset and lose 'a','c' — but
 *      "cbd" is a valid window of size 3 that you'd miss.
 *
 * ❌ APPROACH 2 — Use (left < right) as the duplicate guard
 *    Problem: That condition only checks if the window has
 *    more than 1 char. It does NOT check whether the duplicate
 *    is actually inside the window.
 *    Example: "abcdab"
 *      After processing 'a' at index 4, left moves to 1.
 *      Then 'b' at index 5: map has b→1, and 1 >= left(1) is true,
 *      so left should stay at 2. But with (left < right) you
 *      move left to 2 correctly here — however for:
 *    Example: "abcbda"
 *      'b' duplicate at index 3 → left=2 (correct so far).
 *      'a' at index 5: map has a→0, but left is already 2.
 *      Correct: 0 < 2 so ignore, left stays 2, window = "bda" = 3.
 *      With (left<right): 2<5 is true → left = 0+1 = 1 ← WRONG!
 *      Window becomes "bcbda" which contains duplicate 'b'.
 *
 * ------------------------------------------------------------
 * STEP-BY-STEP DRY RUN:  s = "a b c b d"
 *                                 0 1 2 3 4
 * ------------------------------------------------------------
 *
 *  right=0, ch='a'  map={a:0}          left=0  window="a"     size=1  max=1
 *  right=1, ch='b'  map={a:0,b:1}      left=0  window="ab"    size=2  max=2
 *  right=2, ch='c'  map={a:0,b:1,c:2}  left=0  window="abc"   size=3  max=3
 *  right=3, ch='b'  map has b→1, 1>=0  left=2  window="cb"    size=2  max=3
 *                   map={a:0,b:3,c:2}
 *  right=4, ch='d'  map={...,d:4}      left=2  window="cbd"   size=3  max=3
 *
 *  Answer = 3  ✅
 *
 * ------------------------------------------------------------
 * COMPLEXITY
 * ------------------------------------------------------------
 *   Time  : O(n)  — each character is visited at most twice
 *                   (once by right, once when left passes it)
 *   Space : O(min(n, 26)) — at most 26 unique lowercase letters
 *                           in the map at any time
 *
 * ============================================================
 */

import java.util.HashMap;
import java.util.Map;

class LongestUniqueSubstr {

    public int longestUniqueSubstr(String s) {

        // Stores character → its last seen index
        Map<Character, Integer> map = new HashMap<>();

        int left   = 0;  // left boundary of the sliding window
        int max    = 0;  // answer: length of the longest valid window

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            /*
             * Is this character inside the current window?
             *   map.containsKey(ch)   → we've seen it before
             *   map.get(ch) >= left   → that previous occurrence
             *                           is still inside our window
             *
             * If BOTH are true → shrink: move left past the duplicate.
             * If the previous occurrence is already outside (< left),
             * we can safely include ch without shrinking.
             */
            if (map.containsKey(ch) && map.get(ch) >= left) {
                left = map.get(ch) + 1;
            }

            // Always update the character's latest position
            map.put(ch, right);

            // Current window size = right - left + 1
            max = Math.max(max, right - left + 1);
        }

        return max;
    }

    // ----------------------------------------------------------
    //  Quick tests
    // ----------------------------------------------------------
    public static void main(String[] args) {

        LongestUniqueSubstr sol = new LongestUniqueSubstr();

        System.out.println(sol.longestUniqueSubstr("geeksforgeeks")); // 7
        System.out.println(sol.longestUniqueSubstr("aaa"));           // 1
        System.out.println(sol.longestUniqueSubstr("abcdefabcbb"));   // 6
        System.out.println(sol.longestUniqueSubstr("abcbd"));         // 3
        System.out.println(sol.longestUniqueSubstr("abcbda"));        // 4  ("cbda")
        System.out.println(sol.longestUniqueSubstr(""));              // 0
        System.out.println(sol.longestUniqueSubstr("abcdef"));        // 6
    }
}