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
    int count=0;
    public int countUnivalSubtrees(TreeNode root) {
        helper(root);
        return count;
    }
    public boolean helper(TreeNode root){
        if(root==null) return true;
        boolean left=helper(root.left);
        boolean right=helper(root.right);
        int lval=0,rval=0;
        if(left&&right){
            lval=root.left==null?root.val:root.left.val;
            rval=root.right==null?root.val:root.right.val;
            if(lval==root.val&&rval==root.val){
                count++;
                return true;
            } 
            else return false;
        }
        return false;
    }
}