/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null) return true;
        ListNode slow=head,fast=head.next;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode another=reverse(slow.next);
        slow=head;
        fast=another;
        while(slow!=null&&fast!=null){
            if(slow.val!=fast.val) return false;
            slow=slow.next;
            fast=fast.next;
        }
        return true;
        
    }
    public ListNode reverse(ListNode head){
        if(head==null||head.next==null) return head;
        ListNode tail=reverse(head.next);
        head.next.next=head;
        head.next=null;
        return tail;
    }
}