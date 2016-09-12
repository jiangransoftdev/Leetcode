/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists,0,lists.length-1);
    }
    public ListNode merge(ListNode[] lists,int low,int high){
        if(low>high) return null;
        if(low==high) return lists[low];
        int mid=low+(high-low)/2;
        ListNode left=merge(lists,low,mid);
        ListNode right=merge(lists,mid+1,high);
        return combine(left,right);
    }
    public ListNode combine(ListNode left,ListNode right){
        ListNode l=left,r=right,dummy=new ListNode(0),index=dummy;
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