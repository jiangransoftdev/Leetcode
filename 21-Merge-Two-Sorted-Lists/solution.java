/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode dummy=new ListNode(0);
        ListNode index=dummy;
        while(l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                index.next=l1;
                l1=l1.next;
            }
            else{
                index.next=l2;
                l2=l2.next;
            }
            index=index.next;
        }
        if(l1!=null) index.next=l1;
        if(l2!=null) index.next=l2;
        return dummy.next;
    }
}