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
        ListNode dummy=new ListNode(0);
        ListNode index=dummy,slow=head,fast=head.next;
        while(fast!=null){
            if(slow.val==fast.val)
                fast=fast.next;
            else{
                if(slow.next==fast){
                    index.next=slow;
                    slow=fast;
                    fast=fast.next;
                    index=index.next;
                }
                else{
                    index.next=fast;
                    slow=fast;
                    fast=fast.next;
                }
            }
        }
        if(slow.next!=fast) index.next=null;
        return dummy.next;
    }
}