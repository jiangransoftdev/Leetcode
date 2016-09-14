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
    public boolean isBalanced(TreeNode root) {
        return helper(root)!=-1;
    }
    public int helper(TreeNode root){
        if(root==null) return Integer.MIN_VALUE;
        if(root.left==null&&root.right==null) return 0;
        int left=helper(root.left);
        int right=helper(root.right);
        if(left==-1||right==-1||Math.abs(left-right)>1) return -1;
        return 1+Math.max(left,right);
    }
}