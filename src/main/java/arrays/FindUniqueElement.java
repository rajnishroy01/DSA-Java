package arrays;

/*
------------------------------------------------------
📌 Problem: Find Unique Element (Every element appears twice except one)

Given an array where:
- Every element appears exactly twice
- One element appears only once

👉 Find that unique element

------------------------------------------------------
🧠 Key Idea (XOR Trick):

1. a ^ a = 0   → same numbers cancel out
2. a ^ 0 = a   → identity property
3. XOR is associative & commutative

👉 So:
All duplicate elements cancel out
Only the unique element remains

------------------------------------------------------
🎯 Algorithm:

1. Initialize xor = 0
2. Traverse array:
      xor = xor ^ element
3. Return xor

------------------------------------------------------
🔍 Example:

arr = [2, 3, 5, 4, 5, 3, 4]

Step:
2 ^ 3 ^ 5 ^ 4 ^ 5 ^ 3 ^ 4
→ (3^3), (5^5), (4^4) cancel
→ result = 2

------------------------------------------------------
⚡ Complexity:

Time  : O(n)
Space : O(1)

------------------------------------------------------
*/

public class FindUniqueElement {

    // XOR-based solution
    public static int findUnique(int[] arr) {
        int xor = 0;

        for (int num : arr) {
            xor ^= num;
        }

        return xor;
    }

    // Main method for testing
    public static void main(String[] args) {

        int[] arr = {2, 3, 5, 4, 5, 3, 4};

        int unique = findUnique(arr);

        System.out.println("Unique element is: " + unique);
    }
}