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
        return helper(lists,0,lists.length-1);
    }
    public ListNode helper(ListNode[] lists,int s,int e){
        if(s>e) return null;
        if(s==e) return lists[s];
        int m=s+(e-s)/2;
        ListNode left=helper(lists,s,m);
        ListNode right=helper(lists,m+1,e);
        return combine(left,right);
    }
    public ListNode combine(ListNode left,ListNode right){
        ListNode indexl=left,indexr=right;
        ListNode dummy=new ListNode(0),index=dummy;
        while(indexl!=null&&indexr!=null){
            if(indexl.val<=indexr.val){
                index.next=indexl;
                indexl=indexl.next;
            }
            else{
                index.next=indexr;
                indexr=indexr.next;
            }
            index=index.next;
        }
        if(indexl!=null) index.next=indexl;
        if(indexr!=null) index.next=indexr;
        return dummy.next;
    }
}