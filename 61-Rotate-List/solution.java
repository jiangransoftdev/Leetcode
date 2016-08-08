/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null) return head;
        int count=1;
        ListNode index=head;
        while(index.next!=null){
            count++;
            index=index.next;
        }
        index.next=head;
        index=head;
        k=count-k%count;
        count=1;
        while(count<k){
            index=index.next;
            count++;
        }
        ListNode res=index.next;
        index.next=null;
        return res;
    }
}