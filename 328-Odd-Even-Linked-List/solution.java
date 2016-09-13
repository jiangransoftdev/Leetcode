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
        ListNode odd=new ListNode(0),even=new ListNode(0);
        ListNode index=head,index1=odd,index2=even;
        int count=1;
        while(index!=null){
            if(count%2!=0){
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
        index1.next=even.next;
        index2.next=null;
        return odd.next;
    }
}