package Strings;

import java.util.*;

/*
Problem: Print Anagrams Together

Given an array of strings, return all groups of strings
that are anagrams. The strings in each group must be
arranged in the order of their appearance in the original array.
*/

public class GroupAnagrams {

    public ArrayList<ArrayList<String>> anagrams(String[] arr) {

        ArrayList<ArrayList<String>> result = new ArrayList<>();

        // Map to store sorted string as key and anagram group as value
        HashMap<String, ArrayList<String>> anagramMap = new HashMap<>();

        for (String str : arr) {

            // Convert string into character array
            char[] chars = str.toCharArray();

            // Sort character array
            Arrays.sort(chars);

            // Create sorted string key
            String sortedStr = new String(chars);

            // Add string to existing group
            if (anagramMap.containsKey(sortedStr)) {

                anagramMap.get(sortedStr).add(str);

            } else {

                // Create new anagram group
                ArrayList<String> group = new ArrayList<>();
                group.add(str);

                anagramMap.put(sortedStr, group);
            }
        }

        // Add all groups to result
        for (Map.Entry<String, ArrayList<String>> entry : anagramMap.entrySet()) {

            result.add(entry.getValue());
        }

        return result;
    }

    // Main method for testing
    public static void main(String[] args) {

        GroupAnagrams solution = new GroupAnagrams();

        String[] words = {
                "cat", "dog", "tac", "god", "act", "odg"
        };

        ArrayList<ArrayList<String>> result = solution.anagrams(words);

        System.out.println("Grouped Anagrams:");

        for (ArrayList<String> group : result) {

            System.out.println(group);
        }
    }
}