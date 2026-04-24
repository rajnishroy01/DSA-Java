package arrays;

/*
------------------------------------------------------
📌 Problem: Remove Duplicates from Sorted Array (In-place)

Given a sorted array arr[], remove duplicates such that
each unique element appears only once.

Return:
- The number of unique elements (k)
- First k elements of array should be unique

------------------------------------------------------
🧠 GATE Concept:

Since array is SORTED:
👉 All duplicates are adjacent

We use TWO POINTERS:
- i → tracks last unique element
- j → scans the array

------------------------------------------------------
🎯 Algorithm:

1. Initialize i = 0
2. Traverse j from 1 → n-1
3. If arr[i] != arr[j]:
      i++
      arr[i] = arr[j]
4. Return i + 1

------------------------------------------------------
🔍 Dry Run:

arr = [1, 1, 2, 2, 3]

i = 0

j = 1 → same → skip
j = 2 → different → i=1, arr[1]=2
j = 3 → same → skip
j = 4 → different → i=2, arr[2]=3

Final array:
[1, 2, 3, _, _]
k = 3

------------------------------------------------------
⚡ Complexity:

Time  : O(n)
Space : O(1)  (in-place)

------------------------------------------------------
⚠️ Edge Cases:

[] → 0
[1] → 1
[1,1,1] → 1

------------------------------------------------------
*/

public class RemoveDuplicatesSorted {

    // GATE-level implementation
    public static int removeDuplicates(int[] arr) {
        if (arr.length == 0) return 0;

        int i = 0; // pointer for unique elements

        for (int j = 1; j < arr.length; j++) {
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }
        }

        return i + 1;
    }

    // Utility to print array till k elements
    public static void printArray(int[] arr, int k) {
        for (int i = 0; i < k; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Main method for testing
    public static void main(String[] args) {

        int[] arr = {1, 1, 2, 2, 3, 4, 4};

        int k = removeDuplicates(arr);

        System.out.println("Number of unique elements: " + k);
        System.out.print("Array after removing duplicates: ");
        printArray(arr, k);
    }
}