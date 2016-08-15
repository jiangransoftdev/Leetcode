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
    boolean res=true;
    long pre=Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        helper(root);
        return res;
    }
    public void helper(TreeNode root){
        if(root==null) return;
        if(root.left==null&&root.right==null){
            if(root.val<=pre) res=false;
            pre=root.val;
            return;
        } 
        helper(root.left);
        if(root.val<=pre) res=false;
        pre=root.val;
        helper(root.right);
    }
}