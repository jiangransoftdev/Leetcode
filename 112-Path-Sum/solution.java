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
    boolean res=false;
    public boolean hasPathSum(TreeNode root, int sum) {
        helper(root,sum);
        return res;
    }
    public void helper(TreeNode root,int sum){
        if(root==null) return;
        if(root.left==null&&root.right==null){
            if(root.val==sum) res=true;
            return;
        }
        helper(root.left,sum-root.val);
        helper(root.right,sum-root.val);
    }
}