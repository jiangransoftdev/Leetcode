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
    public int rob(TreeNode root) {
        int[] res=helper(root);
        return Math.max(res[0],res[1]);
    }
    public int[] helper(TreeNode root){
        if(root==null) return new int[2];
        int[] left=helper(root.left);
        int[] right=helper(root.right);
        int[] val=new int[2];
        val[0]=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        val[1]=left[0]+right[0]+root.val;
        return val;
    }
}