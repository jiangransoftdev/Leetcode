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
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null||(root.left==null&&root.right==null)) return 0;
        int l=0,r=0;
        if(root.left!=null) l=(root.left.left==null&&root.left.right==null)?root.left.val:sumOfLeftLeaves(root.left);
        if(root.right!=null) r=sumOfLeftLeaves(root.right);
        return l+r;
    }
}