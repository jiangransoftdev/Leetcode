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
        ListNode cur=head;
        while(cur.next!=null){
            count++;
            cur=cur.next;
        }
        k=count-k%count;
        cur.next=head;
        while(k-->0){
            cur=cur.next;
        }
        ListNode res=cur.next;
        cur.next=null;
        return res;
    }
}