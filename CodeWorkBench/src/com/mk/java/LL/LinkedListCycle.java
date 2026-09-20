package com.mk.java.LL;

public class LinkedListCycle {

    static void main() {
        LinkedListOpt llOpt = new LinkedListOpt();
        ListNode head = llOpt.createLinkedList(new int[]{1, 2, 3, 4, 5});
//        head.next.next.next.next = head.next; // create a cycle



        System.out.println("Is Cycle Present: " + isCyclePresent(head));
    }

    private static boolean isCyclePresent(ListNode head) {
        if(head==null) return false;

        ListNode fast=head;
        ListNode slo=head;

        while(fast!=null && fast.next!=null ) //[1,2]. and [1]
        {
            fast=fast.next.next;
            slo=slo.next;
            if(fast==slo)
                return true;
        }

        return false;
    }
}
