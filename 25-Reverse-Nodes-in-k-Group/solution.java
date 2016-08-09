/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count=0;
        ListNode index=head;
        while(index!=null){
            count++;
            index=index.next;
            if(count==k) break;
        }
        if(count<k) return head;
        index=reverseKGroup(index,k);
        while(count-->0){
            ListNode tmp=head.next;
            head.next=index;
            index=head;
            head=tmp;
        }
        return index;
    }
}