/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy=new ListNode(0);
        ListNode pre=dummy;
        ListNode current=head;
        while(current!=null){
            pre=dummy;
            while(pre.next!=null&&pre.next.val<current.val)
                pre=pre.next;
            ListNode tmp=current.next;
            current.next=pre.next;
            pre.next=current;
            current=tmp;
        }
        return dummy.next;
    }
}