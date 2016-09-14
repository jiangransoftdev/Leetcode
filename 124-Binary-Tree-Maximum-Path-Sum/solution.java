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
    int res=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return res;
    }
    public int helper(TreeNode root){
        if(root==null) return Integer.MIN_VALUE;
        int left=helper(root.left);
        int right=helper(root.right);
        left=left<0?0:left;
        right=right<0?0:right;
        res=Math.max(res,root.val+left+right);
        return Math.max(left,right)+root.val;
    }
}