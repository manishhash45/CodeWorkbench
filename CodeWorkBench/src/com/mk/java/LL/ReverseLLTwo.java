package com.mk.java.LL;

public class ReverseLLTwo {

     static void main() {
        int [] arr = {1, 2, 3, 4, 5};
         LinkedListOpt llOpt = new LinkedListOpt();
         ListNode head= llOpt.createLinkedList(arr);
         llOpt.printLinkedList(head);
         head = reverseLinkedListTwo(head, 2, 4);
         llOpt.printLinkedList(head);
    }

    static ListNode reverseLinkedListTwo(ListNode head, int left, int right) {
     ListNode dummy = new ListNode(0);
     dummy.next = head;

     ListNode leftPrev = dummy;

     for(int i=1; i<left; i++) {
         leftPrev = leftPrev.next;
     }

     ListNode rightNode = leftPrev;

     for(int i= left-1; i<right; i++) {
         rightNode = rightNode.next;
     }

     ListNode rightNext = rightNode.next;
     ListNode curr = leftPrev.next;
     ListNode prev=null;
     ListNode next=null;
     ListNode start=curr;


     while(curr!=null && curr!= rightNext) {
         next = curr.next;
         curr.next = prev;
         prev = curr;
         curr = next;
     }
     // connect the left and right parts
        leftPrev.next = prev;
        start.next = rightNext;

     return dummy.next;
    }
}
