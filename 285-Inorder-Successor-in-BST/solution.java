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
    TreeNode next=null,res=null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        helper(root,p);
        return res;
    }
    public void helper(TreeNode root,TreeNode p){
        if(root==null) return;
        helper(root.right,p);
        if(root==p) res=next;
        next=root;
        helper(root.left,p);
    }
}