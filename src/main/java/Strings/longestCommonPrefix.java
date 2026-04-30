package Strings;

// File: LongestCommonPrefix.java

/**
 * Approach:
 * - Take first string as base
 * - Reduce its size step by step
 * - Check if all strings start with that prefix
 */

class Solution {

    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) return "";

        String check = strs[0];
        int i = check.length();

        while (i >= 0) {

            String prefix = check.substring(0, i);

            int count = 0;

            for (String str : strs) {
                if (str.startsWith(prefix)) {
                    count++;
                } else {
                    break;
                }
            }

            if (count == strs.length) return prefix;

            i--;
        }

        return "";
    }
}
