package arrays;

/*
// Problem statement:
You are given an array arr[] of size n - 1 that contains distinct integers
in the range from 1 to n (inclusive). This array represents a permutation
of the integers from 1 to n with one element missing.
Your task is to identify and return the missing element.

------------------------------------------------------
🧠 Key Idea (XOR Trick):

XOR has special properties:
1. a ^ a = 0      (same numbers cancel out)
2. a ^ 0 = a      (zero has no effect)
3. XOR is commutative & associative
   → order does not matter

👉 Meaning:
- Numbers appearing twice → cancel out
- Number appearing once → remains

------------------------------------------------------
🎯 Strategy:

1. XOR all elements of the array
2. XOR all numbers from 1 to n
3. Take XOR of both results

👉 All common numbers cancel out
👉 Missing number survives

------------------------------------------------------
Example:
arr = [1, 2, 4, 5]

XOR(1 to 5) = 1 ^ 2 ^ 3 ^ 4 ^ 5
XOR(array)  = 1 ^ 2 ^ 4 ^ 5

Final XOR:
(1^1) ^ (2^2) ^ (4^4) ^ (5^5) ^ 3 = 3
*/

public class MissingInArray {

    // XOR-based solution (O(n) time, O(1) space)
    public static int missingNum(int arr[]) {
        int xor1 = 0; // XOR of array elements
        int xor2 = 0; // XOR of 1 to n

        // XOR all array elements
        for (int num : arr) {
            xor1 ^= num;
        }

        // XOR numbers from 1 to n (n = arr.length + 1)
        for (int i = 1; i <= arr.length + 1; i++) {
            xor2 ^= i;
        }

        // Missing number
        return xor1 ^ xor2;
    }

    // Main method for testing
    public static void main(String[] args) {
        int arr[] = {1, 2, 4, 5};

        int missing = missingNum(arr);
        System.out.println("Missing number is: " + missing);
    }
}