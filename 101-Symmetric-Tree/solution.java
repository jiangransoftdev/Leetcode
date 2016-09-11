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
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return helper(root.left,root.right);
    }
    public boolean helper(TreeNode p,TreeNode q){
        if(p==null&&q==null) return true;
        else if(p==null||q==null) return false;
        else if(p.val!=q.val) return false;
        return helper(p.left,q.right)&&helper(p.right,q.left);
    }
}