package com.mk.java.LL;

public class ReverseLL {

    static void main() {
        LinkedListOpt llOpt = new LinkedListOpt();
        ListNode head= llOpt.createLinkedList(new int[]{1, 2, 3, 4, 5});

        llOpt.printLinkedList(head);
        head=reverseLinkedList(head);
        llOpt.printLinkedList(head);


    }


    static ListNode reverseLinkedList(ListNode head) {
        ListNode prev= null;
        ListNode curr=head;
        ListNode next;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        return prev;
    }

}
