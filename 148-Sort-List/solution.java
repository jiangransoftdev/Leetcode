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
        node=head;
        if(head==null||head.next==null) return head;
        int size=0;
        ListNode cur=head;
        while(cur!=null){
            size++;
            cur=cur.next;
        }
        return helper(0,size-1);
    }
    public ListNode helper(int left,int right){
        if(left>right) return null;
        if(left==right){
            ListNode cur=node;
            node=node.next;
            cur.next=null;
            return cur;
        }
        int mid=left+(right-left)/2;
        ListNode l=helper(left,mid);
        ListNode r=helper(mid+1,right);
        return combine(l,r);
    }
    public ListNode combine(ListNode left,ListNode right){
        ListNode dummy=new ListNode(0);
        ListNode index=dummy,index1=left,index2=right;
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