// https://leetcode.com/problems/merge-two-sorted-lists
public class LeetCode21 {
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) {
            return l1;
        } else if (l2 == null) {
            return l1;
        } else if (l1 == null) {
            return l2;
        }

        final ListNode top;
        ListNode p1 = l1;
        ListNode p2 = l2;
        // p1 != null && p2 != null
        if (p1.val <= p2.val) {
            top = p1;
            p1 = p1.next;
            if (p1 == null) {
                top.next = p2;
                return top;
            }
        } else {
            top = p2;
            p2 = p2.next;
            if (p2 == null) {
                top.next = p1;
                return top;
            }
        }
        ListNode p = top;


        while(p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                p.next = p1;
                p1 = p1.next;
                p = p.next;
                if (p1 == null) {
                    p.next = p2;
                    break;
                }
            } else {
                p.next = p2;
                p2 = p2.next;
                p = p.next;
                if (p2 == null) {
                    p.next = p1;
                    break;
                }
            }


        }

        return top;

    }
}