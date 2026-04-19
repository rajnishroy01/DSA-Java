package arrays;

import java.util.Arrays;

public  class ArraysProblem {


public static void main(String[]args){



       int[] arr = {10, 10, 10};
        System.out.println(getSecondLargest(arr));
        }



        /*Given an array of positive integers arr[], return the second largest element from the array. If the second largest element doesn't exist then return -1./*

        Note: The second largest element should not be equal to the largest element.

        Examples:

        Input: arr[] = [12, 35, 1, 10, 34, 1]
        Output: 34
        Explanation: The largest element of the array is 35 and the second largest element is 34.
        Input: arr[] = [10, 5, 10]
        Output: 5
        Explanation: The largest element of the array is 10 and the second largest element is 5.
        Input: arr[] = [10, 10, 10]
        Output: -1
        Explanation: The largest element of the array is 10 and the second largest element does not exist.*/
       public static int getSecondLargest(int[] arr) {
              // code here
              int i = arr.length - 1;
              Arrays.sort(arr);

              while (i > 0 && arr[i] == arr[i - 1]) {
                     i -= 1;

              }
              if (i > 0)
                     return arr[i - 1];
              else
                     return -1;
       }   }