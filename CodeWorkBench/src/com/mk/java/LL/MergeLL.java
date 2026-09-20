package com.mk.java.LL;

public class MergeLL {
    
    
    public static void main() {
        LinkedListOpt llOpt = new LinkedListOpt();
        ListNode head1 = llOpt.createLinkedList(new int[]{1, 3, 5});
        ListNode head2 = llOpt.createLinkedList(new int[]{2, 4, 6});
        llOpt.printLinkedList(head1);
        llOpt.printLinkedList(head2);

        ListNode mergedHead = mergeTwoLists(head1, head2);

        llOpt.printLinkedList(mergedHead);
    }

    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }

            temp = temp.next;
        }

        if (list1 != null) {
            temp.next = list1;
        } else {
            temp.next = list2;
        }

        return dummy.next;

    }
}
