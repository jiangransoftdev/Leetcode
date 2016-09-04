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
    int res=0;
    public int longestConsecutive(TreeNode root) {
        helper(root);
        return res;
    }
    public int helper(TreeNode root){
        if(root==null) return 0;
        int left=helper(root.left);
        int right=helper(root.right);
        int llen=left==0?1:root.val+1==root.left.val?left+1:1;
        int rlen=right==0?1:root.val+1==root.right.val?right+1:1;
        res=Math.max(res,Math.max(llen,rlen));
        return Math.max(llen,rlen);
    }
}