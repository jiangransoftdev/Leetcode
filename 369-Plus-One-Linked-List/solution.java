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
        head=helper(head);
        if(add==1){
            ListNode dummy=new ListNode(1);
            dummy.next=head;
            return dummy;
        }
        return head;
    }
    public ListNode helper(ListNode head){
        if(head==null) return null;
        helper(head.next);
        int digit=(head.val+add)%10;
        add=(head.val+add)/10;
        head.val=digit;
        return head;
    }
    
}