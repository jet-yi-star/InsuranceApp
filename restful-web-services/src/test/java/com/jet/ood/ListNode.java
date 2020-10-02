package com.jet.ood;

public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p1 = head, p2 = head.next;
        while (p1 != null) {
            if (p1 == head) {
                p1.next = null;
            }
            ListNode p3 = p2.next;

            p2.next = p1;
            p1 = p2;
            p2 = p3;
            if (p2 == null) {
                break;
            }
        }
        return p1;
    }

    void show(ListNode head) {
          while(head != null) {
              System.out.println(head.val);
              head = head.next;
          }
    }


}
