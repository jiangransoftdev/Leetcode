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
        if(headA==null||headB==null) return null;
        ListNode indexa=headA,indexb=headB;
        while(indexa!=null&&indexb!=null){
            indexa=indexa.next;
            indexb=indexb.next;
        }
        if(indexa==null)indexa=headB;
        if(indexb==null)indexb=headA;
        while(indexa!=null&&indexb!=null){
            indexa=indexa.next;
            indexb=indexb.next;
        }
        if(indexa==null)indexa=headB;
        if(indexb==null)indexb=headA;
        while(indexa!=null&&indexb!=null){
            if(indexa==indexb) return indexa;
            indexa=indexa.next;
            indexb=indexb.next;
        }
        return null;
    }
}