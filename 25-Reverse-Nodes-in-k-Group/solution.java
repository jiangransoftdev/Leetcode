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
        ListNode cur=head;
        while(cur!=null&&count<k){
            count++;
            cur=cur.next;
        }
        if(count==k){
            cur=reverseKGroup(cur,k);
            while(count-->0){
                ListNode tmp=head.next;
                head.next=cur;
                cur=head;
                head=tmp;
            }
            return cur;
        }
        return head;
    }
}