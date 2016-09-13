/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    ListNode node;
    public TreeNode sortedListToBST(ListNode head) {
        node=head;
        int size=0;
        ListNode cur=head;
        while(cur!=null){
            cur=cur.next;
            size++;
        }
        return traverse(0,size-1);
    }
    public TreeNode traverse(int start,int end){
        if(start>end) return null;
        if(start==end){
            TreeNode tnode=new TreeNode(node.val);
            node=node.next;
            return tnode;
        }
        int mid=start+(end-start)/2;
        TreeNode left=traverse(start,mid-1);
        TreeNode root=new TreeNode(node.val);
        node=node.next;
        TreeNode right=traverse(mid+1,end);
        root.left=left;
        root.right=right;
        return root;
    }
}