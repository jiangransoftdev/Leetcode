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
        sum(root);
        return res;
    }
    public int sum(TreeNode root){
        if(root==null) return 0;
        int left=sum(root.left);
        int right=sum(root.right);
        left=left<0?0:left;
        right=right<0?0:right;
        res=Math.max(res,root.val+left+right);
        return root.val+Math.max(left,right);
    }
}