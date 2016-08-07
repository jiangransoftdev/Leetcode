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
        ListNode index=dummy,index1=l1,index2=l2;
        while(index1!=null&&index2!=null){
            if(index1.val<=index2.val){
                index.next=index1;
                index1=index1.next;
            }
            else{
                index.next=index2;
                index2=index2.next;
            }
            index=index.next;
        }
        if(index1!=null) index.next=index1;
        if(index2!=null) index.next=index2;
        return dummy.next;
    }
}