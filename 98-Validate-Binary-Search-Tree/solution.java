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
    Long pre=Long.MIN_VALUE;
    boolean res=true;
    public boolean isValidBST(TreeNode root) {
        helper(root);
        return res;
    }
    public void helper(TreeNode root){
        if(root==null) return;
        helper(root.left);
        if(root.val<=pre) res=false;
        pre=(long)root.val;
        helper(root.right);
    }
}