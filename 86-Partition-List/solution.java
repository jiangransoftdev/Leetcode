/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode small=new ListNode(0),large=new ListNode(0);
        ListNode index=head,index1=small,index2=large;
        while(index!=null){
            if(index.val<x){
                index1.next=index;
                index1=index1.next;
            }
            else{
                index2.next=index;
                index2=index2.next;
            }
            index=index.next;
        }
        index1.next=large.next;
        index2.next=null;
        return small.next;
    }
}