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
        if(head==null) return null;
        ListNode dummy1=new ListNode(0),dummy2=new ListNode(0),index1=dummy1,index2=dummy2;
        ListNode index=head;
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
        index1.next=dummy2.next;
        index2.next=null;
        return dummy1.next;
    }
}