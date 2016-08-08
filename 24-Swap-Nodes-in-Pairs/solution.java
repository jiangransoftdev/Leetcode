/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode tail=swapPairs(head.next.next);
        ListNode newhead=head.next;
        head.next=tail;
        newhead.next=head;
        return newhead;
    }
}