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
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int h=helper(root);
        int res=helper(root.right)==h-1?(1<<(h-1))+countNodes(root.right):(1<<(h-2))+countNodes(root.left);
        return res;
                                    
    }
    public int helper(TreeNode root){
        if(root==null) return 0;
        return helper(root.left)+1;
    }
}