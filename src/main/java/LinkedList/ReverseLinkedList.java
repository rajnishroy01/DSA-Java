package LinkedList;

/**
 * Reverse Singly Linked List
 * -----------------------------------------
 * Problem:
 * Given the head of a singly linked list,
 * reverse the linked list and return the
 * new head.
 *
 * Example:
 *
 * Input:
 * 1 -> 2 -> 3 -> 4 -> null
 *
 * Output:
 * 4 -> 3 -> 2 -> 1 -> null
 *
 *
 * -----------------------------------------
 * Approach (Iterative Method)
 * -----------------------------------------
 * We use three pointers:
 *
 * 1. prev  -> stores previous node
 * 2. curr  -> current node
 * 3. next  -> stores next node temporarily
 *
 * Steps:
 * 1. Store next node
 * 2. Reverse current node's link
 * 3. Move prev forward
 * 4. Move curr forward
 *
 * Time Complexity:
 * O(n)
 *
 * Space Complexity:
 * O(1)
 *
 * -----------------------------------------
 * Dry Run
 * -----------------------------------------
 *
 * Initial:
 * prev = null
 * curr = 1
 *
 * List:
 * 1 -> 2 -> 3 -> null
 *
 * Iteration 1:
 * next = 2
 * 1 -> null
 * prev = 1
 * curr = 2
 *
 * Iteration 2:
 * next = 3
 * 2 -> 1 -> null
 * prev = 2
 * curr = 3
 *
 * Iteration 3:
 * next = null
 * 3 -> 2 -> 1 -> null
 * prev = 3
 * curr = null
 *
 * Return prev
 *
 */

public class ReverseLinkedList {

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to reverse linked list
    public static Node reverseList(Node head) {

        Node curr = head;
        Node prev = null;

        while (curr != null) {

            Node next = curr.next; // store next node

            curr.next = prev; // reverse current node link

            prev = curr; // move prev forward

            curr = next; // move curr forward
        }

        return prev;
    }

    // Function to print linked list
    public static void printList(Node head) {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    // Main method
    public static void main(String[] args) {

        // Creating linked list:
        // 1 -> 2 -> 3 -> 4 -> null

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        System.out.println("Original Linked List:");
        printList(head);

        // Reverse the linked list
        Node reversedHead = reverseList(head);

        System.out.println("\nReversed Linked List:");
        printList(reversedHead);
    }
}
