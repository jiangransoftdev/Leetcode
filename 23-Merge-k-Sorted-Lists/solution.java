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
        if(lists.length==0) return null;
        return helper(lists,0,lists.length-1);
    }
    public ListNode helper(ListNode[] lists,int start,int end){
        if(start>end) return null;
        if(start==end) return lists[start];
        int mid=start+(end-start)/2;
        ListNode left=helper(lists,start,mid);
        ListNode right=helper(lists,mid+1,end);
        ListNode dummy=new ListNode(0);
        ListNode l=left,r=right,index=dummy;
        while(l!=null&&r!=null){
            if(l.val<r.val){
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