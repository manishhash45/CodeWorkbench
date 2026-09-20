package com.mk.java.LL;

public class LinkedListOpt {

    public static void main() {

        // Create a linked list with values 1, 2, 3, 4, 5
        ListNode head = createLinkedList(new int[]{1, 2, 3,4, 5});

        // Print the linked list
        printLinkedList(head);

        // Add a new node at the beginning of the linked list
       // head = addAtBeginning(head, 0);
        //printLinkedList(head);

        head = addAtMiddle(head, 6, 3);
        printLinkedList(head);

        // Reverse the linked list
        head = reverseLinkedList(head);

        // Print the reversed linked list
        System.out.println("Reversed Linked List: ");
        printLinkedList(head);
    }

    // add to linkedList method
    public static ListNode addAtBeginning(ListNode head, int value) {
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        return newNode;
    }

    // add last to linkedList method
    public static ListNode addAtLast(ListNode head, int value) {
            ListNode newNode = new ListNode(value);
            if (head == null) {
                return newNode;
            }

            while (head.next!= null) {
                head = head.next;
            }

            head.next = newNode;
            return head;
    }

    // add middle to linkedList method
    public static ListNode addAtMiddle(ListNode head, int value, int index) {
        if (index == 0) {
            return addAtBeginning(head, value);
        }
        ListNode current = head;
        int count = 1;

        while (current!= null && count < index-1) {
            current = current.next;
            count++;
        }

        if (current == null) {
            return head;
        }

        ListNode newNode = new ListNode(value);
        newNode.next = current.next;
        current.next = newNode;
        return head;
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




