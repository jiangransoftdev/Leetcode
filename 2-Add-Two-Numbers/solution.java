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
        int add=0;
        ListNode dummy=new ListNode(0);
        ListNode index=dummy;
        while(l1!=null||l2!=null){
            int digita=l1==null?0:l1.val;
            int digitb=l2==null?0:l2.val;
            int digit=(digita+digitb+add)%10;
            add=(digita+digitb+add)/10;
            index.next=new ListNode(digit);
            index=index.next;
            l1=l1==null?null:l1.next;
            l2=l2==null?null:l2.next;
        }
        if(add!=0) index.next=new ListNode(add);
        return dummy.next;
    }
}