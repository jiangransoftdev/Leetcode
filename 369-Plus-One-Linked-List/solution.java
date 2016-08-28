/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    int add=1;
    public ListNode plusOne(ListNode head) {
        helper(head);
        if(add==1){
            ListNode dummy=new ListNode(1);
            dummy.next=head;
            return dummy;
        }
        return head;
    }
    public void helper(ListNode head){
        if(head==null) return;
        helper(head.next);
        int tmp=head.val;
        head.val=(tmp+add)%10;
        add=(tmp+add)/10;
    }
}