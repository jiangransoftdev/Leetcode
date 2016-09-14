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
        ListNode prev=dummy,cur=head;
        while(cur!=null){
            prev=dummy;
            while(prev.next!=null&&prev.next.val<cur.val)
                prev=prev.next;
            ListNode next=cur.next;
            cur.next=prev.next;
            prev.next=cur;
            cur=next;
        }
        return dummy.next;
    }
}