/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null||head.next==null) return head;
        ListNode dummy=new ListNode(0),index=dummy,start=null,end=null;
        dummy.next=head;
        int count=0;
        while(index!=null){
            count++;
            if(count==m)
                start=index;
            if(count==n+1)
                end=index.next;
            index=index.next;
        }
        ListNode r=reverse(start.next,end,m,n,m);
        start.next=r;
        return dummy.next;
    }
    public ListNode reverse(ListNode head,ListNode end,int m,int n,int count){
        if(count==n) return head;
        ListNode tail=reverse(head.next,end,m,n,count+1);
        head.next.next=head;
        head.next=null;
        if(count==m)
            head.next=end;
        return tail;
    }
}