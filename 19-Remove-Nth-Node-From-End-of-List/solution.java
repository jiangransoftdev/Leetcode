/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    int i=0;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        helper(dummy,n);
        return dummy.next;
    }
    public void helper(ListNode head, int n){
        if(head==null){
            i=0;
            return;
        }
        helper(head.next,n);
        i++;
        if(i==n+1){
            head.next=head.next.next;
        }
    }
}