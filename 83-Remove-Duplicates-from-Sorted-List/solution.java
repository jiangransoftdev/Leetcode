/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode slow=head,fast=head.next;
        while(fast!=null){
            if(slow.val!=fast.val){
                slow.next=fast;
                slow=slow.next;
            }
            fast=fast.next;
        }
        if(slow.next!=null) slow.next=null;
        return head;
    }
}