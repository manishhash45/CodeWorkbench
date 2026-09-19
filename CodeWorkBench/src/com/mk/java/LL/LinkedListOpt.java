package com.mk.java.LL;

public class LinkedListOpt {

    public static void main() {

        // Create a linked list with values 1, 2, 3, 4, 5
        ListNode head = createLinkedList(new int[]{1, 2, 3, 4, 5});

        // Print the linked list
        printLinkedList(head);

        // Reverse the linked list
        head = reverseLinkedList(head);

        // Print the reversed linked list
        System.out.println("Reversed Linked List: ");
        printLinkedList(head);
    }

    private static ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode nextNode;

        while (current!= null) {
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }


    //Create a linked list with given values
    public static ListNode createLinkedList(int[] values) {
        ListNode head = null;
        ListNode current = null;

        for (int value : values) {
            if (head == null) {
                head = new ListNode(value);
                current = head;
            } else {
                current.next = new ListNode(value);
                current = current.next;
            }
        }

        return head;
    }

    public static void printLinkedList(ListNode head) {
        ListNode current = head;

        while (current!= null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }




}




