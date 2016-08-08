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
        ListNode dummy=new ListNode(0),index=dummy;
        dummy.next=head;
        while(fast!=null){
            if(slow.val!=fast.val){
                if(slow.next!=fast){
                    index.next=fast;
                    slow=fast;
                }
                else{
                    index.next=slow;
                    index=index.next;
                    slow=slow.next;
                }
            }
            fast=fast.next;
        }
        if(slow.next!=null) index.next=null;
        return dummy.next;
    }
}