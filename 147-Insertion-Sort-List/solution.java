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
        ListNode pre=dummy,cur=head;
        while(cur!=null){
            pre=dummy;
            while(pre.next!=null&&pre.next.val<cur.val)
                pre=pre.next;
            ListNode tmp=cur.next;
            cur.next=pre.next;
            pre.next=cur;
            cur=tmp;
        }
        return dummy.next;
        
    }
}