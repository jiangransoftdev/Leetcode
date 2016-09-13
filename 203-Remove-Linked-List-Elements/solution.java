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
        ListNode dummy=new ListNode(0),index=dummy;
        dummy.next=head;
        while(index.next!=null){
            if(index.next.val==val){
                index.next=index.next.next;
            }
            else index=index.next;
        }
        return dummy.next;
    }
}