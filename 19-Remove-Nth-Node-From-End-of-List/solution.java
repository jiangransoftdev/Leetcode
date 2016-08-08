/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    int count;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        count=0;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        helper(dummy,n);
        return dummy.next;
    }
    public void helper(ListNode head,int n){
        if(head==null) return;
        helper(head.next,n);
        count++;
        if(count==n+1){
            head.next=head.next.next;
        }
    }
}