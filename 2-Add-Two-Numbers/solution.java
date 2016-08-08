/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode index1=l1,index2=l2;
        ListNode dummy=new ListNode(0),index=dummy;
        int add=0;
        while(index1!=null||index2!=null){
            int digit=((index1==null?0:index1.val)+(index2==null?0:index2.val)+add)%10;
            add=((index1==null?0:index1.val)+(index2==null?0:index2.val)+add)/10;
            index.next=new ListNode(digit);
            index1=index1==null?null:index1.next;
            index2=index2==null?null:index2.next;
            index=index.next;
        }
        if(add==1) index.next=new ListNode(1);
        return dummy.next;
    }
}