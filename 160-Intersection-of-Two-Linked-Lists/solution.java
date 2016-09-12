/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode index1=headA,index2=headB;
        while(index1!=null&&index2!=null){
            index1=index1.next;
            index2=index2.next;
        }
        if(index1==null) index1=headB;
        if(index2==null) index2=headA;
        while(index1!=null&&index2!=null){
            index1=index1.next;
            index2=index2.next;
        }
        if(index1==null) index1=headB;
        if(index2==null) index2=headA;
        while(index1!=null&&index2!=null){
            if(index1==index2) return index1;
            index1=index1.next;
            index2=index2.next;
        }
        return null;
    }
}