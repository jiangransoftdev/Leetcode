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
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null&&fast.next!=null){
        	slow=slow.next;
        	fast=fast.next.next;
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
        while(p1!=null&&slow!=null){
        	ListNode ap1=p1.next;
        	ListNode aslow=slow.next;
        	slow.next=p1;
        	p1.next=aslow;
        	p1=ap1;
        	slow=aslow;
    }
    }
}