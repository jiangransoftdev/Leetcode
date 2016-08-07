/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head==null||head.next==null) return;
        ListNode slow=head,fast=head.next;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode p1=slow.next;
        slow.next=null;
        ListNode p2=p1.next;
        p1.next=null;
        while(p1!=null&&p2!=null){
            ListNode t=p2.next;
            p2.next=p1;
            p1=p2;
            p2=t;
        }
        slow=head;
        fast=p1;
        while(slow!=null&&fast!=null){
            ListNode tmp=fast.next;
            fast.next=slow.next;
            slow.next=fast;
            fast=tmp;
            slow=slow.next.next;
        }
    }
    
}