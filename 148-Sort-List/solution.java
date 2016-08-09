/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    ListNode node;
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null) return head;
        node=head;
        int count=0;
        ListNode index=head;
        while(index!=null){
            count++;
            index=index.next;
        }
        return helper(0,count-1);
    }
    public ListNode helper(int s,int e){
        if(s>e) return null;
        if(s==e){
            ListNode tmp=node;
            node=node.next;
            tmp.next=null;
            return tmp;
        }
        int m=s+(e-s)/2;
        ListNode left=helper(s,m);
        ListNode right=helper(m+1,e);
        return combine(left,right);
    }
    public ListNode combine(ListNode left,ListNode right){
        ListNode l=left,r=right;
        ListNode dummy=new ListNode(0),index=dummy;
        while(l!=null&&r!=null){
            if(l.val<=r.val){
                index.next=l;
                l=l.next;
            }
            else{
                index.next=r;
                r=r.next;
            }
            index=index.next;
        }
        if(l!=null) index.next=l;
        if(r!=null) index.next=r;
        return dummy.next;
    }
}