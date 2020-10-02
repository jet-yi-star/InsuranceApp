package com.jet.ood;

public class Test {
    private int t1, t2;

    public Test() {
    }

    public Test(int t1, int t2) {
        this.t1 = t1;
        this.t2 = t2;
    }

    public int getT1() {
        return t1;
    }

    public void setT1(int t1) {
        this.t1 = t1;
    }

    public int getT2() {
        return t2;
    }

    public void setT2(int t2) {
        this.t2 = t2;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n1.show(n1);
        ListNode t = n1.reverse(n1);

    }

}



