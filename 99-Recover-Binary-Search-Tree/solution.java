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
    TreeNode node1=null,node2=null,prevnode=null;
    int prev=Integer.MIN_VALUE;
    public void recoverTree(TreeNode root) {
        helper(root);
        swap(node1,node2);
    }
    public void helper(TreeNode root){
        if(root==null) return;
        helper(root.left);
        if(node1==null&&prev>=root.val) node1=prevnode;
        if(node1!=null&&prev>=root.val) node2=root;
        prevnode=root;
        prev=root.val;
        helper(root.right);
    }
    public void swap(TreeNode i,TreeNode j){
        int tmp=i.val;
        i.val=j.val;
        j.val=tmp;
    }
}