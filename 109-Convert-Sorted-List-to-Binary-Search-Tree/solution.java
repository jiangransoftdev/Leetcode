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
        ListNode another=head;
        int count=0;
        while(another!=null){
            count++;
            another=another.next;
        }
        return helper(0,count-1);
    }
    public TreeNode helper(int s,int e){
        if(s>e) return null;
        int m=s+(e-s)/2;
        TreeNode left=helper(s,m-1);
        TreeNode root=new TreeNode(node.val);
        node=node.next;
        TreeNode right=helper(m+1,e);
        root.left=left;
        root.right=right;
        return root;
    }
}