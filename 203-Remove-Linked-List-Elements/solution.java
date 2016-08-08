/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null) return null;
        ListNode dummy=new ListNode(0),slow=dummy;
        dummy.next=head;
        ListNode fast=head;
        while(fast!=null){
            if(fast.val==val){
                slow.next=fast.next;
            }
            else slow=slow.next;
            fast=fast.next;
        }
        return dummy.next;
    }
}