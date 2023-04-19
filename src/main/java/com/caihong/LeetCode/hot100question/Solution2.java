package com.caihong.LeetCode.hot100question;

public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode result = new ListNode();
        ListNode temp = result;
        int tip = 0;
        while (true) {
            if (l1 == null && l2 == null) {
                if (tip == 0) {
                    break;
                }
            }
            int value1 = 0;
            if (l1 != null) {
                value1 = l1.val;
            }
            int value2 = 0;
            if (l2 != null) {
                value2 = l2.val;
            }
            int digit = value1 + value2 + tip;
            if (digit > 9) {
                tip = 1;
                digit -= 9;
            }
            temp.val = digit;
            temp = new ListNode();
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return result;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
