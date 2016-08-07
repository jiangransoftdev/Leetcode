/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode dummy1=new ListNode(0);
        ListNode dummy2=new ListNode(0);
        ListNode index1=dummy1,index2=dummy2,index=head;
        int count=0;
        while(index!=null){
            if(count%2==0){
                index1.next=index;
                index1=index1.next;
            }
            else{
                index2.next=index;
                index2=index2.next;
            }
            index=index.next;
            count++;
        }
        index2.next=null;
        index1.next=dummy2.next;
        return dummy1.next;
    }
}