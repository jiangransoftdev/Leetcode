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
    int res;
    public int maxPathSum(TreeNode root) {
       res=Integer.MIN_VALUE;
       Sum(root);
       return res;
    }
    public int Sum(TreeNode root){
        if(root==null) return 0;
        int left=Sum(root.left);
        int right=Sum(root.right);
        left=left<0?0:left;
        right=right<0?0:right;
        res=res>(root.val+left+right)?res:root.val+left+right;
        return root.val+Math.max(left,right);
    }
}